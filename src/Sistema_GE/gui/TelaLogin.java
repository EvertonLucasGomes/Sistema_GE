package Sistema_GE.gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.modelo.Programa;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JScrollBar;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;

public class TelaLogin extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtMatricula;
	private JPasswordField txtSenha;
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/login.png"));
	ImageIcon imagIconSair = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	
	private JPanel telas;
	private CardLayout controle;


	private JButton btnLogin;


	private JComponent lblTitulo;


	private JLabel lblLogin;


	private JComponent lblSenha;


	private JButton btnSair;


	private JLabel lblTela;
	
	public TelaLogin(JPanel telas) 
	{
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
				
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtMatricula.setBounds(471, 262, 246, 30);
		add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtSenha.setBounds(471, 313, 246, 30);
		add(txtSenha);
		txtSenha.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Long matricula = Long.parseLong(txtMatricula.getText());
				Programa.setFuncionarioLogado(PersistenciaEmBanco.pegarInstancia().funcionarioLogado(matricula, txtSenha.getText()));
				
				try {
					
					if (PersistenciaEmBanco.pegarInstancia().VerificaLogin(matricula, txtSenha.getText()) == "0") {
						JOptionPane.showMessageDialog(null, "Usuário ou senha Incorretos");
						
					}else {
						
						controle.show(telas, PersistenciaEmBanco.pegarInstancia().VerificaLogin(matricula, txtSenha.getText()));
						setCampos();
						JOptionPane.showMessageDialog(null, "Bem vindo "+Programa.getFuncionarioLogado().getPrimeiroNome());
						
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnLogin.setBounds(589, 371, 128, 42);
		add(btnLogin);
		
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setForeground(new Color(218, 165, 32));
		lblTitulo.setFont(new Font("Sylfaen", Font.BOLD, 80));
		lblTitulo.setBounds(344, 94, 388, 147);
		add(lblTitulo);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setForeground(new Color(218, 165, 32));
		lblLogin.setBounds(398, 262, 63, 30);
		add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenha.setForeground(new Color(218, 165, 32));
		lblSenha.setBounds(397, 313, 76, 22);
		add(lblSenha);
		
		btnSair = new JButton(imagIconSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(827, 583, 200, 100);
		add(btnSair);
				
		lblTela = new JLabel(imagTela);
		lblTela.setBounds(-36, 0, 1438, 763);
		add(lblTela);
		
	}
	public void setCampos() {
		this.txtMatricula.setText("");
		this.txtSenha.setText("");
	}
	
	
	
}
