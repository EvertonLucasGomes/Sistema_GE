package Sistema_GE.gui;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Sistema_GE.modelo.Bolsa;
import Sistema_GE.modelo.Fornecedor;
import Sistema_GE.modelo.Produto;
import Sistema_GE.modelo.Programa;
import Sistema_GE.persistencia.PersistenciaEmBanco;

import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class TelaConsultarProduto extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JPanel telas;
		private CardLayout controle;
		private JTable table;
		private Long codigoDeBarrasSelecionado;
		private final int QUANTIDADE_MAX_CONTAS = 30;
	    private String[] colunasTabela = {"Codigo de barras", "Nome", "Cor", "Valor", "Marca", "Quantidade"};
	    private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][6];
	    
	    ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
		ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
		ImageIcon imagSalvar = new ImageIcon(getClass().getResource("/imagens/salvar.png"));
		ImageIcon imagRemover = new ImageIcon(getClass().getResource("/imagens/removerMenor.png"));
		ImageIcon imagBuscar = new ImageIcon(getClass().getResource("/imagens/buscar.png"));
		ImageIcon imagEditar = new ImageIcon(getClass().getResource("/imagens/alterEstoque.png"));
		ImageIcon imagBuscarBolsa = new ImageIcon(getClass().getResource("/imagens/buscarBolsa.png"));
		ImageIcon imagBuscarRoupa = new ImageIcon(getClass().getResource("/imagens/buscarRoupas.png"));
		ImageIcon imagBuscarCalc = new ImageIcon(getClass().getResource("/imagens/buscarCalc.png"));
		
		private JTextField txtQuantidade;
	
		private int quantidade;
		private JTextField txtNomeProduto;
		private JButton btnBuscar;
		private JButton btnBuscarBolsas;
		private JButton btnBuscarRoupas;
		private JButton btnBuscarCalados;
		private JLabel lblTitulo;
		private JButton btnSalvarEdit;
		private JButton btnVoltar;
		private JButton btnEditar;
		private JButton btnRemover;
		
		private JScrollPane scrollPane;
		
		private JLabel lblNovaQuantiade;
		private JLabel lblTela;

		
		public TelaConsultarProduto(JPanel telas) {
			
			this.telas = telas;
			this.controle = (CardLayout) telas.getLayout();
			
			this.setBounds(0,0,1366,730);
			this.setLayout(null);
			
			btnBuscar = new JButton(imagBuscar);
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
				}
			});
			btnBuscar.setBounds(61, 118, 200, 100);
			add(btnBuscar);
			
			btnBuscarBolsas = new JButton(imagBuscarBolsa);
			btnBuscarBolsas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todasBolsas());
				}
			});
			btnBuscarBolsas.setBounds(271, 118, 200, 100);
			add(btnBuscarBolsas);
			
			btnBuscarRoupas = new JButton(imagBuscarRoupa);
			btnBuscarRoupas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todasRoupas());
				}
			});
			btnBuscarRoupas.setBounds(882, 118, 200, 100);
			add(btnBuscarRoupas);
			
			btnBuscarCalados = new JButton(imagBuscarCalc);
			btnBuscarCalados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todosCalcados());
				}
			});
			btnBuscarCalados.setBounds(1103, 118, 200, 100);
			add(btnBuscarCalados);
			
			lblTitulo = new JLabel("GE System");
			lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 80));
			lblTitulo.setForeground(new Color(160, 122, 31));
			lblTitulo.setBounds(319, 63, 716, 113);
			this.add(lblTitulo);
			
			btnSalvarEdit = new JButton(imagSalvar);
			btnSalvarEdit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					quantidade = Integer.parseInt(txtQuantidade.getText());

					PersistenciaEmBanco.pegarInstancia().UpdateQuantProd(codigoDeBarrasSelecionado,quantidade);
					
					inserirTabela(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
					
					setCampos();
				
				}
					
			});
			btnSalvarEdit.setBounds(835, 571, 200, 100);
			add(btnSalvarEdit);
			
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
			btnVoltar.setBounds(1103, 571, 200, 100);
			this.add(btnVoltar);
			
			btnEditar = new JButton(imagEditar);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int numberLine = table.getSelectedRow();
					 
		                if(numberLine >= 0) {
		                	codigoDeBarrasSelecionado = (Long) table.getModel().getValueAt(numberLine,0);
		                	quantidade = PersistenciaEmBanco.pegarInstancia().getQuantProduto(codigoDeBarrasSelecionado);
		                	setDados(quantidade);
		                    
		                }
		                else {
		                    JOptionPane.showMessageDialog(null, "Por Favor, selecione um Produto!");
		                }
				}
			});
			btnEditar.setBounds(1103, 272, 200, 100);
			add(btnEditar);
			
			btnRemover = new JButton(imagRemover);
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int numberLine = table.getSelectedRow();
					 
		                if(numberLine >= 0) {
		                	codigoDeBarrasSelecionado = (Long) table.getModel().getValueAt(numberLine,0);
		                	
		                	PersistenciaEmBanco.pegarInstancia().deleteProduto(codigoDeBarrasSelecionado);
							
		                	inserirTabela(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
		                    
		                }
		                else {
		                    JOptionPane.showMessageDialog(null, "Por Favor, selecione um Produto!");
		                }
					
				}
			});
			btnRemover.setBounds(1103, 425, 200, 100);
			add(btnRemover);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 218, 1035, 343);
			add(scrollPane);
			
			table = new JTable(elementos, colunasTabela);
			table.setFont(new Font("Sylfaen", Font.BOLD, 15));
			table.setForeground(Color.WHITE);
			table.setBackground(new Color(66, 66, 67));
			table.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
			table.setRowHeight(32);
			scrollPane.setViewportView(table);
			
			txtQuantidade = new JTextField();
			txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtQuantidade.setBounds(668, 180, 115, 27);
			add(txtQuantidade);
			txtQuantidade.setColumns(10);
			
			lblNovaQuantiade = new JLabel("Nova quantidade:");
			lblNovaQuantiade.setForeground(new Color(218, 165, 32));
			lblNovaQuantiade.setFont(new Font("Sylfaen", Font.BOLD, 18));
			lblNovaQuantiade.setBounds(518, 182, 143, 27);
			add(lblNovaQuantiade);
			
			lblTela = new JLabel("");
			lblTela.setIcon(imagTela);
			lblTela.setBounds(0, 0, 1366, 768);
			this.add(lblTela);
			
			txtNomeProduto = new JTextField();
			txtNomeProduto.setBounds(319, 590, 86, 20);
			txtNomeProduto.setColumns(10);
			
			inserirTabela(PersistenciaEmBanco.pegarInstancia().todosProdutos(txtNomeProduto.getText()));
			
		}
		
		public void setCampos() {
			
			this.txtNomeProduto.setText("");
			this.txtQuantidade.setText("");
			
		}
		
		public void inserirTabela(ArrayList<Produto> arrayList) {


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

	        for(Produto produto : arrayList)
	        {
	            elementos[i][0] = produto.getCodigoDeBarra();
	            elementos[i][1] = produto.getNome();
	            elementos[i][2] = produto.getCor();
	            elementos[i][3] = produto.getValor();
	            elementos[i][4] = produto.getMarca();
	            elementos[i][5] = produto.getQuantidade();

	            i++;
	        }

			table.updateUI();
			this.txtQuantidade.setText("");
	    }
		public void setDados(int quantidade) {
			
			this.txtQuantidade.setText(String.valueOf(quantidade));
		}

	}
		



