package Ejercicio2;

public class NumeroOculto extends Thread {

    public NumeroOculto() {
        super();
    }
    public static int numeroOculto;
    private static int comprobacion = 0;
    synchronized public static int propuestaNumero(int propuesta) {

        if (comprobacion == 1) {
            comprobacion = -1;
        }

        if (numeroOculto == propuesta) {
            comprobacion = 1;
        }

        return comprobacion;
    }

    @Override
     public void run() {
        int numero = (int) (Math.random() * (100 + 1));
            while (propuestaNumero(numero) != -1){
                if (propuestaNumero(numero) == 1){
                    System.out.println("Encontrado por el hilo " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
                numero = (int) (Math.random() * (100 + 1));
            }
            Thread.currentThread().interrupt();



    }

    public static void main(String[] args) {
        numeroOculto = (int) (Math.random() * (100 + 1));
        NumeroOculto hilo1 = new NumeroOculto();
        NumeroOculto hilo2 = new NumeroOculto();
        NumeroOculto hilo3 = new NumeroOculto();
        NumeroOculto hilo4 = new NumeroOculto();
        NumeroOculto hilo5 = new NumeroOculto();
        NumeroOculto hilo6 = new NumeroOculto();
        NumeroOculto hilo7 = new NumeroOculto();
        NumeroOculto hilo8 = new NumeroOculto();
        NumeroOculto hilo9 = new NumeroOculto();
        NumeroOculto hilo10 = new NumeroOculto();

        hilo1.setName("hilo1");
        hilo2.setName("hilo2");
        hilo3.setName("hilo3");
        hilo4.setName("hilo4");
        hilo5.setName("hilo5");
        hilo6.setName("hilo6");
        hilo7.setName("hilo7");
        hilo8.setName("hilo8");
        hilo9.setName("hilo9");
        hilo10.setName("hilo10");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        hilo10.start();

    }
}