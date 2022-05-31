package Principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Funcionario;
import model.ProdArte;
import persistence.FuncionarioDao;
import persistence.GenericDao;
import persistence.ProdArteDao;

public class TesteDAO   {
	public static void main(String []args ) throws SQLException {
	try (Connection c = new GenericDao().getConnection() ) {
		
     GenericDao genericDao = new GenericDao();	
     FuncionarioDao funcDao = new FuncionarioDao();
     ProdArteDao arte = new ProdArteDao();
     
     Funcionario funcionario = new Funcionario();     
     funcionario.setId(3);
     //funcionario.setCpf(151515);
     //funcionario.setNome("Testeupd");
     
     //funcDao.insereFuncionario(funcionario);
     
     //funcDao.atualizaFuncionario(funcionario);
     
     funcDao.buscaFuncionario(funcionario);
     System.out.println(funcionario);
     
     
   /*  ProdArte arte2 = new ProdArte();
     
     arte2.setNomeObra("Profundo");
     arte2.setAno(1999);
     arte2.setMaterial("Posca");
     arte2.setValor(1200);
     arte2.setArtista("Kon");
     
     arte.inserirArte(arte2); 
     
     
     */
     List <ProdArte> artes = arte.buscarArtes();
     System.out.println(artes);
     
          
   //  List <Funcionario> funcionarios = funcDao.buscaFuncionarios();
   //System.out.println(funcionarios);
  
     
     
	} 
	catch(Exception ex) { 
		ex.printStackTrace();
		
	}
	}
}

