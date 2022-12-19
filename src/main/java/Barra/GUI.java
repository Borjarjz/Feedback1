package Barra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  {

    private JTextField texto;
    private JProgressBar barra;
    private int contador;
    private JButton cancelar;
    private JLabel etiqueta;
    JFrame frame =new JFrame("GUI");
    JButton cuentaatras;
    JPanel panel;
    private int numCuentaatras;
    private TareaBarra tarea;






    public GUI() {

        barra=new JProgressBar();
        barra.setValue(0);
        barra.setStringPainted(true);
        etiqueta=new JLabel();
        panel=new JPanel();
        cancelar=new JButton("Cancelar");
        cuentaatras=new JButton("Cuenta Atrás");
        texto=new JTextField(2);





        texto.setBounds(100,20,165,25);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
        panel.setLayout(new GridLayout(0,1));
        panel.add(texto);

        panel.add(cuentaatras);
        panel.add(etiqueta);
        panel.add(barra);



        panel.add(cancelar);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);






        cuentaatras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cuentaatras();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
    }

    private void cancelar() {
        System.out.println("cancelar");
        //tarea.execute();
        tarea.cancel();
    }

    private void cuentaatras() throws Exception {

       // tarea.execute();
        tarea.doInBackground();
    }

   /* public GUI() {
        frame =new JFrame("Ejercicio1");
        barra=new JProgressBar();
        barra.setValue(0);
        barra.setStringPainted(true);
        etiqueta=new JLabel();
        panel=new JPanel();
        cancelar=new JButton("Cancelar");
        cuentaatras=new JButton("Cuenta Atrás");
        texto=new JTextField(2);


        cancelar.addActionListener(this);
        cuentaatras.addActionListener(this);
        texto.addActionListener(this);


        texto.setBounds(100,20,165,25);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
        panel.setLayout(new GridLayout(0,1));
        panel.add(texto);

        panel.add(cuentaatras);
        panel.add(etiqueta);
        panel.add(barra);



        panel.add(cancelar);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/

    public static void main(String[] args) {
        GUI a= new GUI();
        TareaBarra tarea=new TareaBarra(a.etiqueta.toString(),Integer.parseInt(a.texto.getText()));
    }

   /* @Override

    public void actionPerformed(ActionEvent e) {
        TareaBarra tarea=new TareaBarra();

        if (e.getActionCommand()=="Cancelar") {
            tarea.cancel();
            System.out.println("cancelar");


        }else if(e.getActionCommand()=="Cuenta Atrás"){
            try {
                tarea.doInBackground();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("cuenta atras");




        }
    }*/
}
