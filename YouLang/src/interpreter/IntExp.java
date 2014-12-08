package interpreter;

public class IntExp extends Exp {

	private int value;
	
	public IntExp (int value) {
		this.value = value;
	}
	@Override
	public int eval(){
		return value;
	}

}
