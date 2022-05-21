public class GameWinStrategy {

    public Result checkWin(char[][] chars, String pos){
        Result ret;
        ret = checkRow(chars,pos);
        //判断横向赢了没，赢了就返回Result，没赢就继续判断
        if (ret.equals(Result.GAMING)){
            ret = checkColumn(chars,pos);
            //判断竖向赢了吗
            if (ret.equals(Result.GAMING)){
                ret = checkDiag_LTtoRB(chars,pos);
                //判断左上到右下赢了吗
                if (ret.equals(Result.GAMING)){
                    ret = checkDiag_LBtoRT(chars,pos);
                    //判断左下到右上赢了吗
                    if (ret.equals(Result.GAMING)){
                        //检查是不是平局
                        ret = checkDraw(chars);
                        return ret;
                    }
                    else {
                        return ret;
                    }
                }
                else {
                    return ret;
                }
            }
            else {
                return ret;
            }
        }else {
            return ret;
        }
    }

    //检查行
    public Result checkRow(char[][] chars, String pos){
        int row = pos.charAt(1)-'1';
        int col = pos.charAt(0)-'A';
        String ret;

        for (int i = 0; i<3; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<3;j++){
                //先查最右边的可能性
                if (col-i+j>=3 || col-i+j<0){
                    continue;
                }
                else {
                    sb.append(chars[row][col-i+j]);
                }
            }

            ret = sb.toString();
            if (ret.equals("XXX")){
                return Result.X_WIN;
            } else if (ret.equals("OOO")) {
                return Result.O_WIN;
            }
        }

        return Result.GAMING;
    }

    //检查列
    public Result checkColumn(char[][] chars, String pos){
        int row = pos.charAt(1)-'1';
        int col = pos.charAt(0)-'A';
        String ret;

        for (int i = 0; i<3; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<3;j++){
                //先查最下边的可能性
                if (row-i+j>2 || row-i+j<0){
                    continue;
                }
                else {
                    sb.append(chars[row-i+j][col]);
                }
            }

            ret = sb.toString();
            if (ret.equals("XXX")){
                return Result.X_WIN;
            } else if (ret.equals("OOO")) {
                return Result.O_WIN;
            }
        }

        return Result.GAMING;
    }

    //检查左上角到右下角的斜线
    public Result checkDiag_LTtoRB(char[][] chars, String pos){
        int row = pos.charAt(1)-'1';
        int col = pos.charAt(0)-'A';
        String ret;

        for (int i = 0; i<3; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<3;j++){
                //先查最下边的可能性
                if (row+i-j>2 || row+i-j<0){
                    continue;
                }
                else {
                    if (col+i-j>2 || col+i-j<0){
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

        return Result.GAMING;
    }

    public Result checkDiag_LBtoRT(char[][] chars, String pos){
        int row = pos.charAt(1)-'1';
        int col = pos.charAt(0)-'A';
        String ret;

        for (int i = 0; i<3; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<3;j++){
                //先查最下边的可能性
                if (row+i-j>2 || row+i-j<0){
                    continue;
                }
                else {
                    if (col-i+j>2 || col-i+j<0){
                        continue;
                    }else {
                        sb.append(chars[row+i-j][col-i+j]);
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

        return Result.GAMING;
    }

    public Result checkDraw(char[][] chars){
        for (char[] line: chars){
            for (char c: line){
                if (c == '_'){
                    return Result.GAMING;
                }
            }
        }

        return Result.DRAW;
    }
}
