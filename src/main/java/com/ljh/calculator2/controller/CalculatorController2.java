package com.ljh.calculator2.controller;

import com.ljh.calculator2.dto.CalculationRequest2;
import com.ljh.calculator2.dto.CalculationResponse2;
import com.ljh.calculator2.service.CalculatorService2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/calculator")
public class CalculatorController2 {
//    java 방식으로 생성
//    CalculatorService2 calculatorService = new CalculatorService2();

//    Spring 방식1: 기본 연결 방식
//    @Autowired
//    CalculatorService2 calculatorService;

//    Spring 방식2: 생성자를 통한 객체 주입 방식.
    CalculatorService2 calculatorService2;
    public CalculatorController2(CalculatorService2 calculatorService) {
        this.calculatorService2 = calculatorService;
    }
//    ===== 문자열을 리턴 =====
//    @GetMapping("/add")
//    public String add() {
//        return new String("/덧셈");
//    }

//    ===== 더블 타입의 연산 결과를 리턴 =====
//    @GetMapping("/add")
//    public double add() {
//        return 10 + 5;
//    }

//    ===== 객체.메소드: 서비스 로직으로 연산 결과를 리턴 =====
//    @GetMapping("/add")
//    public double add(@RequestParam("num1") int num1 , @RequestParam ("num2") int num2) {
//        return calculatorService2.add(num1, num2);
//    }

//    ===== 1. 결과값: 서비스 로직으로 연산 결과 얻음 =====
//    ===== 2. 결과로 출력할 포맷을 dto(recode타입)를 사용하겠다. =====
//    ===== 3. return 타입을 dto(recode타입)로 수정해주자.
//    ===== 4. 브라우저 : 	http://localhost:8100/calculator/add?num1=250&num2=50
//    ===== 4. 브라우저 : 	http://localhost:8100/calculator/add?num1=250&num2=50
    @GetMapping("/add")
    public CalculationResponse2 add(@RequestParam("num1") int num1 , @RequestParam ("num2") int num2) {
        double result = calculatorService2.add(num1, num2);
        return new CalculationResponse2(num1, num2, "ADD", result);
    }

//    @GetMapping("/subtract")
//    public double subtract(){
//        return calculatorService2.subtract(10,5);
//    }

    @GetMapping("/subtract")
    public CalculationResponse2 subtract(@RequestParam("num1") int num1 , @RequestParam ("num2") int num2) {
        double result = calculatorService2.add(num1, num2);
        return new CalculationResponse2(num1, num2, "SUBTRACT", result);
    }

//    @GetMapping("/multiply")
//    public double multiply(){
//        return calculatorService2.multiply(10,5);
//    }

    @GetMapping("/multiply")
    public CalculationResponse2 multiply(@RequestParam("num1") int num1 , @RequestParam ("num2") int num2) {
        double result = calculatorService2.add(num1, num2);
        return new CalculationResponse2(num1, num2, "MULTIPLY", result);
    }

//    @GetMapping("/divide")
//    public double divide(){
//        return calculatorService2.divide(10,5);
//    }

    @GetMapping("/divide")
    public CalculationResponse2 divide(@RequestParam("num1") int num1 , @RequestParam ("num2") int num2) {
        double result = calculatorService2.add(num1, num2);
        return new CalculationResponse2(num1, num2, "DIVIDE", result);
    }
//    ===== Post 메소드 테스트 : entity 문자열을 리턴 =====
//    ENDpoint 테스트: http://localhost:8100/calculator/calculate
//    @PostMapping("/calculate")
//    public String postMethodName(@RequestBody String entity){
//
//        return entity;
//    }

//  ===== 1. @RequestBody : 객체 방식으로 값을 저장 =====
//  ===== 2. result : 연산 결과 값을 저장 =====
//  ===== 3. return : 출력포맷 객체 방식으로 화면에 출력해줌 =====
//    @PostMapping("/calculate")
//    public CalculationResponse postMethodName(@RequestBody CalculationRequest request){
// //      request ==>> num1 = 100, num2 = 50, operation = "ADD"
//
// //      result(150) = 더하기(100, 50)
//        double result = calculatorService2.add(request.getNum1(),request.getNum2());
// //      출력 포맷을 결정
// //      num1 = 100, num2 = 50, operation = "ADD", result = 150
//        return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
//    }

//    테스트 : 	http://localhost:8090/calculator/calculate
//    {
//    "num1" : 100,
//    "num2" : 50,
//    "operation" : "+", "-", "*", "/"
//    }
    @PostMapping("/calculate")
    public CalculationResponse2 postMethodName(@RequestBody CalculationRequest2 request){

//      + - * / 사칙연산
        double result = calculatorService2.calculate(request.getNum1(),request.getNum2(), request.getOperation());

        return new CalculationResponse2(request.getNum1(), request.getNum2(), request.getOperation(), result);
    }
}
