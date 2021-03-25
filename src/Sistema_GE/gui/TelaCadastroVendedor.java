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

import Sistema_GE.enumerate.Cargos;
import Sistema_GE.enumerate.Estados;
import Sistema_GE.enumerate.Sexo;
import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.exception.FuncionarioJaCadastradoException;
import Sistema_GE.modelo.Cliente;
import Sistema_GE.modelo.Funcionario;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaCadastroVendedor extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	
	private JTextField txtSalario;
	private JTextField txtLogradouro;
	private JTextField txtUltimoNome;
	private JTextField txtMatricula;
	private JTextField txtPrimeiroNome;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtSenha;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefone;
	
	private JButton btnVoltar;	
	private JButton btnSalvar;
	
	private JLabel lblCpf;
	private JLabel lblSexo;
	private JLabel lblLagradouro;
	private JLabel lblSalario;
	private JLabel lblTelefone;
	private JLabel lblltimoNome;
	private JLabel lblTitulo;
	private JLabel lblPrimeiroNome;
	private JLabel lblMatricula;
	private JLabel lblNewLabel;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblEstado;
	private JLabel lblSenha;
	private JLabel lblCargo;
	private JLabel lblTela;

	
	private Long matricula;
	private String cpf;
	private String primeiroNome;
	private String ultimoNome;
	private String sexo;
	private float salario;
	private String logradouro;
	private String numero;
	private String cidade;
	private String bairro;
	private String estado;
	private String senha;
	private String cargo;

	private Funcionario vendedor;
	
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	
	private JPanel telas;
	private CardLayout controle;

	public TelaCadastroVendedor(JPanel telas){
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMatricula.setBounds(236, 245, 225, 28);
		this.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtUltimoNome = new JTextField();
		txtUltimoNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtUltimoNome.setBounds(236, 361, 225, 28);
		this.add(txtUltimoNome);
		txtUltimoNome.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtSalario.setBounds(236, 484, 225, 28);
		this.add(txtSalario);
		txtSalario.setColumns(10);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtLogradouro.setBounds(633, 245, 225, 28);
		this.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtTelefone.setBounds(633, 484, 225, 28);
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
		txtCpf.setBounds(236, 423, 225, 28);
		this.add(txtCpf);
		txtCpf.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("###.###.###-##");
			mf.install(txtCpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtPrimeiroNome = new JTextField();
		txtPrimeiroNome.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtPrimeiroNome.setColumns(10);
		txtPrimeiroNome.setBounds(236, 300, 225, 28);
		this.add(txtPrimeiroNome);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		cmbSexo.setModel(new DefaultComboBoxModel<>(Sexo.values()));
		cmbSexo.setBounds(983, 245, 225, 28);
		this.add(cmbSexo);
		
		lblPrimeiroNome = new JLabel("Primeiro nome:");
		lblPrimeiroNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPrimeiroNome.setForeground(new Color(218, 165, 32));
		lblPrimeiroNome.setBounds(104, 296, 157, 40);
		this.add(lblPrimeiroNome);
		
		
		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblMatricula.setForeground(new Color(218, 165, 32));
		lblMatricula.setBounds(104, 245, 157, 40);
		this.add(lblMatricula);
		
		lblltimoNome = new JLabel("\u00DAltimo Nome:");
		lblltimoNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblltimoNome.setForeground(new Color(218, 165, 32));
		lblltimoNome.setBounds(104, 357, 157, 40);
		this.add(lblltimoNome);
		
		lblSalario = new JLabel("Sal\u00E1rio:");
		lblSalario.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblSalario.setForeground(new Color(218, 165, 32));
		lblSalario.setBounds(104, 484, 157, 40);
		this.add(lblSalario);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCpf.setForeground(new Color(218, 165, 32));
		lblCpf.setBounds(104, 423, 157, 40);
		this.add(lblCpf);
		
		lblLagradouro = new JLabel("Lagradouro:");
		lblLagradouro.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblLagradouro.setForeground(new Color(218, 165, 32));
		lblLagradouro.setBounds(532, 241, 157, 40);
		this.add(lblLagradouro);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblSexo.setForeground(new Color(218, 165, 32));
		lblSexo.setBounds(910, 238, 157, 40);
		this.add(lblSexo);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTelefone.setForeground(new Color(218, 165, 32));
		lblTelefone.setBounds(532, 478, 157, 40);
		this.add(lblTelefone);
		
		lblNewLabel = new JLabel("GE System");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(160, 122, 31));
		lblNewLabel.setBounds(324, 46, 716, 113);
		this.add(lblNewLabel);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNumero.setForeground(new Color(218, 165, 32));
		lblNumero.setBounds(532, 294, 157, 40);
		this.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtNumero.setBounds(633, 300, 225, 28);
		this.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCidade.setForeground(new Color(218, 165, 32));
		lblCidade.setBounds(532, 355, 157, 40);
		this.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtCidade.setColumns(10);
		txtCidade.setBounds(633, 361, 225, 28);
		this.add(txtCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblBairro.setForeground(new Color(218, 165, 32));
		lblBairro.setBounds(532, 417, 157, 40);
		this.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtBairro.setColumns(10);
		txtBairro.setBounds(633, 423, 225, 28);
		this.add(txtBairro);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblEstado.setForeground(new Color(218, 165, 32));
		lblEstado.setBounds(910, 293, 157, 40);
		this.add(lblEstado);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		cmbEstado.setModel(new DefaultComboBoxModel<>(Estados.values()));
		cmbEstado.setBounds(983, 300, 225, 28);
		this.add(cmbEstado);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblSenha.setForeground(new Color(218, 165, 32));
		lblSenha.setBounds(104, 543, 157, 40);
		this.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtSenha.setColumns(10);
		txtSenha.setBounds(236, 543, 225, 28);
		this.add(txtSenha);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblCargo.setForeground(new Color(218, 165, 32));
		lblCargo.setBounds(910, 354, 157, 40);
		this.add(lblCargo);
		
		JComboBox cmbCargo = new JComboBox();
		cmbCargo.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		cmbCargo.setModel(new DefaultComboBoxModel<>(Cargos.values()));
		cmbCargo.setBounds(983, 361, 225, 28);
		this.add(cmbCargo);
		
		
		btnSalvar = new JButton(imagSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				matricula = Long.parseLong(txtMatricula.getText());
				cpf = txtCpf.getText();
				primeiroNome = txtPrimeiroNome.getText();
				ultimoNome = txtUltimoNome.getText();
				salario = Float.parseFloat(txtSalario.getText());
				sexo = cmbSexo.getSelectedItem().toString();
				estado = cmbEstado.getSelectedItem().toString();
				cidade = txtCidade.getText();
				bairro = txtBairro.getText();
				numero = txtNumero.getText();
				logradouro = txtLogradouro.getText();
				senha = txtSenha.getText();
				cargo = cmbCargo.getSelectedItem().toString();
				
				vendedor = new Funcionario(matricula, cpf, primeiroNome, ultimoNome, sexo, salario, logradouro, numero, cidade, bairro, estado, senha, cargo);
				setCampos();
				try {
					PersistenciaEmBanco.pegarInstancia().cadastrarFuncionario(vendedor);
					JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso");			
				} catch (FuncionarioJaCadastradoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
			
		});
		
		btnSalvar.setBounds(790, 567, 200, 100);
		this.add(btnSalvar);
		
		btnVoltar= new JButton(imagVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos();
				controle.show(telas, "Tela Gerente");
			}
		});
		btnVoltar.setBounds(1049, 567, 200, 100);
		this.add(btnVoltar);
		
		lblTitulo = new JLabel("Cadastro de Funcionario");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(184, 134, 11));
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 60));
		lblTitulo.setBounds(178, 124, 798, 113);
		add(lblTitulo);
		
		
		lblTela = new JLabel("");
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);

		setVisible(true);
		
	}
	public void setCampos() {
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtCpf.setText("");
		this.txtLogradouro.setText("");
		this.txtMatricula.setText("");
		this.txtNumero.setText("");
		this.txtPrimeiroNome.setText("");
		this.txtSalario.setText("");
		this.txtTelefone.setText("");
		this.txtUltimoNome.setText("");
		this.txtSenha.setText("");
		
	}
	
}

