import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int rows = this.data.length;
		if (rows == 0){
			int[][] _data = new int[0][0];
			MyMatrix mm = new MyMatrix(_data);
			return mm;
		}
		int cols = this.data[0].length;
		int[][] _data = new int[rows][cols];

		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				_data[i][j] = this.data[i][j]+B.data[i][j];
			}
		}

		MyMatrix mm = new MyMatrix(_data);
		return  mm;
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int a_rows = this.data.length;
		if (a_rows == 0 || B.data.length == 0){
			int[][] ret = new int[0][0];
			MyMatrix mm = new MyMatrix(ret);
			return mm;
		}
		int a_cols = this.data[0].length;
		int b_cols = B.data[0].length;
		int[][] ret = new int[a_rows][b_cols];

		for (int i = 0; i<a_rows; i++){
			for (int j = 0; j<b_cols; j++){
				for (int m = 0; m<a_cols; m++){
					ret[i][j] = ret[i][j]+this.data[i][m]*B.data[m][j];
				}
			}
		}

		MyMatrix mm = new MyMatrix(ret);
		return mm;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int rows = this.data.length;
		if (rows == 0){
			int[][] _data = new int[0][0];
			MyMatrix mm = new MyMatrix(_data);
			return mm;
		}
		int cols = this.data[0].length;
		int[][] _data = new int[rows][cols];

		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				_data[i][j] = b*this.data[i][j];
			}
		}

		MyMatrix mm = new MyMatrix(_data);
		return mm;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int rows = this.data.length;
		if (rows == 0){
			int[][] ret = new int[0][0];
			MyMatrix mm = new MyMatrix(ret);
			return mm;
		}
		int cols = this.data[0].length;
		int[][] ret = new int[cols][rows];

		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				ret[j][i] = this.data[i][j];
			}
		}

		MyMatrix mm = new MyMatrix(ret);
		return mm;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
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

		/*int[][] B = new int[rows][cols];
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
		}*/

		MyMatrix mmA = new MyMatrix(A);
//		MyMatrix mmB = new MyMatrix(B);

		if (rows == 0){
			int[][] ret = new int[0][0];
			MyMatrix mm = new MyMatrix(ret);
			return mm;
		}else {
			return this.plus(mmA);
		}
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
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

		/*int[][] B = new int[rows][cols];
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
		}*/

		MyMatrix mmA = new MyMatrix(A);
//		MyMatrix mmB = new MyMatrix(B);

		if (rows == 0){
			int[][] ret = new int[0][0];
			MyMatrix mm = new MyMatrix(ret);
			return mm;
		}else {
			return this.times(mmA);
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
	public void print(){
		String lineBreak = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		int rows = this.data.length;
		int cols = this.data[0].length;
		sb.append(lineBreak);
		for (int i = 0; i<rows; i++){
			for (int j = 0; j<cols; j++){
				if (j == cols-1){
					sb.append(this.data[i][j]);
				}else {
					sb.append(this.data[i][j]);
					sb.append(" ");
				}
			}
			sb.append(lineBreak);
		}
		System.out.println(sb.toString());
	}
}
