package control;

import java.sql.SQLException;

import model.ProdArte;

public interface IProdArteControl {

	public void inserirArte(ProdArte a) throws ClassNotFoundException, SQLException;
	public void atualizarArte(ProdArte a) throws ClassNotFoundException, SQLException;
	public void excluirArte(ProdArte a) throws ClassNotFoundException, SQLException;
	public void buscarArte(ProdArte a) throws ClassNotFoundException, SQLException;
	public void buscarArtes() throws ClassNotFoundException, SQLException;
	
}

