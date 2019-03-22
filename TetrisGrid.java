//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {

	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++){
			for(int k = 0; k < grid[i].length; k++){
				this.grid[i][k] = grid[i][k];
			}
		}
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int cleared = 0;
		boolean isFull;
		for(int j = 0; j < grid[0].length; j++){
			isFull = true;
			for(int i = 0; i < grid.length; i++){
				if(!grid[i][j]){
					isFull = false;
					break;
				}
			}
			if(isFull){
				cleared++;
			} else {
				if (cleared == 0) continue;
				for (int i = 0; i < grid.length; i++) {
					grid[i][j - cleared] = grid[i][j];
				}
			}
		}
		for(int i = grid[0].length - cleared; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[j][i] = false;
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}
