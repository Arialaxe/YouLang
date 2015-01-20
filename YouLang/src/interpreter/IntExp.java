package interpreter;

import org.codehaus.jparsec.functors.Map;

public class IntExp extends Exp implements Map<Integer,IntExp> {

	private int value;
	
	public IntExp (int value) {
		this.value = value;
	}
	public IntExp() {
		//for purposes of Mapping
	}
	
	@Override
	public int eval(){
		return value;
	}
	@Override
	public IntExp map(Integer arg0) {
		return new IntExp(arg0);
	}

}
