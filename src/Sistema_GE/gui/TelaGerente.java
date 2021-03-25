package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Sistema_GE.modelo.Programa;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class TelaGerente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagIconSair = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	ImageIcon imagIconFunc = new ImageIcon(getClass().getResource("/imagens/newFunc.png"));
	ImageIcon imagIconNewProd = new ImageIcon(getClass().getResource("/imagens/newProd.png"));
	ImageIcon imagIconProdutos = new ImageIcon(getClass().getResource("/imagens/produtos.png"));
	ImageIcon imagIconRelatorio = new ImageIcon(getClass().getResource("/imagens/relatorio.png"));
	ImageIcon imagIconRemoveVenda = new ImageIcon(getClass().getResource("/imagens/remover.png"));
	ImageIcon imagIconNewCliente = new ImageIcon(getClass().getResource("/imagens/newCliente.png"));
	ImageIcon imagIconNewFornecedor = new ImageIcon(getClass().getResource("/imagens/newFornecedor.png"));
	ImageIcon imagIconConsultarForncedor= new ImageIcon(getClass().getResource("/imagens/consultarFornecedor.png"));
	ImageIcon imagIconNovaVenda = new ImageIcon(getClass().getResource("/imagens/novaVenda.png"));
	ImageIcon imagIconConsultaClientes = new ImageIcon(getClass().getResource("/imagens/consultarCliente.png"));
	ImageIcon imagIconConsultaFunc = new ImageIcon(getClass().getResource("/imagens/consultarFunc.png")); 
	
	private JPanel telas;
	private CardLayout controle;
	
	private JButton btnNewFunc;
	private JButton btnNewProd;
	private JButton btnRelatorio;
	private JButton btnCadastrarCliente;
	private JButton btnNewFornecedor;
	private JButton btnConsultarFornecedor;
	private JButton btnProdutos;
	private JButton btnSair;
	private JButton btnNovaVenda;
	private JButton btnConsultarCliente;
	private JButton btnConsultarFunc;
	
	private JLabel lblNewLabel;
	private JLabel lblTela;
	
	public TelaGerente(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		btnNewFunc = new JButton(imagIconFunc);
		btnNewFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Vendedor");
			}
		});
		btnNewFunc.setBounds(320, 160, 200, 100);
		this.add(btnNewFunc);
		
		btnNewProd = new JButton(imagIconNewProd);
		btnNewProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Produto");
			}
		});
		btnNewProd.setBounds(72, 160, 200, 100);
		this.add(btnNewProd);
		
		btnRelatorio = new JButton(imagIconRelatorio);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Relatorio");
			}
		});
		btnRelatorio.setBounds(828, 160, 200, 100);
		this.add(btnRelatorio);
		
		btnCadastrarCliente = new JButton(imagIconNewCliente);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Cliente");
			}
		});
		btnCadastrarCliente.setBounds(72, 420, 200, 100);
		this.add(btnCadastrarCliente);
		
		btnNewFornecedor = new JButton(imagIconNewFornecedor);
		btnNewFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Fornecedor");
			}
		});
		btnNewFornecedor.setBounds(1094, 160, 200, 100);
		this.add(btnNewFornecedor);
		
		btnConsultarFornecedor = new JButton(imagIconConsultarForncedor);
		btnConsultarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar Fornecedor");
			}
		});
		btnConsultarFornecedor.setBounds(1094, 291, 200, 100);
		this.add(btnConsultarFornecedor);
		
		btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar Produto");
				
			}
		});
		btnProdutos.setIcon(imagIconProdutos);
		btnProdutos.setBounds(72, 291, 200, 100);
		this.add(btnProdutos);
		
		btnSair = new JButton(imagIconSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Login");
				Programa.setFuncionarioLogado(null);
			}
		});
		btnSair.setBounds(1094, 558, 200, 100);
		this.add(btnSair);
		
		btnNovaVenda = new JButton(imagIconNovaVenda);
		btnNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Venda");
			}
		});
		btnNovaVenda.setBounds(590, 160, 200, 100);
		this.add(btnNovaVenda);
		
		btnConsultarCliente = new JButton(imagIconConsultaClientes);
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar CLiente");
			}
		});
		btnConsultarCliente.setBounds(72, 558, 200, 100);
		add(btnConsultarCliente);
		
		lblNewLabel = new JLabel("GE System");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(160, 122, 31));
		lblNewLabel.setBounds(324, 46, 716, 113);
		this.add(lblNewLabel);
		
		btnConsultarFunc = new JButton(imagIconConsultaFunc);
		btnConsultarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar Func");
			}
		});
		btnConsultarFunc.setBounds(1094, 420, 200, 100);
		add(btnConsultarFunc);
		
		
		lblTela = new JLabel(imagTela);
		lblTela.setBounds(0, 0, 1368, 763);
		this.add(lblTela);
		
		
		
		
		this.setVisible(true);
		
	}
}
