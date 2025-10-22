package com.ljh.calculator2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService2 {

//    add(10,5)
//    서로 다른 패키지 - 리턴 타입 - add(10,5)
    public double add(double num1, double num2) {
        double result = num1 + num2;
        return result;
//        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        return result;
    }

    public double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    public double divide(double num1, double num2) {
//        0으로 나눌 수 없음.
        if (num2 == 0)
            throw new ArithmeticException("0으로 나눌 수 없음");
        return (num1 / num2);
    }

    public double calculate(double num1, double num2, String operation) {
//        사칙연산을 구분해서 수행 + - * /
//        switch (소문자로 변경 operation)
        return switch (operation.toLowerCase()) {
            case "+" -> add(num1, num2);
            case "-" -> subtract(num1, num2);
            case "*" -> multiply(num1, num2);
            case "/" -> divide(num1, num2);
            default -> throw new IllegalArgumentException
                    ("Unexpected value: " + operation.toLowerCase());
        };

    }
}
