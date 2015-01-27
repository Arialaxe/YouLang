package parser;

public class LeftBracketNode extends CustomNode {

	public LeftBracketNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("(");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
