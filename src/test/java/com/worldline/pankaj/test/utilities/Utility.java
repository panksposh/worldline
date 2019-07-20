package com.worldline.pankaj.test.utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/*
 * Utility class having necessary functions to help execute Junit Test cases. This class is used by the Junit Test
 * class - TestPerfectNumberApplication.java
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */

public class Utility {

    private static int port = 8284;

    private static String servletContextPath = "perfectnumber" ;

    private static String uriForCheckingPerfectNumber = "/check/" ;

    private static String uriForFindingPerfectNumbers = "/find" ;

    /*
     * This function actually invokes the HTTP GET request and returns the response in the form of a custom
     * ResponseObject
     *
     * @param int numberToBeChecked
     *
     * @return ResponseObject
     */

    public static ResponseObject checkIfPerfectNumber(String numberToBeChecked) throws Exception {

        String url = "http://localhost:"+port+"/"+servletContextPath+uriForCheckingPerfectNumber+numberToBeChecked;

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(url);

        request.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(request);
        int responseCode = response.getStatusLine().getStatusCode();
        String responseBody = returnResponseString(response) ;

        ResponseObject responseObject = new ResponseObject(responseBody,responseCode) ;

        return responseObject;
    }

    /*
     * This function actually invokes the HTTP POST request and returns the response in the form of a custom
     * ResponseObject
     *
     * @param String input - The JSON formatted String input consisting of start and end numbers
     *
     * @return ResponseObject
     */
    public static ResponseObject findPerfectNumbers(String input) throws Exception {

        String url = "http://localhost:"+port+"/"+servletContextPath+uriForFindingPerfectNumbers;

        HttpPost post = new HttpPost(url);

        HttpClient client = HttpClientBuilder.create().build();

        post.setHeader("Accept", "application/json");

        StringEntity entity = new StringEntity(input);
        entity.setContentType("application/json");

        post.setEntity(entity);

        HttpResponse response = client.execute(post);

        int responseCode = response.getStatusLine().getStatusCode();

        String responseBody = returnResponseString(response) ;

        ResponseObject responseObject = new ResponseObject(responseBody,responseCode) ;

        return responseObject;
    }

    private static String returnResponseString(HttpResponse response) throws Exception {

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString() ;
    }

    public static void createTestCase(List<TestCase> listOfTestCases, TestCase testCase) {
        listOfTestCases.add(testCase) ;
    }
}
