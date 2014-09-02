package br.com.engsoftproj.cadastros;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.engsoftproj.datamenbers.Dispositivo;

public class CadastroDispositivo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1612669659695419551L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCodigo;
	private JTextField textTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDispositivo frame = new CadastroDispositivo();
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
	public CadastroDispositivo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDispositivo = new JLabel("Cadastro de Dispositivo");
		lblCadastroDeDispositivo.setBounds(10, 11, 155, 14);
		contentPane.add(lblCadastroDeDispositivo);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 60, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setBounds(10, 85, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setBounds(10, 110, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textNome = new JTextField();
		textNome.setBounds(67, 57, 308, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(66, 82, 155, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(66, 107, 155, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraDispositivo();
			}
		});
		btnSalvar.setBounds(10, 170, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(286, 170, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
	}
	
	protected void cadastraDispositivo() {
		// TODO Auto-generated method stub
		boolean validaCampos = validaCampos();
		
		if(validaCampos)
			salvarDispositivo();
		else
			lancaMsgDispositivo();
	}

	protected void lancaMsgDispositivo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Validação de Campos", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void salvarDispositivo() {
		// TODO Auto-generated method stub
				
		Dispositivo disp = new Dispositivo();
		disp.setNOME(textNome.getText());
		disp.setCODIGO(textCodigo.getText());
		disp.setTIPO(textTipo.getText());
		
		CadastroDispositivoDAO.salvaDispositivo(disp);
		
		JOptionPane.showMessageDialog(this, "Dispositivo cadastrado com sucesso.", "Dispositivo Cadastrado", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
	}

	protected boolean validaCampos() {
		// TODO Auto-generated method stub
		if(textNome.getText().isEmpty())
			return false;
		
		if(textCodigo.getText().isEmpty())
			return false;
		
		if(textTipo.getText().isEmpty())
			return false;
						
		return true;
	}

	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}
}
 