public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){
        Board b = new Board();
        Result ret = null;
		String[] positions = s.split(",");
        for(int i = 0; i<positions.length; i++){
            //下棋
            if (i%2 == 0){
                b.putChess(positions[i],'X');
            }
            else {
                b.putChess(positions[i],'O');
            }
            //检查下的那个位置的影响
            GameWinStrategy gws = new GameWinStrategy();
            ret = gws.checkWin(b.board,positions[i]);
            if (ret.equals(Result.GAMING)){
                b.printBoard();
            }else {
                b.printBoard();
                break;
            }
        }
        return ret;
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
