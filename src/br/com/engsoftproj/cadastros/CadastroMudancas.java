package br.com.engsoftproj.cadastros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.engsoftproj.datamenbers.Mudanca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastroMudancas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6827000325021049543L;
	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textEquipamento;
	private JTextField textGerente;
	private JTextField textStatus;
	private JTextField textDt_ini;
	private JTextField textHr_ini;
	private JTextField textDt_fim;
	private JTextField textHr_fim;
	private JTextField textArq_ini;
	private JTextField textArq_fim;
	private JTextField textCmd_aplic;
	

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
		
		textEquipamento = new JTextField();
		textEquipamento.setBounds(134, 75, 239, 20);
		contentPane.add(textEquipamento);
		textEquipamento.setColumns(10);
		
		textGerente = new JTextField();
		textGerente.setBounds(134, 100, 239, 20);
		contentPane.add(textGerente);
		textGerente.setColumns(10);
		
		textStatus = new JTextField();
		textStatus.setBounds(134, 125, 120, 20);
		contentPane.add(textStatus);
		textStatus.setColumns(10);		
		
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
		
		textDt_ini = new JTextField();
		textDt_ini.setBounds(134, 153, 120, 20);
		contentPane.add(textDt_ini);
		textDt_ini.setColumns(10);
		
		textHr_ini = new JTextField();
		textHr_ini.setBounds(134, 178, 120, 20);
		contentPane.add(textHr_ini);
		textHr_ini.setColumns(10);
		
		textDt_fim = new JTextField();
		textDt_fim.setBounds(134, 203, 120, 20);
		contentPane.add(textDt_fim);
		textDt_fim.setColumns(10);
		
		textHr_fim = new JTextField();
		textHr_fim.setBounds(134, 228, 120, 20);
		contentPane.add(textHr_fim);
		textHr_fim.setColumns(10);
		
		textArq_ini = new JTextField();
		textArq_ini.setBounds(134, 253, 239, 20);
		contentPane.add(textArq_ini);
		textArq_ini.setColumns(10);
		
		textArq_fim = new JTextField();
		textArq_fim.setBounds(134, 278, 239, 20);
		contentPane.add(textArq_fim);
		textArq_fim.setColumns(10);
		
		textCmd_aplic = new JTextField();
		textCmd_aplic.setBounds(134, 303, 239, 20);
		contentPane.add(textCmd_aplic);
		textCmd_aplic.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraMudancas();
			}
		});
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
	}
	
	protected void cadastraMudancas() {
		// TODO Auto-generated method stub
		boolean validaCampos = validaCampos();
		
		if(validaCampos)
			salvarMudanca();
		else
			lancaMsgMudanca();
	}

	protected void lancaMsgMudanca() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Validação de Campos", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void salvarMudanca() {
		// TODO Auto-generated method stub
				
		Mudanca mudanca = new Mudanca();
		mudanca.setTITULO(textTitulo.getText());
		//mudanca.setID_DISPOSITIVO(textEquipamento.getText());
		//mudanca.setID_USUARIO(textGerente.getText());
		try {
			mudanca.setDATA_INI(new SimpleDateFormat("dd/MM/yyyy").parse(textDt_ini.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mudanca.setHORA_INI(new SimpleDateFormat("HHmmss").parse(textHr_ini.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mudanca.setDATA_FIM(new SimpleDateFormat("dd/MM/yyyy").parse(textDt_fim.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mudanca.setHORA_FIM(new SimpleDateFormat("HHmmss").parse(textHr_fim.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mudanca.setARQUIVO_INI(textArq_ini.getText());
		mudanca.setARQUIVO_FIM(textArq_fim.getText());
		mudanca.setCOMANDOS_APLICADOS(textCmd_aplic.getText());
		mudanca.setSTATUS(textStatus.getText());
				
		//SQLiteJDBC.insereUsuario(novo);
		CadastroMudancasDAO.salvaMudanca(mudanca);
		
		JOptionPane.showMessageDialog(this, "Dispositivo cadastrado com sucesso.", "Dispositivo Cadastrado", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
	}

	protected boolean validaCampos() {
		// TODO Auto-generated method stub
		if(textTitulo.getText().isEmpty())
			return false;
		
		if(textDt_ini.getText().isEmpty())
			return false;
		
		if(textHr_ini.getText().isEmpty())
			return false;
		
		if(textDt_fim.getText().isEmpty())
			return false;
		
		if(textHr_fim.getText().isEmpty())
			return false;
		
		if(textArq_ini.getText().isEmpty())
			return false;
		
		if(textArq_fim.getText().isEmpty())
			return false;
		
		if(textCmd_aplic.getText().isEmpty())
			return false;
		
		//if(textStatus.getText().isEmpty())
		//	return false;
						
		return true;
	}

	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

}
