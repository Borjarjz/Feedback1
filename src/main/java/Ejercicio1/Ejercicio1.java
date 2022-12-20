package Ejercicio1;
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
import java.util.List;

public class Ejercicio1 extends SwingWorker<Void,Void> implements ActionListener {


   private JTextField texto;
    private JProgressBar barra;
    private int contador;
    private JButton cancelar;
    private JLabel etiqueta;
    JFrame frame ;
    JButton cuentaatras;
    JPanel panel;
    private int numCuentaatras;

    public Ejercicio1() {//constructor



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
    }

    @Override
   protected Void doInBackground() throws Exception {
        contador=0;

                for (int i = Integer.parseInt(texto.getText()); i >0 ; i--) {

                    contador++;
                    etiqueta.setText("Quedan: "+i+" Segundos");
                    barra.setValue(contador);
                    etiqueta.setEnabled(true);
                    System.out.println(i);
                    Thread.sleep(1000);

                }

                if(isCancelled()){

                    etiqueta.setText("¡¡¡¡SE HA CANCELADO LA CUENTA!!!!");
                } else if (isDone()) {
                    etiqueta.setText("¡¡¡¡SE HA TERMINADO LA CUENTA!!!!");
                }


        return null;
    }

    @Override protected void done()
    {
        //Cuando acabe.
    }


    public void contar() throws InterruptedException {





    }






    public static void main(String[] args) {



        new Ejercicio1().execute();




            }
















    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand()=="Cancelar") {

            this.isCancelled();


        }else if(e.getActionCommand()=="Cuenta Atrás"){


            this.numCuentaatras= Integer.parseInt(texto.getText());
            this.barra.setMinimum(0);
            this.barra.setMaximum(Integer.parseInt(texto.getText()));


            try {
                doInBackground();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
