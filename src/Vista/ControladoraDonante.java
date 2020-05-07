package Vista;

import java.sql.SQLException;

import Conexion.ConexionBBDD;
import Objetos.Donante;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraDonante {
	
	private Main MenuPrincipal;
	
	@FXML
	private Button close;
	@FXML
	private Button nuevo;
	
	private Stage ventana;
	
	public void setMenuPrincipal(Main MenuPrincipal) {
		this.MenuPrincipal = MenuPrincipal;
	}
	
	public void setPrimaryStage (Stage ventana) {
		//TODO Auto-generated method sub
		this.ventana = ventana;
	}
	
	public void closeWindow() {
		this.ventana.close();
	}
	
	
	@FXML
	private void ventanaNuevoDonante() {
		this.MenuPrincipal.mostrarNuevoDonante();
		this.ventana.close();
	}
	
	
	
	

	

}
