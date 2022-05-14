package edu.nju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int rows = A.length;
		int cols = A[0].length;
		int[][] ret = new int[rows][cols];

		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				ret[i][j] = A[i][j]+B[i][j];
			}
		}

		return ret;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int a_rows = A.length;
		int a_cols = A[0].length;
		int b_cols = B[0].length;
		int[][] ret = new int[a_rows][b_cols];

		for (int i = 0; i<a_rows; i++){
			for (int j = 0; j<b_cols; j++){
				for (int m = 0; m<a_cols; m++){
					ret[i][j] = ret[i][j]+A[i][m]*B[m][j];
				}
			}
		}

		return ret;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int rows = Integer.parseInt(line.split(" ")[0]);
		int cols = Integer.parseInt(line.split(" ")[1]);

		int[][] A = new int[rows][cols];

		for(int i = 0; i<rows; i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			for (int j = 0; j<cols; j++){
				A[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}

		int[][] B = new int[rows][cols];
		try {
			br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i = 0; i<rows; i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			for (int j = 0; j<cols; j++){
				B[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}

		if (rows == 0){
			return A;
		}else {
			return plus(A,B);
		}

	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int rows = Integer.parseInt(line.split(" ")[0]);
		int cols = Integer.parseInt(line.split(" ")[1]);

		int[][] A = new int[rows][cols];

		for(int i = 0; i<rows; i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			for (int j = 0; j<cols; j++){
				A[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}


		try {
			line = br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		rows = Integer.parseInt(line.split(" ")[0]);
		cols = Integer.parseInt(line.split(" ")[1]);

		int[][] B = new int[rows][cols];

		for(int i = 0; i<rows; i++){
			try {
				line = br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			for (int j = 0; j<cols; j++){
				B[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}

		if (rows == 0 || cols == 0){
			return A;
		}else {
			return times(A,B);
		}
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A){
		String lineBreak = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		int rows = A.length;
		int cols = A[0].length;
		sb.append(lineBreak);
		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				if (j == cols-1){
					sb.append(A[i][j]);
				}else {
					sb.append(A[i][j]);
					sb.append(" ");
				}
			}
			sb.append(lineBreak);
		}
		System.out.print(sb.toString());
	}
}
