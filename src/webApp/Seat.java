package webApp;

public class Seat {
	
	int id;
	State state;
	String reservation_name;
	
	public Seat(int id) {
		state = State.AVAILABLE;
		reservation_name = "";
		this.id = id;
	}
	
	public String toHTML() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<label ");
		
		if( state == State.SOLD)
			sb.append("style='color:red'>");
		if( state == State.RESERVED)
			sb.append("style='color:yellow'>");
		if( state == State.AVAILABLE)
			sb.append("style='color:green'>");
		sb.append(this.id+"</label>");
		
		return sb.toString();
		
	}

}