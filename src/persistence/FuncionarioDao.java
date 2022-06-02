package persistence;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao implements IFuncionarioDao {

private Connection c;
	
	public FuncionarioDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void insereFuncionario(Funcionario f) throws SQLException {
		String sql = "INSERT INTO funcionario (nome,CPF) VALUES (?,?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		//ps.setInt(1, f.getId());
		
		ps.setString(1, f.getNome());
		ps.setInt(2, f.getCpf());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaFuncionario(Funcionario f) throws SQLException {
		String sql = "UPDATE funcionario SET nome = ?, CPF = ? WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, f.getNome());
		ps.setInt(2, f.getCpf());
		ps.setInt(3, f.getId());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiFuncionario(Funcionario f) throws SQLException {		
		String sql = "DELETE FROM funcionario WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getId());
		ps.execute();
		ps.close();		
	}

	@Override
	public Funcionario buscaFuncionario(Funcionario f) throws SQLException {
		String sql = "SELECT id, nome, CPF FROM funcionario WHERE nome = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			f.setCpf(rs.getInt("CPF"));
			cont++;
		}
		
		if (cont == 0) {
			f = new Funcionario();
		}
		
		rs.close();
		ps.close();
		return f;
	}

	@Override
	public List<Funcionario> buscaFuncionarios() throws SQLException {
		String sql = "SELECT id, nome, CPF FROM funcionario";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		while (rs.next()) {
			Funcionario f = new Funcionario();
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			f.setCpf(rs.getInt("CPF"));
			
			listaFuncionarios.add(f);
		}
		
		rs.close();
		ps.close();
		
		return listaFuncionarios;

	}
	
}



	