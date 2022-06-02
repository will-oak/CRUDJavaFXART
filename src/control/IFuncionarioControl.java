package control;

import java.sql.SQLException;

import model.Funcionario;

public interface IFuncionarioControl {



	public void buscarFuncionarios() throws ClassNotFoundException, SQLException;
	public void limpaCamposFuncionario()throws ClassNotFoundException, SQLException;
	void inserirFuncionario() throws ClassNotFoundException, SQLException;
	void buscarFuncionario() throws ClassNotFoundException, SQLException;
	void atualizarFuncionario() throws ClassNotFoundException, SQLException;
	void excluirFuncionario() throws ClassNotFoundException, SQLException;
	
}