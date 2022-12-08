package Feedback1;

//Borja Rodriguez Jimenez
//Realiza una aplicación de texto que lance dos hilos de forma que el segundo se ejecute mientras dure la ejecución del primero
public class Ejercicio2 implements Runnable{


    @Override
    public void run() {
        System.out.println("Se está ejecutando el hilo: "+ Thread.currentThread().getName());

    }




    public static void main(String[] args) throws InterruptedException{
//instanciamos el hilo principal que implementa Runnable
        Runnable ejercicio2= new Ejercicio2();


        //se instancian 2 hilos
        Thread hilo1= new Thread(ejercicio2,"HILO1");
        Thread hilo2= new Thread(ejercicio2,"HILO2");


        //iniciamos los dos hilos
        hilo1.start();
        hilo1.sleep(100);// llamamos al método sleep del hilo 1 durante 100ms para asegurarnos de que el hilo2 se lanzará mientras se sigue ejecutando el hilo1
        hilo2.start();






    }


}
