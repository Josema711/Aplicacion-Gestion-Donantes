package Vista;

import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonacion {
		
		@FXML
		private Button close;
		
		private Stage ventana;
		
		private Main MenuPrincipal;
		
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
