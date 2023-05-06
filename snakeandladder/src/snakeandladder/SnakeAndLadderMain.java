package snakeandladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderMain {

	static int numberOfPlayers;
	static Queue<Player> q = new LinkedList<>();;
	static Board b ;
	static Dice d = new Dice(1);
	static int n;
	
	public static void main(String[] args) {
		 
		System.out.println("Start...............");
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		try {
            System.out.println("Enter the board (N * N) value N");
            n = Integer.parseInt(reader.readLine()); // taking string input
            b = new Board(n);
            
        }
        catch (Exception e) {
        	System.out.print(e.getMessage());
        	return;
        	
        }
        try {
            System.out.println("Enter total number of players");
            numberOfPlayers = Integer.parseInt(reader.readLine()); // taking string input
            for(int i=0;i<numberOfPlayers;i++) {
            	q.offer(new Player(i,new Cell(0,0)));
            }
            
        }
        catch (Exception e) {
        	System.out.print(e.getMessage());
        	return;
        }
        
        while(true) {
        	Player p = q.poll();
        	System.out.println();
        	System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Player : " + p.getId() + " chance");
            
            Cell cell = p.getPosition();
            int num = d.throwDice();
            try {
            	System.out.println(" Press enter to throw the dice");
            	reader.readLine();
            } catch(Exception e) {
            	System.out.println(e.getMessage());
            	return ;
            }
            System.out.println(" dice num : " + num);
            int x = cell.getColumn() + num;
            int col = x;
            int row = cell.getRow();
            if(x >= n) { //greater than N
            	col =  x%n;
            	row = cell.getRow() +1;
            }
            if( (row * n + col) >= b.winningPosition)
            {
            	System.out.println("Player : " + p.getId() + " won");
            	return;
            }
           
            if(b.cells[row][col].getJump()!=null) {
            	
            	Jump j = b.cells[row][col].getJump();
            	System.out.println(" Player : " + p.getId()+ ", Jump from : (" + j.getStart().getRow() + j.getStart().getColumn()+ ") to (" + j.getEnd().toString() + ")");
            	cell = j.getEnd();
            	
            } else {
            	cell.setColumn(col);
            	cell.setRow(row);
            }
            System.out.println(" Player : " + p.getId()+ ", is located at : " + cell.toString());
            p.setPosition(cell);
            q.offer(p);
                
            
        }
		

	}

}
