package snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

	int n;
	Cell[][] cells;
	int winningPosition;
	
	Board(int n){
		this.n = n;
		initializeBoard(n);
	}
	public void initializeBoard(int n) {
		
		cells = new Cell[n][n];
		winningPosition = n * n - 1;
		
		//ask for the snakes and ladders, currently assuming
		int snakes = 8, ladders = 8;
		initializeCells(n, cells);
		intializeSnakesAndLadders(snakes, ladders);
		
	}
	public void initializeCells(int n, Cell[][] cells) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				cells[i][j] = new Cell(i,j);
			}
		}
	}
	public void intializeSnakesAndLadders(int s, int l) {
		
		while(s!=0 && l!=0) {
			int top = ThreadLocalRandom.current().nextInt(0, n * n);
			int bottom = ThreadLocalRandom.current().nextInt(0, n * n);
			Cell topCell = getCell(top, n);
			Cell bottomCell = getCell(bottom, n);
			if(s>0 && top < bottom) {//snakes bite
				topCell.setJump(new Jump(bottomCell, topCell));
				cells[topCell.getRow()][topCell.getColumn()] =  topCell;
				System.out.println("Snake " + top + " " + bottom);
				s--;
			}
			if(l>0 && bottom < top) { //ladder
				bottomCell.setJump(new Jump(bottomCell, topCell));
				cells[bottomCell.getRow()][bottomCell.getColumn()] =  bottomCell;
				System.out.println("Ladder " + top + " " + bottom);
				l--;
			}
		}
	}
	public Cell getCell(int x, int n) {
		int row = x / n;
		int column = x % n;
		return new Cell(row, column);
		
	}
	
}
