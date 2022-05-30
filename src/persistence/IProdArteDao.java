package persistence;

import java.sql.SQLException;
import java.util.List;

import model.ProdArte;

public interface IProdArteDao {

	public void inserirArte(ProdArte a) throws SQLException;
	public void atualizarArte(ProdArte a) throws SQLException;
	public void excluirArte(ProdArte a) throws SQLException;
	public ProdArte buscarArte(ProdArte a) throws SQLException;
	public List<ProdArte> buscarArtes() throws SQLException;
}