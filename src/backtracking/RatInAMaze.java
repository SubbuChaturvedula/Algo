package backtracking;

public class RatInAMaze {
	private int solution[][];

	public RatInAMaze(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void solveMaze(int[][] maze, int N) {
		if (findPath(maze, 0, 0, N, "down")) {
			printSolution(maze, N);
		} else {
			System.err.println("NO PATH FOUND");
		}
	}

	public boolean findPath(int[][] maze, int x, int y, int N, String direction) {
		// check if maze[x][y] is feasible to move
		if (x == N - 1 && y == N - 1) {// we have reached
			solution[x][y] = 1;
			return true;
		}
		if (isSafeToGo(maze, x, y, N)) {
			// move to maze[x][y]
			solution[x][y] = 1;
			// now rat has four options, either go right OR go down or left or go up
			if (direction != "up" && findPath(maze, x + 1, y, N, "down")) { // down
				return true;
			}
			if (direction != "left" && findPath(maze, x, y + 1, N, "right")) { // right
				return true;
			}
			if (direction != "down" && findPath(maze, x - 1, y, N, "up")) { // up
				return true;
			}
			if (direction != "right" && findPath(maze, x, y - 1, N, "left")) { // left
				return true;
			}
			// if none of the options work out BACKTRACK undo the move
			solution[x][y] = 0;
			return false;
		}
		return false;
	}


	public boolean isSafeToGo(int[][] maze, int x, int y, int N) {
		// check if x and y are in limits and cell is not blocked
		if (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] != 0) {
			return true;
		}
		return false;
	}

	public void printSolution(int[][] maze, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int N = 5;
		int[][] maze = { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 1 }, 
				{ 0, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 1 } };
		RatInAMaze rm = new RatInAMaze(N);
		rm.solveMaze(maze, N);
	}
}
