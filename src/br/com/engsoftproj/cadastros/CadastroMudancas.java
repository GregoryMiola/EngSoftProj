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
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
		setBounds(100, 100, 400, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeMudanas = new JLabel("Cadastro de Mudan\u00E7as");
		lblCadastroDeMudanas.setBounds(10, 11, 297, 14);
		contentPane.add(lblCadastroDeMudanas);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(10, 56, 132, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEquipamento = new JLabel("Equipamento:");
		lblEquipamento.setBounds(10, 81, 132, 14);
		contentPane.add(lblEquipamento);
		
		JLabel lblNewLabel = new JLabel("Gerente:");
		lblNewLabel.setBounds(10, 106, 132, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 131, 132, 14);
		contentPane.add(lblStatus);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(134, 50, 239, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(134, 75, 239, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 100, 239, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 125, 120, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 358, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnCancelar.setBounds(284, 358, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDataInicio = new JLabel("Data In\u00EDcio:");
		lblDataInicio.setBounds(10, 156, 132, 14);
		contentPane.add(lblDataInicio);
		
		JLabel lblHoraIncio = new JLabel("Hora In\u00EDcio:");
		lblHoraIncio.setBounds(10, 181, 132, 14);
		contentPane.add(lblHoraIncio);
		
		JLabel lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setBounds(10, 206, 132, 14);
		contentPane.add(lblDataFim);
		
		JLabel lblHoraFim = new JLabel("Hora Fim:");
		lblHoraFim.setBounds(10, 231, 132, 14);
		contentPane.add(lblHoraFim);
		
		JLabel lblArquivoInicial = new JLabel("Arquivo Inicial:");
		lblArquivoInicial.setBounds(10, 256, 132, 14);
		contentPane.add(lblArquivoInicial);
		
		JLabel lblArquivoFinal = new JLabel("Arquivo Final:");
		lblArquivoFinal.setBounds(10, 281, 132, 14);
		contentPane.add(lblArquivoFinal);
		
		JLabel lblComandosAplicados = new JLabel("Comandos Aplicados:");
		lblComandosAplicados.setBounds(10, 306, 132, 14);
		contentPane.add(lblComandosAplicados);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 153, 120, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(134, 178, 120, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(134, 203, 120, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(134, 228, 120, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(134, 253, 239, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(134, 278, 239, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(134, 303, 239, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
	}

	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

}
