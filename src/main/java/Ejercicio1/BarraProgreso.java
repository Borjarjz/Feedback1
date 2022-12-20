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

public class BarraProgreso extends SwingWorker<Void,Void> {

    JProgressBar barra;
    JLabel label;
    JTextField texto;
    int contador=0;

    public BarraProgreso(JProgressBar barra, JLabel label, JTextField texto) {
        this.barra = barra;
        this.label = label;
        this.texto=texto;
    }

    @Override
    protected Void doInBackground() throws Exception {
        contador=0;
        barra.setMaximum(Integer.parseInt(texto.getText()));
        for (int i = Integer.parseInt(texto.getText()); i >=0 ; i--) {
            contador++;
            label.setText("Quedan: "+i+" Segundos");
            barra.setValue(contador);

            if(isCancelled()){
                Thread.sleep(1);
                label.setText("¡¡¡¡SE HA CANCELADO LA CUENTA!!!!");

                break;
                //contador=0;

            }


                Thread.sleep(1000);






        }








        return null;
    }



}
