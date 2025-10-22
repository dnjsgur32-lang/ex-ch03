package com.ljh.calculator.dto;

public record CalculationResponse(
        double num1,
        double num2,
        String operation,
        String result) {

}


