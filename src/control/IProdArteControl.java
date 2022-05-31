package control;

import java.sql.SQLException;

import model.ProdArte;

public interface IProdArteControl {

	public void atualizarArte(ProdArte a) throws ClassNotFoundException, SQLException;
	public void excluirArte(ProdArte a) throws ClassNotFoundException, SQLException;
	void inserirArte() throws ClassNotFoundException, SQLException;
	void buscarArte() throws ClassNotFoundException, SQLException;
	void buscarArtes() throws ClassNotFoundException, SQLException;
	
}

