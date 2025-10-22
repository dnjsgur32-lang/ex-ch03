package com.ljh.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String add(double num1, double num2) {
        String result = String.valueOf(num1 + num2);
        return result;
    } //덧셈

    public String subtract(double num1, double num2) {
        String result = String.valueOf(num1 - num2);
        return result;
    } //뺄셈

    public String multiply(double num1, double num2) {
        String result = String.valueOf(num1 * num2);
        return result;
    } //곱셈

    public String divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        String result = String.valueOf(num1 / num2);
        return result;
    } //나눗셈

    public String calculate(double num1, double num2, String operation) {
        if (operation == null || operation.trim().isEmpty()) {
            throw new IllegalArgumentException("operation은 필수입니다");
        }
        return switch (operation.toUpperCase()) {
            case "ADD" -> add(num1, num2);
            case "SUBTRACT" -> subtract(num1, num2);
            case "MULTIPLY" -> multiply(num1, num2);
            case "DIVIDE" -> divide(num1, num2);
            default -> throw new IllegalArgumentException("적합하지 않은 연산자");
        };
    }
}
