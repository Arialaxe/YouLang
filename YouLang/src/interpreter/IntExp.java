package interpreter;

public class IntExp extends Exp {

	private int value;
	
	public IntExp (String value) { //needs to be a string for the currying to work
		this.value = Integer.valueOf(value);
	}
	
	@Override
	public int eval(){
		return value;
	}

}
