package Sistema_GE.modelo;

import java.io.Serializable;

public class Roupa extends Produto implements IProduto, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String tipoTecido;
	String tipoRoupa;
	String tamanho;
	
	public Roupa(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);
		
	}
	
	public Roupa(Long codigoDeBarra, String nome, String marca, float valor, String cor, int quantidade,String tipoTecido,
	String tipoRoupa, String tamanho) {
		super(codigoDeBarra, nome, marca, valor, cor, quantidade);
		this.tipoTecido = tipoTecido;
		this.tipoRoupa = tipoRoupa;
		this.tamanho = tamanho;
		
	}
	

	public String getTipoTecido() {
		return tipoTecido;
	}

	public void setTipoTecido(String tipoTecido) {
		this.tipoTecido = tipoTecido;
	}

	public String getTipoRoupa() {
		return tipoRoupa;
	}

	public void setTipoRoupa(String tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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
