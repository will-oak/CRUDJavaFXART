package persistence;

import model.ProdArte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdArteDao implements IProdArteDao {

	private Connection c;

	public ProdArteDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void inserirArte(ProdArte a) throws SQLException {
		String sql = "INSERT INTO prodarte (obra, material, artista, ano, valor) VALUES (?,?,?,?,?)";

		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, a.getNomeObra());
		ps.setString(2, a.getMaterial());
		ps.setString(3, a.getArtista());
		ps.setInt   (4, a.getAno());
		ps.setFloat (5, a.getValor());

		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarArte(ProdArte a) throws SQLException {
		String sql = "UPDATE prodarte SET obra = ?, material = ?, artista = ?, ano = ?, valor = ? WHERE obra = ?";

		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, a.getNomeObra());
		ps.setString(2, a.getMaterial());
		ps.setString(3, a.getArtista());
		ps.setInt(4, a.getAno());
		ps.setFloat(5, a.getValor());
		ps.setInt(6, a.getIdObra());

		ps.execute();
		ps.close();
	}

	@Override
	public void excluirArte(ProdArte a) throws SQLException {		
		String sql = "DELETE FROM prodarte WHERE obra = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getNomeObra());
		ps.execute();
		ps.close();		
	}

	@Override
	public ProdArte buscarArte(ProdArte a) throws SQLException {
		String sql = "SELECT id_obra, obra, material, artista, ano, valor FROM prodarte WHERE obra = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getNomeObra());

		int cont = 0;
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setIdObra(rs.getInt("id_obra"));
			a.setArtista(rs.getString("artista"));
			a.setAno(rs.getInt("ano"));
			a.setMaterial(rs.getString("material"));
			a.setValor(rs.getFloat("valor"));

			cont++;
		}

		if (cont == 0) {
			a = new ProdArte();
		}

		rs.close();
		ps.close();
		return a;
	}


	@Override
	public List<ProdArte> buscarArtes() throws SQLException {
		String sql = "SELECT id_obra, obra, material, artista, ano, valor FROM prodarte";

		PreparedStatement ps = c.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<ProdArte> listaArte = new ArrayList<ProdArte>();

		while (rs.next()) {
			ProdArte a = new ProdArte();
			a.setIdObra(rs.getInt("id_obra"));
			a.setNomeObra(rs.getString("obra"));
			a.setArtista(rs.getString("artista"));
			a.setAno(rs.getInt("ano"));
			a.setMaterial(rs.getString("material"));
			a.setValor(rs.getFloat("valor"));

			listaArte.add(a);
		}

		rs.close();
		ps.close();

		return listaArte;

	}

}