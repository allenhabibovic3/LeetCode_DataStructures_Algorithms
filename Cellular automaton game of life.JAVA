
public class Simulation {
	
	int width;
	int height;
	int[][] board;
	
	public Simulation(int width, int height) {
		this.width = width;
		this.height = height;
		this.board = new int[width][height];
	}
	
	public void printBoard() {
		for(int i = 0; i < this.height; i++) {
			for(int j = 0; j < this.width; j++) {
				if(this.board[j][i] == 0) {
					System.out.print(" | . | ");
				}else {
					System.out.print(" | * | ");
				}
			}
			System.out.println();
		}
		System.out.println("--------");
	}
	
	public void setAlive(int i, int j) {
		this.board[i][j] = 1;
	}
	
	public void setDead(int i, int j) {
		this.board[i][j] = 0;
	}
	
	public int countAliveNeighbors(int i, int j) {
		int count = 0;
		
		count += getState(i-1, j-1);
		count += getState(i-1, j);
		count += getState(i-1, j+1);
		count += getState(i, j+1);
		count += getState(i+1, j+1);
		count += getState(i+1, j);
		count += getState(i+1, j-1);
		count += getState(i, j-1);
		
		return count;
	}
	
	public int getState(int i, int j) {
		if(i < 0 || i >= this.width)
			return 0;
		
		if(j < 0 || j >= this.height) {
			return 0;
		}
		
		return this.board[i][j];
	}
	
	public void step() {
		
		int[][] new_board = new int[this.width][this.height];
		for(int j = 0; j < this.height; j++) {
			for(int i = 0; i < this.width; i++) {
				int aliveNeighbors = this.countAliveNeighbors(i, j);
				
				if(this.board[i][j] == 1) {
					if(aliveNeighbors < 2)
						new_board[i][j] = 0;
					else if(aliveNeighbors == 2 || aliveNeighbors == 3)
						new_board[i][j] = 1;
					else if(aliveNeighbors > 3)
						new_board[i][j] = 0;
				}else {
					if(aliveNeighbors == 3)
						new_board[i][j] = 1;
				}
			}
		}
		this.board = new_board;
		
	}
	
	public static void main(String[] args) {
		Simulation sim = new Simulation(8, 5);
		
		sim.setAlive(2, 2);
		sim.setAlive(3, 2);
		
		sim.printBoard();
		sim.step();
		sim.printBoard();
		sim.step();
		sim.printBoard();
		sim.step();
	}
}
