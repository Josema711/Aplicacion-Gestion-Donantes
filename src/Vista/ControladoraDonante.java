package Vista;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import Conexion.ConexionBBDD;
import Objetos.Donante;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	@FXML
	private Button eliminar;
	@FXML
	private Button btn_imprime;


	
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
	   
	   @FXML
	   private Button Buscar;
	   @FXML
	   private Button Eliminar;
	   @FXML
	   private TextField FiltroTXT;
	   
	

		
	//Vinculacion con BBDD
	
	   ConexionBBDD con;
	   
		public ObservableList<Donante> TablaDonantes = FXCollections.observableArrayList();	
		 private ObservableList<Donante> ListaFiltrado = FXCollections.observableArrayList();
		
	 
	 
	 
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
		
		
		public void Buscar() throws SQLException{
			
			
			if(FiltroTXT.getText().length()==0){
				
				initialize();
			
			}else{
				
				ListaFiltrado=con.FiltrarSangre(FiltroTXT.getText());
				Tabla.setItems(ListaFiltrado);
				if(ListaFiltrado.size()!=0){
					Alert alerta = new Alert ( AlertType.INFORMATION ); 
				   	alerta . setTitle ( "Información" ); 
				   	alerta . setHeaderText (""); 
				   	alerta . setContentText ("Los donantes con sangre : " +FiltroTXT.getText() + " ");  
				   	alerta . showAndWait();
				}else{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error!!!");
					alert.setHeaderText("Observa los datos introducidos");
					alert.setContentText("No existe nadie hasta el momento con ese tipo de sangre :" + FiltroTXT.getText() +"");
					alert.showAndWait();
				}
				
			}


		}
		
		public void Eliminar(ActionEvent event) throws SQLException{
			
			int index = Tabla.getSelectionModel().getSelectedIndex();

			if(index>=0){
				
				Donante selec = Tabla.getSelectionModel().getSelectedItem();

						Alert alert = new Alert(AlertType.CONFIRMATION);
				       alert.setTitle("Borrando...");
				       alert.setHeaderText("Desea Borrar a " + selec.getNombre() +" "+ selec.getApellido1() +" "+ selec.getApellido2());
				      
				       Optional <ButtonType> result = alert.showAndWait ();
				       
				      if (result.get () == ButtonType.OK){
				    	  
				    	  	con.BorrarDonante(selec.getNºdonante());
				    	  	System.out.println("Pasa por aqui");
				    	   	TablaDonantes.remove(selec);
							
				    	   	Alert alerta = new Alert ( AlertType.INFORMATION ); 
				    	   	alerta . setTitle ( "Información" ); 
				    	   	alerta . setHeaderText (""); 
				    	   	alerta . setContentText ( "¡Eliminado correctamente!" );  
				    	   	alerta . showAndWait ();
				    	  
				      }
				      
			}else{
				
					Alert alerta = new Alert(AlertType.ERROR);
			       alerta.setTitle("Error !");
			       alerta.setHeaderText("Tiene que seleccionar una fila...");
			       alerta.showAndWait();
			}
			

		}
			
			
	
		
		
		public void imprime() throws FileNotFoundException, DocumentException{
			
			int index = Tabla.getSelectionModel().getSelectedIndex();

			if(index>=0){
				
				Donante selec = Tabla.getSelectionModel().getSelectedItem();

						Alert alert = new Alert(AlertType.CONFIRMATION);
				       alert.setTitle("Imprimiendo");
				       alert.setHeaderText("Imprimiendo carnet de " + selec.getNombre() +" "+ selec.getApellido1() +" "+ selec.getApellido2());
				      
				       Optional <ButtonType> result = alert.showAndWait ();
				       
				      if (result.get () == ButtonType.OK){
				    	  
							ImprimeArchivo imprime = new ImprimeArchivo("Carnet " + selec.getNombre(),"C:\\Users\\JoseManuel\\Desktop\\");
							imprime.generarArchivoPDF(selec.getNºdonante(), selec.getNombre(), selec.getApellido1() +" "+ selec.getApellido1() +" "+ selec.getApellido2(), selec.getApellido2(), selec.getGrupo_sanguineo(), selec.getIdentificacion());
							
				    	   	Alert alerta = new Alert ( AlertType.INFORMATION ); 
				    	   	alerta . setTitle ( "Información" ); 
				    	   	alerta . setHeaderText (""); 
				    	   	alerta . setContentText ( "¡Impresion realizada!" );  
				    	   	alerta . showAndWait ();
				    	  
				      }
				      
			}else{
				
					Alert alerta = new Alert(AlertType.ERROR);
			       alerta.setTitle("Error !");
			       alerta.setHeaderText("No se ha podido imprimir");
			       alerta.showAndWait();
			}
			


		}
	

	

}
