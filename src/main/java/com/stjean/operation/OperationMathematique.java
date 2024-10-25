package com.stjean.operation;

import java.util.Arrays;
import java.util.Collections;

public class OperationMathematique {
	
	public boolean estPositif(int nombre) {
	    return nombre > 0;
	}
	
	public int factorial(int number) {
	    if (number <= 1) return 1;
	    return number * factorial(number - 1);
	}
	


	public Integer[] sort(Integer[] lists) {
	    Arrays.sort(lists, Collections.reverseOrder());
	    return lists;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
