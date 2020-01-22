package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SL {
	
	public static int index = 0;
	
	public static Cedula cedula = new Cedula();
	
	public static ObservableList<Cedula> cedulas = FXCollections.observableArrayList();
	
	public static VBox tela = new VBox();
	public static Text valorTotal = new Text();
	
	
    public static void adicionarAViewCedulas() {
		tela.getChildren().clear();
		int index = 0;
		for(Cedula c : SL.cedulas) {
			iniciarCedula(c,index);
			index++;
		}
		atualizarValorTotal();
	}

	public static void iniciarCedula(Cedula cedula, int index) {
		SL.cedula = cedula;
		int indexAtual = index;
		try {
			VBox root = (VBox)FXMLLoader.load(SampleController.class.getResource("Cedula.fxml"));
			tela.getChildren().add(root);
			
			root.setOnMouseClicked((click)->{
				SL.index = indexAtual;
				Stage primaryStage = new Stage();
				try {
					VBox root2 = (VBox)FXMLLoader.load(SampleController.class.getResource("Valor.fxml"));
					Scene scene = new Scene(root2);
					scene.getStylesheets().add(SampleController.class.getResource("application.css").toExternalForm());
					scene.setFill(Color.TRANSPARENT);
					primaryStage.initStyle(StageStyle.TRANSPARENT);
					//primaryStage.initOwner((Stage) btnADD.getScene().getWindow());
					primaryStage.initModality(Modality.APPLICATION_MODAL);
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(SL.cedulas.get(index).getCedula());
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static void atualizarValorTotal() {
		double valorTotal = 0D;
		for(Cedula c: cedulas) {
			valorTotal += c.getValorTotal();
		}
		SL.valorTotal.setText("R$ "+valorTotal+"");
	}

}
