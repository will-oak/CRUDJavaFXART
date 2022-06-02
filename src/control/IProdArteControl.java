package control;

import java.sql.SQLException;

import model.ProdArte;

public interface IProdArteControl {

	public void excluirArte() throws ClassNotFoundException, SQLException;
	void inserirArte() throws ClassNotFoundException, SQLException;
	void buscarArte() throws ClassNotFoundException, SQLException;
	void buscarArtes() throws ClassNotFoundException, SQLException;
	void atualizarArte() throws ClassNotFoundException, SQLException;
	
}

