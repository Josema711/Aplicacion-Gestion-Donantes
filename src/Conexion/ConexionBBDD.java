package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
				int nºdonante = resultado.getInt(1);
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
	
}