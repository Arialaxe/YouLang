package frontEnd;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import parser.Grammar;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	Grammar grammar = new Grammar();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("YouLang");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		showBaseView();
	}

	private void showBaseView() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Base.fxml"));
			SplitPane baseView = (SplitPane) loader.load();
			rootLayout.setCenter(baseView);
			BaseViewController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch (IOException e)  {
			e.printStackTrace();
		}
	}
	
	public boolean showPlusEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PlusEditView.fxml"));
			AnchorPane plusEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit plus production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(plusEdit);
			editStage.setScene(scene);
			
			PlusEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showSubEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SubEditView.fxml"));
			AnchorPane subEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit subtract production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(subEdit);
			editStage.setScene(scene);
			
			SubEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showMulEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MulEditView.fxml"));
			AnchorPane mulEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit multiply production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(mulEdit);
			editStage.setScene(scene);
			
			MulEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showDivEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DivEditView.fxml"));
			AnchorPane divEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit divide production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(divEdit);
			editStage.setScene(scene);
			
			DivEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showGreaterThanEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GreaterThanEditView.fxml"));
			AnchorPane greaterEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit greater-than production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(greaterEdit);
			editStage.setScene(scene);
			
			GreaterThanEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showOpAppExpEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OpAppExpEditView.fxml"));
			AnchorPane opAppExpEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit brackets symbols in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(opAppExpEdit);
			editStage.setScene(scene);
			
			OpAppExpEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showVarAssignEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VarAssignEditView.fxml"));
			AnchorPane varAssignEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit equals symbol in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(varAssignEdit);
			editStage.setScene(scene);
			
			VarAssignEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showIfStmtEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("IfStmtEditView.fxml"));
			AnchorPane ifStmtEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit if, then, else in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(ifStmtEdit);
			editStage.setScene(scene);
			
			IfStmtEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showWhileStmtEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("WhileStmtEditView.fxml"));
			AnchorPane whileStmtEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit while, do symbols in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(whileStmtEdit);
			editStage.setScene(scene);
			
			WhileStmtEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showPrintStmtEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PrintStmtEditView.fxml"));
			AnchorPane printStmtEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit print symbol in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(printStmtEdit);
			editStage.setScene(scene);
			
			PrintStmtEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showSequenceEditView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SequenceEditView.fxml"));
			AnchorPane sequenceEdit = (AnchorPane) loader.load();
			
			Stage editStage = new Stage();
			editStage.setTitle("Edit semi-colon symbol in production");
			editStage.initModality(Modality.WINDOW_MODAL);
			editStage.initOwner(primaryStage);
			Scene scene = new Scene(sequenceEdit);
			editStage.setScene(scene);
			
			SequenceEditViewController controller = loader.getController();
			controller.setEditStage(editStage);
			controller.setGrammar(grammar);
			controller.setMainApp(this);
			
			editStage.showAndWait();
			return controller.isOkClicked();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void showWarningView() {
		Dialogs.create()
                .title("Invalid setting")
                .message("Sorry! You input an invalid setting. Try again!")
                .actions(Dialog.ACTION_OK)
                .showConfirm();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
