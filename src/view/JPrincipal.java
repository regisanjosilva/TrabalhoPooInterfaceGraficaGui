package view;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import modelo.Estudante;
import modelo.ModeloTabela;
import dao.DAO;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPrincipal extends JFrame {

	
	
	
	private JPanel contentPane;
	private JPanel jpPesquisa;
	private JTextField txtBusca;
	private JTable table;
	private ArrayList<Estudante> estudante;
	private JPrincipal jprincipal; 
	private TableRowSorter<TableModel> rowSorter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JPrincipal() {
		this.jprincipal = this;
		DAO dao = new DAO();
		try {
		estudante = dao.listarEstudante();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		setTitle("Cadastro de Matrículas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 483);
		jpPesquisa = new JPanel();
		jpPesquisa.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpPesquisa);
		jpPesquisa.setLayout(null);
		
		JButton jpCadastrar = new JButton("Cadastrar:");
		jpCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastro jCadastro  = new JCadastro(null, jprincipal);
				jCadastro.setLocationRelativeTo(jpCadastrar);
				jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jCadastro.setVisible(true);
				
			}
		});
		jpCadastrar.setBounds(37, 53, 96, 23);
		jpPesquisa.add(jpCadastrar);
		
		txtBusca = new JTextField();
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}

			
		});
		txtBusca.setBounds(151, 54, 438, 20);
		jpPesquisa.add(txtBusca);
		txtBusca.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 109, 739, 287);
		jpPesquisa.add(scrollPane);
		
		ModeloTabela modeloTabela = new ModeloTabela(estudante);
		
		
		table = new JTable();
		table.setModel(modeloTabela);
		table.addMouseListener(new MouseAdapter(){
			
			public void	mouseclicked(MouseEvent e) {
				if(e.getButton()==1) {
					try {
					Estudante estudanteSelecionado = dao.consultarEstudante(modeloTabela.getValueAt(table.getSelectedRow(),0).toString());
					JCadastro jCadastro = new JCadastro(estudanteSelecionado, jprincipal);
					jCadastro.setLocationRelativeTo(jpCadastrar);
					jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					jCadastro.setVisible(true);
					
					
					} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
		}
		
		});
			
		
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
		
	}
	
	private void filtrar() {
		String busca = txtBusca.getText().trim();
		
		if(busca.length()==0) {
			rowSorter.setRowFilter(null);
		}else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?I)"+ busca));
		}
		
	}
}