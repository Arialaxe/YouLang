package parser;

public class ThenNode extends CustomNode {

	public ThenNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("then");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
