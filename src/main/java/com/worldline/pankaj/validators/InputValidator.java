package com.worldline.pankaj.validators;

import com.worldline.pankaj.models.InputNumbersRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;

/*
 * InputValidator is a custom validator created to validate the input number to be checked for a Perfect Number
 * or to validate the number range given
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */

public class InputValidator {

    private static final Logger logger = LoggerFactory.getLogger(InputValidator.class);


    /*
     * This is a validator function to validate if the number to be checked is a valid number.
     * It also validates if the number is less than 0.
     *
     * If the validation fails, it throws BadRequestException
     *
     * @param String strNumberToBeChecked
     *
     * @return int - returns the int value of the input String if the input String is successfully validated and
     * if it is a number
     */
    public static int validateNumberToBeChecked(String strNumberToBeChecked) {

        int numberToBeChecked ;
        try {
            numberToBeChecked = (new Integer(strNumberToBeChecked)).intValue() ;
        }
        catch(NumberFormatException nfe) {
            logger.error("Input should be a number. The input entered is '"+strNumberToBeChecked+"'");
            throw new BadRequestException() ;
        }

        if (numberToBeChecked<=0) {
            logger.error("Number to be checked should be greater than 0");
            throw new BadRequestException() ;
        }

        return numberToBeChecked ;
    }

    /*
     * This is a validator function to validate the numbers entered in the input range.
     * It validates if either/ both the start and end numbers are less than .
     * It also validates if end number is less than start number.
     *
     * If the validation fails, it throws BadRequestException
     *
     * @param InputNumbersRange inputNumbersRange
     *
     * @return void
     */
    public static void validateStartAndEndNumbers(InputNumbersRange inputNumbersRange) {
        int startNumber = inputNumbersRange.getStartNumber() ;
        int endNumber = inputNumbersRange.getEndNumber() ;

        if (startNumber <=0 || endNumber <= 0) {
            logger.error("Numbers in the range should be greater than 0");
            throw new BadRequestException() ;
        }

        if  (startNumber >= endNumber) {
            logger.error("Start Number should be less than End Number");
            throw new BadRequestException() ;
        }
    }
}
