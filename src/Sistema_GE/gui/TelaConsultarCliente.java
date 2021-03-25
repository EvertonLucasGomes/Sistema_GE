package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import Sistema_GE.modelo.Cliente;
import Sistema_GE.modelo.Programa;
import Sistema_GE.modelo.Venda;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JTextField;

public class TelaConsultarCliente extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel telas;
	private CardLayout controle;
	private JTable table;
	private final int QUANTIDADE_MAX_CONTAS = 40;
    private String[] colunasTabela = {"Cpf", "Primeiro Nome", "Ultimo Nome", "Idade", "Email", "Sexo"};
    private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][6];
    
    
    
    
    ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagBuscar = new ImageIcon(getClass().getResource("/imagens/atualizar.png"));
	private JTextField txtNome;

	private JScrollPane scrollPane;

	private JButton btnVoltar;

	private JLabel lblNewLabel;

	private JButton btnBuscar;

	private JLabel lblBusca;
	
	
	public TelaConsultarCliente(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setBounds(0,0,1366,730);
		this.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 204, 1035, 441);
		add(scrollPane);
		
		table = new JTable(elementos, colunasTabela);
		table.setFont(new Font("Sylfaen", Font.BOLD, 15));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(66, 66, 67));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		table.setRowHeight(32);
		scrollPane.setViewportView(table);
		
		btnVoltar= new JButton(imagVoltar);
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
		btnVoltar.setBounds(1111, 545, 200, 100);
		this.add(btnVoltar);
		
		lblNewLabel = new JLabel("GE System");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(160, 122, 31));
		lblNewLabel.setBounds(319, 63, 716, 113);
		this.add(lblNewLabel);
		
		btnBuscar = new JButton(imagBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().length() > 0) {
					String nome = Character.toUpperCase(txtNome.getText().charAt(0)) + txtNome.getText().substring(1);
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todosClientes(nome));
					setCampos();
				}else {
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todosClientes(txtNome.getText()));
					setCampos();
				}
				
				
			}
		});
		btnBuscar.setBounds(1111, 273, 200, 100);
		add(btnBuscar);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		txtNome.setBounds(1111, 200, 200, 42);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblBusca = new JLabel("Busca:");
		lblBusca.setForeground(new Color(218, 165, 32));
		lblBusca.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblBusca.setBounds(1111, 171, 64, 29);
		add(lblBusca);
		
		
		JLabel lblTela = new JLabel("");
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);
		
		inserirTabela(PersistenciaEmBanco.pegarInstancia().todosClientes(txtNome.getText()));
		
		
	}
	public void setCampos() {
		this.txtNome.setText("");
	}
	
	public void inserirTabela(ArrayList<Cliente> arrayList) {


        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
            elementos[i][3] = "";
            elementos[i][4] = "";
            elementos[i][5] = "";          

        }


        int i = 0;

        for(Cliente cliente : arrayList)
        {
            elementos[i][0] = cliente.getCpf();
            elementos[i][1] = cliente.getPrimeiroNome();
            elementos[i][2] = cliente.getUltimoNome();
            elementos[i][3] = cliente.getIdade();
            elementos[i][4] = cliente.getEmail();
            elementos[i][5] = cliente.getSexo();

            i++;
        }

		table.updateUI();
    }
	
}
