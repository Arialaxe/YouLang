package parser;

public class IfNode extends CustomNode {

	public IfNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("if");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
