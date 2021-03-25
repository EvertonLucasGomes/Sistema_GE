package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Sistema_GE.enumerate.Sexo;
import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.modelo.Cliente;
import Sistema_GE.modelo.Programa;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JFormattedTextField;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	
	private JTextField txtIdade;
	private JTextField txtEmail;
	private JTextField txtUltimoNome;
	private JTextField txtPrimeiroNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefone;
	
	private JLabel lblCpf;
	private JLabel lblSexo;
	private JLabel lblEmail;
	private JLabel lblIdade;
	private JLabel lblTelefone;
	private JLabel lblltimoNome;
	
	private JButton btnSalvar;
	
	private String primeiroNome;
	private String ultimoNome;
	private String cpf;
	private int idade;
	private String email;
	private String telefone;
	private String sexo;
	private Cliente cliente;

	
	private JPanel telas;
	private CardLayout controle;
	
	private JButton btnVoltar;
	private JLabel lblSubtitulo;
	private JLabel lblTela;
	private JLabel lblTitulo;
	private JLabel lblPrimeiroNome;
	
	public TelaCadastroCliente(JPanel telas){
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
				
		txtPrimeiroNome = new JTextField();
		txtPrimeiroNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtPrimeiroNome.setBounds(291, 290, 225, 28);
		this.add(txtPrimeiroNome);
		txtPrimeiroNome.setColumns(10);
		
		txtUltimoNome = new JTextField();
		txtUltimoNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtUltimoNome.setBounds(717, 290, 225, 28);
		this.add(txtUltimoNome);
		txtUltimoNome.setColumns(10);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		cmbSexo.setModel(new DefaultComboBoxModel<>(Sexo.values()));
		cmbSexo.setBounds(717, 356, 225, 28);
		this.add(cmbSexo);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtIdade.setBounds(291, 482, 225, 28);
		this.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtEmail.setBounds(291, 418, 225, 28);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtTelefone.setBounds(717, 418, 225, 28);
		this.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("(##)#-####-####");
			mf.install(txtTelefone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtCpf = new JFormattedTextField();
		txtCpf.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCpf.setBounds(291, 356, 225, 28);
		this.add(txtCpf);
		txtCpf.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("###.###.###-##");
			mf.install(txtCpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblPrimeiroNome = new JLabel("Primeiro Nome:");
		lblPrimeiroNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPrimeiroNome.setForeground(new Color(218, 165, 32));
		lblPrimeiroNome.setBounds(158, 283, 157, 40);
		this.add(lblPrimeiroNome);
		
		lblltimoNome = new JLabel("\u00DAltimo Nome:");
		lblltimoNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblltimoNome.setForeground(new Color(218, 165, 32));
		lblltimoNome.setBounds(594, 283, 157, 40);
		this.add(lblltimoNome);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblIdade.setForeground(new Color(218, 165, 32));
		lblIdade.setBounds(158, 475, 157, 40);
		this.add(lblIdade);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCpf.setForeground(new Color(218, 165, 32));
		lblCpf.setBounds(158, 352, 157, 40);
		this.add(lblCpf);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblEmail.setForeground(new Color(218, 165, 32));
		lblEmail.setBounds(158, 413, 157, 40);
		this.add(lblEmail);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblSexo.setForeground(new Color(218, 165, 32));
		lblSexo.setBounds(594, 352, 157, 40);
		this.add(lblSexo);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTelefone.setForeground(new Color(218, 165, 32));
		lblTelefone.setBounds(594, 414, 157, 40);
		this.add(lblTelefone);
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		btnSalvar = new JButton(imagSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				primeiroNome = Character.toUpperCase(txtPrimeiroNome.getText().charAt(0)) + txtPrimeiroNome.getText().substring(1);
				ultimoNome = Character.toUpperCase(txtUltimoNome.getText().charAt(0)) + txtUltimoNome.getText().substring(1);
				cpf = txtCpf.getText();
				idade = Integer.parseInt(txtIdade.getText());
				email = txtEmail.getText();
				telefone = txtTelefone.getText();
				sexo = cmbSexo.getSelectedItem().toString();
				
				cliente = new Cliente(cpf, primeiroNome, ultimoNome, sexo,idade,telefone,email);
				setCampos();
				
				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
				} catch (ClienteJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}			
			
			}
		});
		
		btnSalvar.setBounds(855, 553, 200, 100);
		this.add(btnSalvar);
		
		btnVoltar= new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos();
				String valida = "gerente";
				if(Programa.getFuncionarioLogado().getCargo().equals(valida)) {
					controle.show(telas, "Tela Gerente");
				}else
					controle.show(telas, "Tela Vendedor");
			}
		});
		btnVoltar.setIcon(imagVoltar);
		btnVoltar.setBounds(1104, 553, 200, 100);
		this.add(btnVoltar);
		
		lblSubtitulo = new JLabel("Cadastro de Cliente");
		lblSubtitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(160, 122, 31));
		lblSubtitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblSubtitulo.setBounds(35, 142, 798, 113);
		add(lblSubtitulo);
		
		lblTela = new JLabel("");
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1368, 768);
		this.add(lblTela);
		
		setVisible(true);

		
	}
	
	public void setCampos() {
		this.txtCpf.setText("");
		this.txtEmail.setText("");
		this.txtIdade.setText("");
		this.txtPrimeiroNome.setText("");
		this.txtUltimoNome.setText("");
		this.txtTelefone.setText("");
		
		
	}
}
