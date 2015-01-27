package parser;

public class RightBracketNode extends CustomNode {

	public RightBracketNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla(")");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
