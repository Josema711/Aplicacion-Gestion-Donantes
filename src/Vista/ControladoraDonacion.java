package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonacion {
		
		@FXML
		private Button close;
		
		private Stage ventana;
		
		public void setprimaryStage(Stage ventana) {
			this.ventana = ventana;
		}
		
		public void closeWindow() {
			this.ventana.close();
		}
}
