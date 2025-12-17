package org.example;

import org.example.Classes.JSPLoginTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );

        JSPLoginTest test=new JSPLoginTest();
        test.testLoginJSP();
    }
}
