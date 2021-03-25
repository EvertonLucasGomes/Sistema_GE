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
import Sistema_GE.exception.FornecedorJaCadastradoException;
import Sistema_GE.modelo.Fornecedor;
import Sistema_GE.modelo.Roupa;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JTabbedPane;

public class TelaCadastroFornecedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	
	private JTextField txtEmail;
	private JTextField txtRazaoSocial;
	private JFormattedTextField txtCnpj;
	private JTextField txtPrincipalProduto;
	private JFormattedTextField txtTelefone;
	
	private JLabel lblltimoNome;
	private JLabel lblCpf;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	
	private String cnpj;
	private String razaoSocial;
	private String telefone;
	private String email;
	private String principalProduto;
	
	private Fornecedor fornecedor;
	
	private JButton btnSalvar;
	
	private JPanel telas;
	private CardLayout controle;

	private JLabel lblPrimeiroNome;

	private JLabel lblTitulo;

	private JLabel lblSubtitulo;

	private JLabel lblTela;
	
	public TelaCadastroFornecedor(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
	
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		this.txtRazaoSocial = new JTextField();
		txtRazaoSocial.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtRazaoSocial.setBounds(370, 286, 225, 28);
		this.add(txtRazaoSocial);
		this.txtRazaoSocial.setColumns(10);
		
		this.txtPrincipalProduto = new JTextField();
		txtPrincipalProduto.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtPrincipalProduto.setBounds(370, 348, 225, 28);
		this.add(txtPrincipalProduto);
		this.txtPrincipalProduto.setColumns(10);
		
		this.txtEmail = new JTextField();
		txtEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtEmail.setBounds(370, 466, 225, 28);
		this.add(txtEmail);
		this.txtEmail.setColumns(10);
		
		this.txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtTelefone.setBounds(370, 529, 225, 28);
		this.add(txtTelefone);
		this.txtTelefone.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("(##)#-####-####");
			mf.install(txtTelefone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.txtCnpj = new JFormattedTextField();
		txtCnpj.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtCnpj.setBounds(370, 405, 225, 28);
		this.add(txtCnpj);
		this.txtCnpj.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
			mf.install(txtCnpj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		lblPrimeiroNome = new JLabel("Raz\u00E3o Social:");
		lblPrimeiroNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPrimeiroNome.setForeground(new Color(218, 165, 32));
		lblPrimeiroNome.setBounds(210, 286, 157, 40);
		this.add(lblPrimeiroNome);
		
		this.lblltimoNome = new JLabel("Principal Produto:");
		lblltimoNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblltimoNome.setForeground(new Color(218, 165, 32));
		this.lblltimoNome.setBounds(210, 348, 157, 40);
		
		this.add(lblltimoNome);
		
		this.lblCpf = new JLabel("CNPJ:");
		lblCpf.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCpf.setForeground(new Color(218, 165, 32));
		this.lblCpf.setBounds(210, 405, 157, 40);
		this.add(lblCpf);
		
		this.lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblEmail.setForeground(new Color(218, 165, 32));
		this.lblEmail.setBounds(210, 466, 157, 40);
		this.add(lblEmail);
		
		this.lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTelefone.setForeground(new Color(218, 165, 32));
		this.lblTelefone.setBounds(210, 533, 157, 40);
		this.add(lblTelefone);
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		this.btnSalvar = new JButton(imagSalvar);
		this.btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cnpj = txtCnpj.getText();
				razaoSocial = Character.toUpperCase(txtRazaoSocial.getText().charAt(0)) + txtRazaoSocial.getText().substring(1);
				telefone = txtTelefone.getText();
				email = txtEmail.getText();
				principalProduto = Character.toUpperCase(txtPrincipalProduto.getText().charAt(0)) + txtPrincipalProduto.getText().substring(1);
				
				fornecedor = new Fornecedor(cnpj, razaoSocial, telefone, email, principalProduto);
				setCampos();
				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarForncedor(fornecedor);
					JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com Sucesso");
					
				} catch (FornecedorJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			
			}
				
		});
		this.btnSalvar.setBounds(805, 555, 200, 100);
		this.add(btnSalvar);
		
		JButton btnVoltar= new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos();
				controle.show(telas, "Tela Gerente");
			}
		});
		btnVoltar.setIcon(imagVoltar);
		btnVoltar.setBounds(1077, 555, 200, 100);
		this.add(btnVoltar);
		
		lblSubtitulo = new JLabel("Cadastro de fornecedor");
		lblSubtitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(160, 122, 31));
		lblSubtitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblSubtitulo.setBounds(35, 142, 798, 113);
		add(lblSubtitulo);
		
		lblTela = new JLabel("");
		lblTela.setIcon(imagTela);
		lblTela.setBounds(10, 0, 1366, 768);
		this.add(lblTela);

	}
	
	public void setCampos(){
		this.txtCnpj.setText("");
		this.txtEmail.setText("");
		this.txtPrincipalProduto.setText("");
		this.txtRazaoSocial.setText("");
		this.txtTelefone.setText("");
	}
}
