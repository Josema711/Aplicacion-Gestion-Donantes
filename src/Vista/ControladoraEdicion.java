package Vista;

import java.sql.SQLException;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraEdicion {
	
	private Main MenuPrincipal;
	
	 private boolean edicion=false;
	 private int indiceEdicion=0;
	
	@FXML
	private Button close;
	@FXML
	private Button editar;
	@FXML
	private Button Guardar;
	


	
	private Stage ventana;
	
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
	
	
	
	//Botones Edicion
	
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
		public ObservableList<Donante> TablaDonantes2 = FXCollections.observableArrayList();
	 
	 
	 
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
		
		public void Guardar(ActionEvent event) throws SQLException{
	 		
	 		con = new ConexionBBDD();
	 		//Numero aleatorio para que no se repitan
	 		Integer NºDonante = (int) (Math.random()*(99999));
	 		NºDonante = (int) Math.floor(NºDonante);
	 		
			String sexo;

			if(HombreBotton.isSelected()) {
				sexo = "Hombre";
			}else {
				sexo = "Mujer";
			}

			// Añadir un chequeo de campos vacío
			if(Nombre.getText().equals("") || Apellido1.getText().equals("") || Apellido2.getText().equals("") || Identificacion.getText().equals("") || Correo.getText().equals("") || Sangre.getText().equals("") || Ciclo.getText().equals("") ){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!");
				alert.setHeaderText("¡¡Hay campos vacios!!");
				alert.setContentText("¡No se pueden introducir campos vacíos!");
				alert.showAndWait();
			}
			else{

				
				
				Donante DonanteNuevoA = new Donante(NºDonante, Nombre.getText(), Apellido1.getText(), Apellido2.getText(), Identificacion.getText(), Fecha_nacimiento.getText(), Direccion.getText(), Poblacion.getText(), Integer.parseInt(CP.getText()), Integer.parseInt(Telefono.getText()), Correo.getText(), sexo, Sangre.getText(), Ciclo.getText());
				TablaDonantes2.add(DonanteNuevoA);
				
				if(edicion == true){
					Donante editada = TablaDonantes.get(indiceEdicion);
					editada.setNºdonante(NºDonante);
					editada.setNombre(Nombre.getText());
					editada.setApellido1(Apellido1.getText());
					editada.setApellido2(Apellido2.getText());
					editada.setIdentificacion(Identificacion.getText());
					editada.setFecha_nacimiento(Fecha_nacimiento.getText());
					editada.setDireccion(Direccion.getText());
					editada.setPoblacion(Poblacion.getText());
					editada.setCp(Integer.parseInt(CP.getText()));
					editada.setTelefono(Integer.parseInt(Telefono.getText()));
					editada.setCorreo(Correo.getText());
					editada.setSexo(sexo);
					editada.setGrupo_sanguineo(Sangre.getText());
					editada.setCiclo(Ciclo.getText());
					TablaDonantes.set(indiceEdicion, editada);
					con.ActualizarDatosDonante(TablaDonantes2.get(0), editada);
					
					Alert alerta = new Alert ( AlertType.INFORMATION ); 
				   	alerta . setTitle ( "Información" ); 
				   	alerta . setHeaderText (null); 
				   	alerta . setContentText ("¡Campo Actualizado!");  
				   	alerta . showAndWait();
		
				}else{
					
					Donante DonanteNuevoB = new Donante(NºDonante, Nombre.getText(), Apellido1.getText(), Apellido2.getText(), Identificacion.getText(), Fecha_nacimiento.getText(), Direccion.getText(), Poblacion.getText(), Integer.parseInt(CP.getText()), Integer.parseInt(Telefono.getText()), Correo.getText(), sexo, Sangre.getText(), Ciclo.getText());
					con.GuardarDonante(NºDonante, Nombre.getText(), Apellido1.getText(), Apellido2.getText(), Identificacion.getText(), Fecha_nacimiento.getText(), Direccion.getText(), Poblacion.getText(), Integer.parseInt(CP.getText()), Integer.parseInt(Telefono.getText()), Correo.getText(), sexo, Sangre.getText(), Ciclo.getText());
					
					boolean esta = false;
					
					for(Donante a : TablaDonantes){
						if(a.getNºdonante().equals(DonanteNuevoB.getNºdonante())  ||  a.getIdentificacion().equals(DonanteNuevoB.getIdentificacion())){
							esta=true;
						}

					}
						if(esta==true){
							Alert alerta = new Alert ( AlertType.INFORMATION ); 
						   	alerta . setTitle ( "Información" ); 
						   	alerta . setHeaderText (""); 
						   	alerta . setContentText ("¡Prueba de nuevo o chequea que el DNI/NIE es correcto!");  
						   	alerta . showAndWait();
						}else{
							TablaDonantes.add(DonanteNuevoB);
							Alert alerta = new Alert ( AlertType.INFORMATION ); 
						   	alerta . setTitle ( "Información" ); 
						   	alerta . setHeaderText (""); 
						   	alerta . setContentText ("¡Campo guardado correctamente!");  
						   	alerta . showAndWait();
						}
					
				}

			}
				//-----------------------------Vaciar los textField (estetica)----------------------------
					this.Nombre.setText("");
					this.Apellido1.setText("");
					this.Apellido2.setText("");
					this.Identificacion.setText("");
					this.Fecha_nacimiento.setText("");
					this.Direccion.setText("");
					this.Poblacion.setText("");
					this.CP.setText("");
					this.Telefono.setText("");
					this.Correo.setText("");
					//Sexo no se puede poner en blanco que yo sepa
					this.Sangre.setText("");
					this.Ciclo.setText("");
					
					

	 		}
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
				Telefono.setText(choose.getTelefono().toString());
				CP.setText(choose.getCp().toString());
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
		
		
		
			
			
	
		
		
		

	


	
	
	

