package Vista;

//Problema//
		import javafx.scene.control.Button;
//Problema//
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.Optional;

import Conexion.ConexionBBDD;
import Objetos.Donante;
import Principal.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;



public class ControladoraEdicion {
	
	private Main MenuPrincipal;
	
	@FXML
	private Button Guardar;
	@FXML
	private Button Borrar;
	@FXML
	private Button Volver;
	
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
	}
	
	@FXML
 		private TextField Apellido1; 
	@FXML
 		private TextField Apellido2;
	@FXML
		private TextField Nombre;
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
 		private TextField Sangre;
 	@FXML
		private TextField Ciclo;
 	
 	@FXML
	   private TableView<Donante> Tabla;
 	
	public boolean edicion=false;
	public int indiceEdicion=0;
	
	
	
	public void Editar() throws SQLException{
		
		int index = Tabla.getSelectionModel().getSelectedIndex();
		
		if(index >=0){
			
			edicion=true;
			indiceEdicion=index;
			
			Donante choose = Tabla.getSelectionModel().getSelectedItem();
			
			
			Nombre.setText(choose.getNombre());
			Apellido1.setText(choose.getApellido1());
			Apellido2.setText(choose.getApellido2());
			Identificacion.setText(choose.getIdentificacion());
			Fecha_nacimiento.setText(choose.getFecha_nacimiento());
			Direccion.setText(choose.getDireccion());
			Poblacion.setText(choose.getPoblacion());
			Correo.setText(choose.getCorreo());
			Sangre.setText(choose.getGrupo_sanguineo());
			Ciclo.setText(choose.getCiclo());

			if(choose.getSexo().equals("Hombre") || choose.getSexo().equals("HOMBRE") || choose.getSexo().equals("H")){
				
				HombreBotton.setSelected(true);
				
			}else{
				
				MujerBotton.setSelected(true);
			}
			
		}else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("¡¡No has sellecionado ningun donante!!");
			alert.setContentText("¡Debes seleccionar un donante para poder modificarlo!");
			alert.showAndWait();
		}
		
	}		
	
}
