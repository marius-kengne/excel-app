package org.example;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int sum(int a, int b) {
        return a+b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public void longExcecution(){
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        final Set<Integer> result = new HashSet<>();
        final String stringNumber = String.valueOf(number);

        for (int i = 0; i < stringNumber.length(); i++) {
            result.add(Integer.parseInt(stringNumber,i,i+1,10));
        }

        return result;
    }
}
