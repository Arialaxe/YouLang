package parser;

public class EqualsNode extends CustomNode {

	public EqualsNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("=");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
