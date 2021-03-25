package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;

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

public class TelaVendedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagIconNewCliente = new ImageIcon(getClass().getResource("/imagens/newCliente.png"));
	ImageIcon imagIconNewProd = new ImageIcon(getClass().getResource("/imagens/newProd.png"));
	ImageIcon imagIconConsultaClientes = new ImageIcon(getClass().getResource("/imagens/consultarCliente.png"));
	ImageIcon imagIconNovaVenda = new ImageIcon(getClass().getResource("/imagens/novaVenda.png"));
	ImageIcon imagIconSair = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	ImageIcon imagIconProdutos = new ImageIcon(getClass().getResource("/imagens/produtos.png")); 
	
	
	private JPanel telas;
	private CardLayout controle;
	private JLabel lblTitulo;
	private JButton btnCadastrarCliente;
	
	public TelaVendedor(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		
		
		btnCadastrarCliente = new JButton(imagIconNewCliente);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Cliente");
			}
		});
		btnCadastrarCliente.setBounds(348, 170, 200, 100);
		this.add(btnCadastrarCliente);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar Produto");
				
			}
		});
		btnProdutos.setIcon(imagIconProdutos);
		btnProdutos.setBounds(120, 170, 200, 100);
		this.add(btnProdutos);
		
		JButton btnSair = new JButton(imagIconSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Login");
				Programa.setFuncionarioLogado(null);
			}
		});
		btnSair.setBounds(1106, 170, 200, 100);
		this.add(btnSair);
		
		JButton btnNovaVenda = new JButton(imagIconNovaVenda);
		btnNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Venda");
			}
		});
		btnNovaVenda.setBounds(627, 170, 200, 100);
		this.add(btnNovaVenda);
		
		JButton btnConsultarCliente = new JButton(imagIconConsultaClientes);
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Consultar CLiente");
			}
		});
		btnConsultarCliente.setBounds(866, 170, 200, 100);
		add(btnConsultarCliente);
		
		JLabel lblTela = new JLabel(imagTela);
		lblTela.setBounds(0, 0, 1366, 763);
		this.add(lblTela);
		
	}



}