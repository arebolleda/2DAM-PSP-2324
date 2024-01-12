class Contador2 {
	private int c = 0;

	Contador2(int c) {
		this.c = c;
	}

	public void incrementa() {
		c = c + 1;
	}

	public void decrementa() {
		c = c - 1;
	}

	public int getValor() {
		return c;
	}

}// CONTADOR

class HiloA2 extends Thread {
	private Contador2 contador;

	public HiloA2(String n, Contador2 c) {
		setName(n);
		contador = c;
	}

	public void run() {
                // Bloque synchronized sobre objeto "contador"
        // Cada vez que un hilo intenta acceder a bloque sincronizado le pregunta al objeto si no hay ningún otro hilo que lo tenga ya bloqueado
        // Si el objeto está tomado por otro hilo -> hilo actual se suspende y se pone en espera hasta que se libere el bloqueo
        // Si el objeto está libre -> hilo actual bloquea el objeto y ejecuta
        // El bloqueo del objeto se libera cuando el hilo que lo tiene tomado termina su ejecución, ejecuta un return o se lanza excepción
        // Objeto "contador actua como "cerrojo" (lock) -> región o sección crítica: zona protegida por el cerrojo
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.incrementa();
				/*try {
					sleep(100);
				} catch (InterruptedException e) {}*/
				
			}
			System.out.println(getName() + " contador vale "
					+ contador.getValor());
		}

	}
}// HILOA

class HiloB2 extends Thread {
	private Contador2 contador;

	public HiloB2(String n, Contador2 c) {
		setName(n);
		contador = c;
	}

	public void run() {

        // Bloque synchronized sobre objeto "contador"
        // Cada vez que un hilo intenta acceder a bloque sincronizado le pregunta al objeto si no hay ningún otro hilo que lo tenga ya bloqueado
        // Si el objeto está tomado por otro hilo -> hilo actual se suspende y se pone en espera hasta que se libere el bloqueo
        // Si el objeto está libre -> hilo actual bloquea el objeto y ejecuta
        // El bloqueo del objeto se libera cuando el hilo que lo tiene tomado termina su ejecución, ejecuta un return o se lanza excepción
        // Objeto "contador actua como "cerrojo" (lock) -> región o sección crítica: zona protegida por el cerrojo

		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.decrementa();
				/*try {
					sleep(100);
				} catch (InterruptedException e) {}*/
				
			}
			System.out.println(getName() + " contador vale "
					+ contador.getValor());
		}
	}
}// HILOB

//El problema anterior se resuelve con "synchronized (contador)"
// Las operaciones de incremento/decremento sobre el objeto "contador" NO son atómicas. 
// Es decir, nos tenemos que asegurar mientras se hagan operaciones de incremento no se hagan operaciones de decremento y viceversa.
// Java utiliza bloques synchronized para establecer regiones críticas

public class HiloSincro2 {
	public static void main(String[] args) {
		Contador2 cont = new Contador2(100);
		HiloA2 a = new HiloA2("HiloA", cont);
		HiloB2 b = new HiloB2("HiloB", cont);
		a.start();		
		b.start();
		
	}
}
