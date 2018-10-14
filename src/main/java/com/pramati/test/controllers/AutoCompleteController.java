package com.pramati.test.controllers;


import com.google.gson.Gson;
import com.pramati.test.models.GenericResponse;
import com.pramati.test.services.AutoCompleteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AutoCompleteController {

    private static final Logger LOGGER= LogManager.getLogger(AutoCompleteController.class);

    private Gson gson = new Gson();

    @Autowired
    private AutoCompleteService autoCompleteService;

    /**
     * @api {GET} /v1/suggest_cities Api to autocomplete city search
     * @apiSampleRequest https://localhost:8081/v1/suggest_cities?start=che&atmost=2
     * @apiName autoComplete
     * @apiDescription Api to autocomplete city search
     * @apiParam {query param} start Starting text to match - String
     * @apiParam {query param} atmost Atmost result - int

     * @apiVersion 1.0.0
     * @apiExample {curl} Example usage:
     *	curl -X GET https://localhost:8081/v1/suggest_cities?start=che&atmost=2
     *
     * @apiSuccess {json} List of matching citis
     * @apiSuccessExample Success-Response:
     *    {
     *		[
     *	       chenni,
     *	       cherapunji
     *	    ]
     *		}
     *
     * @apiError (Error 200) 1202 Invalid value for maximum number of monthly transactions.
     * @apiErrorExample Error-Response:
     *	{
     *	"status": "ERROR",
     *	"responseCode": "400",
     *	"message": "Tnc description cannot be empty.",
     *	"success": false
     *	}
     *
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/v1/suggest_cities")
    public ResponseEntity<String> autoComplete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try{
            String start  = httpServletRequest.getParameter("start");
            String limit = httpServletRequest.getParameter("atmost");
            int atmost = 5;
            if(!StringUtils.isEmpty(limit)){
                atmost = Integer.parseInt(limit);
            }
            if(!StringUtils.isEmpty(start)){
                LOGGER.info("request received with start : {} , atmost {}", start,atmost);
                List<String> cityList  = autoCompleteService.getAutoCompleteCities(start,atmost);
                return new ResponseEntity<>(gson.toJson(cityList),HttpStatus.OK);
            }else
            {
                //send blank response if start is empty
                return new ResponseEntity<>(gson.toJson(new ArrayList<String>()), HttpStatus.OK);
            }
        }catch (Exception e){
            LOGGER.error("Something went wrong {}",e.fillInStackTrace());
            return new ResponseEntity<>(gson.toJson(new GenericResponse(false,"400","Something went wrong")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
