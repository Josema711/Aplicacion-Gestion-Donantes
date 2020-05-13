package Vista;

//Problema//
		import javafx.scene.control.Button;
//Problema//

import java.sql.SQLException;


import Objetos.Donante;
import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class ControladoraNuevoDonante extends ControladoraDonante {
	


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
		this.MenuPrincipal.mostrarDonantes();
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
 	
 	
 	
 	//-----------------------ACCIONES----------------------//

		

 	public void Guardar(ActionEvent event) throws SQLException{
 		
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

 	public void Borrar(ActionEvent event) throws SQLException{
 		
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

	}

