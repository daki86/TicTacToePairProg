import java.util.Observable;

public class GameBoard extends Observable{
	
	//Marker marker;
	
	private static GameBoard game = new GameBoard();
	private String board[][];
	private int size = 3;
	
	private GameBoard(){		
		board = new String[size][size];
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = null;
			}
		}
	}	
	
	public static GameBoard getGame(){
		return game;
	}
	
	public void placeMarker(Marker marker, int markerPos)throws Exception{
		int counter = 0;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(markerPos == counter && board[i][j] == null){
					board[i][j] = marker.name();
				}else if(markerPos == counter && board[i][j] != null){
					throw new Exception();
				}
				counter++;
			}
		}
	}
	
	public boolean checkWinCondition(Marker marker){
		
		boolean win = false;
		int counter = 0;
		
		//Check for winner diagonal
		if(marker.name() == board[0][0] && marker.name() == board[1][1] && marker.name() == board[2][2]){		
			win = true;					
		}else if(marker.name() == board[0][2] && marker.name() == board[1][1] && marker.name() == board[2][0]){
			win = true;
		}		
		
		if(win != true){
			
		//Check for winner horizontal	
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(marker.name() == board[i][j]){
											
						counter++;	
						if(counter == 3){
							win = true;
							break;
						}
					}
					else{
						counter = 0;
						break;
					}
				}
			}
		}
		
		if(win !=true){
			
			//Check for winner vertical
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(marker.name() == board[j][i]){
											
						counter++;			
						if(counter == 3){
							win = true;
							break;
						}
					}
					else{
						counter = 0;
						break;
					}
				}
			}		
		}
		return win;
	}
	
	public boolean checkTie(){
		boolean tie = false;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == null){
				tie = false;
				
				break;
				
				}	
				else{
					tie = true;
					
				}
			}
		}
		
		return tie;
	}
	
	public void resetBoard(){
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = null;
			}
		}
	}
	
	public void printBoard(){
		int pos = 1;
		System.out.println();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(j == 0){
					if(board[i][j] != null){
						System.out.print("|" + board[i][j] + "|");
					}
					else
						System.out.print("|"+pos+"|");
				}
				else{
					if(board[i][j] != null){
						System.out.print(board[i][j] + "|");
					}
					else{
						System.out.print(pos+"|");
					}
				}
				pos++;
			}
			System.out.println();
		}
		System.out.println();
	}
}
