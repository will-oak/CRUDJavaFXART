package control;

import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ProdArte;
import persistence.ProdArteDao;

public class ProdArteControl implements IProdArteControl {

	private TextField tfCodigoObra;
	private TextField tfNomeObra;
	private TextField tfNomeArtista;
	private TextField tfMaterial;
	private TextField tfValor;
	private TextField tfAno;
	private TextArea taListaArtes;
	
	public ProdArteControl(TextField tfCodigoObra, TextField tfNomeObra,
			TextField tfNomeArtista, TextField tfMaterial,TextField tfValor,TextField tfAno,  TextArea taListaArtes) {
		this.tfCodigoObra = tfCodigoObra;
		this.tfNomeObra = tfNomeObra;
		this.tfNomeArtista = tfNomeArtista;
		this.tfMaterial = tfMaterial;
		this.tfValor = tfValor;
		this.tfAno = tfAno;
		this.taListaArtes = taListaArtes;
	}

	@Override
	public void inserirArte(ProdArte a) throws ClassNotFoundException, SQLException {
		ProdArteDao aDao = new ProdArteDao();
		aDao.inserirArte(a);
		limparCamposArte();
		buscarArtes();
	}

	@Override
	public void atualizarArte(ProdArte a) throws ClassNotFoundException, SQLException {
		ProdArteDao aDao = new ProdArteDao();
		aDao.atualizarArte(a);
		limparCamposArte();
		buscarArtes();
	}

	@Override
	public void excluirArte(ProdArte a) throws ClassNotFoundException, SQLException {
		ProdArteDao aDao = new ProdArteDao();
		aDao.excluirArte(a);
		limparCamposArte();
		buscarArtes();
	}

	@Override
	public void buscarArte(ProdArte a) throws ClassNotFoundException, SQLException {
		limparCamposArte();
		ProdArteDao aDao = new ProdArteDao();
		a = aDao.buscarArte(a);
		tfCodigoObra.setText(String.valueOf(a.getIdObra()));
		tfNomeObra.setText(a.getNomeObra());
        tfNomeArtista.setText(a.getArtista());
        tfMaterial.setText(a.getMaterial());
        tfValor.setText(String.valueOf(a.getValor()));
        tfAno.setText(String.valueOf(a.getAno()));
	
	}
	
	

	@Override
	public void buscarArtes() throws ClassNotFoundException, SQLException {
		limparCamposArte();
		
		ProdArteDao aDao = new ProdArteDao();
		List<ProdArte> listaArte = aDao.buscarArtes();
		
		taListaArtes.setText("");
		
		StringBuffer sb = new StringBuffer("Código da Obra\t\t\t\tNome da Obra\t\t\t\t\tNome do Artista\t\t\t\t\tMaterial\t\t\t\t\tValor\t\t\t\t\tAno\n");
		for (ProdArte a: listaArte) {
			sb.append(a.getIdObra()+"\t\t\t\t"+a.getNomeObra()+"\t\t\t\t"+a.getArtista()+"\t\t\t\t"+a.getMaterial()+"\t\t\t\t"+a.getValor()+"\t\t\t\t"+a.getAno()+"\n");
		}
		
		taListaArtes.setText(sb.toString());
	}
	
	private void limparCamposArte() {
		tfCodigoObra.setText("");
		tfNomeObra.setText("");
		tfNomeArtista.setText("");
		tfMaterial.setText("");
		tfValor.setText("");
		tfAno.setText("");
	}

}