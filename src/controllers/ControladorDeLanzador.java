package controllers;

import conexion.ConexionBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ControladorDeLanzador {

	@FXML
    private Tab tabPro;

    @FXML
    private Button btnLanzarProductos;

    @FXML
    private Tab tabSec;

    @FXML
    private Button btnLanzarSecciones;

    @FXML
    private Button btnLanzarTablaProductos;

    @FXML
    private Tab tabGra;

    @FXML
    private Button btnLanzarGraficos;
    
    @FXML
    void lanzarGra(ActionEvent event) {
    	try {
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Graficos.jasper"));
			lanza(report);
		} catch (JRException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void lanzarPro(ActionEvent event) {
    	try {
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Productos.jasper"));
			lanza(report);
		} catch (JRException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void lanzarSec(ActionEvent event) {
    	try {
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Seccion.jasper"));
			lanza(report);
		} catch (JRException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void lanzarTabPro(ActionEvent event) {
    	try {
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("TablaProductos.jasper"));
			lanza(report);
		} catch (JRException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }
    
    void lanza(JasperReport report) {
		try {
			ConexionBDD con = new ConexionBDD();

			JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);

		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
	}

}