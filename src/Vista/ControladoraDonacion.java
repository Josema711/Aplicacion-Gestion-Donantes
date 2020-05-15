package Vista;

import java.sql.SQLException;

import Conexion.ConexionBBDD;
import Objetos.Donacion;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraDonacion {
		
	//Atributos, botones, etc
		@FXML
		private Button close;
		@FXML
		private Button guardar;
		
		private Stage ventana;
		
		private Main MenuPrincipal;
		
	
		
	@FXML
 		private TextField NºDonacion; 
	@FXML
 		private TextField Cod_colecta;
	@FXML
		private TextField Tipo;
	@FXML
 		private TextField Pulso;
	@FXML
		private TextField Sist; 
	@FXML
		private TextField Diast;
	@FXML
 		private TextField Cap;
	@FXML
 		private TextField Ven;
	@FXML
		private TextField Fecha;

		
			@FXML
				private TableView<Donacion> Tabla;
			@FXML
		  		private TableColumn<Donacion,Integer> ColN_Donacion;
			@FXML
				private TableColumn<Donacion,Integer> ColCod_Colecta;
			@FXML
				private TableColumn<Donacion,String> ColTipo;
			@FXML
				private TableColumn<Donacion,Integer> ColPulso;
			@FXML
				private TableColumn<Donacion,Integer> ColSist;
			@FXML
				private TableColumn<Donacion,Integer> ColDiast;
			@FXML
				private TableColumn<Donacion,Integer> ColCap;
		  	@FXML
		  		private TableColumn<Donacion,Integer> ColVen;
		  	@FXML
		  		private TableColumn<Donacion,String> ColFecha;
		  	
		  	
		  //Vinculacion con BBDD
			
			ConexionBBDD con;
			   
				protected ObservableList<Donacion> TablaDonaciones = FXCollections.observableArrayList();	
				protected ObservableList<Donacion> TablaDonaciones2 = FXCollections.observableArrayList();
					protected boolean edicion=false;
					protected int indiceEdicion=0;
			 
			 
			 
			 public void initialize() throws SQLException{
				
				con = new ConexionBBDD();
				
				 TablaDonaciones = con.MostrarTablaDonacion();
				
				 Tabla.setItems(TablaDonaciones);
				 ColN_Donacion.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("nºdonacion"));
				 ColCod_Colecta.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("cod_colecta"));
				 ColTipo.setCellValueFactory(new PropertyValueFactory<Donacion,String>("tipo_donacion"));
				 ColPulso.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("pulso"));
				 ColSist.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("ta_sist"));
				 ColDiast.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("ta_diast"));
				 ColCap.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("hb_cap"));
				 ColVen.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("hb_ven"));
				 ColFecha.setCellValueFactory(new PropertyValueFactory<Donacion,String>("fecha"));
			
			 }
			 
			 
			 ///-------------------accion de guardar-----------------------
			 
			 public void Guardar(ActionEvent event) throws SQLException{
			 		
			 		//Numero aleatorio para que no se repitan
			 		Integer NºDonacion = (int) (Math.random()*(99999));
			 		NºDonacion = (int) Math.floor(NºDonacion);
			 		

					// Añadir un chequeo de campos vacío
					if(Integer.parseInt(Cod_colecta.getText())==0 || Tipo.getText().equals("") || Integer.parseInt(Pulso.getText())==0 || Integer.parseInt(Sist.getText())==0 || Integer.parseInt(Diast.getText())==0 || Integer.parseInt(Cap.getText())==0 || Integer.parseInt(Ven.getText())==0 || Fecha.getText().equals("") ){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!!!");
						alert.setHeaderText("¡¡Hay campos vacios!!");
						alert.setContentText("¡No se pueden introducir campos vacíos!");
						alert.showAndWait();
					}
					else{

						
						
						Donacion DonacionNuevoA = new Donacion(NºDonacion, Integer.parseInt(Cod_colecta.getText()), Tipo.getText(), Integer.parseInt(Pulso.getText()), Integer.parseInt(Sist.getText()), Integer.parseInt(Diast.getText()), Integer.parseInt(Cap.getText()), Integer.parseInt(Ven.getText()), Fecha.getText());
						TablaDonaciones2.add(DonacionNuevoA);
						
						if(edicion == true){
							Donacion editada = TablaDonaciones.get(indiceEdicion);
							editada.setNºdonacion(NºDonacion);
							editada.setCod_colecta(Integer.parseInt(Cod_colecta.getText()));
							editada.setTipo_donacion(Tipo.getText());
							editada.setPulso(Integer.parseInt(Pulso.getText()));
							editada.setTa_sist(Integer.parseInt(Sist.getText()));
							editada.setTa_diast(Integer.parseInt(Diast.getText()));
							editada.setHb_cap(Integer.parseInt(Cap.getText()));
							editada.setHb_ven(Integer.parseInt(Ven.getText()));
							editada.setFecha(Fecha.getText());
							TablaDonaciones.set(indiceEdicion, editada);
							con.ActualizarDatosDonaciones(TablaDonaciones2.get(0), editada);
							
							Alert alerta = new Alert ( AlertType.INFORMATION ); 
						   	alerta . setTitle ( "Información" ); 
						   	alerta . setHeaderText (null); 
						   	alerta . setContentText ("¡Campo Actualizado!");  
						   	alerta . showAndWait();
				
						}else{
							
							Donacion DonacionNuevoB = new Donacion(NºDonacion, Integer.parseInt(Cod_colecta.getText()), Tipo.getText(), Integer.parseInt(Pulso.getText()), Integer.parseInt(Sist.getText()), Integer.parseInt(Diast.getText()), Integer.parseInt(Cap.getText()), Integer.parseInt(Ven.getText()), Fecha.getText());
							con.GuardarDonacion(NºDonacion, Integer.parseInt(Cod_colecta.getText()), Tipo.getText(), Integer.parseInt(Pulso.getText()), Integer.parseInt(Sist.getText()), Integer.parseInt(Diast.getText()), Integer.parseInt(Cap.getText()), Integer.parseInt(Ven.getText()), Fecha.getText());
							
							boolean esta = false;
							
							for(Donacion a : TablaDonaciones){
								if(a.getNºdonacion().equals(DonacionNuevoB.getNºdonacion())){
									esta=true;
								}

							}
								if(esta==true){
									Alert alerta = new Alert ( AlertType.INFORMATION ); 
								   	alerta . setTitle ( "Información" ); 
								   	alerta . setHeaderText (""); 
								   	alerta . setContentText ("¡Prueba de nuevo!");  
								   	alerta . showAndWait();
								}else{
									TablaDonaciones.add(DonacionNuevoB);
									Alert alerta = new Alert ( AlertType.INFORMATION ); 
								   	alerta . setTitle ( "Información" ); 
								   	alerta . setHeaderText (""); 
								   	alerta . setContentText ("¡Campo guardado correctamente!");  
								   	alerta . showAndWait();
								}
							
						}

					}
						//-----------------------------Vaciar los textField (estetica)----------------------------
							this.Cod_colecta.setText("");
							this.Tipo.setText("");
							this.Pulso.setText("");
							this.Sist.setText("");
							this.Diast.setText("");
							this.Cap.setText("");
							this.Ven.setText("");
							this.Fecha.setText("");
							
							

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
			
}
