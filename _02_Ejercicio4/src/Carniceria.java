import java.util.concurrent.Semaphore;

public class Carniceria implements Runnable {


    //Creamos el semaforo
    public static Semaphore semaforo = new Semaphore(4);

    private boolean terminado = false;

    //Contructor
    public Carniceria() {
        super();
    }

    //El hilo entra en la carnicería y termina en un tiempo aleatorio entre 1 y 10 segundos
    public void carniceria() {
        try {
            semaforo.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " entrado en la carniceria");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la carniceria");
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!terminado) { //Mientras no haya termiando
            if (semaforo.availablePermits() > 0 && !terminado) { //Si hay espacio y no ha terminado entra
                carniceria();
                terminado = true;
            }
        }
    }

    public static void main(String[] args) {
        //Crea los nuevos hilos le asigna una prioridad
        for (int i = 1; i <= 10; i++) {
            Thread hilo = new Thread(new Carniceria());
            hilo.setName("Cliente" + i);
            hilo.setPriority(i / 9 + 1);
            hilo.start();
        }
    }
}