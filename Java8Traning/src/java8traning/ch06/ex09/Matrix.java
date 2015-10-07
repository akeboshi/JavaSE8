/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex09;


import java.util.Arrays;

public class Matrix {
	public static void main(String[] args) {
		Matrix F = new Matrix(1,1,1,0);
		int n = 1000;
		Matrix[] result = new Matrix[n];
		Arrays.parallelSetAll(result,x -> F);
		Arrays.parallelPrefix(result, Matrix::multiply);
		System.out.println("fibonacci n = " + n + ": " + result[n-2].getFibonacci());
		Arrays.stream(result).forEach(x -> System.out.println(x.getFibonacci()));
	}

	private double[][] arr = new double[2][2];
	public Matrix (double arr11, double arr12, double arr21, double arr22) {
		arr[0][0] = arr11;
		arr[0][1] = arr12;
		arr[1][0] = arr21;
		arr[1][1] = arr22;
	}

	private Matrix (double[][] arr){
		this.arr = arr;
	}

	public double[][] getData(){
		return arr;
	}

	public double getFibonacci(){
		return arr[0][0];
	}

	public Matrix multiply (Matrix matrix) {
		double[][] other = matrix.getData();
		double[][] result = new double[2][2];
		for (int i = 0; i < 2 ; i++ ){
			for (int j = 0; j < 2 ; j++) {
				result[i][j] = 0;
				for (int k = 0; k < 2; k++)
				result[i][j] += arr[i][k] * other[k][j];
			}
		}
		return new Matrix(result);
	}
}