package com.worldline.pankaj.models;

/*
 * InputNumbersRange is a model Input object which is an input JSON object for the
 * HTTP POST method to find out all the positive numbers between a range of numbers provided
 *
 * @author Pankaj Poshirkar
 * @date   18 July 2019
 */
public class InputNumbersRange {

    /*
        The starting positive number to find out all the Perfect Numbers from
     */
    private int startNumber;

    /*
        The last positive number to find out all the Perfect Numbers upto
    */
    private int endNumber;

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }
}
