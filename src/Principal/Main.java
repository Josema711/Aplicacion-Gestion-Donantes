package Principal;

import Vista.Controladora;
import Vista.ControladoraDonacion;
import Vista.ControladoraDonante;
import Vista.ControladoraEstadisticas;
import Vista.ControladoraNuevoDonante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {

	private static Stage primaryStage;
	private AnchorPane rootPane;

	@Override
	public void start(Stage primaryStage) throws Exception{
		Main.primaryStage = primaryStage;
		mostrarPrincipal();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	/*
	 * Cargamos la Ventana pricipal
	 */
	
	public void mostrarPrincipal(){
		try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("..\\Vista\\UIMenuInicial.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setTitle("Ventana Principal");
            primaryStage.setScene(scene);
            	/*
            	 * Añadimos las llamadas del main al controlador y del controlador al main
            	 */
            
            Controladora controladora = loader.getController();
            controladora.setMenuPrincipal(this);
            
            primaryStage.show();
            
           } catch(Exception e) {
			e.printStackTrace();
		}
	}




	public void mostrarDonantes() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("..\\Vista\\UIDonante.fxml"));
            SplitPane VentanaDonantes = (SplitPane) loader.load();
            //Creamos la segunda ventana como otro stage
            Stage ventana = new Stage();
            ventana.setTitle("Donantes");
            //Marcamos cual es la pincipal
            ventana.initOwner(primaryStage);
            Scene scene = new Scene(VentanaDonantes);
            ventana.setScene(scene);
            	/*
            	 * Añadimos las llamadas del main al controlador y del controlador al main
            	 */
            
            ControladoraDonante controladora = loader.getController();
            controladora.setPrimaryStage(ventana);
            controladora.setMenuPrincipal(this);
            
            ventana.show();
            
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void mostrarDonaciones() {
		try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("..\\Vista\\UIDonaciones.fxml"));
            AnchorPane VentanaDonaciones = (AnchorPane) loader.load();
            //Creamos la segunda ventana como otro stage
            Stage ventana = new Stage();
            ventana.setTitle("Donaciones");
            //Marcamos cual es la pincipal
            ventana.initOwner(primaryStage);
            Scene scene = new Scene(VentanaDonaciones);
            ventana.setScene(scene);
            	/*
            	 * Añadimos las llamadas del main al controlador y del controlador al main
            	 */
            
            ControladoraDonacion controladora = loader.getController();
            controladora.setPrimaryStage(ventana);
            controladora.setMenuPrincipal(this);
            
            ventana.show();
            
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void mostrarEstadisticas() {
		try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("..\\Vista\\UIEstadisticas.fxml"));
            AnchorPane VentanaEstadisticas = (AnchorPane) loader.load();
            //Creamos la segunda ventana como otro stage
            Stage ventana = new Stage();
            ventana.setTitle("Donantes");
            //Marcamos cual es la pincipal
            ventana.initOwner(primaryStage);
            Scene scene = new Scene(VentanaEstadisticas);
            ventana.setScene(scene);
            	/*
            	 * Añadimos las llamadas del main al controlador y del controlador al main
            	 */
            
            ControladoraEstadisticas controladora = loader.getController();
            controladora.setPrimaryStage(ventana);
            controladora.setMenuPrincipal(this);
            
            ventana.show();
            
           } catch(Exception e) {
			e.printStackTrace();
		}
	}



	public void mostrarNuevoDonante() {
		try {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("..\\Vista\\UINuevoDonante.fxml"));
        AnchorPane VentanaNuevoDonante = (AnchorPane) loader.load();
        //Creamos la segunda ventana como otro stage
        Stage ventana = new Stage();
        ventana.setTitle("NuevoDonante");
        //Marcamos cual es la pincipal
        ventana.initOwner(primaryStage);
        Scene scene = new Scene(VentanaNuevoDonante);
        ventana.setScene(scene);
        	/*
        	 * Añadimos las llamadas del main al controlador y del controlador al main
        	 */
        
        ControladoraNuevoDonante controladora = loader.getController();
        controladora.setPrimaryStage(ventana);
        controladora.setMenuPrincipal(this);
        
        ventana.show();
        
       } catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	public class Imprime extends Application {

		private Stage primaryStage;
		private AnchorPane rootLayout;

		@Override
		public void start(Stage primaryStage) {
			try {
				this.primaryStage = primaryStage;
				this.primaryStage.setTitle("Pulsa e Imprime");

				 // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("UIImprime.fxml"));
	            rootLayout = (AnchorPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	           } catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
}
