
public class Player {
	private String name;
	private int wins;
	
	public Player(){
		this.name = "uknown";
		this.wins = 0;
	}
	
	public Player(String name){
		this.name = name;
		this.wins = 0;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addWin(){
		this.wins++;
	}
	
	public int winCount(){
		return this.wins;
	}
	
	public String toString(){
		String presentation = "Player: "+this.name+"\n Wins: "+this.wins; 
		
		return presentation;
	}
}
