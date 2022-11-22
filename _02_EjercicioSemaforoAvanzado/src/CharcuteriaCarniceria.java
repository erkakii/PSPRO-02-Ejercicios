import java.util.concurrent.Semaphore;

public class CharcuteriaCarniceria implements Runnable {


    //Creamos los semáforos
    public static Semaphore smfrCarniceria = new Semaphore(20);
    public static Semaphore smfrCharcuteria = new Semaphore(10);

    //Variables que comprobarán si el hilo ha terminado o no
    private boolean finCarniceria =false;
    private boolean finCharcuteria =false;

    private int id;

    //Constructor
    public CharcuteriaCarniceria(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método con el que los hilos "entran" a la carnicería
     */
    public void carniceria() {
        try {
            smfrCarniceria.acquire();
            System.out.println(Thread.currentThread().getName() + " entra en la carnicería");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " ha terminado en la carnicería");
            smfrCarniceria.release();
        } catch (InterruptedException interruptedException) {
            System.err.println("Error: " + interruptedException);
        }
    }

    /**
     * Método con el que los hilos entran en la charcutería
     */
    public void charcuteria() {
        try {
            smfrCharcuteria.acquire();
            System.out.println(Thread.currentThread().getName() + " entra en la charcutería");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " ha terminado en la charcutería");
            smfrCharcuteria.release();
        } catch (InterruptedException interruptedException) {
            System.err.println("Error: " + interruptedException);
        }
    }


    @Override
    public void run() {
        while(!finCarniceria || !finCharcuteria) { //Mientras no haya acabado en la charcutería o en la carniceria
            if(smfrCarniceria.availablePermits()>0 && !finCarniceria) { //Entra en la carniceria
                carniceria();
                finCarniceria = true;
            }
            if (smfrCharcuteria.availablePermits()>0 && !finCharcuteria) { //Si no entra en la charcuteria
                charcuteria();
                finCharcuteria = true;
            }
        }
    }

    public static void main(String[] args) {
        //Crea los nuevos hilos y les da las prioridades
        for(int i=1;i<=10;i++) {
            Thread hilo = new Thread(new CharcuteriaCarniceria(i));
            hilo.setName("Hilo"+i);
            hilo.setPriority(i/9+1);
            hilo.start();
        }

    }



}