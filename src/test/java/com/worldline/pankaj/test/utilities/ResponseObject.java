package com.worldline.pankaj.test.utilities;

/*
 * An object of this class represents a Response provided by either a GET or a POST HTTP request.
 *
 * Field 'responseBody' represents the response (BODY) of a GET/POST HTTP request
 * Field 'responseCode' represents the HTTP Response Code upon invoking GET/POST HTTP request
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */
public class ResponseObject {

    private String responseBody ;
    private int responseCode ;

    public ResponseObject(String responseBody, int responseCode) {
        this.responseBody = responseBody;
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
