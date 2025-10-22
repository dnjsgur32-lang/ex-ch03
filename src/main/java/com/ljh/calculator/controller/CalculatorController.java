package com.ljh.calculator.controller;

import com.ljh.calculator.dto.CalculationRequest;
import com.ljh.calculator.dto.CalculationResponse;
import com.ljh.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculator")
public class CalculatorController {

//    사용법1: Autowired 어노테이션을 사용하는 방법: 객체obj
//    @Autowired
//    CalculatorService calculatorService;

    //    사용법2: 생성자를 사용하는 방법: 객체obj
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

@PostMapping("/calculate")
public CalculationResponse calculate(@RequestBody CalculationRequest request){
    String result = calculatorService.calculate(request.getNum1(),request.getNum2(),request.getOperation());
    return new CalculationResponse(request.getNum1(),request.getNum2(),request.getOperation(), result);
//    return "test";
    }

//    @GetMapping("/add")
//    public String add(@RequestParam double num1, @RequestParam double num2){
//        return calculatorService.add(num1, num2);
//    }

//    http://localhost:8080/calculator/add?num1=100&num2=4
    @GetMapping("/add")
    public CalculationResponse add(@RequestParam double num1, @RequestParam double num2) {
//        return calculatorService.add(num1, num2);
        String result = calculatorService.add(num1, num2);
        return new CalculationResponse(num1, num2, "ADD", result);

    }

//    @GetMapping("/subtract")
//    public String subtract(@RequestParam double num1, @RequestParam double num2) {
//        return calculatorService.subtract(num1, num2);
//    }

//http://localhost:8080/calculator/subtract?num1=100&num2=4
    @GetMapping("/subtract")
    public CalculationResponse subtract(@RequestParam double num1, @RequestParam double num2) {
        String result = calculatorService.subtract(num1, num2);
        return new CalculationResponse(num1, num2, "SUBTRACT", result);
    }

//    @GetMapping("/multiply")
//    public String multiply(@RequestParam double num1, @RequestParam double num2) {
//        return calculatorService.multiply(num1, num2);
//    }

//    http://localhost:8080/calculator/multiply?num1=100&num2=4
    @GetMapping("/multiply")
    public CalculationResponse multiply(@RequestParam double num1, @RequestParam double num2) {
        String result = calculatorService.multiply(num1, num2);
        return new CalculationResponse(num1, num2, "MULTIPLY", result);
    }

//    @GetMapping("/divide")
//    public String divide(@RequestParam double num1, @RequestParam double num2) {
//        return calculatorService.divide(num1, num2);
//    }

//    http://localhost:8080/calculator/divide?num1=100&num2=4
    @GetMapping("/divide")
    public CalculationResponse divide(@RequestParam double num1, @RequestParam double num2) {
        String result = calculatorService.divide(num1, num2);
        return new CalculationResponse(num1, num2, "DIVIDE", result);
    }

}
