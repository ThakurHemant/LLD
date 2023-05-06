package snakeandladder;

public class Cell {
	
	private int row;
	private int column;
	private Jump jump;
	public Cell(int r, int c) {
		setRow(r);
		setColumn(c);
		setJump(null);
	}
	public Cell(int r, int c, Jump j) {
		setRow(r);
		setColumn(c);
		this.setJump(j);
	}

	public int getRow() {
		return row;
	}
	public void setRow(int r) {
		this.row = r;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int c) {
		this.column = c;
	}
	public Jump getJump() {
		return jump;
	}
	public void setJump(Jump jump) {
		this.jump = jump;
	}
	@Override
	public String toString() {
		return "" + this.getRow() + this.getColumn();
	}
	
}
