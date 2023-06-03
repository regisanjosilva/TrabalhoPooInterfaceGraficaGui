package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import dao.DAO;
import modelo.Estudante;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class JCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEmail;
	private JTextField txtAreaEndereco;
	private JTextField txtTelefone;
	private JTextField txtCep;
	private JTextField txtCurso;
	private JTextField txtObservacoes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JCadastro(Estudante estudanteSelecionado, JPrincipal jPrincipal) {
		DAO dao = new DAO();
		
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlnome = new JLabel("Nome:");
		jlnome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlnome.setBounds(32, 11, 46, 14);
		contentPane.add(jlnome);
		
		txtNome = new JTextField();
		txtNome.setBounds(32, 36, 712, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel jlIdade = new JLabel("Idade ");
		jlIdade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlIdade.setBounds(32, 67, 46, 14);
		contentPane.add(jlIdade);
		
		JLabel jlEmail = new JLabel("E-mail");
		jlEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlEmail.setBounds(224, 67, 46, 14);
		contentPane.add(jlEmail);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(32, 92, 116, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(224, 92, 520, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel jlTelefone = new JLabel("Telefone:");
		jlTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlTelefone.setBounds(32, 127, 77, 14);
		contentPane.add(jlTelefone);
		
		JLabel jlCep = new JLabel("CEP:");
		jlCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlCep.setBounds(276, 127, 46, 14);
		contentPane.add(jlCep);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(32, 152, 192, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(276, 152, 192, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel jlEndereco = new JLabel("Endereço:");
		jlEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlEndereco.setBounds(32, 190, 77, 20);
		contentPane.add(jlEndereco);
		
		JTextArea txtAreaEndereco = new JTextArea();
		txtAreaEndereco.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaEndereco.setBounds(32, 221, 712, 62);
		contentPane.add(txtAreaEndereco);
		
		JLabel jlCurso = new JLabel("Curso:");
		jlCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jlCurso.setBounds(518, 128, 66, 14);
		contentPane.add(jlCurso);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(518, 152, 226, 20);
		contentPane.add(txtCurso);
		txtCurso.setColumns(10);
		
		
			
		
		JButton jbSalvar = new JButton(estudanteSelecionado==null?"Salvar":"Alterar");
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Estudante estudante = new Estudante(null, txtNome.getText(), txtIdade.getText(), txtEmail.getText(),
							txtAreaEndereco.getText(), txtCep.getText(), txtTelefone.getText(), txtCurso.getText(),
			      			txtObservacoes.getText() );
			
		    if(estudanteSelecionado == null) {
		    	if(!"".equalsIgnoreCase(txtNome.getText()) && !"".equalsIgnoreCase(txtIdade.getText())){
		    		dao.cadastrarEstudante(estudante);
		            abrirTelaPrincipal(jPrincipal);
		    			    		
		    	}else {
		    		JOptionPane.showMessageDialog(null, "Confira compos Nome  e idade");
		    	}
			
			}else {
				if(!"".equalsIgnoreCase(txtNome.getText()) && !"".equalsIgnoreCase(txtIdade.getText())){
		    		dao.cadastrarEstudante(estudante);
		            abrirTelaPrincipal(jPrincipal);
				}else {
					JOptionPane.showMessageDialog(null, "Confira compos Nome  e idade");
				}
				}
			}
			
		});
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbSalvar.setBounds(518, 415, 89, 23);
		contentPane.add(jbSalvar);
	
	
	
		JLabel jLObservacoes=new JLabel("Observações:");
		jLObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLObservacoes.setBounds(32, 288, 100, 14);
		contentPane.add(jLObservacoes);
		
		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtObservacoes.setBounds(32, 313, 436, 91);
		contentPane.add(txtObservacoes);
		
		JRadioButton rdbAtivoSim = new JRadioButton("Sim");
		rdbAtivoSim.setBounds(97, 415, 46, 23);
		contentPane.add(rdbAtivoSim);
		
		JRadioButton rdbAtivoNao = new JRadioButton("Não:");
		rdbAtivoNao.setBounds(150, 416, 49, 23);
		contentPane.add(rdbAtivoNao);
		
		JButton jbExcluir = new JButton("Excluir");
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.excluirEstudante(estudanteSelecionado.getId());
				abrirTelaPrincipal(jPrincipal);
				
				JOptionPane.showMessageDialog(null,"Você tem certeza que quer excluir ", "", JOptionPane.WARNING_MESSAGE);
				
			}
		});
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbExcluir.setBounds(655, 416, 89, 23);
		jbExcluir.setVisible(false);
		
		contentPane.add(jbExcluir);
		
		if(estudanteSelecionado!=null) {
		preencherCampos(estudanteSelecionado);
		jbExcluir.setVisible(true);
		}
		}
		
		private void preencherCampos(Estudante estudanteSelecionado) {
			txtNome.setText(estudanteSelecionado.getNomeCompleto());
			txtNome.setInt(estudanteSelecionado.getIdadeNaMatricula());
			txtNome.setText(estudanteSelecionado.getEmail());
			txtNome.setText(estudanteSelecionado.getEndereco());
			txtNome.setText(estudanteSelecionado.getCep());
			txtNome.setText(estudanteSelecionado.getTelefone());
			txtNome.setText(estudanteSelecionado.getCurso());
			txtNome.setText(estudanteSelecionado.getObservacoes());
			txtNome.setText(estudanteSelecionado.isAtivo());
			
		}
		
		private void abrirTelaPrincipal(JPrincipal jPrincipal) {
			jPrincipal.dispose();
			dispose();
			jPrincipal = new JPrincipal();
			jPrincipal.setLocationRelativeTo(jPrincipal);
			jPrincipal.setVisible(true);

		}		
}
