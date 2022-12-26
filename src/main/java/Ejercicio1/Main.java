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

    static BarraProgreso segundoplano;//se define un objeto BarraProgreso(que hereda de SwingWorker) que almacenará los cambio en la progressbar y los ira actualizando en timepo real(en segundo plano)

    public static void main(String args[]) {//método MAIN, se definen aspectos de la interfaz grafica
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);

        JButton empezar = new JButton("Empezar");
        JButton cancelar = new JButton("Cancelar");
        JLabel label=new JLabel("Introduzca un numero para hacer la cuenta atrás:");
        JTextField texto=new JTextField();


        segundoplano = new BarraProgreso(barra, label, texto);//se instancia un objeto BarraProgreso




        ActionListener actionListener = new ActionListener() {//actionListener para realizar acciones al clickar los botones Empezar y Cancelar
            public void actionPerformed(ActionEvent e) {




                    if (e.getActionCommand() == "Empezar") {//si se pulsa EmpezaR, se ejecuta el metodo doInBackground de la clase BarraProgreso

                        segundoplano.execute();

                    }
                    if (e.getActionCommand() == "Cancelar") {//Al pulsar cancelar, se llama al metodo cancel de la clase BarraProgreso(heredado de SwingWorker)

                        segundoplano.cancel(true);
                        barra.setValue(0);//se devuelve la barra de progreso a 0
                        label.setText("Se ha cancelado la cuenta!!!");// se escribe el mensaje de cancelación en el label

                    }


            }
        };

        empezar.addActionListener(actionListener);//se añaden los action listener a los botones
        cancelar.addActionListener(actionListener);


//Se definen más aspecto de la interfaz grafica.
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
