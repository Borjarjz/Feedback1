package Ejercicio2;

public class HiloSecundario implements Runnable{
    private Thread otroHilo;


    public HiloSecundario(Thread otroHilo) {
        this.otroHilo = otroHilo;
    }


    @Override
    public void run() {
        while (otroHilo.isAlive()) {
            System.out.println("Yo ( "+Thread.currentThread().getName()+") hago cosas mientras el hilo: "+otroHilo.getName()+" siga en ejecución");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("El hilo"+otroHilo.getName()+" ha terminado. Por tanto yo ("+Thread.currentThread().getName()+" ) también");
    }

}
