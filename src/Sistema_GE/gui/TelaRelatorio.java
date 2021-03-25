package Sistema_GE.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Sistema_GE.modelo.Produto;
import Sistema_GE.modelo.Venda;
import Sistema_GE.persistencia.PersistenciaEmBanco;

public class TelaRelatorio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel telas;
	private CardLayout controle;
	private JTable table;
	private final int QUANTIDADE_MAX_CONTAS = 40;
    private String[] colunasTabela = {"id", "Matricula Funcionário", "Código do Produto", "Cpf do cliente", "Forma de pagamento"};
    private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][5];

    ImageIcon imagVoltar = new ImageIcon(getClass().getResource("/imagens/voltar.png"));
	ImageIcon imagTela = new ImageIcon(getClass().getResource("/imagens/tela.png"));
	ImageIcon imagBuscar = new ImageIcon(getClass().getResource("/imagens/atualizar.png"));

	private JScrollPane scrollPane;

	private JButton btnVoltar;

	private JLabel lblNewLabel;

	private JButton btnBuscar;
	
	
	public TelaRelatorio(JPanel telas) {
		
		this.telas = telas;
		this.controle = (CardLayout) telas.getLayout();
		
		this.setBounds(0,0,1366,730);
		this.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 170, 1035, 343);
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
				controle.show(telas, "Tela Gerente");
			}
		});
		btnVoltar.setBounds(1097, 555, 200, 100);
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
				inserirTabela(PersistenciaEmBanco.pegarInstancia().todasVendas());
			}
		});
		btnBuscar.setBounds(1097, 167, 200, 100);
		add(btnBuscar);
		
		JLabel lblTela = new JLabel("");
		lblTela.setIcon(imagTela);
		lblTela.setBounds(0, 0, 1366, 768);
		this.add(lblTela);
		
		inserirTabela(PersistenciaEmBanco.pegarInstancia().todasVendas());
		
	}
	
	public void inserirTabela(ArrayList<Venda> arrayList) {


        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
            elementos[i][3] = "";
            elementos[i][4] = "";

        }


        int i = 0;

        for(Venda venda : arrayList)
        {
        	elementos[i][0] = venda.getId();
            elementos[i][1] = venda.getMatriculaFuncionario();
            elementos[i][2] = venda.getCodigoBarrasProduto();
            elementos[i][3] = venda.getCpfCliente();
            elementos[i][4] = venda.getFormaDePagamento();


            i++;
        }

		table.updateUI();
    }

}
