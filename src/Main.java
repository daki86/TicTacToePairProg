import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		GameBoard game = GameBoard.getGame();
		
		ArrayList<Player> player = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		Scanner placer = new Scanner(System.in);
		
		int currentPlayer = 0;
		int markerPos = 0;
		
		Boolean nextPlayer = true;
		
		Marker currentMarker = Marker.X;
		
		String option;
		String name;
		Boolean gameOver = false;
		
		do{
			System.out.println("1. New game");
			System.out.println("2. exit");
			System.out.print("\nOption: ");

			option = input.nextLine();

			if(option.equals("1")){
				for(Marker marker: Marker.values()){					
					System.out.print("\nPlayer " + marker.name() + ": ");
					name = input.nextLine();
					player.add(new Player(name));
				
				}
			}
			
			game.printBoard();
			
			do{
				for(Player p: player){
					if(currentPlayer % 2 == 0){
						currentMarker = Marker.X;
						currentPlayer++;
					}else{
						currentMarker = Marker.O;
						currentPlayer++;
					}
					do{	
					System.out.print("Player: " + p.getName() + "\nPlace marker "+currentMarker+": ");	
						do{	
							markerPos = 0;
							try {
								markerPos = Integer.parseInt(placer.nextLine());
							} catch (Exception e){
								System.out.println("\nOnly numbers allowed");
								
							}
							
							if(markerPos < 1 || markerPos > 9) {
								System.out.println("\npick a number between 1-9");	
								System.out.print("\nPlayer: " + p.getName() + "\nPlace marker "+currentMarker+": ");
							}
						}while(markerPos < 1 || markerPos > 9);
						
						nextPlayer = true;
						
						try {
							game.placeMarker(currentMarker, markerPos-1);
						} catch (Exception e) {
							System.out.println("\nSpace is occupied");
							nextPlayer = false;
							//currentPlayer--;
						}
						game.printBoard();
					}while(!nextPlayer);
					
					nextPlayer = true;
		
					gameOver = game.checkWinCondition(currentMarker);
					
					if(gameOver == true){
						System.out.println("Winner is " + p.getName()+"\n ");
						
						game.resetBoard();
						currentPlayer = 0;
						break;
					}
					else if(game.checkTie()){
						System.out.println("It's a tie!");
						
						game.resetBoard();
						currentPlayer = 0;
						gameOver = true;
						break;	
					}
				}
			}while(gameOver != true);
			player.clear();
		}while(!option.equals("2"));

	}

}
