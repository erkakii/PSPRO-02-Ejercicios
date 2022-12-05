import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {

    private boolean [] tenedores;

    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzq(int i){
        return i;
    }

    public int tenedorDerecha(int i){
        int devolucion;
        if(i == 0){
            devolucion = this.tenedores.length - 1;
        }else {
            devolucion = i - 1;
        }
        return devolucion;
    }


    public synchronized void cogerTenedores (int comensal){
        while (tenedores[tenedorIzq(comensal)] || tenedores[tenedorDerecha(comensal)]){
            try {
                wait();
            }catch (InterruptedException interruptedException){
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, interruptedException);
            }
        }

        tenedores[tenedorIzq(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }


    public synchronized void soltarTenedores (int comensal){
        tenedores[tenedorIzq(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        notifyAll();
    }
}
