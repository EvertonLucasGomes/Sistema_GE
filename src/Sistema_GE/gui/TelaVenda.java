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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Sistema_GE.modelo.Cliente;
import Sistema_GE.modelo.Fornecedor;
import Sistema_GE.modelo.Produto;
import Sistema_GE.modelo.Programa;
import Sistema_GE.modelo.Venda;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaVenda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel telas;
	private CardLayout controle;
	
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
	ImageIcon imagAtualizar = new ImageIcon(getClass().getResource("/imagens/atualizar.png"));
	
	private JTable tableProdutos;
	private Long codigoDeBarrasSelecionado;
	private final int QUANTIDADE_MAX_CONTAS = 40;
    private String[] colunasTabelaProduto = {"Codigo de barras", "Nome", "Valor"};
    private Object [][] elementosProduto = new Object[QUANTIDADE_MAX_CONTAS][3];
    
    private JTable tableClientes;
    private String[] colunasTabelaCliente = {"Cpf", "Primeiro Nome", "Ultimo Nome"};
    private Object [][] elementosCliente = new Object[QUANTIDADE_MAX_CONTAS][3];
	private JButton btnSalvarEdit;
	
	private Long matriculaFuncionario;
	private Long codigoBarrasProduto;
	private String cpfCliente;
	private String formaDePagamento;
	private JTextField txtNome;
	private JTextField txtNomeProduto;

	private JScrollPane scrollPaneProdutos;
	
	private JLabel lblNome;
	private JLabel lblNomeProduto;
	private JLabel lblTela;
	
	public TelaVenda(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setBounds(0,0,1366,730);
		this.setLayout(null);
		
		JComboBox cmbFormaDePagamento = new JComboBox();
		cmbFormaDePagamento.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		cmbFormaDePagamento.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Cart\u00E3o de Cr\u00E9dito", "Cart\u00E3o de D\u00E9bito"}));
		cmbFormaDePagamento.setBounds(1168, 296, 133, 28);
		add(cmbFormaDePagamento);
		
		JLabel lblNewLabel_3 = new JLabel("Forma de pagamento:");
		lblNewLabel_3.setForeground(new Color(218, 165, 32));
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel_3.setBounds(1137, 249, 185, 42);
		add(lblNewLabel_3);

		JLabel lblTitulo = new JLabel("GE System");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
		lblTitulo.setForeground(new Color(160, 122, 31));
		lblTitulo.setBounds(324, 46, 716, 113);
		this.add(lblTitulo);
		
		JButton btnVoltar= new JButton(imagVoltar);
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
		btnVoltar.setBounds(1122, 541, 200, 100);
		this.add(btnVoltar);
		
		this.btnSalvarEdit = new JButton(imagSalvar);
		this.btnSalvarEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int numberLineCliente = tableClientes.getSelectedRow();
				int numberLineProduto = tableProdutos.getSelectedRow();
				 
                if(numberLineCliente >= 0 && numberLineProduto >= 0) {
                	matriculaFuncionario = Programa.getFuncionarioLogado().getMatricula();
                	codigoBarrasProduto = (Long) tableProdutos.getModel().getValueAt(numberLineProduto,0);
                	cpfCliente = tableClientes.getModel().getValueAt(numberLineCliente,0).toString();
                	formaDePagamento = cmbFormaDePagamento.getSelectedItem().toString(); 
                	
                	Venda novaVenda = new Venda(matriculaFuncionario, codigoBarrasProduto, cpfCliente, formaDePagamento);

    				PersistenciaEmBanco.pegarInstancia().novaVenda(novaVenda);
    				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");	         
                }
                else {
                    JOptionPane.showMessageDialog(null, "Por Favor, selecione os campos necessários!");
                }

			}
				
		});
		this.btnSalvarEdit.setBounds(1122, 385, 200, 100);
		this.add(btnSalvarEdit);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(53, 232, 519, 409);
		add(scrollPaneClientes);
		
		tableClientes = new JTable(elementosCliente, colunasTabelaCliente);
		tableClientes.setFont(new Font("Sylfaen", Font.BOLD, 15));
		tableClientes.setForeground(Color.WHITE);
		tableClientes.setBackground(new Color(66, 66, 67));
		tableClientes.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tableClientes.setRowHeight(32);
		scrollPaneClientes.setViewportView(tableClientes);
		
		scrollPaneProdutos = new JScrollPane();
		scrollPaneProdutos.setBounds(582, 232, 530, 409);
		add(scrollPaneProdutos);
		
		tableProdutos = new JTable(elementosProduto, colunasTabelaProduto);
		tableProdutos.setFont(new Font("Sylfaen", Font.BOLD, 15));
		tableProdutos.setForeground(Color.WHITE);
		tableProdutos.setBackground(new Color(66, 66, 67));
		tableProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tableProdutos.setRowHeight(32);
		scrollPaneProdutos.setViewportView(tableProdutos);
		
		txtNome = new JTextField();
		txtNome.setBounds(263, 189,225, 28);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Buscar Nome:");
		lblNome.setForeground(new Color(218, 165, 32));
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNome.setBounds(106, 191, 225, 28);
		add(lblNome);
		
		JButton btnNewButton = new JButton(imagAtualizar);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().length() > 0 && txtNomeProduto.getText().length() > 0 ) {
					String nome = Character.toUpperCase(txtNome.getText().charAt(0)) + txtNome.getText().substring(1);
					inserirTabelaCliente(PersistenciaEmBanco.pegarInstancia().todosClientes(nome));
					inserirTabelaProduto(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
				}
				else if (txtNome.getText().length() > 0 ) {
					String nome = Character.toUpperCase(txtNome.getText().charAt(0)) + txtNome.getText().substring(1);
					inserirTabelaCliente(PersistenciaEmBanco.pegarInstancia().todosClientes(nome));

				}else if (txtNomeProduto.getText().length() > 0) {
					inserirTabelaProduto(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
				}else {
					inserirTabelaCliente(PersistenciaEmBanco.pegarInstancia().todosClientes(txtNome.getText()));
					inserirTabelaProduto(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
				}
				
				setCampos();
				
			}
		});
		btnNewButton.setBounds(1068, 122, 200, 100);
		add(btnNewButton);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(798, 189, 225, 28);
		add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setForeground(new Color(218, 165, 32));
		lblNomeProduto.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNomeProduto.setBounds(611, 193, 225, 28);
		add(lblNomeProduto);
		
		lblTela = new JLabel(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);	
		
		inserirTabelaProduto(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
		
		inserirTabelaCliente(PersistenciaEmBanco.pegarInstancia().todosClientes(txtNome.getText()));
		
		

	}
	public void setCampos() {
		this.txtNome.setText("");
		this.txtNomeProduto.setText("");
	}
	
	public void inserirTabelaCliente(ArrayList<Cliente> arrayList) {


        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementosCliente[i][0] = "";
            elementosCliente[i][1] = "";
            elementosCliente[i][2] = "";

        }


        int i = 0;

        for(Cliente cliente : arrayList)
        {
        	elementosCliente[i][0] = cliente.getCpf();
        	elementosCliente[i][1] = cliente.getPrimeiroNome();
        	elementosCliente[i][2] = cliente.getUltimoNome();

            i++;
        }

		tableClientes.updateUI();
    }
	
	public void inserirTabelaProduto(ArrayList<Produto> arrayList) {


        for(int j = 0; j<QUANTIDADE_MAX_CONTAS; j++)
        {
            elementosProduto[j][0] = "";
            elementosProduto[j][1] = "";
            elementosProduto[j][2] = "";

        }


        int j = 0;

        for(Produto produto : arrayList)
        {
        	elementosProduto[j][0] = produto.getCodigoDeBarra();
        	elementosProduto[j][1] = produto.getNome();
        	elementosProduto[j][2] = produto.getValor();

            j++;
        }

		tableProdutos.updateUI();

    }
}
