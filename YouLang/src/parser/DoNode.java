package parser;

public class DoNode extends CustomNode {

	public DoNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("do");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
