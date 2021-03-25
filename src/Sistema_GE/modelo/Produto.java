package Sistema_GE.modelo;

import java.io.Serializable;
import java.math.BigInteger;

public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Long codigoDeBarra;
	String nome;
	String marca;
	float valor;
	String cor;
	int quantidade;
	
	public Produto(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade) {
		super();
		this.codigoDeBarra = codigoDeBarra;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.cor = cor;
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDeBarra == null) ? 0 : codigoDeBarra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigoDeBarra == null) {
			if (other.codigoDeBarra != null)
				return false;
		} else if (!codigoDeBarra.equals(other.codigoDeBarra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codigoDeBarra=" + codigoDeBarra + ", nome=" + nome + ", marca=" + marca + ", valor=" + valor
				+ ", cor=" + cor + ", quantidade=" + quantidade + "]";
	}

	public Long  getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(Long codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	
	

}
