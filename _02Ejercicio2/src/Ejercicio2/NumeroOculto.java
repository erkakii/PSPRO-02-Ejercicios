package Ejercicio2;

public class NumeroOculto extends Thread {

    //Constructo de la clase
    public NumeroOculto() {
        super();
    }

    //Variables estáticas
    public static int numeroOculto;
    private static int comprobacion = 0;

    /**
     * Método que devuelve un valor en dependiendo si el hilo ha encontrado el número o no
     * @param propuesta numero aleatorio que propone el hilo
     * @return si ha acertado no ha acertado o si otro hilo ha acertado antes
     */

     public synchronized static int propuestaNumero(int propuesta) {

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
         //Núemro que propone el hilo
        int numero = (int) (Math.random() * 100 + 1);
        while (propuestaNumero(numero) != -1) {
            //Si devuelve uno significa que el hilo ha acertado y además interrumpe el mismo
            if (propuestaNumero(numero) == 1) {
                System.out.println("Encontrado por el " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
            //Propone un nuevo número
            numero = (int) (Math.random() * (100 + 1));
        }
        //interrupción de todos los hilos
        Thread.currentThread().interrupt();


    }

    public static void main(String[] args) {
         //Número que se tiene que adivinar
        numeroOculto = (int) (Math.random() * 100 + 1);
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

        //Añadimos los nombres a los hilos
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


        //Iniciamos los hilos
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

   /*

   for (int i = 0; i < 10; i++) {
            new NumeroOculto().start();
        }

   synchronized public static int propuestaNumero(int propuesta) {
        int res = 0;
        if (numeroOculto == propuesta) {
            comprobacion = 1;
            Thread.currentThread().interrupt();
        }

        if (acertado) {
            comprobacion = -1;
            Thread.currentThread().interrupt();
        }
        return res;
    }

    @Override
    public void run() {
        int numero = (int) (Math.random() * (100 + 1));
        int res = propuestaNumero(numero);
        while (res == 0){
            numero = (int) (Math.random() * (100 + 1));
            res = propuestaNumero(numero);
            if (propuestaNumero(numero) == 1){
                System.out.println("Encontrado por el hilo " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }

        }
        Thread.currentThread().interrupt();*/


}
