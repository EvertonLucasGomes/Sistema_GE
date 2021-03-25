package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Sistema_GE.exception.ProdutoJaCadastradoException;
import Sistema_GE.modelo.Bolsa;
import Sistema_GE.modelo.Calcado;
import Sistema_GE.modelo.Produto;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaCadastroProdutoCalcado extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	
	private JLabel lblCor;
	private JLabel lblMarca;
	private JLabel lblIdade;
	private JLabel lblModelo;
	private JLabel lblSubtitulo;
	private JLabel lblTela;
	private JLabel lblQuantidade;
	private JLabel lblCodigoDeBarras;
	
	private JTextField txtCor;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtValor;
	private JTextField txtQuantidade;
	private JTextField txtNumero;
	private JTextField txtModelo;
	private JTextField txtCodigoDeBarra;
	private JLabel lblNome;

	private JButton btnSalvar;
	private JButton btnVoltar;
	
	private Long codigoDeBarra;
	private String nome;
	private String marca;
	private float valor;
	private String cor;
	private int quantidade;
	private int numero;
	private String modelo;
	private Produto calcado;
	
	private JPanel telas;
	private CardLayout controle;
	
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));

	public TelaCadastroProdutoCalcado(JPanel telas){
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtNome.setBounds(382, 318, 225, 28);
		this.add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMarca.setBounds(382, 373, 225, 28);
		this.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtValor.setBounds(726, 318, 225, 28);
		this.add(txtValor);
		txtValor.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCor.setBounds(726, 373,225, 28);
		this.add(txtCor);
		txtCor.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtModelo.setBounds(382, 498, 225, 28);
		this.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCodigoDeBarra = new JTextField();
		txtCodigoDeBarra.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCodigoDeBarra.setBounds(382, 441, 225, 28);
		this.add(txtCodigoDeBarra);
		txtCodigoDeBarra.setColumns(10);
		
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(218, 165, 32));
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNome.setBounds(225, 318, 157, 40);
		this.add(lblNome);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(218, 165, 32));
		lblMarca.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblMarca.setBounds(225, 364, 157, 40);
		this.add(lblMarca);
		
		lblIdade = new JLabel("Valor:");
		lblIdade.setForeground(new Color(218, 165, 32));
		lblIdade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblIdade.setBounds(629, 314, 157, 40);
		this.add(lblIdade);
		
		lblCodigoDeBarras = new JLabel("C\u00F3digo de barras:");
		lblCodigoDeBarras.setForeground(new Color(218, 165, 32));
		lblCodigoDeBarras.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCodigoDeBarras.setBounds(225, 432, 157, 40);
		this.add(lblCodigoDeBarras);
		
		lblCor = new JLabel("Cor:");
		lblCor.setForeground(new Color(218, 165, 32));
		lblCor.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCor.setBounds(629, 369, 157, 40);
		this.add(lblCor);
		
		lblQuantidade = new JLabel("Quantidade Inicial:");
		lblQuantidade.setForeground(new Color(218, 165, 32));
		lblQuantidade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblQuantidade.setBounds(629, 437, 157, 40);
		this.add(lblQuantidade);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(218, 165, 32));
		lblModelo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblModelo.setBounds(225, 489, 157, 40);
		this.add(lblModelo);
		
		JLabel lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtQuantidade.setBounds(796, 441, 225, 28);
		this.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(new Color(218, 165, 32));
		lblNumero.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNumero.setBounds(225, 545, 157, 40);
		this.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtNumero.setBounds(382, 554, 225, 28);
		this.add(txtNumero);
		txtNumero.setColumns(10);
		
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
				numero = Integer.parseInt(txtNumero.getText());
				
				calcado = new Calcado(codigoDeBarra, nome, marca, valor, cor, quantidade, modelo, numero);
				setCampos();

				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarProduto(calcado);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				} catch (ProdutoJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
					
			}	
		});
		btnSalvar.setBounds(798, 550, 200, 100);
		this.add(btnSalvar);
		
		btnVoltar= new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos();
				controle.show(telas, "Tela Cadastro Produto");
			}
		});
		btnVoltar.setIcon(imagVoltar);
		btnVoltar.setBounds(1030, 550, 200, 100);
		this.add(btnVoltar);
		
		lblSubtitulo = new JLabel("Cadastro de Bolsa");
		lblSubtitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(184, 134, 11));
		lblSubtitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblSubtitulo.setBounds(173, 142, 798, 113);
		add(lblSubtitulo);
		
		lblTela = new JLabel("");
		lblTela.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1360, 768);
		this.add(lblTela);

	}
	
	public void setCampos() {
		txtCodigoDeBarra.setText("");
		txtCor.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtNome.setText("");
		txtNumero.setText("");
		txtQuantidade.setText("");
		txtValor.setText("");
		
	}
	
	
	
	
}

