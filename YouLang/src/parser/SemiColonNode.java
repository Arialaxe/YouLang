package parser;

public class SemiColonNode extends CustomNode {

	public SemiColonNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla(";");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
