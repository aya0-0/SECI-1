public class Board {
    char[][] board;

    Board(){
        board = new char[][]
        {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
    }

    public void putChess(String pos,char player){
        int row = pos.charAt(1)-'1';
        int col = pos.charAt(0)-'A';

        board[row][col] = player;
    }

    public void printBoard(){
        System.out.println("  A B C");
        for (int i = 0; i<3; i++){
            System.out.print(i+1);
            for (int j = 0; j<3; j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }
}
