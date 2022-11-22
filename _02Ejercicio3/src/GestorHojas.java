import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorHojas extends Thread {

	//Cambiamos el arrayList por una lista en la que acceden los hilos de uno en uno
	private volatile static CopyOnWriteArrayList<String> lista = new CopyOnWriteArrayList<>();

	@Override
	public void run() {
		//Añadimos el texto al array
		for (int i = 0; i < 10; i++) {
			lista.add(new String("Texto" + i));
		}

		//Recorre el array
		for (String string : lista) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		//Creamos e iniciamos los hilos
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}


	}


}
