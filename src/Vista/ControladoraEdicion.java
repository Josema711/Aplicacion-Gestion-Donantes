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
	
	//Atributos
	
		private Integer nºdonante;
		private String nombre;
		private String apellido1;
		private String apellido2;
		private String identificacion;
		private String fecha_nacimiento;
		private String direccion;
		private String poblacion;
		private Integer cp;
		private Integer telefono;
		private String correo;
		private String sexo;
		private String grupo_sanguineo;
		private String ciclo;

	
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
	ConexionBBDD con;
	
	
	
	 public void initialize() throws SQLException{
		 	Nombre.setText(nombre);
			Apellido1.setText(apellido1);
			Apellido2.setText(apellido2);
			Identificacion.setText(identificacion);
			Fecha_nacimiento.setText(fecha_nacimiento);
			Direccion.setText(direccion);
			Poblacion.setText(poblacion);
			Correo.setText(correo);
			Sangre.setText(grupo_sanguineo);
			Ciclo.setText(ciclo);
		 	
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

	public void setDonante(String nombre, String apellido1, String apellido2, String identificacion,
			String fecha_nacimiento, String direccion, String poblacion, Integer cp, Integer telefono, String correo, String sexo,
			String grupo_sanguineo, String ciclo) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.identificacion = identificacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.cp = cp;
		this.telefono = telefono;
		this.correo = correo;
		this.sexo = sexo;
		this.grupo_sanguineo = grupo_sanguineo;
		this.ciclo = ciclo;

		
	}		
	
}
