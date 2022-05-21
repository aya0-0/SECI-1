package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV {
	/**
	 * 自行实现检测获胜的方法
	 * @param chars  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] chars, String pos)
	{
		int row = pos.charAt(1)-'1';
		int col = pos.charAt(0)-'A';
		String ret;
		int size = chars.length;

		//检查行
		for (int i = 0; i<size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; j++) {
				//先查最右边的可能性
				if (col - i + j >= size || col - i + j < 0) {
					continue;
				} else {
					sb.append(chars[row][col - i + j]);
				}
			}

			ret = sb.toString();
			if (ret.length()>3){
				ret = ret.substring(0,3);
			}
			/*System.out.println("H ret = "+ret);*/
			if (ret.equals("XXX")) {
				return Result.X_WIN;
			} else if (ret.equals("OOO")) {
				return Result.O_WIN;
			}
		}

		//检查列
		for (int i = 0; i<size; i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0;j<size;j++){
				//先查最下边的可能性
				if (row-i+j>= size || row-i+j<0){
					continue;
				}
				else {
					sb.append(chars[row-i+j][col]);
				}
			}

			ret = sb.toString();
			if (ret.length()>3){
				ret = ret.substring(0,3);
			}
			/*System.out.println("V ret = "+ret);*/
			if (ret.equals("XXX")){
				return Result.X_WIN;
			} else if (ret.equals("OOO")) {
				return Result.O_WIN;
			}
		}

		return checkDraw(chars);
	}

	public Result checkDraw(char[][] chars){
		for (char[] line:chars){
			for (char c:line){
				if (c == '_'){
					return Result.GAMING;
				}
			}
		}
		return Result.DRAW;
	}
}