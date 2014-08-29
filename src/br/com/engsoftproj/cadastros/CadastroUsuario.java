package br.com.engsoftproj.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import sun.awt.image.PixelConverter.Bgrx;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCargo;
	private JTextField textUsername;
	private JTextField textSenha;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroUsurio.setBounds(10, 11, 139, 14);
		contentPane.add(lblCadastroUsurio);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 62, 57, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 112, 89, 14);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(77, 59, 313, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCargo = new JTextField();
		textCargo.setBounds(77, 84, 155, 20);
		contentPane.add(textCargo);
		textCargo.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validaCampos = validaCampos();
				
				if(validaCampos)
					salvarUsuario();
				else
					lancaMsgUsuario();
			}
		});
		btnSalvar.setBounds(10, 254, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnCancelar.setBounds(301, 252, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 87, 89, 14);
		contentPane.add(lblCargo);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(77, 109, 155, 20);
		contentPane.add(textUsername);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 137, 77, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(77, 134, 155, 20);
		contentPane.add(textSenha);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00EDvel:");
		lblNewLabel_1.setBounds(10, 162, 47, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel rdbPanel = new JPanel();
		rdbPanel.setBounds(77, 156, 72, 56);
				
		JRadioButton rdbGerente = new JRadioButton("Gerente");
		rdbGerente.setSelected(true);
		//rdbGerente.setBounds(77, 158, 109, 23);
		
		JRadioButton rdbTecnico = new JRadioButton("T\u00E9cnico");
		//rdbTecnico.setBounds(77, 184, 109, 23);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbGerente);
		buttonGroup.add(rdbTecnico);
	    
	    //rdbPanel.setLayout(new GridLayout(2, 1));
	    rdbPanel.add(rdbGerente);
	    rdbPanel.add(rdbTecnico);
	    contentPane.add(rdbPanel);
	}

	protected void lancaMsgUsuario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Validação de Campos", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void salvarUsuario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "OK.", "Validação de Campos", JOptionPane.CLOSED_OPTION);
	}

	protected boolean validaCampos() {
		// TODO Auto-generated method stub
		if(textNome.getText().isEmpty())
			return false;
		
		if(textCargo.getText().isEmpty())
			return false;
		
		if(textUsername.getText().isEmpty())
			return false;
		
		if(textSenha.getText().isEmpty())
			return false;
		
		if(!buttonGroup.getSelection().isSelected())
			return false;
		
		return true;
	}

	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
