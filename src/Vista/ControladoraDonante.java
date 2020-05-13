package Vista;

import java.sql.SQLException;

import Conexion.ConexionBBDD;
import Objetos.Donante;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraDonante {
	
	private Main MenuPrincipal;
	
	@FXML
	private Button close;
	@FXML
	private Button nuevo;
	@FXML
	private Button editar;
	
	private Stage ventana;
	

	
	
	//Botones Donante
	
	
	 

	   @FXML
	   private TableView<Donante> Tabla;
	   @FXML
	   private TableColumn<Donante,Integer> ColN_Donante;
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
	   
	

		
	//Vinculacion con BBDD
	
	   ConexionBBDD con;
	   
		public ObservableList<Donante> TablaDonantes = FXCollections.observableArrayList();	
		
	 
	 
	 
	 public void initialize() throws SQLException{
		
		  con = new ConexionBBDD();
		
		 TablaDonantes = con.MostrarTablaDonante();
		
		 Tabla.setItems(TablaDonantes);
		 System.out.println("Funciona");
		 ColN_Donante.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("Nºdonante"));
		 ColNombre.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nombre"));
		 ColApellido1.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido1"));
		 ColApellido2.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido2"));
		 ColIdentificacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Identificacion"));
		 ColFecha_nacimiento.setCellValueFactory(new PropertyValueFactory<Donante,String>("Fecha_nacimiento"));
		 ColDireccion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Direccion"));
		 ColPoblacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Poblacion"));
		 ColCP.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("Cp"));
		 ColTelefono.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("Telefono"));
		 ColCorreo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Correo"));
		 ColSexo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Sexo"));
		 ColGrupo_sanguineo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Grupo_sanguineo"));
		 ColCiclo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Ciclo"));
	
	 }
	
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
		
		public void ventanaNuevoDonante() {
			this.MenuPrincipal.mostrarNuevoDonante();
		}
		public void ventanaEditarDonante() {
			this.MenuPrincipal.mostrarEdicion();
		}
		
	

	

}
