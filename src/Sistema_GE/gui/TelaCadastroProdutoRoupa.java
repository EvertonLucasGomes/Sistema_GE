package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
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
import Sistema_GE.modelo.Produto;
import Sistema_GE.modelo.Roupa;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaCadastroProdutoRoupa extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	
	private JLabel lblCor;
	private JLabel lblMarca;
	private JLabel lblIdade;
	private JLabel lblModelo;
	private JLabel lblTamanho;
	private JLabel lblQuantidade;
	private JLabel lblCodigoDeBarras;
	private JLabel lblTela;
	private JLabel lblSubtitulo;
	private JLabel lblTipoDeRoupa;
	private JLabel lblTitulo;
	private JLabel lblNome;
	
	private JTextField txtCor;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtValor;
	private JTextField txtQuantidade;
	private JTextField txtTipoDeRoupa;
	private JTextField txtTipoDeTecido;
	private JTextField txtCodigoDeBarra;
	private JTextField txtTamanho;

	private JButton btnSalvar;
	private JButton btnVoltar;
	
	private Long codigoDeBarra;
	private String nome;
	private String marca;
	private float valor;
	private String cor;
	private int quantidade;
	private String tipoTecido;
	private String tipoRoupa;
	private String tamanho;
	
	private Produto roupa;
	
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	
	private JPanel telas;
	private CardLayout controle;
	
	public TelaCadastroProdutoRoupa(JPanel telas){
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtNome.setBounds(373, 282, 225, 28);
		this.add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMarca.setBounds(373, 329, 225, 28);
		this.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtValor.setBounds(373, 477, 225, 28);
		this.add(txtValor);
		txtValor.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCor.setBounds(373, 425, 225, 28);
		this.add(txtCor);
		txtCor.setColumns(10);
		
		txtTipoDeTecido = new JTextField();
		txtTipoDeTecido.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtTipoDeTecido.setBounds(833, 335,225, 28);
		this.add(txtTipoDeTecido);
		txtTipoDeTecido.setColumns(10);
		
		txtCodigoDeBarra = new JTextField();
		txtCodigoDeBarra.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCodigoDeBarra.setBounds(373, 374, 225, 28);
		this.add(txtCodigoDeBarra);
		txtCodigoDeBarra.setColumns(50);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNome.setForeground(new Color(218, 165, 32));
		lblNome.setBounds(227, 282, 157, 40);
		this.add(lblNome);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblMarca.setForeground(new Color(218, 165, 32));
		lblMarca.setBounds(227, 323, 157, 40);
		this.add(lblMarca);
		
		lblIdade = new JLabel("Valor:");
		lblIdade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblIdade.setForeground(new Color(218, 165, 32));
		lblIdade.setBounds(227, 470, 157, 40);
		this.add(lblIdade);
		
		lblCodigoDeBarras = new JLabel("C\u00F3digo de barras:");
		lblCodigoDeBarras.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCodigoDeBarras.setForeground(new Color(218, 165, 32));
		lblCodigoDeBarras.setBounds(227, 374, 157, 40);
		this.add(lblCodigoDeBarras);
		
		lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCor.setForeground(new Color(218, 165, 32));
		lblCor.setBounds(227, 419, 157, 40);
		this.add(lblCor);
		
		lblQuantidade = new JLabel("Quantidade Inicial:");
		lblQuantidade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblQuantidade.setForeground(new Color(218, 165, 32));
		lblQuantidade.setBounds(678, 282, 157, 40);
		this.add(lblQuantidade);
		
		lblModelo = new JLabel("Tipo de Tecido:");
		lblModelo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblModelo.setForeground(new Color(218, 165, 32));
		lblModelo.setBounds(678, 329, 157, 40);
	    this.add(lblModelo);
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtQuantidade.setBounds(833, 288, 225, 28);
		this.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		lblTipoDeRoupa = new JLabel("Tipo de Roupa:");
		lblTipoDeRoupa.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTipoDeRoupa.setForeground(new Color(218, 165, 32));
		lblTipoDeRoupa.setBounds(678, 374,157, 40);
		this.add(lblTipoDeRoupa);
		
		txtTipoDeRoupa = new JTextField();
		txtTipoDeRoupa.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtTipoDeRoupa.setBounds(833, 380, 225, 28);
		this.add(txtTipoDeRoupa);
		txtTipoDeRoupa.setColumns(10);
		
		txtTamanho = new JTextField();
		txtTamanho.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtTamanho.setBounds(833, 425, 225, 28);
		this.add(txtTamanho);
		txtTamanho.setColumns(10);
		
		btnSalvar = new JButton(imagSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				codigoDeBarra = Long.parseLong(txtCodigoDeBarra.getText());
				nome = txtNome.getText();
				marca = txtMarca.getText();
				valor = Float.parseFloat(txtValor.getText());
				cor = txtCor.getText();
				quantidade = Integer.parseInt(txtQuantidade.getText());
				tipoTecido = txtTipoDeTecido.getText();
				tipoRoupa = txtTipoDeRoupa.getText();
				tamanho = txtTamanho.getText();
				
				roupa = new Roupa(codigoDeBarra, nome, marca, valor, cor, quantidade, tipoTecido, tipoRoupa, tamanho);
				setCampos();
				
				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarProduto(roupa);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				} catch (ProdutoJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
			}	
		});
		
		btnSalvar.setBounds(797, 550, 200, 100);
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
		
		lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTamanho.setForeground(new Color(218, 165, 32));
		lblTamanho.setBounds(678, 419, 157, 40);
		this.add(lblTamanho);
		
		lblSubtitulo = new JLabel("Cadastro de Roupa");
		lblSubtitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(184, 134, 11));
		lblSubtitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblSubtitulo.setBounds(173, 142, 798, 113);
		add(lblSubtitulo);
		
		lblTela = new JLabel(imagTela);
		lblTela.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblTela.setBounds(0, 0, 1366, 761);
		this.add(lblTela);

	}
	
	public void setCampos() {
		txtCodigoDeBarra.setText("");
		txtCor.setText("");
		txtMarca.setText("");
		txtNome.setText("");
		txtQuantidade.setText("");
		txtTamanho.setText("");
		txtTipoDeRoupa.setText("");
		txtTipoDeTecido.setText("");
		txtValor.setText("");
		
	}
}
