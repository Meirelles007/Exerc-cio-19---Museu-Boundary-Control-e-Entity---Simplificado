package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VisitanteBoundary extends Application {

	private TextField txtID = new TextField();
	private TextField txtNomeVisitante = new TextField();
	private TextField txtNomeEscola = new TextField();
	private DatePicker dataVisita = new DatePicker();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private VisitanteControl control = new VisitanteControl();

	public Visitante boundaryToEntity() {
		Visitante v = new Visitante();
		try {
			v.setId(Integer.parseInt(txtID.getText()));
		} catch (NumberFormatException e) {
			new Alert(Alert.AlertType.ERROR, "Valor ID incorreto").show();
		}
		v.setNomeVisitante(txtNomeVisitante.getText());
		v.setNomeEscola(txtNomeEscola.getText());
//		try {
		v.setDataVisita(dataVisita.getValue());

		return v;
	}

    public void entityToBoundary(Visitante v) {
        if (v != null) {
            txtID.setText(String.valueOf(v.getId()));
            txtNomeVisitante.setText(v.getNomeVisitante());
            txtNomeEscola.setText(v.getNomeEscola());
            dataVisita.setValue(v.getDataVisita());
        }
    }	
	
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		Scene snc = new Scene(pane, 300, 200);

		pane.setHgap(5);
		pane.add(new Label("Id:"), 0, 0);
		pane.add(txtID, 1, 0);
		pane.add(new Label("Nome do Visitante:"), 0, 1);
		pane.add(txtNomeVisitante, 1, 1);
		pane.add(new Label("Nome da Escola:"), 0, 2);
		pane.add(txtNomeEscola, 1, 2);
		pane.add(new Label("Data da Visita:"), 0, 3);
		pane.add(dataVisita, 1, 3);
		pane.add(btnAdicionar, 0, 4);
		pane.add(btnPesquisar, 1, 4);
		stage.setScene(snc);
		stage.setTitle("Museu de História Natural - Cadastro de Visitantes");
		stage.show();
		
        btnAdicionar.setOnAction((e) -> {
            Visitante v = boundaryToEntity();
            control.adicionar(v);
            entityToBoundary(new Visitante());
        });

        btnPesquisar.setOnAction((e) -> {
            Visitante v = control.pesquisar(txtNomeVisitante.getText());
            entityToBoundary(v);
        });
        
	}

	public static void main(String[] args) {
		Application.launch(VisitanteBoundary.class, args);
	}

}