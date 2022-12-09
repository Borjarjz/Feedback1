package Ejercicio2;

//Borja Rodriguez Jimenez
//Realiza una aplicación de texto que lance dos hilos de forma que el segundo se ejecute mientras dure la ejecución del primero
public class HiloPrincipal implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("EJECUTANDO EL HILO PRINCIPAL");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }



    public static void main(String[] args) throws InterruptedException{
        HiloPrincipal hiloPrincipal = new HiloPrincipal();
        Thread hilo1 = new Thread(hiloPrincipal);

        HiloSecundario tareaAlive = new HiloSecundario(hilo1);
        Thread hilo2 = new Thread(tareaAlive);

        hilo1.start();
        hilo2.start();
    }


}
