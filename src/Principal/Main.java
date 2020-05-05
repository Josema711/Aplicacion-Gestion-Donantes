package Principal;

import Vista.Controladora;
import Vista.ControladoraDonacion;
import Vista.ControladoraDonante;
import Vista.ControladoraEstadisticas;
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
	
	
	
	public static void main1(String[] args) {
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
            controladora.setprimaryStage(ventana);
            
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
            controladora.setprimaryStage(ventana);
            
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
            controladora.setprimaryStage(ventana);
            
            ventana.show();
            
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
}
