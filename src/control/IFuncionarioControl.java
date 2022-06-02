package control;

import java.sql.SQLException;

import model.Funcionario;

public interface IFuncionarioControl {


	public void atualizarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void excluirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void buscarFuncionarios() throws ClassNotFoundException, SQLException;
	public void limpaCamposFuncionario()throws ClassNotFoundException, SQLException;
	void inserirFuncionario() throws ClassNotFoundException, SQLException;
	void buscarFuncionario() throws ClassNotFoundException, SQLException;
	
}