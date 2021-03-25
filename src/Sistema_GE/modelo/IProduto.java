package Sistema_GE.modelo;

public interface IProduto {
	
	public Long getCodigoDeBarra();

	public void setCodigoDeBarra(Long codigoDeBarra);

	public String getNome();

	public void setNome(String nome);

	public String getMarca();

	public void setMarca(String marca);
	
	public float getValor();

	public void setValor(float valor);
	
	public String getCor();

	public void setCor(String cor);

	public int getQuantidade() ;

	public void setQuantidade(int quantidade) ;
	
	public float calculaImposto(float valor);
	
	

}
