public class HilosDurmientes extends Thread { //Heredamos de la clase Thread

    public HilosDurmientes(){ //Añadimos el constructor del padre al constructor de nuestra clase
        super();
    }

    @Override
    public void run(){

        //Creamos el bucle infinito
        while (true){
            //Hacemos un número aleatorio que irá desde 1000 hasta 10000
            double random =  Math.random() * (10000 - 1000 + 1) + 1000;
            //Ponemos la frase de que está trabajando
            System.out.println("Hola soy el hilo " + Thread.currentThread().getName() + " y estoy trabajando");
            //Mostramos cuanto tiempo estará durmiendo ese hilo
            System.out.println("Hola soy el hilo " + Thread.currentThread().getName() + " y me voy a dormir " + (int) random + " milisegundos");
            try {
                //Mandamos a dormir al hilo
                Thread.sleep((long) random);
            } catch (InterruptedException interruptedException) {
                System.err.println(interruptedException.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        //Creamos los 5 hilos
        HilosDurmientes hilo1 = new HilosDurmientes();
        HilosDurmientes hilo2 = new HilosDurmientes();
        HilosDurmientes hilo3 = new HilosDurmientes();
        HilosDurmientes hilo4 = new HilosDurmientes();
        HilosDurmientes hilo5 = new HilosDurmientes();

        //Le asignamos un nombre a los hilos
        hilo1.setName("Hilo1");
        hilo2.setName("Hilo2");
        hilo3.setName("Hilo3");
        hilo4.setName("Hilo4");
        hilo5.setName("Hilo5");

        //Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();


    }
}