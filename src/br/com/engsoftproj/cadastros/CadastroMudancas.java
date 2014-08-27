package br.com.engsoftproj.cadastros;

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

public class CadastroMudancas extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMudancas frame = new CadastroMudancas();
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
	public CadastroMudancas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeMudanas = new JLabel("Cadastro de Mudan\u00E7as");
		lblCadastroDeMudanas.setBounds(10, 11, 297, 14);
		contentPane.add(lblCadastroDeMudanas);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(10, 56, 90, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEquipamento = new JLabel("Equipamento:");
		lblEquipamento.setBounds(10, 81, 90, 14);
		contentPane.add(lblEquipamento);
		
		JLabel lblNewLabel = new JLabel("Gerente:");
		lblNewLabel.setBounds(10, 106, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 131, 90, 14);
		contentPane.add(lblStatus);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(86, 53, 275, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(86, 78, 275, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 103, 275, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 128, 136, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 193, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnCancelar.setBounds(335, 193, 89, 23);
		contentPane.add(btnCancelar);
	}

	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

}
