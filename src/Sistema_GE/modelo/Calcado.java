package Sistema_GE.modelo;

import java.io.Serializable;

public class Calcado extends Produto implements IProduto, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	String modelo;
	int numero;
	
	public Calcado(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);

	}
	
	public Calcado(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade,String modelo,
	int numero ) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);
		this.modelo = modelo;
		this.numero = numero;

	}

	

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumero() {
		return numero;
		
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public float calculaImposto(float valor) {
		float imposto = (float) (valor * 0.04);
		return imposto;
	}
	
	
	
	
	

}
