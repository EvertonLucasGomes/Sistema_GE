package Sistema_GE.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModJanela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModJanela() {
		
		this.setTitle("SistemaGE");
		this.setDefaultCloseOperation(3);
		this.setResizable(false);	
		this.setBounds(0,0,1366,730);
		
		CardLayout controle = new CardLayout();
		JPanel telas = new JPanel(controle);
		
		TelaGerente telaGerente = new TelaGerente(telas);
		TelaVendedor telaVendedor = new TelaVendedor(telas);
		TelaLogin telaLogin = new TelaLogin(telas);
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(telas);
		TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor(telas);
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(telas);
		TelaCadastroProdutoRoupa telaCadastroProdutoRoupas = new TelaCadastroProdutoRoupa(telas);
		TelaCadastroProdutoBolsa telaCacastroProdutoBolsa = new TelaCadastroProdutoBolsa(telas);
		TelaCadastroProdutoCalcado telaCadastroProdutoCalcado = new TelaCadastroProdutoCalcado(telas);
		TelaCadastroVendedor telaCadastroVendedor = new TelaCadastroVendedor(telas);
		TelaConsultarFornecedor telaConsultarFornecedor = new TelaConsultarFornecedor(telas);
		TelaConsultarProduto telaConsultarProduto = new TelaConsultarProduto(telas);
		TelaConsultarCliente telaConsultarCliente = new TelaConsultarCliente(telas);
		TelaRelatorio telaRelatorio = new TelaRelatorio(telas);
		TelaVenda telaVenda = new TelaVenda(telas);
		TelaConsultarFuncionario telaConsultarFuncionario = new TelaConsultarFuncionario(telas);
		
		telas.add(telaLogin, "Tela Login");
		telas.add(telaGerente, "Tela Gerente");
		telas.add(telaVendedor, "Tela Vendedor");
		telas.add(telaCadastroProduto, "Tela Cadastro Produto");
		telas.add(telaCacastroProdutoBolsa, "Tela Cadastro Bolsa");
		telas.add(telaCadastroProdutoCalcado, "Tela Cadastro Calcado");
		telas.add(telaCadastroProdutoRoupas, "Tela Cadastro Roupa");
		telas.add(telaCadastroCliente, "Tela Cadastro Cliente");
		telas.add(telaCadastroFornecedor, "Tela Cadastro Fornecedor");
		telas.add(telaCadastroVendedor, "Tela Cadastro Vendedor");
		telas.add(telaConsultarFornecedor, "Tela Consultar Fornecedor");
		telas.add(telaConsultarProduto, "Tela Consultar Produto");
		telas.add(telaConsultarCliente, "Tela Consultar CLiente");
		telas.add(telaRelatorio, "Tela Relatorio");
		telas.add(telaVenda, "Tela Venda");
		telas.add(telaConsultarFuncionario, "Tela Consultar Func");
		
		this.add(telas);

		this.setVisible(true);
		
	}

}
