package br.com.engsoftproj.validacoes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.engsoftproj.cadastros.CadastroMudancas;
import br.com.engsoftproj.cadastros.CadastroMudancasDAO;

public class ValidaProposta extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8577146791386115730L;
	private JPanel contentPane;
	private JComboBox cbPendencias;
	private JButton btnMostrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidaProposta frame = new ValidaProposta();
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
	public ValidaProposta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValidaProposta = new JLabel("Validação de Proposta");
		lblValidaProposta.setBounds(10, 11, 155, 14);
		contentPane.add(lblValidaProposta);
		
		JLabel lblValidaProposta2 = new JLabel("Lista de propostas pendentes de aprovação:");
		lblValidaProposta2.setBounds(65, 50, 300, 14);
		contentPane.add(lblValidaProposta2);
		
		//-- adicionado
		cbPendencias = new JComboBox();
		cbPendencias.setBounds(45, 75, 300, 20);
		contentPane.add(cbPendencias);
		//--
		
		JButton btnMostrar = new JButton("Detalhar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraPendencias();
			}
		});
		btnMostrar.setBounds(140, 170, 106, 23);
		contentPane.add(btnMostrar);
		
		carregaComboPendencias();
		/*
		ItemListener listener = new ItemListener(){  
		    public void itemStateChanged(ItemEvent e) {  
		        // Tratamento do Evento 
		    	mostraPendencias();
		    }  
		};
		*/
		
		
		//cbPendencias.addItemListener(listener);
	}
	
	protected void carregaComboPendencias(){
		List<String> lst = new ArrayList<String>();
		lst = CadastroMudancasDAO.buscaMudancaPorStatus("P");
		
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(lst.toArray());
		cbPendencias.setModel(defaultComboBox);
		
	}
	
	protected void mostraPendencias(){
		// TODO Auto-generated method stub
		VisualizaMudanca f = new VisualizaMudanca();
		f.setVisible(true);		
	}

}
