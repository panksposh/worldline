package com.worldline.pankaj.services;

import com.worldline.pankaj.models.InputNumbersRange;
import com.worldline.pankaj.models.OutputPerfectNumbers;
import com.worldline.pankaj.validators.InputValidator;

import java.util.ArrayList;
import java.util.List;

/*
 * PerfectNumberService is a Service class having the actual business logic to check whether a given number is a
 * Perfect Number and to find all the perfect numbers between a given range of positive numbers
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */

public class PerfectNumberService {

    /*
     * This is a function that checks whether the given number is a Perfect Number.
     * The logic used is the given number is checked for being a multiple of each number from 2 to
     * the number half of the given number. If number is found to be divisor of the given number, it is added to
     * the sum (with initial value of 1). At the end, the cumulative sum is checked whether it is equal to the
     * given number. If it is equal, it is a Perfect Number and true is written, else false is written
     *
     * @param int numberToBeChecked
     *
     * @return boolean flag - true if the given number is a Perfect Number, else false
     */
    public static Boolean isPerfectNumber(String strNumberToBeChecked) {

        int numberToBeChecked = InputValidator.validateNumberToBeChecked(strNumberToBeChecked);

        boolean perfectNumberFlag = false ;

        if (numberToBeChecked > 1) {

            int sum = 1;

            for (int i = 2; i <= (numberToBeChecked / 2); i++) {
                if (numberToBeChecked % i == 0) {
                    sum += i;
                }
            }

            if (sum == numberToBeChecked)
                perfectNumberFlag = true;
        }

        return new Boolean(perfectNumberFlag) ;
    }

    /*
     * This is a function that finds all the Perfect Numbers between a range of numbers provided in the form of an
     * object - InputNumbersRange which has two fields - startNumber and endNumber.
     *
     * The logic used is that it simply calls isPerfectNumber() function for each number in the range. If any number
     * is found to be Perfect Number, it is added in the list and at the end, the final list is added to the field
     * 'perfectNumbersList' of the object of class OutputPerfectNumbers
     *
     * @param InputNumbersRange input
     *
     * @return OutputPerfectNumbers - consists of List<Integer> having all the positive perfect numbers between
     * a range provided in the InputNumbersRange object.
     */
    public static OutputPerfectNumbers findPerfectNumbers(InputNumbersRange input) {

        InputValidator.validateStartAndEndNumbers(input) ;

        List<Integer> perfectNumbersList = new ArrayList<Integer>() ;

        OutputPerfectNumbers outputPerfectNumbers = new OutputPerfectNumbers() ;

        for (int i = input.getStartNumber() ; i <= input.getEndNumber() ; i++) {
            if (isPerfectNumber(""+i)) {
                perfectNumbersList.add(i) ;
            }
        }

        outputPerfectNumbers.setPerfectNumbersList(perfectNumbersList);

        return outputPerfectNumbers ;
    }
}
