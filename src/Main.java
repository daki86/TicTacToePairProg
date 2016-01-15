import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		GameBoard game = new GameBoard();
		ArrayList<Player> player = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		Scanner placer = new Scanner(System.in);
		
		int currentPlayer = 0;
		int markerPos = 0;
		
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
					System.out.print("Player: " + p.getName() + "\nPlace marker "+currentMarker+": ");
					markerPos = placer.nextInt() - 1;
					game.placeMarker(currentMarker, markerPos);
					
					game.printBoard();
					gameOver = game.checkWinCondition(currentMarker);
					
					if(gameOver == true){
						System.out.println("Winner is " + p.getName()+"\n ");
						
						game.resetBoard();
						currentPlayer = 0;
						break;
					}
				}
			}while(gameOver != true);
			player.clear();
		}while(!option.equals("2"));

	}

}
