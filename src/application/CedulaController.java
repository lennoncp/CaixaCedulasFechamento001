package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CedulaController implements Initializable{

    @FXML
    private TextField txfQuantidade;

    @FXML
    private Text textNomeCedula;

    @FXML
    private Text textTotalCedula;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		String cedula = SL.cedula.getCedula();
		double valor = SL.cedula.getValor();
		int quantidade = SL.cedula.getQuantidade();
		double valorTotal = SL.cedula.getValorTotal();
		
		textNomeCedula.setText(cedula);
		txfQuantidade.setText(quantidade+"");
		textTotalCedula.setText(valorTotal+"");
		
	}

}
