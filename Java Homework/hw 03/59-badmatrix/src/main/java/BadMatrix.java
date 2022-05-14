

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b){
		int rows = data.length;
		int cols = data[0].length;
		int[][] ret = new int[rows][cols];

		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				ret[i][j] = data[i][j]+b[i][j];
			}
		}
		return ret;
	}
        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int a_rows = data.length;
		int a_cols = data[0].length;
		int b_cols = b[0].length;
		int[][] ret = new int[a_rows][b_cols];

		for (int i = 0; i<a_rows; i++){
			for (int j = 0; j<b_cols; j++){
				for (int m = 0; m<a_cols; m++){
					ret[i][j] = ret[i][j]+data[i][m]*b[m][j];
				}
			}
		}
		return ret;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString(){
		String lineBreak = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		int rows = data.length;
		int cols = data[0].length;
		sb.append(lineBreak);
		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				if (j == cols-1){
					sb.append(data[i][j]);
				}else {
					sb.append(data[i][j]);
					sb.append(" ");
				}
			}
			sb.append(lineBreak);
		}
		return sb.toString();
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
