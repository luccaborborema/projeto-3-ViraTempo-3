package entrypoint;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import compromisso.Compromisso;
import cronometro.Cronometro;
import frames.OkFrame;
import inatividade.Inativo;
import tarefa.Tarefa;
import usuario.Usuario;

public class Main {

	private JFrame frame;
	private JTextField nomecomp;
	private JTextField horacomeco;
	private JTextField nometar;
	private JTextField duracaotar;
	private JTextField minutocomeco;
	private JTextField horafim;
	private JTextField minutofim;
	private JTextField textField;
	/* Launch the application.*/
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*Create the application.*/
	public Main() {
		initialize();
	}
	
	/*Initialize the contents of the frame.*/ //Dimensoes e etc da tela
	private void initialize() {
		Inativo ina = new Inativo();
		ina.start();
		Usuario u1 = new Usuario();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 699, 448);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(false);
		
		nomecomp = new JTextField();
		nomecomp.setBounds(10, 55, 140, 23);
		frame.getContentPane().add(nomecomp);
		nomecomp.setColumns(10);
		
		JLabel txtNome = new JLabel("Nome Compromisso");
		txtNome.setBounds(10, 30, 147, 15);
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNome.setForeground(Color.WHITE);
		frame.getContentPane().add(txtNome);
		
		horacomeco = new JTextField();
		horacomeco.setBounds(10, 125, 22, 20);
		frame.getContentPane().add(horacomeco);
		horacomeco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Tarefa");
		lblNewLabel_1.setBounds(188, 30, 112, 15);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_2.setBounds(188, 83, 99, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_2);
		
		nometar = new JTextField();
		nometar.setBounds(188, 55, 140, 23);
		nometar.setColumns(10);
		frame.getContentPane().add(nometar);
		
		duracaotar = new JTextField();
		duracaotar.setBounds(188, 108, 80, 23);
		duracaotar.setColumns(10);
		frame.getContentPane().add(duracaotar);
		
		//BOTAO DE ADD TAREFA
		JButton addtar = new JButton("ADICIONAR");
		addtar.setBounds(192, 243, 129, 47);
		addtar.setFont(new Font("Tahoma", Font.BOLD, 11));
		addtar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa t = new Tarefa(nometar.getText(), duracaotar.getText());
				u1.setTarefa(t); //add tarefa
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Digite valores v�lidos");
				}
				
				OkFrame fr = new OkFrame();
				fr.show();
			}
		});
		frame.getContentPane().add(addtar);
		
		JLabel lblNewLabel = new JLabel("Minutos");
		lblNewLabel.setBounds(104, 105, 46, 14);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Hora");
		lblNewLabel_3.setBounds(10, 105, 46, 14);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewLabel_3);
		
		minutocomeco = new JTextField();
		minutocomeco.setBounds(104, 125, 22, 20);
		minutocomeco.setColumns(10);
		frame.getContentPane().add(minutocomeco);
		
		horafim = new JTextField();
		horafim.setBounds(10, 195, 22, 20);
		horafim.setColumns(10);
		frame.getContentPane().add(horafim);
		
		minutofim = new JTextField();
		minutofim.setBounds(104, 195, 22, 20);
		minutofim.setColumns(10);
		frame.getContentPane().add(minutofim);
		
		JLabel lblNewLabel_3_1 = new JLabel("H F");
		lblNewLabel_3_1.setBounds(10, 175, 46, 14);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("M F");
		lblNewLabel_3_2.setBounds(104, 175, 46, 14);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewLabel_3_2);
		
		
		//BOTAO DE ADD COMPROMISSO
		JButton addcomp = new JButton("ADICIONAR");
		addcomp.setBounds(10, 243, 129, 47);
		addcomp.setFont(new Font("Tahoma", Font.BOLD, 11));
		addcomp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hc, mc, hf, mf;
				try {
					hc = Integer.parseInt(horacomeco.getText());
					mc = Integer.parseInt(minutocomeco.getText());
					hf = Integer.parseInt(horafim.getText());
					mf = Integer.parseInt(minutofim.getText());
					
					Compromisso c = new Compromisso(nomecomp.getText(), hc, mc, hf, mf);
					u1.setCompromisso(c); //add compromisso

				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Digite valores v�lidos");
				}
				OkFrame fr = new OkFrame();
				fr.show();
			}
		});
		frame.getContentPane().add(addcomp);
		
		
		JButton btnNewButton_1 = new JButton("CRONOMETRO");
		btnNewButton_1.setBounds(10, 326, 327, 71);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cronometro crono = new Cronometro();
				crono.show();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PRINT");
		btnNewButton_2.setBounds(346, 29, 327, 62);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xyz = "";
				xyz = "Lista de compromissos: \n"+u1.getStringC()+"\nLista de tarefas: \n"+u1.getStringT();
				JTextArea tf = new JTextArea();
				tf.setLayout(null);
				tf.setVisible(true);
				tf.setText(xyz);
				frame.getContentPane().add(tf);
				tf.setBounds(346, 109, 327, 206);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(166, 29, 12, 261);
		frame.getContentPane().add(verticalStrut);
		
		JButton btnNewButton_1_1 = new JButton("INATIVIDADE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ina.callback();
				JOptionPane.showMessageDialog(null, "Voce ficou inativo por: "+i*5+" minutos");
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton_1_1.setBounds(346, 326, 327, 71);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Come\u00E7o:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 85, 66, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fim: ");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(10, 155, 66, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
	}
}
