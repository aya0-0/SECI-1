package cn.edu.nju.TicTacToe;

import java.util.ArrayList;

public class GameChessStrategy_most5 extends GameChessStrategy{
    public void putChess(char[][] cells, Player currentPlayer, String chessPos)
    {
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
    }

    public void removeChess(char[][] cells, Player currentPlayer, ArrayList<String> moveRecord){
        if (moveRecord.size() > 10){
            int row = moveRecord.get(0).charAt(1) - '1';
            int col = moveRecord.get(0).charAt(0) - 'A';

            cells[row][col] = '_';
            moveRecord.remove(0);
        }else {
            return;
        }
    }
}
