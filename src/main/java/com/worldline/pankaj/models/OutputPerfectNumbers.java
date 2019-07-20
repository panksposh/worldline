package com.worldline.pankaj.models;

import java.util.List;

/*
 * OutputPerfectNumbers is a model Output object which is returned as a response JSON object on calling the
 * HTTP POST method to find out all the positive numbers between a range of numbers provided
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */
public class OutputPerfectNumbers {

    /*
       It is a list to store all the positive perfect numbers between
     * a range provided in the InputNumbersRange object
     */
    List<Integer> perfectNumbersList ;

    public List<Integer> getPerfectNumbersList() {
        return perfectNumbersList;
    }

    public void setPerfectNumbersList(List<Integer> perfectNumbersList) {
        this.perfectNumbersList = perfectNumbersList;
    }
}
