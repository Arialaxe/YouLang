package interpreter;

import java.util.Vector;

public class VarList {
	
	public static Vector<VarExp> varList;
	public static Boolean varInitFlag = false;
	
	public static void clear() {
		varList = null;
		varInitFlag = false;
	}
}
