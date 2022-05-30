package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Funcionario;

public interface IFuncionarioDao {

	public void insereFuncionario(Funcionario f) throws SQLException;
	public void atualizaFuncionario(Funcionario f) throws SQLException;
	public void excluiFuncionario(Funcionario f) throws SQLException;
	public Funcionario buscaFuncionario(Funcionario f) throws SQLException;
	public List<Funcionario> buscaFuncionarios() throws SQLException;
	
}