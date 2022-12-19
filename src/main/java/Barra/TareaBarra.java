package Barra;

import javax.swing.*;

public class TareaBarra extends SwingWorker<String, Integer> {

    private String label;
    private Integer porciento;

    public TareaBarra(String label,Integer porciento){

    }
    @Override
    protected String doInBackground() throws Exception {
        System.out.println("holi");
        int contador=0;

        for (int i = porciento; i >0 ; i--) {
            contador++;
            label="Quedan: " + i + " Segundos";
            //barra.setValue(contador);



            Thread.sleep(1000);
            return label;
        }
        return "Finalizada la cuenta";
    }

    public void cancel() {

    }


}
