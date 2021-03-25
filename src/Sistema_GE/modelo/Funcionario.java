package Sistema_GE.modelo;

import java.io.Serializable;

public class Funcionario implements IFuncionario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long matricula;
	private String senha;
	private String cpf;
	private String primeiroNome;
	private String ultimoNome;
	private float salario;
	private String sexo;
	private String estado;
	private String cidade;
	private String bairro;
	private String numero;
	private String logradouro;
	private String cargo;
	private Long numeroDeVendas;
	
	public Funcionario(Long matricula, String cpf, String primeiroNome, String ultimoNome, String sexo, float salario,
			String logradouro, String numero, String cidade, String bairro, String estado, String senha, String cargo) {
		
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.salario = salario;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.senha = senha;
		this.cargo = cargo;

	}
	public Funcionario(Long matricula, String cpf, String primeiroNome, String ultimoNome, String sexo, float salario,
			String logradouro, String numero, String cidade, String bairro, String estado, Long numeroDeVendas, String cargo) {
		
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.salario = salario;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.numeroDeVendas = numeroDeVendas;
		this.cargo = cargo;

	}
	
	
	

	public Long getNumeroDeVendas() {
		return numeroDeVendas;
	}

	public void setNumeroDeVendas(Long numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}


	@Override
	public float calculaComissao(float valor) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
