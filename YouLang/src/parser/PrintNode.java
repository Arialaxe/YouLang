package parser;

public class PrintNode extends CustomNode {

	public PrintNode(Grammar newParent, String setting) {
		super(newParent, setting);
		initialiseVanilla("print");
	}

	@Override
	public boolean settingCheck(String setting) {
		// TODO Auto-generated method stub
		return false;
	}

}
