package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import controle.Criptografia;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpanel = new JPanel();
		jpanel.setBorder(new TitledBorder(null, "login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanel.setBounds(109, 27, 234, 177);
		contentPane.add(jpanel);
		jpanel.setLayout(null);
		
		JLabel jlUsuario = new JLabel("Usuário ");
		jlUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlUsuario.setBounds(41, 46, 79, 14);
		jpanel.add(jlUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(42, 61, 165, 20);
		jpanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel jlBemVindo = new JLabel("Bem Vindo!");
		jlBemVindo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlBemVindo.setBounds(77, 11, 130, 24);
		jpanel.add(jlBemVindo);
		
		JButton jbtAcessar = new JButton("Acessar");
		jbtAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if(txtUsuario.getText() != null &&
						!txtUsuario.getText().isEmpty()&& passwordField.getText()!=null &&
						!passwordField.getText().isEmpty()) {
					if(criptografia.criptografar().equals("E10ADC3949BA59ABBE56E057F20F883E")) {
						JOptionPane.showMessageDialog(jbtAcessar,"Informações válidas");
					dispose();
					
					JPrincipal jPrincipal = new JPrincipal();
					jPrincipal.setLocationRelativeTo(jPrincipal);
					
					jPrincipal.setVisible(true);
					
					}else { 
					JOptionPane.showMessageDialog(jbtAcessar,"Verifique informações", "Aviso", JOptionPane.WARNING_MESSAGE);
					
					
					
				}
					
				}
			}
		});
		jbtAcessar.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbtAcessar.setBounds(77, 143, 89, 23);
		jpanel.add(jbtAcessar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 106, 166, 20);
		jpanel.add(passwordField);
		
		JLabel jlSenha = new JLabel("Senha");
		jlSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlSenha.setBounds(41, 91, 46, 14);
		jpanel.add(jlSenha);
	}
}
