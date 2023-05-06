package snakeandladder;

public class Jump {

	private Cell start;
	private Cell end ;
	
	public Jump(Cell s, Cell e) {
		setStart(s);
		setEnd(e);
	}

	public Cell getStart() {
		return start;
	}

	public void setStart(Cell start) {
		this.start = start;
	}

	public Cell getEnd() {
		return end;
	}

	public void setEnd(Cell end) {
		this.end = end;
	}
	
}
