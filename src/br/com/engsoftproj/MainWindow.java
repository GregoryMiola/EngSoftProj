package br.com.engsoftproj;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import br.com.engsoftproj.cadastros.CadastroDispositivo;
import br.com.engsoftproj.cadastros.CadastroMudancas;
import br.com.engsoftproj.cadastros.CadastroUsuario;
import br.com.engsoftproj.datamenbers.Usuario;
import br.com.engsoftproj.enumerators.NivelAcesso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

	private String usuarioLogado;
	private Usuario usuario;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow(Usuario logado) {
		this.usuario = logado;
		this.usuarioLogado = logado.getUsername();
		
		montaTela();
	}
	
	public MainWindow(String user, String passwd) {
		this.usuarioLogado = user;
		
		montaTela();
	}
	
	public MainWindow() {
		montaTela();
	}
	
	private void montaTela(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadUser = new JButton("Usu\u00E1rio");
		btnCadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abreCadastroUsuario();
			}
		});
		btnCadUser.setBounds(145, 82, 106, 23);
				
		JButton btnCadDev = new JButton("Dispositivos");
		btnCadDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abreCadastroDispositivo();
			}
		});
		btnCadDev.setBounds(145, 116, 106, 23);
				
		JButton btnCadEvents = new JButton("Eventos");
		btnCadEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abreCadastroEventos();
			}
		});
		btnCadEvents.setBounds(145, 150, 106, 23);
				
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(174, 57, 55, 14);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio Logado:");
		lblNewLabel.setBounds(10, 11, 95, 14);
				
		JLabel lblUsuario = new JLabel(this.usuarioLogado);
		lblUsuario.setBounds(107, 11, 134, 14);
		
		if(usuario.getNivelAcesso() == NivelAcesso.TECNICO){
			btnCadUser.setEnabled(false);
		}
		
		contentPane.add(btnCadUser);
		contentPane.add(btnCadDev);
		contentPane.add(btnCadEvents);
		contentPane.add(lblCadastro);
		contentPane.add(lblNewLabel);
		contentPane.add(lblUsuario);
	}

	private void abreCadastroUsuario() {
		// TODO Auto-generated method stub
		CadastroUsuario f = new CadastroUsuario();
		f.setVisible(true);   
	}

	private void abreCadastroDispositivo() {
		// TODO Auto-generated method stub
		CadastroDispositivo f = new CadastroDispositivo();
		f.setVisible(true);   
	}

	private void abreCadastroEventos() {
		// TODO Auto-generated method stub
		CadastroMudancas f = new CadastroMudancas();
		f.setVisible(true);   
	}
}
