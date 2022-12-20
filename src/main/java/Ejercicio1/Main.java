/*
 *   Realiza una aplicación en la que se muestre, mediante una barra de progreso y una etiqueta de texto, la cuenta atrás desde una cantidad de segundos introducida por el usuario. En cualquier momento éste podrá cancelar la cuenta:
 *       1 La tarea se lanzará en segundo plano una vez el usuario pulse el botón
 *       2 La tarea mantendrá la cuenta atrás de los segundos que el usuario haya introducido
 *       3 El usuario podrá cancelar la tarea en cualquier momento
 *       4 Se mostrará el progreso en una barra de progreso y como texto en una etiqueta
 *       5 Cuando la tarea termine mostrará un mensaje en una ventana emergente
 *
 *      BORJA RODRIGUEZ JIMENEZ
 * */


package Ejercicio1;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static BarraProgreso segundoplano;

    public static void main(String args[]) {
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);

        JButton empezar = new JButton("Empezar");
        JButton cancelar = new JButton("Cancelar");
        JLabel label=new JLabel("Introduzca un numero para hacer la cuenta atrás:");
        JTextField texto=new JTextField();


        segundoplano = new BarraProgreso(barra, label, texto);


        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {




                    if (e.getActionCommand() == "Empezar") {
                        segundoplano.execute();

                    }
                    if (e.getActionCommand() == "Cancelar") {

                        segundoplano.cancel(true);

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
