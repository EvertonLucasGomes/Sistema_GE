package Sistema_GE.modelo;

public class Fornecedor {
	
	String cnpj;
	String razaoSocial;
	String telefone;
	String email;
	String principalProduto;
	
	public Fornecedor(String cnpj, String razaoSocial, String telefone, String email, String principalProduto) {
		
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.email = email;
		this.principalProduto = principalProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	public String getPrincipalProduto() {
		return principalProduto;
	}

	public void setPrincipalProduto(String principalProduto) {
		this.principalProduto = principalProduto;
	}

	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", telefone=" + telefone + ", email="
				+ email + ", principalProduto=" + principalProduto + "]";
	}
	
	
	
	
	
	

}
