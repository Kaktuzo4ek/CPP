package com.lab_cp.lab_1;
import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;

        n = scan.nextInt();
        if(n<15){
            double sum = 0.0;
            for (int i = 0; i < n ; i++) {
                sum += (1.0/(1.0+(double) i));
            }
            System.out.println("Sum = " + sum );
        }
        else{
            BigDecimal sum = new BigDecimal("0.0");
            BigDecimal in = new BigDecimal("1.0");

            for (int i = 0; i < n ; i++) {
                BigDecimal p = new BigDecimal(i);
                sum = sum.add(in.divide(in.add(p),10, RoundingMode.HALF_UP));
            }
            System.out.println("Sum = " + sum );
        }
    }
}