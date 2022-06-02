package Principal;
import java.sql.SQLException;

import control.FuncionarioControl;
import control.ProdArteControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {

	private ProdArteControl arteControl = new ProdArteControl();
	private FuncionarioControl funcControl = new FuncionarioControl();


	@Override
	public void start(Stage stage) throws Exception {

		Image img = new Image("/Principal/Splash.jpg");	
		Button btnIniciar = new Button("Iniciar");
		btnIniciar.setPrefWidth(50.0);
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
	


		Label lblId = new Label("Código funcionario: ");
		TextField tfCodigoFuncionario = new TextField("");

		Label lblNome = new Label("Nome: ");
		TextField tfNomeFuncionario = new TextField("");

		Label lblCpf = new Label("CPF: ");
		TextField tfCPFFuncionario = new TextField("");
        
		Button btnConsultarTodosFuncionarios = new Button("Pesquisar Todos Funcionarios");
		Button btnInserirFuncionario = new Button("Incluir");
		Button btnConsultarFuncionario = new Button("Pesquisar por nome");
		Button btnAtualizarFuncionario = new Button("Atualizar");
		Button btnExcluirFuncionario = new Button("Excluir");
		Button btnLimpaFuncionario = new Button("Limpar Campos");
		Button btnCadastrarArte = new Button("Cadastrar Arte");
		Button btnVoltarFunc = new Button("Voltar ao Menu Anterior");

		GridPane painelScreenFunc = new GridPane();
		Scene scnScreenFunc = new Scene(painelScreenFunc, 600, 250);
		
		GridPane painelScreenFuncTable = new GridPane();
		Scene scnScreenFuncTable = new Scene(painelScreenFuncTable, 600, 250);

		Bindings.bindBidirectional(funcControl.nomeProperty(), tfNomeFuncionario.textProperty());
		Bindings.bindBidirectional(funcControl.CPFProperty(), tfCPFFuncionario.textProperty());
		Bindings.bindBidirectional(funcControl.IdProperty(), tfCodigoFuncionario.textProperty());


        
		btnConsultarTodosFuncionarios.setOnAction( e -> {
			try {
				stage.setScene(scnScreenFuncTable);
				funcControl.buscarFuncionarios();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});


		btnInserirFuncionario.setOnAction( e -> {
			try {
				funcControl.inserirFuncionario();
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

		GridPane painelScreenArte = new GridPane();
		Scene scnScreenArte = new Scene(painelScreenArte, 600, 250);

		GridPane painelScreenArteTable = new GridPane();
		Scene scnScreenArteTable = new Scene(painelScreenArteTable, 600, 250);


		FlowPane fPScreenFunc = new FlowPane();
		GridPane gPScreenFunc = new GridPane();

		gPScreenFunc.getChildren().addAll(lblId, tfCodigoFuncionario, lblNome, tfNomeFuncionario, lblCpf, tfCPFFuncionario);
		painelScreenFunc.add(lblId, 0,0);
		painelScreenFunc.add(tfCodigoFuncionario, 1,0);

		painelScreenFunc.add(lblNome, 0,1);
		painelScreenFunc.add(tfNomeFuncionario, 1,1);

		painelScreenFunc.add(lblCpf, 0,2);
		painelScreenFunc.add(tfCPFFuncionario,1,2);

		fPScreenFunc.getChildren().addAll(btnInserirFuncionario, btnConsultarFuncionario, btnAtualizarFuncionario, btnExcluirFuncionario,btnLimpaFuncionario, btnConsultarTodosFuncionarios, btnCadastrarArte);


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
		Button btnAtualizarArte = new Button("Atualizar");
		Button btnExcluirArte = new Button("Excluir");
		Button btnVoltarArte = new Button("Voltar ao Menu Anterior");
		Button btnCadastrarFunc = new Button("Cadastrar Funcionario");


		Label lblIdObra = new Label("Código da Obra: ");
		TextField tfIdObra = new TextField("");

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

		gPScreenArte.getChildren().addAll(lblIdObra, tfIdObra, lblNomeObra, tfNomeObra, lblMaterial, tfMaterial, lblNomeArtista, tfNomeArtista, lblValor, tfValor,lblAno, tfAno);
		painelScreenArte.add(lblIdObra, 0,0);
		painelScreenArte.add(tfIdObra, 1,0);

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

		fPScreenArte.getChildren().addAll(btnInserirArte, btnConsultarArte, btnConsultarTodasArtes, btnAtualizarArte, btnExcluirArte, btnCadastrarFunc);

		Bindings.bindBidirectional(arteControl.idObraProperty(), tfIdObra.textProperty());
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

		stage.setScene(splashScreen);
		stage.show();



	}






	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
}