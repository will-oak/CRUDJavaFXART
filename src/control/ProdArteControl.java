package control;

import java.sql.SQLException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Funcionario;
import model.ProdArte;
import persistence.FuncionarioDao;
import persistence.IFuncionarioDao;
import persistence.IProdArteDao;
import persistence.ProdArteDao;

public class ProdArteControl implements IProdArteControl {
	

	private TextField tfCodigoObra;
	private TextField tfNomeObra;
	private TextField tfNomeArtista;
	private TextField tfMaterial;
	private TextField tfValor;
	private TextField tfAno;
	private TextArea taListaArtes;

	private StringProperty idObra = new SimpleStringProperty("");
	private StringProperty nomeObra = new SimpleStringProperty("");
	private StringProperty nomeArtista = new SimpleStringProperty("");
	private StringProperty valor = new SimpleStringProperty("");
	private StringProperty ano = new SimpleStringProperty("");
	private StringProperty material = new SimpleStringProperty("");
	private TableView<ProdArte> tableArte = new TableView<>();
	private ObservableList<ProdArte> arteObsList = FXCollections.observableArrayList();
	
	
	
	

	//public ProdArteControl(TextField tfCodigoObra, TextField tfNomeObra,
	//		TextField tfNomeArtista, TextField tfMaterial,TextField tfValor,TextField tfAno,  TextArea taListaArtes) {
		
	//	this.tfCodigoObra = tfCodigoObra;
	//	this.tfNomeObra = tfNomeObra;
	//	this.tfNomeArtista = tfNomeArtista;
	//	this.tfMaterial = tfMaterial;
	//	this.tfValor = tfValor;
	//	this.tfAno = tfAno;
	//	this.taListaArtes = taListaArtes;


	 //   }
		


	public ProdArteControl() {
        TableColumn<ProdArte, String> col11 = new TableColumn<>("Nome da Obra");
        col11.setCellValueFactory(new PropertyValueFactory<>("nomeObra"));
        
        TableColumn<ProdArte, String> col22 = new TableColumn<>("Material Usado");
        col22.setCellValueFactory(new PropertyValueFactory<>("material"));
        
        TableColumn<ProdArte, String> col33 = new TableColumn<>("Nome do Artista");
        col33.setCellValueFactory(new PropertyValueFactory<>("artista"));
        
        TableColumn<ProdArte, String> col44 = new TableColumn<>("Ano da Obra");
        col44.setCellValueFactory(new PropertyValueFactory<>("ano"));

        TableColumn<ProdArte, String> col55 = new TableColumn<>("Valor da Obra");
        col55.setCellValueFactory(new PropertyValueFactory<>("valor"));
        
        tableArte.getColumns().addAll(col11, col22, col33, col44, col55);

        tableArte.setItems(arteObsList);
	}



	public StringProperty nomeObraProperty() {
	        return nomeObra;
	    }
	  
	  public StringProperty materialProperty() {
	        return material;
	    }
	  
      public StringProperty idObraProperty() {
	        return idObra;
	    }
      
      public StringProperty artistaProperty() {
	        return nomeArtista;
	    }
      
      public StringProperty valorProperty() {
	        return valor;
	    }
      
      public StringProperty anoProperty() {
	        return ano;
	    }

	@Override
	public void inserirArte() throws ClassNotFoundException, SQLException {
		ProdArte  a = new ProdArte();
		ProdArteDao aDao = new ProdArteDao();
		a.setNomeObra(nomeObra.get());
        a.setMaterial(material.get());
		a.setArtista(nomeArtista.get());
        a.setAno(Integer.parseInt(ano.get()));
        a.setValor(Float.parseFloat(valor.get()));
        arteObsList.add(a);
        aDao.inserirArte(a);
        
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
	public void buscarArte() throws ClassNotFoundException, SQLException {
    IProdArteDao arteDao = new ProdArteDao();
    
    for (ProdArte a : arteObsList) {
    if (a != null && a.getNomeObra().contains(nomeObra.get())) {
	    nomeObra.set(a.getNomeObra());
    nomeObra.set(a.getNomeObra());
    material.set(a.getMaterial());
    idObra.set(Integer.toString(a.getIdObra()));
    nomeArtista.set(a.getArtista());
    valor.set(Float.toString(a.getValor()));
    ano.set(Integer.toString(a.getAno()));
    

    
    break;
      }
    }	    	
    	
    	
       List<ProdArte> listaArte = arteDao.buscarArtes();
       arteObsList.clear();
       arteObsList.addAll(listaArte);
 
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

	 public TableView<ProdArte> getTable() {
	        return tableArte;
	    }



	

}