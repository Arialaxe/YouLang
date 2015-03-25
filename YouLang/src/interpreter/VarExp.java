package interpreter;

public class VarExp extends Exp {

	private String varID;
	private IntExp value;
	
	public VarExp (String idRetn) {
		this.varID = idRetn;
		Boolean flag = false;
		if (VarList.varInitFlag) {
			for (VarExp v : VarList.varList) {
				if (varID.equals(v.getID())){
					this.value = v.value;
					flag = true;
				}
			}
		}
		if (!flag) this.value = new IntExp("0");
	}

	@Override
	public int eval(){
		Boolean flag = false;
		if (VarList.varInitFlag) {
			for (VarExp v : VarList.varList) {
				if (varID.equals(v.getID())){
					this.value = v.value;
					flag = true;
				}
			}
		}
		if (!flag) this.value = new IntExp("0");
		return value.eval();
	}
	
	public void assign(int value) {
		this.value = new IntExp(Integer.toString(value)); 
	}
	
	public String getID() {
		return varID;
	}
}
