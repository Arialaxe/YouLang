package frontEnd;

import interpreter.SeqStmt;

import java.util.LinkedList;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import parser.Grammar;

public class BaseViewController {

	@FXML private TextField plus;
	@FXML private TextField sub;
	@FXML private TextField mul;
	@FXML private TextField div;
	@FXML private TextField greaterThan;
	@FXML private TextField opAppExp;
	@FXML private TextField varAssign;
	@FXML private TextField ifStmt;
	@FXML private TextField whileStmt;
	@FXML private TextField printStmt;
	@FXML private TextField sequence;
	
	@FXML private Button plusEdit;
	@FXML private Button subEdit;
	@FXML private Button mulEdit;
	@FXML private Button divEdit;
	@FXML private Button greaterThanEdit;
	@FXML private Button opAppExpEdit;
	@FXML private Button varAssignEdit;
	@FXML private Button ifStmtEdit;
	@FXML private Button whileStmtEdit;
	@FXML private Button printStmtEdit;
	@FXML private Button sequenceEdit;
	
	@FXML private Button reset;
	@FXML private Button run;
	@FXML private Button clear;
	
	@FXML private TextArea codeInput;
	@FXML private TextArea console;
	
	private MainApp mainApp;
	private LinkedList<String> printed = new LinkedList<String>();
	
	public BaseViewController() {
		
	}
	
	@FXML private void initialize(){
		codeInput.textProperty().addListener(
				new ChangeListener<String>() {
					public void changed (ObservableValue<? extends String> observable, String oldValue, String newValue) {
						try {
							if (!newValue.equals("")) {
								((StringProperty) observable).setValue(newValue);
							}
						}
						catch (Exception e) {
							((StringProperty) observable).setValue(oldValue);
						}
					}
				}
			);
	}
	
	@FXML private void handlePlusEdit(){
		boolean okClicked = mainApp.showPlusEditView();
		if (okClicked){
			plus.setText(mainApp.grammar.getPlusOpSetting());
		}
	}
	
	@FXML private void handleSubEdit(){
		boolean okClicked = mainApp.showSubEditView();
		if (okClicked){
			sub.setText(mainApp.grammar.getSubOpSetting());
		}
	}
	
	@FXML private void handleMulEdit(){
		boolean okClicked = mainApp.showMulEditView();
		if (okClicked){
			mul.setText(mainApp.grammar.getMulOpSetting());
		}
	}
	
	@FXML private void handleDivEdit(){
		boolean okClicked = mainApp.showDivEditView();
		if (okClicked){
			div.setText(mainApp.grammar.getDivOpSetting());
		}
	}
	
	@FXML private void handleGreaterThanEdit(){
		boolean okClicked = mainApp.showGreaterThanEditView();
		if (okClicked){
			greaterThan.setText(mainApp.grammar.getGreaterOpSetting());
		}
	}
	
	@FXML private void handleOpAppExpEdit(){
		boolean okClicked = mainApp.showOpAppExpEditView();
		if (okClicked){
			opAppExp.setText(mainApp.grammar.getLeftBracketSetting() + " exp op exp " + 
					mainApp.grammar.getRightBracketSetting());
			ifStmt.setText(mainApp.grammar.getIfSetting() + " exp " + mainApp.grammar.getThenSetting() + 
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " + 
					mainApp.grammar.getRightBracketSetting() + " " + mainApp.grammar.getElseSetting() +
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " +
					mainApp.grammar.getRightBracketSetting());
			whileStmt.setText(mainApp.grammar.getWhileSetting() + " exp " + mainApp.grammar.getDoSetting() + 
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " + 
					mainApp.grammar.getRightBracketSetting());
		}
	}
	
	@FXML private void handleVarAssignEdit(){
		boolean okClicked = mainApp.showVarAssignEditView();
		if (okClicked){
			varAssign.setText("var " + mainApp.grammar.getEqualsSetting() + " exp");
		}
	}
	
	@FXML private void handleIfStmtEdit(){
		boolean okClicked = mainApp.showIfStmtEditView();
		if (okClicked){
			ifStmt.setText(mainApp.grammar.getIfSetting() + " exp " + mainApp.grammar.getThenSetting() + 
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " + 
					mainApp.grammar.getRightBracketSetting() + " " + mainApp.grammar.getElseSetting() +
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " +
					mainApp.grammar.getRightBracketSetting());
		}
	}
	
	@FXML private void handleWhileStmtEdit(){
		boolean okClicked = mainApp.showWhileStmtEditView();
		if (okClicked){
			whileStmt.setText(mainApp.grammar.getWhileSetting() + " exp " + mainApp.grammar.getDoSetting() + 
					" " + mainApp.grammar.getLeftBracketSetting() + " seqStmt " + 
					mainApp.grammar.getRightBracketSetting());
		}
	}
	
	@FXML private void handlePrintStmtEdit(){
		boolean okClicked = mainApp.showPrintStmtEditView();
		if (okClicked){
			printStmt.setText(mainApp.grammar.getPrintSetting() + " exp");
		}
	}
	
	@FXML private void handleSequenceEdit(){
		boolean okClicked = mainApp.showSequenceEditView();
		if (okClicked){
			sequence.setText("stmt " + mainApp.grammar.getSemiColonSetting() + " seqStmt");
		}
	}
	
	@FXML private void handleReset(){
		Action response = Dialogs.create()
				.title("Reset grammar to default settings")
		        .message("Are you sure you want to reset your grammar? (cannot be undone!)")
		        .showConfirm();

		if (response == Dialog.ACTION_YES) {
		    mainApp.grammar = new Grammar();
		    plus.setText("+");;
			sub.setText("-");
			mul.setText("*");;
			div.setText("/");;
			greaterThan.setText(">");;
			opAppExp.setText("( exp op exp )");
			varAssign.setText("var = exp");
			ifStmt.setText("if exp then ( seqStmt ) else ( seqStmt )");
			whileStmt.setText("while exp do ( seqStmt )");
			printStmt.setText("print exp");
			sequence.setText("stmt ; seqStmt");
		}
	}
	
	@FXML private void handleRun(){
		try {
			SeqStmt runMe = mainApp.grammar.parse(codeInput.getText());
			printed = runMe.eval(new LinkedList<String>());
			//
			String prev;
			int j = printed.size();
			for (int i = 0; i < j; i++) {
				if (i == 0) {
					console.setText(printed.removeFirst());
					continue;
				}
				prev = console.getText();
				console.setText(prev.concat("\n" + printed.removeFirst()));
			}
		}
		catch (Exception e) {
			//System.err.println("Marker!");
			e.printStackTrace();
		}
	}
	
	@FXML private void handleClear(){
		console.setText("");
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}
	
	public void addPrinted(String string) {
		printed.push(string);
	}
	
}
