package parser;

public class WhileNode extends CustomNode {

	public WhileNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("while");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
