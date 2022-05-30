package control;

import java.sql.SQLException;
import java.util.List;

import model.Funcionario;
import persistence.FuncionarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FuncionarioControl implements IFuncionarioControl {
	
	private TextField tfCodigoFuncionario;
	private TextField tfNomeFuncionario;
	private TextField tfCPFFuncionario;
	private TextArea taListaFuncionarios;
	

	

	public FuncionarioControl(TextField tfCodigoFuncionario, TextField tfNomeFuncionario, TextField tfCPFFuncionario,
			TextArea taListaFuncionarios) {
		this.tfCodigoFuncionario = tfCodigoFuncionario;
		this.tfNomeFuncionario = tfNomeFuncionario;
		this.tfCPFFuncionario = tfCPFFuncionario;
		this.taListaFuncionarios = taListaFuncionarios;
	}

	@Override
	public void inserirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		FuncionarioDao fDao = new FuncionarioDao();
		fDao.insereFuncionario(f);
		limpaCamposFuncionario();
		buscarFuncionarios();
	}

	@Override
	public void atualizarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		FuncionarioDao fDao = new FuncionarioDao();
		fDao.atualizaFuncionario(f);
		limpaCamposFuncionario();
		buscarFuncionarios();
	}

	@Override
	public void excluirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		FuncionarioDao fDao = new FuncionarioDao();
		fDao.excluiFuncionario(f);
		limpaCamposFuncionario();
		buscarFuncionarios();
	}

	@Override
	public void buscarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
		limpaCamposFuncionario();

		FuncionarioDao fDao = new FuncionarioDao();
		f = fDao.buscaFuncionario(f);

		tfCodigoFuncionario.setText(String.valueOf(f.getId()));
		tfNomeFuncionario.setText(f.getNome());
		tfCPFFuncionario.setText(String.valueOf(f.getCpf()));
	
	}

	@Override
	public void buscarFuncionarios() throws ClassNotFoundException, SQLException {
		limpaCamposFuncionario();
		taListaFuncionarios.setText("");
		
		FuncionarioDao fDao = new FuncionarioDao();
		List<Funcionario> listaFuncionarios = fDao.buscaFuncionarios();
		
		StringBuffer buffer = new StringBuffer("Código\t\t\t\tNome\t\t\t\tCPF\n");
		for (Funcionario f : listaFuncionarios ) {
			buffer.append(f.getId()+"\t\t\t\t\t"+f.getNome()+"\t\t\t\t"+f.getCpf()+"\n");
		}
		
		taListaFuncionarios.setText(buffer.toString());
		
	}
	
	private void limpaCamposFuncionario() {
		tfCodigoFuncionario.setText("");
		tfNomeFuncionario.setText("");
		tfCPFFuncionario.setText("");
	}

}