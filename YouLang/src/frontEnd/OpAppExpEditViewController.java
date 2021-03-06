package frontEnd;
import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import parser.Grammar;

public class OpAppExpEditViewController {

	@FXML private TextField leftBracketField;
	@FXML private TextField rightBracketField;
	
	@FXML private Button ok;
	@FXML private Button cancel;
	
	private Stage editStage;
	private Stage warningStage;
	Grammar grammar;
	
	private Boolean okClicked = false;
	
	private MainApp mainApp;
	
	public OpAppExpEditViewController() {
		
	}
	
	@FXML private void initialize(){
		leftBracketField.textProperty().addListener(
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
		
		rightBracketField.textProperty().addListener(
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
	
	@FXML private void handleOk(){
		try {
			String text1 = leftBracketField.getText();
			if (grammar.setLeftBracketSetting(text1)) {
				System.out.println(grammar.getLeftBracketSetting());
				okClicked = true;
				editStage.close();
			}
			else {
				mainApp.showWarningView();
			}
			
			String text2 = rightBracketField.getText();
			if (grammar.setRightBracketSetting(text2)) {
				System.out.println(grammar.getRightBracketSetting());
				okClicked = true;
				editStage.close();
			}
			else {
				mainApp.showWarningView();
			}
		}
		catch (Exception e) {
			//field might be null
			editStage.close();
		}
	}
	
	@FXML private void handleCancel(){
		editStage.close();
	}
	
	public void setEditStage(Stage editStage) {
		this.editStage = editStage;
	}
	
	public void setGrammar(Grammar grammar) {
		this.grammar = grammar;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public boolean isOkClicked() {
		return okClicked;
	}
}
