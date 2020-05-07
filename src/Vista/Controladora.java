package Vista;


import java.net.URL;
import java.util.ResourceBundle;

import Principal.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class Controladora implements Initializable{
	
	private Main MenuPrincipal;

  //Botones Menu Principal
	
		@FXML
			private Button Donantes;
		@FXML
			private Button Donaciones;
		@FXML
			private Button Estadisticas;
		

	 public void setMenuPrincipal(Main MenuPrincipal) {
		this.MenuPrincipal = MenuPrincipal;
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Cuando se pulsen las diferentes ventanas se deberan abrir
	 */
	
	@FXML
	private void ventanaDonantes() {
		this.MenuPrincipal.mostrarDonantes();
	}
	
	@FXML
	private void ventanaDonaciones() {
		this.MenuPrincipal.mostrarDonaciones();
	}
	
	
	@FXML
	private void ventanaEstadisticas() {
		this.MenuPrincipal.mostrarEstadisticas();
	}
	
	
		

		
	
		   
}
   
