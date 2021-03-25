package Sistema_GE.modelo;

import java.util.Date;

public class Cliente {
	
	String cpf;
	String primeiroNome;
	String ultimoNome;
	String sexo;
	int idade;
	String telefone;
	String email;
	
	public Cliente(String cpf, String primeiroNome, String ultimoNome, String sexo, int idade, String telefone,
			String email) {
		super();
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.sexo = sexo;
		this.idade = idade;
		this.telefone = telefone;
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", sexo="
				+ sexo + ", idade=" + idade + ", telefone=" + telefone + ", email=" + email + "]";
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}
