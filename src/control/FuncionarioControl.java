package control;

import java.sql.SQLException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.IFuncionarioDao;

public class FuncionarioControl implements IFuncionarioControl {

	//private TextArea taListaFuncionarios;
	private ObservableList<Funcionario> funcObsList = FXCollections.observableArrayList();
	private TableView<Funcionario> tableFunc = new TableView<>();
	private StringProperty nomeFunc = new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty idFunc = new SimpleStringProperty();

	public StringProperty nomeProperty() {
		return nomeFunc;
	}

	public StringProperty CPFProperty() {
		return cpf;
	}

	public StringProperty IdProperty() {
		return idFunc;
	}
	
	
	
	public FuncionarioControl() {
		
		TableColumn<Funcionario, String> col2 = new TableColumn<>("Nome do Funcionario");
		col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TableColumn<Funcionario, String> col3 = new TableColumn<>("CPF");
		col3.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableFunc.getColumns().addAll(col2, col3);
     	tableFunc.setItems(funcObsList);


	}

	@Override
	public void inserirFuncionario() throws ClassNotFoundException, SQLException {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao();
		f.setNome(nomeFunc.get());
		f.setCpf(Integer.parseInt(cpf.get())); 
		funcObsList.add(f);
		fd.insereFuncionario(f);
		limpaCamposFuncionario();
	}

	@Override
	public void atualizarFuncionario() throws ClassNotFoundException, SQLException {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao();
		f.setNome(nomeFunc.get());
		f.setCpf(Integer.parseInt(cpf.get())); 
		fd.atualizaFuncionario(f);
	//	limpaCamposFuncionario();
	//	buscarFuncionarios();
	}


	@Override
	public void excluirFuncionario() throws ClassNotFoundException, SQLException {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao();
		f.setNome(nomeFunc.get());
		f.setCpf(Integer.parseInt(cpf.get())); 
		fd.excluiFuncionario(f);
		limpaCamposFuncionario();
	//	buscarFuncionarios();
	}

	@Override
	public void buscarFuncionario() throws ClassNotFoundException, SQLException {
		IFuncionarioDao funcDao = new FuncionarioDao();
		List<Funcionario> listaFunc = funcDao.buscaFuncionarios();
		
		for (Funcionario f : listaFunc) {
			if (f != null && f.getNome().contains(nomeFunc.get())) {
				nomeFunc.set(f.getNome());
				idFunc.set(Integer.toString(f.getId()));
				cpf.set(Integer.toString(f.getCpf()));
				break;
			}
		}	    	

	}


	@Override
	public void buscarFuncionarios() throws ClassNotFoundException, SQLException {
		FuncionarioDao fDao = new FuncionarioDao();
		List<Funcionario> listaFuncionarios = fDao.buscaFuncionarios();
		funcObsList.clear();
		funcObsList.addAll(listaFuncionarios);
		
		StringBuffer buffer = new StringBuffer("Código\t\t\t\tNome\t\t\t\tCPF\n");
		for (Funcionario f : listaFuncionarios ) {
			buffer.append(f.getId()+"\t\t\t\t\t"+f.getNome()+"\t\t\t\t"+f.getCpf()+"\n");
		}


	}

	public void limpaCamposFuncionario() {
		nomeFunc.set("");
		idFunc.set("");
		cpf.set("");

	}


	public TableView getTable() {
		return tableFunc;
	}
}

