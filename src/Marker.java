
public enum Marker {
	X(1), O(2);
	
	int value;
	
	private Marker(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
