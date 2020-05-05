package Vista;

import java.sql.SQLException;

import Conexion.ConexionBBDD;
import Objetos.Donante;
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
	
	@FXML
	private Button close;
	
	private Stage ventana;
	
	public void setprimaryStage(Stage ventana) {
		this.ventana = ventana;
	}
	
	public void closeWindow() {
		this.ventana.close();
	}
	
	
	
	//Botones Donante
	
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
			 

			   @FXML
			   private TableView<Donante> Tabla;
			   @FXML
			   private TableColumn<Donante,Integer> ColNºDonante;
			   @FXML
			   private TableColumn<Donante,String> ColNombre;
			   @FXML
			   private TableColumn<Donante,String> ColApellido1;
			   @FXML
			   private TableColumn<Donante,String> ColApellido2;
			   @FXML
			   private TableColumn<Donante,String> ColIdentificacion;
			   @FXML
			   private TableColumn<Donante,String> ColFecha_nacimiento;
			   @FXML
			   private TableColumn<Donante,String> ColDireccion;
			   @FXML
			   private TableColumn<Donante,String> ColPoblacion;
			   @FXML
			   private TableColumn<Donante,Integer> ColCP;
			   @FXML
			   private TableColumn<Donante,Integer> ColTelefono;
			   @FXML
			   private TableColumn<Donante,String> ColCorreo;
			   @FXML
			   private TableColumn<Donante,String> ColSexo;
			   @FXML
			   private TableColumn<Donante,String> ColGrupo_sanguineo;
			   @FXML
			   private TableColumn<Donante,String> ColCiclo;
			   
			
			@FXML
				private Button Guardar;
			@FXML
				private Button Borrar;
			@FXML
				private Button Eliminar;
			
			
			//Vinculacion con BBDD
			
		ConexionBBDD con = new ConexionBBDD();
			   
			 private ObservableList<Donante> data = FXCollections.observableArrayList();	
			  
			
			 
			 
			 
		public void initialize() throws SQLException{
				
				
				
			data = con.MostrarTabla();
				
			Tabla.setItems(data);
			ColNºDonante.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("NºDonante"));
			ColNombre.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nombre"));
			ColApellido1.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido1"));
			ColApellido2.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido2"));
			ColIdentificacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Identificacion"));
			ColFecha_nacimiento.setCellValueFactory(new PropertyValueFactory<Donante,String>("Fecha_nacimiento"));
			ColDireccion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Direccion"));
			ColPoblacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Poblacion"));
			ColCP.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("CP"));
			ColTelefono.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("Telefono"));
			ColCorreo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Correo"));
			ColSexo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Sexo"));
			ColGrupo_sanguineo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Grupo_sanguineo"));
			ColCiclo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Ciclo"));
			
			}
	

}
