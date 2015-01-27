package parser;

public class ElseNode extends CustomNode {

	public ElseNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("else");
	}	

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
