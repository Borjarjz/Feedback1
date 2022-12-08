package Feedback1;

public class Ejercicio3 implements Runnable{


    @Override
    public void run() {
        System.out.println("Se está ejecutando el hilo: "+ Thread.currentThread().getName());


    }


    public static void main(String[] args) throws InterruptedException {
        //inmstanciamos el hilo principal que implementa Runnable
        Runnable ejercicio3= new Ejercicio3();


        //instanciamos los 4 hilos
        Thread hilo1= new Thread(ejercicio3,"HILO1");
        Thread hilo2= new Thread(ejercicio3,"HILO2");
        Thread hilo3= new Thread(ejercicio3,"HILO3");
        Thread hilo4= new Thread(ejercicio3,"HILO4");

hilo1.start();//Se lanza el hilo1
hilo1.join();//Se invoca al metodo Join del hilo 1 que producira que no se continue con la ejecución de las siguientes lineas hasta que el hilo1 haya concluido


        //se hace lo mismo con los demás hilos
hilo2.start();
hilo2.join();

hilo3.start();
hilo3.join();

hilo4.start();
hilo4.join();


    }
}