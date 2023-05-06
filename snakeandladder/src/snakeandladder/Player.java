package snakeandladder;

public class Player {
	private int id;
	private Cell position;
	
	Player(int id, Cell pos)
	{
		this.id = id;
		this.setPosition(pos);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell position) {
		this.position = position;
	}
	
	

}
