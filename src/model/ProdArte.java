package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "prodarte")

public class ProdArte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obra")
	@NotNull
	private int idObra;
    
	@Column(name = "obra", length = 100)
	@NotNull
	private String nomeObra;
	@Column(name = "material", length = 200)
	@NotNull
	private String material;
	@Column(name = "artista", length = 300)
	@NotNull
	private String artista;
	@Column(name = "ano")
	@NotNull
	private int ano;
	@Column(name = "valor")
	@NotNull
	private float valor;
	private String vazioArte = null;

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
