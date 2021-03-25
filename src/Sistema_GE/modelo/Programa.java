package Sistema_GE.modelo;

import Sistema_GE.gui.ModJanela;
import Sistema_GE.gui.TelaCadastroCliente;
import Sistema_GE.gui.TelaCadastroFornecedor;
import Sistema_GE.gui.TelaCadastroProduto;
import Sistema_GE.gui.TelaCadastroProdutoBolsa;
import Sistema_GE.gui.TelaCadastroProdutoCalcado;
import Sistema_GE.gui.TelaCadastroProdutoRoupa;
import Sistema_GE.gui.TelaCadastroVendedor;
import Sistema_GE.gui.TelaGerente;
import Sistema_GE.gui.TelaLogin;

public class Programa {
	
	private static Funcionario funcionarioLogado;
	
	public static void main(String[]args) {
		
		ModJanela janela = new ModJanela();
		
		//new TelaLogin();
		//new TelaGerente();
		//new TelaCadastroCliente();
		//new TelaCadastroFornecedor();
		//new TelaCadastroProdutoBolsa();
		//new TelaCadastroProduto();
		//new TelaCadastroProdutoCalcado();
		//new TelaCadastroProdutoRoupa();
		//new TelaCadastroVendedor();


		
	}

	public static Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public static void setFuncionarioLogado(Funcionario funcionarioLogado) {
		Programa.funcionarioLogado = funcionarioLogado;
	}


		
	
}
	
	

	


