package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.exception.ProdutoJaCadastradoException;
import Sistema_GE.modelo.Bolsa;
import Sistema_GE.modelo.Cliente;
import Sistema_GE.modelo.Produto;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaCadastroProdutoBolsa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	
	private JLabel lblCor;
	private JLabel lblMarca;
	private JLabel lblIdade;
	private JLabel lblTela;
	private JLabel lblSubtitulo;	
	private JLabel lblMateriaPrima;
	private JLabel lblNome;
	private JLabel lblModelo;
	private JTextField txtCor;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtValor;
	private JLabel lblQuantidade;
	private JLabel lblCodigoDeBarras;
	private JTextField txtQuantidade;
	private JTextField txtMateriaPrima;
	private JTextField txtModelo;
	private JTextField txtCodigoDeBarra;
	
	private JButton btnSalvar;
	private JButton btnVoltar;
	
	private Long codigoDeBarra;
	private String nome;
	private String marca;
	private float valor;
	private String cor;
	private int quantidade;
	private String modelo;
	private String materiaPrima;
	private Produto bolsa;
	
	private JPanel telas;
	private CardLayout controle;
	
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));	
	
	public TelaCadastroProdutoBolsa(JPanel telas){
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setBounds(0,0,1366,730);
	
		this.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtNome.setBounds(372, 288, 225, 28);
		this.add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMarca.setBounds(815, 288, 225, 28);
		this.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtValor.setBounds(815, 354, 225, 28);
		this.add(txtValor);
		txtValor.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCor.setBounds(372, 421, 225, 28);
		this.add(txtCor);
		txtCor.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtModelo.setBounds(372, 491, 225, 28);
		this.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCodigoDeBarra = new JTextField();
		txtCodigoDeBarra.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCodigoDeBarra.setBounds(372, 354,225, 28);
		this.add(txtCodigoDeBarra);
		txtCodigoDeBarra.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(218, 165, 32));
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNome.setBounds(221, 288,157, 40);
		this.add(lblNome);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(218, 165, 32));
		lblMarca.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblMarca.setBounds(652, 282, 157, 40);
		this.add(lblMarca);
		
		lblIdade = new JLabel("Valor:");
		lblIdade.setForeground(new Color(218, 165, 32));
		lblIdade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblIdade.setBounds(652, 348, 157, 40);
		this.add(lblIdade);
		
		lblCodigoDeBarras = new JLabel("C\u00F3digo de barras:");
		lblCodigoDeBarras.setForeground(new Color(218, 165, 32));
		lblCodigoDeBarras.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCodigoDeBarras.setBounds(221, 354, 157, 40);
		this.add(lblCodigoDeBarras);
		
		lblCor = new JLabel("Cor:");
		lblCor.setForeground(new Color(218, 165, 32));
		lblCor.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCor.setBounds(221, 421, 157, 40);
		this.add(lblCor);
		
		lblQuantidade = new JLabel("Quantidade Inicial:");
		lblQuantidade.setForeground(new Color(218, 165, 32));
		lblQuantidade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblQuantidade.setBounds(652, 415, 157, 40);
		this.add(lblQuantidade);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(218, 165, 32));
		lblModelo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblModelo.setBounds(221, 491, 157, 40);
		this.add(lblModelo);
		
		JLabel lblNewLabel = new JLabel("GE System");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(184, 134, 11));
		lblNewLabel.setBounds(324, 46, 716, 113);
		this.add(lblNewLabel);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtQuantidade.setBounds(815, 421,225, 28);
		this.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		lblMateriaPrima = new JLabel("Materia Prima:");
		lblMateriaPrima.setForeground(new Color(218, 165, 32));
		lblMateriaPrima.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblMateriaPrima.setBounds(221, 562,  157, 40);
		this.add(lblMateriaPrima);
		
		txtMateriaPrima = new JTextField();
		txtMateriaPrima.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMateriaPrima.setBounds(372, 562, 225, 28);
		this.add(txtMateriaPrima);
		txtMateriaPrima.setColumns(10);
		
		btnSalvar = new JButton(imagSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				codigoDeBarra = Long.parseLong(txtCodigoDeBarra.getText());
				nome = txtNome.getText();
				marca = txtMarca.getText();
				valor = Float.parseFloat(txtValor.getText());
				cor = txtCor.getText();
				quantidade = Integer.parseInt(txtQuantidade.getText());
				modelo = txtModelo.getText();
				materiaPrima = txtMateriaPrima.getText();
				
				bolsa = new Bolsa(codigoDeBarra, nome, marca, valor, cor, quantidade, modelo, materiaPrima);
				setCampos();
				
				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarProduto(bolsa);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				} catch (ProdutoJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}	
		});
		
		btnSalvar.setBounds(774, 550, 200, 100);
		this.add(btnSalvar);
		
		btnVoltar= new JButton(imagVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos();
				controle.show(telas, "Tela Cadastro Produto");
			}
		});
		btnVoltar.setBounds(1030, 550, 200, 100);
		this.add(btnVoltar);
		
		lblSubtitulo = new JLabel("Cadastro de Bolsa");
		lblSubtitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(184, 134, 11));
		lblSubtitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblSubtitulo.setBounds(176, 141, 798, 113);
		add(lblSubtitulo);
		
		lblTela = new JLabel(imagTela);
		lblTela.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);		

	}
	public void setCampos() {
		
		this.txtCodigoDeBarra.setText("");
		this.txtCor.setText("");
		this.txtMarca.setText("");
		this.txtMateriaPrima.setText("");
		this.txtModelo.setText("");
		this.txtNome.setText("");
		this.txtQuantidade.setText("");
		this.txtValor.setText("");
	}
	
}
