/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import java.util.Date;

/**
 *
 * @author seramirez
 */
public class Clock {

    //Declaration of globalvariable for access to any class
    private static Clock clock;

    //Private constructor to restrict instance with new operator
    private Clock() {
    }

    //Method create instance use synchronized for assign creation to a single thread
    private synchronized static void createInstance() {
        if (clock == null) {
            clock = new Clock();
            clock.initializeClock();
        }
    }

    //Return the instance
    public static Clock getInstance() {
        createInstance();
        return clock;
    }

    public void initializeClock() {
        while (true) {
            Date hour = new Date(System.currentTimeMillis());
            System.out.println(hour);

            try {
                
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
