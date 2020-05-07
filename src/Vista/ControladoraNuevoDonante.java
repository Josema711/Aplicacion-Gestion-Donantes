package Vista;

import java.awt.Button;

import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	
	@FXML
 		private TextField Apellido1; 
	@FXML
 		private TextField Apellido2;
	@FXML
		private TextField Nombre;
	@FXML
 		private TextField NºDonante;
	@FXML
 		private TextField Identificacion;
	@FXML
		private TextField Fecha_nacimiento; 
	@FXML
	private TextField Direccion;
	@FXML
 		private TextField Poblacion;
	@FXML
 		private TextField CP;
	@FXML
 		private TextField Telefono;
	@FXML
		private TextField Correo;
	@FXML
		private ToggleGroup Sexo;
 			@FXML
 				private RadioButton HombreBotton;
 			@FXML
 				private RadioButton MujerBotton;
 	@FXML
 		private TextField Grupo_sanguineo;
 	@FXML
 		private TextField Ciclo;

}
