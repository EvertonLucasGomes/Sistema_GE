package Sistema_GE.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Sistema_GE.modelo.Fornecedor;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaEditarFornecedor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	ImageIcon imagRemover = new ImageIcon(getClass().getResource("/imagens/removerMenor.png"));
	
	private JTextField txtRazaoSocial;
	private JTextField txtPrincipalProduto; 
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCnpj;
	private JLabel lblltimoNome;
	private JLabel lblCpf;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JButton btnSalvarEdit;	
	private JLabel lblPrimeiroNome;
	
	private String cnpj;
	private String razaoSocial;
	private String telefone;
	private String email;
	private String principalProduto;
	private Fornecedor fornecedor;
	private JLabel lblAlterarFornecedor;
	
	public TelaEditarFornecedor(String cnpjEscolhido) {
		getContentPane().setForeground(new Color(218, 165, 32));
		getContentPane().setFont(new Font("Sylfaen", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(66, 66, 67));
		setResizable(false);
		
		setSize(750,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setTitle("Editar Fornecedor");
		setModal(true);
		
		this.txtRazaoSocial = new JTextField();
		txtRazaoSocial.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtRazaoSocial.setBounds(204, 205,  225, 28);
		getContentPane().add(txtRazaoSocial);
		this.txtRazaoSocial.setColumns(10);
		
		this.txtPrincipalProduto = new JTextField();
		txtPrincipalProduto.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtPrincipalProduto.setBounds(204, 264,  225, 28);
		getContentPane().add(txtPrincipalProduto);
		this.txtPrincipalProduto.setColumns(10);
		
		this.txtEmail = new JTextField();
		txtEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtEmail.setBounds(204, 385, 225, 28);
		getContentPane().add(txtEmail);
		this.txtEmail.setColumns(10);
		
		this.txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		this.txtTelefone.setBounds(479, 266, 225, 28);
		getContentPane().add(txtTelefone);
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
		this.txtCnpj.setBounds(204, 324, 225, 28);
		getContentPane().add(txtCnpj);
		this.txtCnpj.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
			mf.install(txtCnpj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		lblPrimeiroNome = new JLabel("Raz\u00E3o Social:");
		lblPrimeiroNome.setForeground(new Color(218, 165, 32));
		lblPrimeiroNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPrimeiroNome.setBounds(48, 205, 165, 32);
		getContentPane().add(lblPrimeiroNome);
		
		this.lblltimoNome = new JLabel("Principal Produto:");
		lblltimoNome.setForeground(new Color(218, 165, 32));
		lblltimoNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		this.lblltimoNome.setBounds(48, 264, 165, 32);
		getContentPane().add(lblltimoNome);
		
		this.lblCpf = new JLabel("CNPJ:");
		lblCpf.setForeground(new Color(218, 165, 32));
		lblCpf.setFont(new Font("Sylfaen", Font.BOLD, 18));
		this.lblCpf.setBounds(48, 324, 165, 32);
		getContentPane().add(lblCpf);
		
		this.lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(218, 165, 32));
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 18));
		this.lblEmail.setBounds(48, 385, 165, 32);
		getContentPane().add(lblEmail);
		
		this.lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(218, 165, 32));
		lblTelefone.setFont(new Font("Sylfaen", Font.BOLD, 18));
		this.lblTelefone.setBounds(478, 223, 165, 32);
		getContentPane().add(lblTelefone);
		
		JLabel lblNewLabel = new JLabel("GE System");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(160, 122, 31));
		lblNewLabel.setBounds(10, 11, 716, 113);
		getContentPane().add(lblNewLabel);
		
		this.btnSalvarEdit = new JButton(imagSalvar);
		this.btnSalvarEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cnpj = txtCnpj.getText();
				razaoSocial = txtRazaoSocial.getText();
				telefone = txtTelefone.getText();
				email = txtEmail.getText();
				principalProduto = txtPrincipalProduto.getText();
				
				Fornecedor novoFornecedor = new Fornecedor(cnpj, razaoSocial, telefone, email, principalProduto);

				PersistenciaEmBanco.pegarInstancia().UpdateFornecedor(fornecedor.getCnpj(),novoFornecedor);
				
	
				dispose();
				
				//inserirTabela(PersistenciaEmBanco.pegarInstancia().todosFornecedores());
			
			}
				
		});
		this.btnSalvarEdit.setBounds(504, 403, 200, 100);
		getContentPane().add(btnSalvarEdit);
		
		lblAlterarFornecedor = new JLabel("Alterar Fornecedor");
		lblAlterarFornecedor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAlterarFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarFornecedor.setForeground(new Color(160, 122, 31));
		lblAlterarFornecedor.setFont(new Font("Sylfaen", Font.BOLD, 45));
		lblAlterarFornecedor.setBounds(10, 67, 716, 113);
		getContentPane().add(lblAlterarFornecedor);
		
		fornecedor = PersistenciaEmBanco.pegarInstancia().getFornecedor(cnpjEscolhido);
    	setDados(fornecedor);
    	
		setVisible(true);
	}
	
	public void setDados(Fornecedor fornecedorg) {
		
		//SETAR CAMPOS
		this.txtCnpj.setText(fornecedorg.getCnpj());
		this.txtRazaoSocial.setText(fornecedorg.getRazaoSocial());
		this.txtTelefone.setText(fornecedorg.getTelefone());
		this.txtEmail.setText(fornecedorg.getEmail());
		this.txtPrincipalProduto.setText(fornecedorg.getPrincipalProduto());
	}

}
