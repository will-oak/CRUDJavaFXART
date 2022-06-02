package Principal;
import java.sql.SQLException;

import control.FuncionarioControl;
import control.ProdArteControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	private ProdArteControl arteControl = new ProdArteControl();
	private FuncionarioControl funcControl = new FuncionarioControl();


	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Galeria Grafite Brasil V1.00");
		Image img = new Image("/Principal/Splash.jpg");	
		Button btnIniciar = new Button("Iniciar");
		btnIniciar.setPrefWidth(80.0);
		btnIniciar.setPrefHeight(50.0);
		HBox splash = new HBox(); 
		splash.setAlignment(Pos.CENTER);
		ImageView configImagem = new ImageView(img);
		splash.getChildren().addAll(btnIniciar);
		configImagem.setFitHeight(350.0);
		configImagem.setFitWidth(600.0);
		BackgroundImage bImg = new BackgroundImage(img,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background bGround = new Background(bImg);
        splash.setBackground(bGround);
		Scene splashScreen = new Scene(splash, 600, 350);

		Label lblNome = new Label("Nome: ");
		TextField tfNomeFuncionario = new TextField("");
		Label lblCpf = new Label("CPF: ");
		TextField tfCPFFuncionario = new TextField("");     
		
		Button btnConsultarTodosFuncionarios = new Button("Pesquisar Todos Funcionarios");
		Button btnInserirFuncionario = new Button("Incluir");
		Button btnConsultarFuncionario = new Button("Pesquisar por nome");
		Button btnAtualizarFuncionario = new Button("Atualizar por nome");
		Button btnExcluirFuncionario = new Button("Excluir por CPF");
		Button btnLimpaFuncionario = new Button("Limpar Campos");
		Button btnCadastrarArte = new Button("Cadastrar Arte");
		Button btnVoltarFunc = new Button("Voltar ao Menu Anterior");
		btnCadastrarArte.setStyle("-fx-background-color:#9370DB; ");
		btnInserirFuncionario.setStyle("-fx-background-color:#98FB98; ");
		btnConsultarFuncionario.setStyle("-fx-background-color:#1E90FF; ");
		btnConsultarTodosFuncionarios.setStyle("-fx-background-color:#00BFFF; ");
		btnLimpaFuncionario.setStyle("-fx-background-color:#FA8072; ");
		btnExcluirFuncionario.setStyle("-fx-background-color:#FF0000; ");
		
		GridPane painelScreenFunc = new GridPane();
		Scene scnScreenFunc = new Scene(painelScreenFunc, 600, 250);
		GridPane painelScreenFuncTable = new GridPane();
		Scene scnScreenFuncTable = new Scene(painelScreenFuncTable, 600, 250);
		Bindings.bindBidirectional(funcControl.nomeProperty(), tfNomeFuncionario.textProperty());
		Bindings.bindBidirectional(funcControl.CPFProperty(), tfCPFFuncionario.textProperty());

		btnInserirFuncionario.setOnAction( e -> {
			try {
				funcControl.inserirFuncionario();
				stage.setScene(scnScreenFuncTable);
				funcControl.buscarFuncionarios();
			} catch (ClassNotFoundException | SQLException e1) {
				

				e1.printStackTrace();
			}
		});

		btnLimpaFuncionario.setOnAction( e -> {
			funcControl.limpaCamposFuncionario();
		});
		
		btnVoltarFunc.setOnAction( e -> {
			stage.setScene(scnScreenFunc);
		});

		btnConsultarFuncionario.setOnAction(e ->	{
			try {
				funcControl.buscarFuncionario();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
		
		btnAtualizarFuncionario.setOnAction(e ->	{
			try {
				funcControl.atualizarFuncionario();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
		
		btnExcluirFuncionario.setOnAction(e ->	{
			try {
				funcControl.excluirFuncionario();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});


		btnConsultarTodosFuncionarios.setOnAction( e -> {
			try {
				stage.setScene(scnScreenFuncTable);
				funcControl.buscarFuncionarios();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});

		GridPane painelScreenArte = new GridPane();
		Scene scnScreenArte = new Scene(painelScreenArte, 600, 250);

		GridPane painelScreenArteTable = new GridPane();
		Scene scnScreenArteTable = new Scene(painelScreenArteTable, 600, 250);


		FlowPane fPScreenFunc = new FlowPane();
		GridPane gPScreenFunc = new GridPane();

		gPScreenFunc.getChildren().addAll(lblNome, tfNomeFuncionario, lblCpf, tfCPFFuncionario);


		painelScreenFunc.add(lblNome, 0,1);
		painelScreenFunc.add(tfNomeFuncionario, 1,1);
		painelScreenFunc.add(lblCpf, 0,2);
		painelScreenFunc.add(tfCPFFuncionario,1,2);
		fPScreenFunc.getChildren().addAll(btnInserirFuncionario, btnConsultarFuncionario, btnAtualizarFuncionario, 
				btnExcluirFuncionario,btnLimpaFuncionario, btnConsultarTodosFuncionarios, btnCadastrarArte);
		painelScreenFunc.add(fPScreenFunc, 0,3);
		painelScreenFuncTable.add(btnVoltarFunc, 0, 9);
		painelScreenFuncTable.add(funcControl.getTable(), 0, 8);
		painelScreenFuncTable.setPrefSize(600, 250);
	    ColumnConstraints colunaFunc = new ColumnConstraints();
	    colunaFunc.setPercentWidth(100);
	    painelScreenFuncTable.getColumnConstraints().addAll(colunaFunc);

	

		Button btnInserirArte = new Button("Incluir");
		Button btnConsultarArte = new Button("Pesquisar por nome");
		Button btnConsultarTodasArtes = new Button("Pesquisar Todas Artes");
		Button btnAtualizarArte = new Button("Atualizar por nome");
		Button btnExcluirArte = new Button("Excluir por nome");
		Button btnVoltarArte = new Button("Voltar ao Menu Anterior");
		Button btnCadastrarFunc = new Button("Cadastrar Funcionario");
		Button btnLimpaArte = new Button("Limpar Campos");
		btnCadastrarFunc.setStyle("-fx-background-color:#9370DB; ");
		btnInserirArte.setStyle("-fx-background-color:#98FB98; ");
		btnConsultarArte.setStyle("-fx-background-color:#1E90FF; ");
		btnConsultarTodasArtes.setStyle("-fx-background-color:#00BFFF; ");
		btnLimpaArte.setStyle("-fx-background-color:#FA8072; ");
		btnExcluirArte.setStyle("-fx-background-color:#FF0000; ");


		Label lblNomeObra = new Label("Nome da Obra: ");
		TextField tfNomeObra = new TextField("");
		Label lblMaterial = new Label("Material Usado: ");
		TextField tfMaterial = new TextField("");
		Label lblNomeArtista = new Label("Nome do Artista: ");
		TextField tfNomeArtista = new TextField("");
		Label lblValor = new Label("Valor da Obra: ");
		TextField tfValor = new TextField("");
		Label lblAno = new Label("Ano da Obra: ");
		TextField tfAno = new TextField("");
		FlowPane fPScreenArte = new FlowPane();
		GridPane gPScreenArte = new GridPane();
		GridPane gPScreenArteTable = new GridPane();

		gPScreenArte.getChildren().addAll(lblNomeObra, tfNomeObra, lblMaterial, tfMaterial, lblNomeArtista, tfNomeArtista, lblValor, tfValor,lblAno, tfAno);


		painelScreenArte.add(lblNomeObra, 0,1);
		painelScreenArte.add(tfNomeObra, 1,1);
		painelScreenArte.add(lblMaterial, 0,2);
		painelScreenArte.add(tfMaterial,1,2);
		painelScreenArte.add(lblNomeArtista, 0,3);
		painelScreenArte.add(tfNomeArtista,1,3);
		painelScreenArte.add(lblValor, 0,4);
		painelScreenArte.add(tfValor,1,4);
		painelScreenArte.add(lblAno, 0,5);
		painelScreenArte.add(tfAno,1,5);
		fPScreenArte.getChildren().addAll(btnInserirArte, btnConsultarArte, btnConsultarTodasArtes,
				btnAtualizarArte, btnExcluirArte, btnLimpaArte,btnCadastrarFunc);


		Bindings.bindBidirectional(arteControl.nomeObraProperty(), tfNomeObra.textProperty());
		Bindings.bindBidirectional(arteControl.artistaProperty(), tfNomeArtista.textProperty());
		Bindings.bindBidirectional(arteControl.materialProperty(), tfMaterial.textProperty());
		Bindings.bindBidirectional(arteControl.valorProperty(), tfValor.textProperty());
		Bindings.bindBidirectional(arteControl.anoProperty(), tfAno.textProperty());

		painelScreenArte.add(fPScreenArte, 1,6);
		gPScreenArteTable.getChildren().addAll(btnVoltarArte);
		painelScreenArteTable.add(btnVoltarArte, 0, 9);
		painelScreenArteTable.add(arteControl.getTable(), 0, 8);
	    ColumnConstraints colunaArte = new ColumnConstraints();
	    colunaArte.setPercentWidth(100);
	    painelScreenArteTable.getColumnConstraints().addAll(colunaArte);
		
		

		btnInserirArte.setOnAction( e -> {
			try {
				arteControl.inserirArte();
				stage.setScene(scnScreenArteTable);
				arteControl.buscarArtes();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
	
		btnExcluirArte.setOnAction( e -> {
			try {
				arteControl.excluirArte();

			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});

		btnConsultarArte.setOnAction( e -> {
			try {
				arteControl.buscarArte();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
		
		btnLimpaArte.setOnAction( e -> {
			arteControl.limparCamposArte();
		});

		btnConsultarTodasArtes.setOnAction( e -> {
			try {
				stage.setScene(scnScreenArteTable);
				arteControl.buscarArtes();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});

		btnCadastrarFunc.setOnAction( e -> {
			stage.setScene(scnScreenFunc);
		});

		btnCadastrarArte.setOnAction( e -> {
			stage.setScene(scnScreenArte);
		});

		btnVoltarArte.setOnAction( e -> {
			stage.setScene(scnScreenArte);
		});
        
		btnIniciar.setOnAction( e -> {
			stage.setScene(scnScreenFunc);
		});
		stage.setResizable(false);
		stage.setScene(splashScreen);
		stage.show();



	}






	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
}