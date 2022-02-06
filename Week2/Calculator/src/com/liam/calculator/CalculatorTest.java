package com.liam.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
        Calculator c = new Calculator();
        
        c.setOperandOne(10.6);
        c.setOperandTwo(5.9);
        c.setOperator('*');
        
        c.performOperation();
        c.getResults();

	}

}
