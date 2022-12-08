package Feedback1;
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





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 implements ActionListener,Runnable{




    public Ejercicio1() {//constructor



        JFrame frame =new JFrame("Ejercicio1");
        JPanel panel=new JPanel();
        JButton cancelar=new JButton("Cancelar");
        JButton cuentaatras=new JButton("Cuenta Atrás");
        JTextField texto=new JTextField(20);


        cancelar.addActionListener(this);
        texto.setBounds(100,20,165,25);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
        panel.setLayout(new GridLayout(0,1));
        panel.add(cancelar);
        panel.add(texto);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }








    public static void main(String[] args) {
        new Ejercicio1();
    }












    @Override
    public void run() {

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand()=="Cancelar") {
            System.exit(0);
        }
    }
}
