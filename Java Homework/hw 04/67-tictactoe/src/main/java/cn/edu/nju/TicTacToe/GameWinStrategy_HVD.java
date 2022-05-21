package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD extends GameWinStrategy_HV {
	/**
	 * 根据需要修改获胜的方法
	 * @param chars  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] chars,String pos)
	{
		Result ret = super.check(chars,pos);

		if (ret.equals(Result.GAMING)){
			return checkDia(chars,pos);
		}
		else {
			return ret;
		}
	}

	public Result checkDia(char[][] chars, String pos){
		int row = pos.charAt(1)-'1';
		int col = pos.charAt(0)-'A';
		String ret;
		int size = chars.length;

		for (int i = 0; i<size; i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0;j<size;j++){
				//先查最下边的可能性
				if (row+i-j>=size || row+i-j<0){
					continue;
				}
				else {
					if (col-i+j>=size || col-i+j<0){
						continue;
					}else {
						sb.append(chars[row+i-j][col-i+j]);
					}
				}
			}
			ret = sb.toString();
			if (ret.length()>3){
				ret = ret.substring(0,3);
			}
			/*System.out.println("ret = "+ret);*/
			if (ret.equals("XXX")){
				return Result.X_WIN;
			} else if (ret.equals("OOO")) {
				return Result.O_WIN;
			}
		}

		for (int i = 0; i<size; i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0;j<size;j++){
				//先查最下边的可能性
				if (row+i-j>=size || row+i-j<0){
					continue;
				}
				else {
					if (col+i-j>=size || col+i-j<0){
						continue;
					}else {
						sb.append(chars[row+i-j][col+i-j]);
					}
				}
			}
			ret = sb.toString();
			if (ret.equals("XXX")){
				return Result.X_WIN;
			} else if (ret.equals("OOO")) {
				return Result.O_WIN;
			}
		}

		return checkDraw(chars);
	}
}