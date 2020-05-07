package Vista;

import java.awt.Button;

import Principal.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControladoraNuevoDonante {
	
	private Main MenuPrincipal;
	
	
	@FXML
	private Button volver;
	
	private Stage ventana;
	
	public void  setPrimaryStage (Stage ventana) {
		//TODO
		this.ventana = ventana;
	}
	
	public void setMenuPrincipal(Main MenuPrincipal) {
		this.MenuPrincipal = MenuPrincipal;
	}
	
	//Al presionar abro la 3 y cierro la 2
	
	public void Volver() {
		this.ventana.close();
		this.MenuPrincipal.mostrarDonantes();
	}

}
