package cn.edu.nju.TicTacToe;

import java.util.ArrayList;

public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameChessStrategy_most5 chessStrategy_most5;
	protected GameWinStrategy_HVD winStrategy_hvd;
	protected GameWinStrategy_HV winStrategy_hv;
	protected Player player = Player.X;
	protected ArrayList<String> moveRecord;
	protected int size;

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
	public Board(){
		cells = new char[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				cells[i][j] = '_';
			}
		}
		/*System.out.println("无参");*/
		chessStrategy = new GameChessStrategy();
		winStrategy_hvd = new GameWinStrategy_HVD();
		size = 3;
	}

	// 00的棋盘构造
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		/*System.out.println("00");*/
		this.chessStrategy = chessStrategy;
		this.winStrategy_hvd = winStrategy;
		this.size = boardSize;
	}

	//01的棋盘构造
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy = chessStrategy;
		this.winStrategy_hv = winStrategy;
		this.size = boardSize;
	}

	// 10的棋盘构造
	public Board(int boardSize, GameChessStrategy_most5 chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		/*System.out.println("10");*/
		this.chessStrategy_most5 = chessStrategy;
		this.winStrategy_hvd = winStrategy;
		this.moveRecord = new ArrayList<>();
		this.size = boardSize;
	}

	//11的棋盘构造
	public Board(int boardSize, GameChessStrategy_most5 chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy_most5 = chessStrategy;
		this.winStrategy_hv = winStrategy;
		this.moveRecord = new ArrayList<>();
		this.size = boardSize;
	}


	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move) {
		if (chessStrategy != null){
			chessStrategy.putChess(cells, player, move);
		}else {
			moveRecord.add(move);
			chessStrategy_most5.putChess(cells, player, move);
			chessStrategy_most5.removeChess(cells,player,moveRecord);
		}

		player = nextPlay();

		if (winStrategy_hvd != null){
			return winStrategy_hvd.check(cells, move);
		}else {
			return winStrategy_hv.check(cells, move);
		}

	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		return player == Player.O?Player.X:Player.O;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(){
		System.out.print(" ");
		for (int i=0; i<size; i++){
			System.out.print(" ");
			System.out.print((char) ('A'+i));
		}
		System.out.println();
		for(int i=0 ;i<size; i++){
			System.out.print(i+1);
			for(int j=0; j<size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}