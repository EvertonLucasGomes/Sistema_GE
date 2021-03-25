package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroProduto extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagBolsa = new ImageIcon(getClass().getResource("/imagens/bolsa.png"));
	ImageIcon imagCalcado = new ImageIcon(getClass().getResource("/imagens/sapato.png"));
	ImageIcon imagRoupa = new ImageIcon(getClass().getResource("/imagens/roupa.png"));
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	
	private JPanel telas;
	private CardLayout controle;
	
	private JLabel lblTitulo;	
	private JLabel lblTela;
	
	private JButton btnVoltar;
	private JButton btnNewBolsa;
	private JButton btnNewCalcado;
	private JButton btnNewRoupa;
	
	public TelaCadastroProduto(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		this.setLayout(null);
		this.setBounds(0,0,1366,730);
		
		btnNewRoupa = new JButton(imagRoupa);
		btnNewRoupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Roupa");
			}
		});
		btnNewRoupa.setBounds(85, 173, 300, 300);
		this.add(btnNewRoupa);
		
		btnNewCalcado = new JButton(imagCalcado);
		btnNewCalcado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Calcado");
			}
		});
		btnNewCalcado.setBounds(504, 173, 300, 300);
		this.add(btnNewCalcado);
		
		btnNewBolsa = new JButton(imagBolsa);
		btnNewBolsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Cadastro Bolsa");
			}
		});
		btnNewBolsa.setBounds(930, 173, 300, 300);
		this.add(btnNewBolsa);
		
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(184, 134, 11));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		btnVoltar= new JButton(imagVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Gerente");
			}
		});
		btnVoltar.setBounds(1030, 550, 200, 100);
		this.add(btnVoltar);
		
		lblTela = new JLabel(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);
		
		
		setVisible(true);
		
		
	}
}
