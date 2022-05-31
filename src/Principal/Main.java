package Principal;
import java.sql.SQLException;

import control.FuncionarioControl;
import control.MainController;
import control.ProdArteControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {


private MainController mainController = new MainController();
private ProdArteControl arteController = new ProdArteControl();
//private FuncionarioControl funcControl = new FuncionarioControl();
	
	
	
    @Override
    public void start(Stage stage) throws Exception {
    	
        Label lblId = new Label("Código funcionario: ");
        TextField tfCodigoFuncionario = new TextField("");

        Label lblNome = new Label("Nome: ");
        TextField tfNomeFuncionario = new TextField("");

        Label lblCpf = new Label("CPF: ");
        TextField tfCPFFuncionario = new TextField("");
        

        Bindings.bindBidirectional(mainController.nomeProperty(), tfNomeFuncionario.textProperty());
        Bindings.bindBidirectional(mainController.CPFProperty(), tfCPFFuncionario.textProperty());
        Bindings.bindBidirectional(mainController.IdProperty(), tfCodigoFuncionario.textProperty());
        



        Button btnInserirFuncionario = new Button("Incluir");
        Button btnConsultarFuncionario = new Button("Pesquisar");
        Button btnAtualizarFuncionario = new Button("Atualizar");
        Button btnExcluirFuncionario = new Button("Excluir");
        Button btnLimpaFuncionario = new Button("Limpar Campos");
        Button cadastrarArte = new Button("Cadastrar Arte");
    	
    	//SplashScreen
 	
        //Tela de cadastro do Funcionário
    	GridPane painel = new GridPane();
        
        Scene scn = new Scene(painel, 600, 250);
        stage.setScene(scn);


        

        
        
        btnInserirFuncionario.setOnAction( e -> {
			try {
				mainController.adicionar();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
     /*   
        btnLimpaFuncionario.setOnAction( e -> {
			try {
				mainController.LimpaCampos();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
       */ 
        btnConsultarFuncionario.setOnAction(e ->	{
        try {
				mainController.consultar();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
        
      /* ARRUMANDO OS TEXTOS  
    //    salvar.setPrefWidth(80.0);
     //   salvar.setPrefHeight(80.0);
        
        //txtCpf.setPrefWidth(80.0);
      //  txtCpf.setPrefHeight(80.0);
        
        */
        
        FlowPane flowPane = new FlowPane();
        GridPane gridePane = new GridPane();

        gridePane.getChildren().addAll(lblId, tfCodigoFuncionario, lblNome, tfNomeFuncionario, lblCpf, tfCPFFuncionario);
        painel.add(lblId, 0,0);
        painel.add(tfCodigoFuncionario, 1,0);

        painel.add(lblNome, 0,1);
        painel.add(tfNomeFuncionario, 1,1);

        painel.add(lblCpf, 0,2);
        painel.add(tfCPFFuncionario,1,2);

        flowPane.getChildren().addAll(btnInserirFuncionario, btnConsultarFuncionario, btnAtualizarFuncionario, btnExcluirFuncionario, cadastrarArte);
        
                
        painel.add(flowPane, 0,3);
        
        stage.show();
        

    	//Tela de cadastro das obras de arte no estoque
        GridPane painel2 = new GridPane();
        Scene scn2 = new Scene(painel2, 600, 250);
        
        Button btnInserirArte = new Button("Incluir");
        Button btnConsultarArte = new Button("Pesquisar");
        Button btnAtualizarArte = new Button("Atualizar");
        Button btnExcluirArte = new Button("Excluir");
        
        Button cadastrarFunc = new Button("Cadastrar Funcionario");
        
        
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
        
        FlowPane flowPane2 = new FlowPane();
        GridPane gridePane2 = new GridPane();
        
        gridePane2.getChildren().addAll(lblIdObra, tfIdObra, lblNomeObra, tfNomeObra, lblMaterial, tfMaterial, lblNomeArtista, tfNomeArtista, lblValor, tfValor,lblAno, tfAno);
        painel2.add(lblIdObra, 0,0);
        painel2.add(tfIdObra, 1,0);

        painel2.add(lblNomeObra, 0,1);
        painel2.add(tfNomeObra, 1,1);

        painel2.add(lblMaterial, 0,2);
        painel2.add(tfMaterial,1,2);

        painel2.add(lblNomeArtista, 0,3);
        painel2.add(tfNomeArtista,1,3);
        
        painel2.add(lblValor, 0,4);
        painel2.add(tfValor,1,4);
        
        painel2.add(lblAno, 0,5);
        painel2.add(tfAno,1,5);
        
        flowPane2.getChildren().addAll(btnInserirArte, btnConsultarArte, btnAtualizarArte, btnExcluirArte, cadastrarFunc);
        
        Bindings.bindBidirectional(arteController.idObraProperty(), tfIdObra.textProperty());
        Bindings.bindBidirectional(arteController.nomeObraProperty(), tfNomeObra.textProperty());
        Bindings.bindBidirectional(arteController.artistaProperty(), tfNomeArtista.textProperty());
        Bindings.bindBidirectional(arteController.materialProperty(), tfMaterial.textProperty());
        Bindings.bindBidirectional(arteController.valorProperty(), tfValor.textProperty());
        Bindings.bindBidirectional(arteController.anoProperty(), tfAno.textProperty());
                
        painel2.add(flowPane2, 1,6);

        painel.add(mainController.getTable(), 0, 7);
        painel2.add(arteController.getTable(), 1, 8);
        
        btnInserirArte.setOnAction( e -> {
			try {
				arteController.inserirArte();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
        
        btnConsultarArte.setOnAction( e -> {
			try {
				arteController.buscarArte();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
        
        btnLimpaArte.setOnAction( e -> {
			try {
				arteController.buscarArte();
			} catch (ClassNotFoundException | SQLException e1) {

				e1.printStackTrace();
			}
		});
        
        
        //Evento do botão cadastrarArte
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	stage.setScene(scn2);
            }
        };
  
       cadastrarArte.setOnAction(event);
        
       EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e)
           {
           	stage.setScene(scn);
           }
       };     

       cadastrarFunc.setOnAction(event2);
       
       
    

  //  btnInserirFuncionario.setOnAction(b -> funcControl.inserirFuncionario());
    
    
    

    }
    





	public static void main(String[] args) {
    	Application.launch(Main.class, args);
    }
    }