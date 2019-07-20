package com.worldline.pankaj.test.utilities;

/*
 * An object of this class represents a test case to be tested.
 *
 * Field 'inputString' represents the input to be given to either a GET or POST HTTP request
 * Field 'expectedResponseBody' represents the expected response (BODY) of the test case in JSON formatted String
 * Field 'expectedOutputResponseCode' represents the expected HTTP Response Code upon invoking GET/POST HTTP request
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */
public class TestCase {

    private int testCaseId ;
    private String inputString ;
    private String expectedResponseBody ;
    private int expectedOutputResponseCode ;

    public TestCase(int testCaseId, String inputString, String expectedResponseBody, int expectedOutputResponseCode) {
        this.testCaseId = testCaseId;
        this.inputString = inputString;
        this.expectedResponseBody = expectedResponseBody;
        this.expectedOutputResponseCode = expectedOutputResponseCode;
    }

    public int getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(int testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getExpectedResponseBody() {
        return expectedResponseBody;
    }

    public void setExpectedResponseBody(String expectedResponseBody) {
        this.expectedResponseBody = expectedResponseBody;
    }

    public int getExpectedOutputResponseCode() {
        return expectedOutputResponseCode;
    }

    public void setExpectedOutputResponseCode(int expectedOutputResponseCode) {
        this.expectedOutputResponseCode = expectedOutputResponseCode;
    }
}
