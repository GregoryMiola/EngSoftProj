package br.com.engsoftproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginDoSistema = new JLabel("Login do Sistema");
		lblLoginDoSistema.setBounds(73, 44, 109, 14);
		contentPane.add(lblLoginDoSistema);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setBounds(99, 84, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(99, 129, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(76, 98, 86, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPasswd = new JTextField();
		textPasswd.setBounds(76, 143, 86, 20);
		contentPane.add(textPasswd);
		textPasswd.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logar();
			}
		});
		btnAcessar.setBounds(73, 184, 89, 23);
		contentPane.add(btnAcessar);
	}

	protected void Logar() {
		// TODO Auto-generated method stub
		MainWindow mw = new MainWindow(textUser.getText(), textPasswd.getText());
		mw.setVisible(true);
	}
}
