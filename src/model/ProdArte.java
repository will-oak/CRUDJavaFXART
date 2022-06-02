package model;

public class ProdArte {
	
	private int idObra;
	private String nomeObra;
	private String material;
	private String artista;
	private int ano;
	private float valor;
	private String vazioArte = null;
	
	
	public String getVazioArte() {
		return vazioArte;
	}
	public void setVazioArte(String vazioArte) {
		this.vazioArte = vazioArte;
	}
	public int getIdObra() {
		return idObra;
	}
	public void setIdObra(int idObra) {
	this.idObra = idObra;
    }
	public String getNomeObra() {
		return nomeObra;
	}
	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ProdArte [idObra=" + idObra + ", nomeObra=" + nomeObra + ", material=" + material + ", artista="
				+ artista + ", ano=" + ano + ", valor=" + valor + ", vazioArte=" + vazioArte + "]";
	}

}
