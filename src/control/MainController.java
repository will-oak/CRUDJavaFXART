package control;

import java.sql.SQLException;
import java.util.List;


import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Funcionario;
import model.ProdArte;
import persistence.FuncionarioDao;
import persistence.IFuncionarioDao;

public class MainController {
	


	private ObservableList<Funcionario> funcionario = FXCollections.observableArrayList();
	
	
	private StringProperty nomeFunc = new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty idFunc = new SimpleStringProperty();
	

	public MainController() {
        
        TableColumn<Funcionario, String> col2 = new TableColumn<>("nomeFunc");
        col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        TableColumn<Funcionario, String> col3 = new TableColumn<>("CPF");
        col3.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        

        table.getColumns().addAll(col2, col3);
        

        table.setItems(funcionario);
    }
	
	
	private StringProperty idObra = new SimpleStringProperty("");
	private StringProperty nomeObra = new SimpleStringProperty("");
	private StringProperty nomeArtista = new SimpleStringProperty("");
	private StringProperty valor = new SimpleStringProperty("");
	private StringProperty ano = new SimpleStringProperty("");
	
	private StringProperty material = new SimpleStringProperty("");
	
	private TableView<Funcionario> table = new TableView<>();
	
	
		
	
	  public StringProperty nomeProperty() {
	        return nomeFunc;
	    }
	  
	  public StringProperty CPFProperty() {
	        return cpf;
	    }
	  
  public StringProperty IdProperty() {
	        return idFunc;
	    }
	  
	  public void adicionar() throws ClassNotFoundException, SQLException {

	        Funcionario f = new Funcionario();
	        FuncionarioDao fd = new FuncionarioDao();
	        f.setNome(nomeFunc.get());
	        f.setCpf(Integer.parseInt(cpf.get())); 
	        funcionario.add(f);
	        fd.insereFuncionario(f);
	        System.out.println("Nome: " + nomeFunc.get());
	        System.out.println("CPF: " + cpf.get());

	    }
	  
	    public void consultar()  throws ClassNotFoundException, SQLException {
	    IFuncionarioDao funcDao = new FuncionarioDao();
	    
	    for (Funcionario f : funcionario) {
	    if (f != null && f.getNome().contains(nomeFunc.get())) {
  	    nomeFunc.set(f.getNome());
	    idFunc.set(Integer.toString(f.getId()));
	    cpf.set(Integer.toString(f.getCpf()));
	    break;
	      }
	    }	    	
	    	
	    	
           List<Funcionario> listaFunc = funcDao.buscaFuncionarios();
	       funcionario.clear();
	       funcionario.addAll(listaFunc);
	 
	    }
	    public TableView getTable() {
	        return table;
	    }
	}
	


