package Sistema_GE.gui;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.modelo.Fornecedor;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaConsultarFornecedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel telas;
	private CardLayout controle;
	private JTable table;
	private String cnpj_selecionado;
	private final int QUANTIDADE_MAX_CONTAS = 20;
    private String[] colunasTabela = {"Cnpj", "Razão Social", "Telefone", "email", "Principal Produto"};
    private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][5];
	
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	ImageIcon imagRemover = new ImageIcon(getClass().getResource("/imagens/removerMenor.png"));
	ImageIcon imagBuscar = new ImageIcon(getClass().getResource("/imagens/atualizar.png"));
	ImageIcon imagEditar = new ImageIcon(getClass().getResource("/imagens/editar.png"));
	
	private JScrollPane scrollPane;

	private JButton btnBuscar;	
	private JButton btnEditar;
	private JButton btnRemover;
	private JButton btnVoltar;
	
	private JLabel lblTela;
	private JLabel lblTitulo;

	
	public TelaConsultarFornecedor(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setBounds(0,0,1366,730);
		this.setLayout(null);
		
		btnBuscar = new JButton(imagBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirTabela(PersistenciaEmBanco.pegarInstancia().todosFornecedores());
			}
		});
		btnBuscar.setBounds(1103, 169, 200, 100);
		add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 169, 1035, 343);
		add(scrollPane);
		
		table = new JTable(elementos, colunasTabela);
		table.setFont(new Font("Sylfaen", Font.BOLD, 15));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(66, 66, 67));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		table.setRowHeight(32);
		scrollPane.setViewportView(table);
		
		btnEditar = new JButton(imagEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int numberLine = table.getSelectedRow();
				 
	                if(numberLine >= 0 && table.getModel().getValueAt(numberLine,0).toString() != "") {
	                	String cnpjEscolhido = table.getModel().getValueAt(numberLine,0).toString();
	                	TelaEditarFornecedor telaEditarFornecedor = new TelaEditarFornecedor(cnpjEscolhido);	                		                    
	                }
	                else {
	                    JOptionPane.showMessageDialog(null, "Por favor, selecione um fornecedor!");
	                }
			}
		});
		btnEditar.setBounds(1103, 280, 200, 100);
		add(btnEditar);
		
		btnRemover = new JButton(imagRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int numberLine = table.getSelectedRow();
				 
	                if(numberLine >= 0) {
	                	String cnpjEscolhido = table.getModel().getValueAt(numberLine,0).toString();
	                	PersistenciaEmBanco.pegarInstancia().deleteFornecedor(cnpjEscolhido);
	    				inserirTabela(PersistenciaEmBanco.pegarInstancia().todosFornecedores());
	                    
	                }
	                else {
	                    JOptionPane.showMessageDialog(null, "Por favor, selecione um fornecedor!");
	                }
				
			}
		});
		btnRemover.setBounds(1103, 391, 200, 100);
		add(btnRemover);
			
		lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		btnVoltar= new JButton(imagVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.show(telas, "Tela Gerente");
			}
		});
		btnVoltar.setBounds(1103, 571, 200, 100);
		this.add(btnVoltar);
		
		lblTela = new JLabel(imagTela);
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);
		
		inserirTabela(PersistenciaEmBanco.pegarInstancia().todosFornecedores());
		
	}
	
	public void inserirTabela(List<Fornecedor> list) {


        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
            elementos[i][3] = "";
            elementos[i][4] = "";
        }


        int i = 0;

        for(Fornecedor fornecedor : list)
        {
            elementos[i][0] = fornecedor.getCnpj();
            elementos[i][1] = fornecedor.getRazaoSocial();
            elementos[i][2] = fornecedor.getTelefone();
            elementos[i][3] = fornecedor.getEmail();
            elementos[i][4] = fornecedor.getPrincipalProduto();

            i++;
        }

        table.updateUI();
    }
	

	public String getCnpj_selecionado() {
		return cnpj_selecionado;
	}

	public void setCnpj_selecionado(String cnpj_selecionado) {
		this.cnpj_selecionado = cnpj_selecionado;
	}
	


}
	


