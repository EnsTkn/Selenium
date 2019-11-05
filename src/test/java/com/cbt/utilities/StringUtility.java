package com.cbt.utilities;

public class StringUtility {

            public static void verifyEquals(String expected, String actual) {
                if(expected.equalsIgnoreCase(actual)){
                    System.out.println("Test Passed");
                    System.out.println("expected: "+expected);
                    System.out.println("actual: "+actual);
                }else{
                    System.out.println("Test Failed");
                    System.out.println("expected: "+expected);
                    System.out.println("actual: "+actual);
                }
            }


}
