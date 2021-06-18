package cronometro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JFrame{

  JLabel contagemTempo;
  JFrame janela;
  JPanel painel;
  JButton btIniciar;
  JButton btReset;

  Timer tm;
  Integer contador = 0;
  boolean running = false;

  final int fontsize = 100;
  final int timetick = 1000;
  
  public Cronometro() {
	  init();
  }

  public void init() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame janela = new JFrame("Cronometro");
    JPanel painel = new JPanel();
    btIniciar = new JButton("Iniciar");
    btReset = new JButton("Reset");

    janela.setSize(300,200);
    janela.setAlwaysOnTop(true);
    janela.setVisible(true);
    //janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    janela.setLayout(new BorderLayout());

    JLabel contagemTempo = new JLabel("00:00:00");
    contagemTempo.setFont(new Font(contagemTempo.getName(), Font.PLAIN, fontsize));
    janela.add(contagemTempo, BorderLayout.CENTER);

    painel.setLayout(new GridLayout(2, 1));
    
    janela.getContentPane().add(contagemTempo);

    btIniciar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!running) {
          btReset.setText("Parar");

          // contagemTempo.setText("00:00:00");
          tm = new Timer();
          tm.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
              contador++;
              int seg = contador % 60;
              int min = contador / 60;
              int hora = min / 60;
              min %= 60;
              contagemTempo.setText(String.format("%02d:%02d:%02d", hora,min,seg));
            }
          }, timetick, timetick);
          running = true;
        }
      }
    });

    btReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (running) {
          tm.cancel();
          running = false;

          btReset.setText("Reset");  // when running, if you click btReset, it only stops the clock
        } else {
          // if the clock is stopped, then this button resets the chronometer
          tm.cancel();
          running = false;

          contador = 0;
        }
      }
    });

    painel.add(btIniciar);
    painel.add(btReset);

    janela.add(painel,BorderLayout.EAST);

    janela.pack();
    janela.setVisible(true);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
        	new Cronometro();
        }catch (Exception e) {
        	e.printStackTrace();
        }
      }
    });
  }

}