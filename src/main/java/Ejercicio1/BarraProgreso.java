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

public class BarraProgreso extends SwingWorker<Void,Void> {//Clase barra progreso que hereda de SwingWorker


    //Variables que se necesitan para almacenar los cambios que se producen en timepo real en segundo plano
    JProgressBar barra;
    JLabel label;
    JTextField texto;
    int contador=0;

    public BarraProgreso(JProgressBar barra, JLabel label, JTextField texto) {//constructor de BarraProgreso
        this.barra = barra;
        this.label = label;
        this.texto=texto;
    }

    @Override
    protected Void doInBackground() throws Exception {//Metodo doInBackground sobreescrito. cuando se lanza la tarea en segundo plano, se realiza la cuenta atrás de la cantida indicada
        contador=0;//contador para actualizar el progreso en la ProgressBar
        barra.setMaximum(Integer.parseInt(texto.getText()));//se establece el maximo de la barra de progreso

                    for (int i = Integer.parseInt(texto.getText()); i >=0 ; i--) {//bucle for que cuenta regresivamente
                        contador++;
                        label.setText("Quedan: "+i+" Segundos");// se actualiza el label con la cantidad de segundos restante
                        barra.setValue(contador); //se avanza la barra de progreso


                            Thread.sleep(1000);// se espera 1 segundo.

                    }
                    avisoFin();// método avisoFin que genera la ventana emergente que se pide al finalizar la cuenta.
        return null;
    }

    private void avisoFin() {//método avisoFin que genera la ventana emergente que se pide al finalizar la cuenta.
        JFrame frameaviso = new JFrame("aviso");
        JLabel labelaviso=new JLabel("¡¡¡SE HA TERMINADO LA CUENTA!!!");
        frameaviso.setLayout(new GridLayout(0,1));
        frameaviso.setSize(300, 200);
        frameaviso.add(labelaviso);
        frameaviso.setVisible(true);
        frameaviso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
