package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleController implements Initializable {

    @FXML
    private Button btnADD;

    @FXML
    private Button btnPDF;

    @FXML
    private Button btnFechar;

    @FXML
    private VBox vbCedulas;
    
    @FXML
    private Text txtValotTotal;

    @FXML
    void fechar() {
    	System.exit(0);
    }

    @FXML
    void gerarPDF() {
    	//TODO GERAR UM PDF
    	System.out.println("Gerar PDF");
    	PDF.criarPDF();
    }

    @FXML
    void addCedula() {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Cedula.fxml"));
			vbCedulas.getChildren().add(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SL.tela = vbCedulas;
		SL.valorTotal = txtValotTotal;
		iniciarCedulas();
		adicionarAViewCedulas();
	}
	
	private void iniciarCedulas() {
		
		Cedula caixa = new Cedula(SL.cedulas.size() + 20, "CAIXA", 0D, 0, 0D);
		SL.cedulas.add(caixa);
		
		Cedula lateral = new Cedula(SL.cedulas.size() + 20, "LATERAL", 0D, 0, 0D);
		SL.cedulas.add(lateral);
		
		Cedula cem = new Cedula(SL.cedulas.size() + 1, "R$ 100,00", 100D, 0, 0D);
		SL.cedulas.add(cem);
		
		Cedula cinquenta = new Cedula(SL.cedulas.size() + 1, "R$ 50,00", 50D, 0, 0D);
		SL.cedulas.add(cinquenta);
		
		Cedula vintecinco = new Cedula(SL.cedulas.size() + 1, "R$ 25,00", 25D, 0, 0D);
		SL.cedulas.add(vintecinco);
		
		Cedula dez = new Cedula(SL.cedulas.size() + 1, "R$ 10,00", 10D, 0, 0D);
		SL.cedulas.add(dez);
		
		Cedula cinco = new Cedula(SL.cedulas.size() + 1, "R$ 5,00", 5D, 0, 0D);
		SL.cedulas.add(cinco);
		
		Cedula dois = new Cedula(SL.cedulas.size() + 1, "R$ 2,00", 2D, 0, 0D);
		SL.cedulas.add(dois);
		
		Cedula um = new Cedula(SL.cedulas.size() + 1, "R$ 1,00", 1D, 0, 0D);
		SL.cedulas.add(um);
		
		Cedula cinquentacentavos = new Cedula(SL.cedulas.size() + 1, "R$ 0,50", .5D, 0, 0D);
		SL.cedulas.add(cinquentacentavos);
		
		Cedula vintecincocentavos = new Cedula(SL.cedulas.size() + 1, "R$ 0,25", .25D, 0, 0D);
		SL.cedulas.add(vintecincocentavos);
		
		Cedula dezcentavos = new Cedula(SL.cedulas.size() + 1, "R$ 0,10", .1D, 0, 0D);
		SL.cedulas.add(dezcentavos);
		
		Cedula cincocentavos = new Cedula(SL.cedulas.size() + 1, "R$ 0,05", .05D, 0, 0D);
		SL.cedulas.add(cincocentavos);
		
		Cedula umcentavo = new Cedula(SL.cedulas.size() + 1, "R$ 0,01", .01D, 0, 0D);
		SL.cedulas.add(umcentavo);
		
	}
	
	private void adicionarAViewCedulas() {
		
		int index = 0;
		for(Cedula c : SL.cedulas) {
			iniciarCedula(c,index);
			index++;
		}
		
	}

	private void iniciarCedula(Cedula cedula, int index) {
		SL.cedula = cedula;
		int indexAtual = index;
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Cedula.fxml"));
			vbCedulas.getChildren().add(root);
			
			root.setOnMouseClicked((click)->{
				SL.index = indexAtual;
				Stage primaryStage = new Stage();
				try {
					VBox root2 = (VBox)FXMLLoader.load(getClass().getResource("Valor.fxml"));
					Scene scene = new Scene(root2);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					scene.setFill(Color.TRANSPARENT);
					primaryStage.initStyle(StageStyle.TRANSPARENT);
					primaryStage.initOwner((Stage) btnADD.getScene().getWindow());
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

}

