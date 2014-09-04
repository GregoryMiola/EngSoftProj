package br.com.engsoftproj.validacoes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.engsoftproj.cadastros.CadastroMudancasDAO;
import br.com.engsoftproj.datamenbers.Mudanca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VisualizaMudanca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6827000325021049543L;
	private JPanel contentPane;
	private JTextField textTitulo;
	//-- adicionado
	private JComboBox cbEquipamento;
	private JComboBox cbUsuario;
	//-- adicionado	
	
	//private JTextField textGerente;
	private JTextField textStatus;
	private JTextField textDt_ini;
	private JTextField textHr_ini;
	private JTextField textDt_fim;
	private JTextField textHr_fim;
	private JTextField textArq_ini;
	private JTextField textArq_fim;
	private JTextField textCmd_aplic;
	private JTextField textAnalisadoPor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizaMudanca frame = new VisualizaMudanca();
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
	public VisualizaMudanca() {
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
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setBounds(10, 106, 132, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 131, 132, 14);
		contentPane.add(lblStatus);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(134, 50, 239, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		/*-- alterado
		textEquipamento = new JTextField();
		textEquipamento.setBounds(134, 75, 239, 20);
		contentPane.add(textEquipamento);
		textEquipamento.setColumns(10);
		*/
		
		//-- adicionado
		cbEquipamento = new JComboBox();
		cbEquipamento.setBounds(134, 75, 239, 20);
		contentPane.add(cbEquipamento);
		//textEquipamento.setColumns(10);
		//--
		
		//-- alterado
		cbUsuario = new JComboBox();
		cbUsuario.setBounds(134, 100, 239, 20);
		contentPane.add(cbUsuario);
		//textGerente.setColumns(10);
		
		//textGerente = new JTextField();
		//textGerente.setBounds(134, 100, 239, 20);
		//contentPane.add(textGerente);
		//textGerente.setColumns(10);
		//-- alterado
		
		textStatus = new JTextField();
		textStatus.setBounds(134, 125, 120, 20);
		contentPane.add(textStatus);
		textStatus.setColumns(10);
		textStatus.setText("P");
		textStatus.setEditable(false);
		
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
		
		textAnalisadoPor = new JTextField();
		textAnalisadoPor.setBounds(134, 303, 239, 20);
		contentPane.add(textAnalisadoPor);
		textAnalisadoPor.setColumns(10);
		textAnalisadoPor.setText(" ");		
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaMudanca();
			}
		});
		btnAprovar.setBounds(50, 358, 89, 23);
		contentPane.add(btnAprovar);
		
		JButton btnReprovar = new JButton("Reprovar");
		btnReprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaMudanca();
			}
		});
		btnReprovar.setBounds(150, 358, 89, 23);
		contentPane.add(btnReprovar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnVoltar.setBounds(250, 358, 89, 23);
		contentPane.add(btnVoltar);
		
		
		//-- adicionado
		carregaComboEquip();
		carregaComboUser();
		//-- adicionado
	}
	
	//-- adicionado
	protected void carregaComboEquip(){
		List<String> lst = new ArrayList<String>();
		lst = CadastroMudancasDAO.buscaEquipamentos();
		
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(lst.toArray());
		cbEquipamento.setModel(defaultComboBox);
		
	}
	
	protected void carregaComboUser(){
		List<String> lst = new ArrayList<String>();
		lst = CadastroMudancasDAO.buscaUsuarios();
		
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(lst.toArray());
		cbUsuario.setModel(defaultComboBox);
	}
	//-- adicionado
	
	
	protected void atualizaMudanca() {
		// TODO Auto-generated method stub
			
			
		JOptionPane.showMessageDialog(this, "Dispositivo cadastrado com sucesso.", "Dispositivo Cadastrado", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
	}
		
	protected void fecharJanela() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

}
