package com.kla;

import java.util.Scanner;
import java.util.HashMap;

public class FinFal {

    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static HashMap<Integer, Double> memo = new HashMap<>();
    public static double futureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        if (memo.containsKey(years)) return memo.get(years);
        double result = futureValueMemo(presentValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter present value (e.g., 1000): ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.1 for 10%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        double resultRecursive = futureValue(presentValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + resultRecursive);

        double resultMemoized = futureValueMemo(presentValue, growthRate, years);
        System.out.println("Future Value (Memoized): " + resultMemoized);

        scanner.close();
    }
}