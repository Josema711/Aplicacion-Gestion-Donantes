package Vista;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Conexion.ConexionBBDD;

import Objetos.Donante;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controladora implements Initializable{
	
	private Main MenuPrincipal;

  //Botones Menu Principal
	
		@FXML
			private Button Donantes;
		@FXML
			private Button Donaciones;
		@FXML
			private Button Estadisticas;
		

	 public void setMenuPrincipal(Main menuPrincipal) {
		MenuPrincipal = menuPrincipal;
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
		this.MenuPrincipal.mostrarPrincipal();
	}
	
	@FXML
	private void ventanaDonaciones() {
		this.MenuPrincipal.mostrarPrincipal();
	}
	
	@FXML
	private void ventanaEstadisticas() {
		this.MenuPrincipal.mostrarPrincipal();
	}
	
		

		
	
		   
}
   
