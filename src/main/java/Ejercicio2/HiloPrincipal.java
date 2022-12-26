package Ejercicio2;

//Borja Rodriguez Jimenez
//Realiza una aplicación de texto que lance dos hilos de forma que el segundo se ejecute mientras dure la ejecución del primero
public class HiloPrincipal implements Runnable{


    @Override
    public void run() {//implementacion del método run
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
        HiloPrincipal hiloPrincipal = new HiloPrincipal();//se crea un objeto HiloPrincipal
        Thread hilo1 = new Thread(hiloPrincipal);//Se crea un Thread de hiloPrincipal

        HiloSecundario tareaAlive = new HiloSecundario(hilo1);//se crea un objeto HiloSecuandario y se le pasa por parametro el Thread hilo1(que necesita para saber si se está ejecutando(el hilo principal) en cada instante)
        Thread hilo2 = new Thread(tareaAlive);//Se crea un Thread de hiloSecundario

        hilo1.start();
        hilo2.start();//se inician los dos hilos.
    }


}
