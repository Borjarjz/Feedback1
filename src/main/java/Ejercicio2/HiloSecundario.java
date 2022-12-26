package Ejercicio2;

public class HiloSecundario implements Runnable{
    private Thread otroHilo;//variable que almacena el hilo principal


    public HiloSecundario(Thread otroHilo) {
        this.otroHilo = otroHilo;
    }


    @Override
    public void run() {//se sobreeescribe la clase run, se comprueba que el hiloPrincipal esta en ejecución y se imprime por pantalla un mensaje cada 0'5 segundos
        while (otroHilo.isAlive()) {
            System.out.println("Yo ( "+Thread.currentThread().getName()+") hago cosas mientras el hilo: "+otroHilo.getName()+" siga en ejecución");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("El hilo"+otroHilo.getName()+" ha terminado. Por tanto yo: ("+Thread.currentThread().getName()+" ) también");//cuando termina el hilo principal, tambien termina el hilo secundario y se imprime un mensaje
    }

}
