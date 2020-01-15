package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SampleController {

    @FXML
    private Button btnADD;

    @FXML
    private Button btnPDF;

    @FXML
    private Button btnFechar;

    @FXML
    private VBox vbCedulas;

    @FXML
    void fechar() {
    	System.exit(0);
    }

    @FXML
    void gerarPDF() {
    	//TODO GERAR UM PDF
    	System.out.println("Gerar PDF");
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



}

