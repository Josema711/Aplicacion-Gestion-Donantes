package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import Objetos.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionBBDD {

	private String url= "";
	private   String user = "";
	private String pwd = "";
	private   String usr = "";
	private   Connection conexion;

	public ConexionBBDD()  {


		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Conexion/datosBBDD.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
	
	public ObservableList<Donante> MostrarTabla() throws SQLException{

		
		ObservableList<Donante> listaDonantes =  FXCollections.observableArrayList();

		Statement stm = conexion.createStatement();
		String select = "SELECT NºDONANTE,NOMBRE,APELLIDO1,APELLIDO2,IDENTIFICACION,FECHA_NACIMIENTO,DIRECCION,POBLACION,CP,TELEFONO,CORREO,SEXO,GRUPO_SANGUINEO,CICLO FROM JOSEMA.DONANTE";

		try{
			ResultSet resultado = stm.executeQuery(select);

			while(resultado.next()){
				Integer nºdonante = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String identificacion = resultado.getString(5);
				String fecha_nacimiento = resultado.getString(6);
				String direccion = resultado.getString(7);
				String poblacion = resultado.getString(8);
				int cp = resultado.getInt(9);
				int telefono = resultado.getInt(10);
				String correo = resultado.getString(11);
				String sexo = resultado.getString(12);
				String grupo_sanguineo = resultado.getString(13);
				String ciclo = resultado.getString(14);
				
						
				Donante donante = new Donante(nºdonante, nombre, apellido1, apellido2, identificacion, fecha_nacimiento, direccion, poblacion, cp, telefono, correo, sexo, grupo_sanguineo, ciclo);
				listaDonantes.add(donante);
			}

		}catch(SQLException e){

					
			int pos = e.getMessage().indexOf(":");
			String codeError = e.getMessage().substring(0,pos);

			System.out.println(codeError);
		}
				

		return listaDonantes;
	}
	
	//---------------------------------ACCION DE ACTUALIZAR------------------------------------
	
	public void ActualizarDatos(Donante Donante1,Donante Donante2) throws SQLException{
		 
		 String update = "UPDATE JOSEMA.DONANTE SET NºDONANTE=?,NOMBRE=?,APELLIDO1=?,APELLIDO2=?,IDENTIFICACION=?,FECHA_NACIMIENTO=?,DIRECCION=?,POBLACION=?,CP=?,TELEFONO=?,CORREO=?,SEXO=?,GRUPO_SANGUINEO=?,CICLO=?";		
		
		  PreparedStatement pstmt = conexion.prepareStatement(update);
			

				
			pstmt.setLong(1, Donante2.getNºdonante());
			pstmt.setString(2, Donante2.getNombre());
			pstmt.setString(3, Donante2.getApellido1());
			pstmt.setString(4, Donante2.getApellido2());
			pstmt.setString(5, Donante2.getIdentificacion());
			pstmt.setString(6, Donante2.getFecha_nacimiento());
			pstmt.setString(7, Donante2.getDireccion());
			pstmt.setString(8, Donante2.getPoblacion());
			pstmt.setLong(9, Donante2.getCp());
			pstmt.setLong(10, Donante2.getTelefono());
			pstmt.setString(11, Donante2.getCorreo());
			pstmt.setString(12, Donante2.getSexo());
			pstmt.setString(13, Donante2.getGrupo_sanguineo());
			pstmt.setString(14, Donante2.getCiclo());

	try{
			int resultado = pstmt.executeUpdate(update);
				
			if(resultado != 1)
				System.out.println("Error en la modificación " + resultado);
		
	}catch(SQLException e){
		System.out.println(e);
		int pos = e.getMessage().indexOf(":");
		String codeError = e.getMessage().substring(0, pos);
		if(codeError.equals("ORA-00955") )
			System.out.println("La tabla Donante ya estaba creada!!!");
		else
			System.out.println("Ha habido algún problema con Oracle al hacer la modificación de campo");
	}
		  }
	
	//-------------------------ACCION DE GUARDAR-------------------------------------------
	
	public void Guardar(Integer nºdonante, String nombre, String apellido1, String apellido2, String identificacion,
			String fecha_nacimiento, String direccion, String poblacion, int cp, int telefono, String correo, String sexo,
			String grupo_sanguineo, String ciclo) throws SQLException{
		
		//Insercion de datos
		
		String insert = "INSERT INTO JOSEMA.FINAL VALUES (?,?,?,?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement(insert);
		
			
		pstmt.setLong(1, nºdonante);
		pstmt.setString(2,  nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, identificacion);
		pstmt.setString(6, fecha_nacimiento);
		pstmt.setString(7, direccion);
		pstmt.setString(8, poblacion);
		pstmt.setLong(9, cp);
		pstmt.setLong(10, telefono);
		pstmt.setString(11, correo);
		pstmt.setString(12, sexo);
		pstmt.setString(13, grupo_sanguineo);
		pstmt.setString(14, ciclo);

	try{
				
			int resultado = pstmt.executeUpdate();
				
			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
				
	}catch(SQLException e){
				
		int pos = e.getMessage().indexOf(":");
		String codeError = e.getMessage().substring(0, pos);
		if(codeError.equals("ORA-00001") )
			System.out.println("NºDonante ya existente.");
				
		else if(codeError.equals("ORA-00001"))
					
			System.out.println("Algun campo es demasiado largo");
		else if(codeError.equals("ORA-12899"))
			System.out.println("Exceso de caracteres");
		else
			System.out.println("Problema al introducir datos: " + e);
	}
	
	

}
	
}