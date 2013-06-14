/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author skatam
 *
 */
@ManagedBean
@RequestScoped
public class SpinnerController {


	private int number1;
	
	private double number2;
	
	private int number3;
	
	private int number4;
	
	private int number5;
	
	private int number6;

    private int number7;

	public int getNumber1() {
		return number1;
	}
	
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	
	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	
	public int getNumber3() {
		return number3;
	}

	public void setNumber3(int number3) {
		this.number3 = number3;
	}

	public int getNumber4() {
		return number4;
	}

	public void setNumber4(int number4) {
		this.number4 = number4;
	}

	public int getNumber5() {
		return number5;
	}

	public void setNumber5(int number5) {
		this.number5 = number5;
	}
	

}
