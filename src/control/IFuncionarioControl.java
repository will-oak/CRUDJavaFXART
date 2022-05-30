package control;

import java.sql.SQLException;

import model.Funcionario;

public interface IFuncionarioControl {

	public void inserirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void atualizarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void excluirFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void buscarFuncionario(Funcionario f) throws ClassNotFoundException, SQLException;
	public void buscarFuncionarios() throws ClassNotFoundException, SQLException;
	
}