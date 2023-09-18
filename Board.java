public class Board{
	private int[][] board = {
	{0, 0, 0},
	{0, 0, 0},
	{0, 0, 0}
	};
	private boolean done = false;

	public Board(){}

	public void setBoard(int row, int col, int player){
		try{
			if(board[row][col] == 0){
				board[row][col] = player;
			}
			else if(row < 0 || col < 0){
				throw new ArrayIndexOutOfBoundsException();
			}
			else{
				System.out.println("Space is already occupied!");
			}
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid index!");
		}
	}

	public int[][] getBoard(){
		return this.board;
	}

	public boolean isDone(){
		return this.done;
	}

	//Returns int array with win and player who won (i.e. [1, 2] for computer win)
	public int[] checkWin(){
		boolean playerWin = false;
		boolean compWin = false;
		int winningPlayer = 0;
		int winExists = 0;
		for(int i = 0; i < 3; i++){
			playerWin = checkRow(i, 1) || checkCol(i, 1) || checkDiagOne(1) || checkDiagTwo(1);
			if(playerWin == true){
				winningPlayer = 1;
				winExists = 1;
				this.done = true;
				break;
			}
		}
		if(playerWin != true){
			for(int i = 0; i < 3; i++){
				compWin = checkRow(i, 2) || checkCol(i, 2) || checkDiagOne(2) || checkDiagTwo(2);
				if(compWin == true){
					winningPlayer = 2;
					winExists = 1;
					this.done = true;
					break;
				}
			}
		}
		int[] result = new int[2];
		result[0] = winExists;
		result[1] = winningPlayer;
		return result;
	}

	public boolean checkRow(int row, int player){
		int num = 0;
		for(int col = 0; col < 3; col++){
			if(this.board[row][col] == player){
				num++;
			}
		}
		if(num < 3){
			return false;
		}
		return true;
	}

	public boolean checkCol(int col, int player){
		int num = 0;
		for(int row = 0; row < 3; row++){
			if(this.board[row][col] == player){
				num++;
			}
		}
		if(num < 3){
			return false;
		}
		return true;
	}

	public boolean checkDiagOne(int player){
		int num = 0;
		for(int i = 0; i < 3; i++){
			if(this.board[i][i] == player){
				num++;
			}
		}
		if(num < 3){
			return false;
		}
		return true;
	}

	public boolean checkDiagTwo(int player){
		int num = 0;
		for(int i = 2; i > -1; i--){
			if(this.board[i][i] == player){
				num++;
			}
		}
		if(num < 3){
			return false;
		}
		return true;
	}
}