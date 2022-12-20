package Ejercicio1;

import javax.swing.*;

public class Barra extends SwingWorker<Void,Void> {

    JProgressBar barra;
    JLabel label;
    JTextField texto;
    int contador=0;

    public Barra(JProgressBar barra, JLabel label,JTextField texto) {
        this.barra = barra;
        this.label = label;
        this.texto=texto;
    }

    @Override
    protected Void doInBackground() throws Exception {
        contador=0;
        barra.setMaximum(Integer.parseInt(texto.getText()));
        for (int i = Integer.parseInt(texto.getText()); i >0 ; i--) {
            contador++;
            label.setText("Quedan: "+i+" Segundos");
            barra.setValue(contador);
            if(isCancelled()){
                label.setText("¡¡¡¡SE HA CANCELADO LA CUENTA!!!!");
                break;

            }
            Thread.sleep(1000);




        }
        if (isDone()) {
            label.setText("¡¡¡¡SE HA TERMINADO LA CUENTA!!!!");
        }

        return null;
    }


}
