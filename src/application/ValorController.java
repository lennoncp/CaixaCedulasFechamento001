package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ValorController implements Initializable{

    @FXML
    private TextField txfValor;

    @FXML
    private Button btnSalve;

    @FXML
    void salvar() {

    	if(SL.cedulas.get(SL.index).getCodigo() >= 20) {
    		SL.cedulas.get(SL.index).setValorTotal(Double.valueOf(txfValor.getText()));
    	}else {
    		SL.cedulas.get(SL.index).setQuantidade(Integer.valueOf(txfValor.getText()));
    	}
    	
    	Stage stage = (Stage) btnSalve.getScene().getWindow();
    	stage.close();
    	
    	SL.adicionarAViewCedulas();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(SL.cedulas.get(SL.index).getCodigo() >= 20) {
			System.out.println(SL.index);
			txfValor.setText(SL.cedulas.get(SL.index).getValorTotal()+"");
		}else {
			System.out.println(SL.index);
			txfValor.setText(SL.cedulas.get(SL.index).getQuantidade()+"");
		}
	}

}
