package Sistema_GE.modelo;

import java.io.Serializable;

public class Bolsa extends Produto implements IProduto, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String modelo;
	String materiaPrima;
	
	public Bolsa(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);
		
	}
	
	public Bolsa(Long  codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade, String modelo, String materiaPrima) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);
		this.modelo = modelo;
		this.materiaPrima = materiaPrima;
	}


	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public float calculaImposto(float valor) {
		float imposto = (float) (valor * 0.03);
		return imposto;
	}
	
	
	

}
