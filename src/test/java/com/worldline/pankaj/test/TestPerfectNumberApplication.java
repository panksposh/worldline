package com.worldline.pankaj.test;

import com.worldline.pankaj.test.utilities.ResponseObject;
import com.worldline.pankaj.test.utilities.TestCase;
import com.worldline.pankaj.test.utilities.Utility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPerfectNumberApplication {

    private static final Logger logger = LoggerFactory.getLogger(TestPerfectNumberApplication.class);


    @Test
    public void testIsPerfectNumber() throws Exception {

        List<TestCase> listOfTestCases = new ArrayList<TestCase>();

        Utility.createTestCase(listOfTestCases, new TestCase(1, "496",
                "true", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(2, "1",
                "false", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(3, "2",
                "false", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(4, "6",
                "true", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(5, "28",
                "true", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(6, "52",
                "false", 200));


        listOfTestCases.forEach(testCase -> {

            try {
                String inputString = testCase.getInputString();
                String expectedResponseBody = testCase.getExpectedResponseBody();
                int expectedResponseCode = testCase.getExpectedOutputResponseCode();

                /*
                    The function Utility.checkIfPerfectNumber actually invokes the GET request for checking
                    the given number is a Perfect Number
                 */
                ResponseObject responseObject = Utility.checkIfPerfectNumber(inputString);


                String actualResponseBody = responseObject.getResponseBody();
                int actualResponseCode = responseObject.getResponseCode();

                /*
                    Assertion for Response Body
                 */
                assertEquals(expectedResponseBody, actualResponseBody,
                        "Test Case " + testCase.getTestCaseId() + " Failed!! " +
                                " Input: " + inputString +
                                ", Expected: " + expectedResponseBody + ", Actual: " + actualResponseBody);

                /*
                    Assertion for Response Code
                 */
                assertEquals(expectedResponseCode, actualResponseCode,
                        "Test Case " + testCase.getTestCaseId() + " Failed!! " +
                                " Input: " + inputString +
                                ", Expected Response Code: " + expectedResponseCode + ",  " +
                                "Actual Response Code: " + actualResponseCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testFindPerfectNumbers() throws Exception {

        List<TestCase> listOfTestCases = new ArrayList<TestCase>();

        Utility.createTestCase(listOfTestCases, new TestCase(1, "{\"startNumber\":3,\"endNumber\":120}",
                "{\"perfectNumbersList\":[6,28]}", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(2, "{\"startNumber\":3,\"endNumber\":10}",
                "{\"perfectNumbersList\":[6]}", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(3, "{\"startNumber\":3,\"endNumber\":5}",
                "{\"perfectNumbersList\":[]}", 200));
        Utility.createTestCase(listOfTestCases, new TestCase(4, "{\"startNumber\":3,\"endNumber\":1200}",
                "{\"perfectNumbersList\":[6,28,496]}", 200));

        listOfTestCases.forEach(testCase -> {

            try {

                String inputString = testCase.getInputString();
                String expectedResponseBody = testCase.getExpectedResponseBody();
                int expectedResponseCode = testCase.getExpectedOutputResponseCode();

                /*
                    The function Utility.findPerfectNumbers actually invokes the POST request for finding
                    all the Perfect Numbers from a given numbers range
                 */
                ResponseObject responseObject = Utility.findPerfectNumbers(inputString);

                String actualResponseBody = responseObject.getResponseBody();
                int actualResponseCode = responseObject.getResponseCode();

                /*
                    Assertion for Response Body
                 */
                assertEquals(expectedResponseBody, actualResponseBody,
                        "Test Case " + testCase.getTestCaseId() + " Failed!! " +
                                " Input: " + inputString +
                                ", Expected: " + expectedResponseBody + ", Actual: " + actualResponseBody);

                /*
                    Assertion for Response Code
                 */
                assertEquals(expectedResponseCode, actualResponseCode,
                        "Test Case " + testCase.getTestCaseId() + " Failed!! " +
                                " Input: " + inputString +
                                ", Expected Response Code: " + expectedResponseCode + ",  " +
                                "Actual Response Code: " + actualResponseCode);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /*
     Tests for HTTP.BadRequest when the Response Code is 400, when the input number entered is less than 1
    */
    @Test
    public void testIsPerfectNumber_negativeScenarios() throws Exception {

        String inputString = "-1";
        int expectedResponseCode = 400 ;

        ResponseObject responseObject = Utility.checkIfPerfectNumber(inputString);

        int actualResponseCode = responseObject.getResponseCode();

        assertEquals(expectedResponseCode, actualResponseCode);
    }

    /*
        Testing negative scenario of End Number being smaller than Start Number.
    */
    @Test
    public void testFindPerfectNumbers_negativeScenarios() throws Exception {


        String inputString = "{\"startNumber\":120,\"endNumber\":13}";
        int expectedResponseCode = 400 ;

        ResponseObject responseObject = Utility.findPerfectNumbers(inputString);

        int actualResponseCode = responseObject.getResponseCode();

        assertEquals(expectedResponseCode, actualResponseCode);
    }
}
