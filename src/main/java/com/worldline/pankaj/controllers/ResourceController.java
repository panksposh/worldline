package com.worldline.pankaj.controllers;

import com.worldline.pankaj.models.InputNumbersRange;
import com.worldline.pankaj.models.OutputPerfectNumbers;
import com.worldline.pankaj.services.PerfectNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/*
 * ResourceController is a controller that gets the GET and POST request calls
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */

@Path("")
public class ResourceController {


    /*
     * This is a function that receives GET HTTP request on the path - /check/{number}
     * where number is the url parameter which needs to be check for Perfect Number.
     *
     * This function calls the 'isPerfectNumber' static method in the service class - PerfectNumberService
     *
     * @param int numberToBeChecked
     *
     * @return boolean flag in the JSON form
     */
    @GET
    @Path("/check/{number}")
    @Produces("application/json")
    public Boolean checkPerfectNumber(@PathParam("number") String strNumberToBeChecked) {
        return PerfectNumberService.isPerfectNumber(strNumberToBeChecked) ;
    }

    /*
     * This is a function that receives POST HTTP request on the path - /find
     * It has the JSON body of the form : {"startNumber":3, "endNumber":120}
     *
     * This function calls the 'findPerfectNumbers' static method in the service class - PerfectNumberService
     *
     * @param InputNumbersRange inputNumbersRange - An input object containing startNumber and endNumber indicating
     * the range of numbers between which all the Perfect Numbers should be found
     *
     * @return List<Integer> in the JSON form consisting of list of Perfect Numbers between
     * the startNumber and endNumber
     */
    @POST
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OutputPerfectNumbers getPerfectNumbersFromRange(InputNumbersRange inputNumbersRange) {
        return PerfectNumberService.findPerfectNumbers(inputNumbersRange);
    }
}
