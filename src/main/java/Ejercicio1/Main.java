package Ejercicio1;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static Barra segundoplano;

    public static void main(String args[]) {
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);

        JButton empezar = new JButton("Empezar");
        JButton cancelar = new JButton("Cancelar");
        JLabel label=new JLabel("Introduzca un numero para hacer la cuenta atrás:");
        JTextField texto=new JTextField();





        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    segundoplano = new Barra(barra, label, texto);
                    segundoplano.execute();

                    if (e.getActionCommand() == "Empezar") {
                        //segundoplano.doInBackground();
                    }
                    if (e.getActionCommand() == "Cancelar") {

                        segundoplano.cancel(true);

                    }
                }catch(Exception eu){
                    throw new RuntimeException(eu);
                }

            }
        };

        empezar.addActionListener(actionListener);
        cancelar.addActionListener(actionListener);


        //frame.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
        frame.setLayout(new GridLayout(0,1));
        frame.add(label);
        frame.add(texto);

        frame.add(barra);
        frame.add(empezar);
        frame.add(cancelar);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
