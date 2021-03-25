package Sistema_GE.modelo;

import java.io.Serial;

public class Venda {
	
	private Long id;
	private Long matriculaFuncionario;
	private Long codigoBarrasProduto;
	private String cpfCliente;
	private String formaDePagamento;
	
	public Venda(Long id, Long matriculaFuncionario, Long codigoBarrasProduto, String cpfCliente, String formaDePagamento) {
		super();
		this.id = id;
		this.matriculaFuncionario = matriculaFuncionario;
		this.codigoBarrasProduto = codigoBarrasProduto;
		this.cpfCliente = cpfCliente;
		this.formaDePagamento = formaDePagamento;
	}
	
	public Venda( Long matriculaFuncionario, Long codigoBarrasProduto, String cpfCliente, String formaDePagamento) {
		super();
		this.matriculaFuncionario = matriculaFuncionario;
		this.codigoBarrasProduto = codigoBarrasProduto;
		this.cpfCliente = cpfCliente;
		this.formaDePagamento = formaDePagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatriculaFuncionario() {
		return matriculaFuncionario;
	}

	public void setMatriculaFuncionario(Long matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}

	public Long getCodigoBarrasProduto() {
		return codigoBarrasProduto;
	}

	public void setCodigoBarrasProduto(Long codigoBarrasProduto) {
		this.codigoBarrasProduto = codigoBarrasProduto;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	
	
	

}
