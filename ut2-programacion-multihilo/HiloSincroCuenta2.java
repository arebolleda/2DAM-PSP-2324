class Cuenta2 {
	private int saldo ;
	Cuenta2 (int s) { saldo = s; }
	
	int getSaldo() { return saldo; }
	void restar(int cantidad) { saldo=saldo-cantidad; }
	
    // El método "RetirarDinero" debe ser atómico -> región crítica: si una persona está sacando dinero, 
    //la otra no debería poder sacarlo hasta que la primera haya finalizado la operación.

    // Solución: declarar el método "RetirarDinero" como "synchronized"
    // Cuando hilo invoca método "RetirarDinero":
    //      -> si está libre => lo toma (bloquea) y lo ejecuta
    //      -> si no está libre => se suspende hasta que el hilo lo tiene bloqueado finalice y lo libere
	synchronized void RetirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println(nom+" va a sacar 10€ -> Saldo Actual cuenta = "+getSaldo());
			try {
				Thread.sleep(40000);
			} catch (InterruptedException ex) {	}
			
			restar(cant);		
			
			System.out.println("\t"+ nom+ " retira -> "+cant + " ACTUAL("+getSaldo()+")" );	
		} else {
			System.out.println(nom+ " No puede retirar dinero, NO HAY SALDO("+getSaldo()+")" );
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO -> "+getSaldo());
		}
		
	}//retirar
}

class SacarDineroCajero2 extends Thread {
	private Cuenta2 c;
	String nom;
	public SacarDineroCajero2 (String n, Cuenta2 c) {		
		super(n);
		this.c = c;
	}
	public void run() {		
		for (int x = 1; x<= 4; x++) {		
			c.RetirarDinero(10, getName());			
		}		
	}// run
	
}
public class HiloSincroCuenta2 {
	public static void main(String[] fer) {
		Cuenta2 c = new Cuenta2(40);
		SacarDineroCajero2 h1 = new SacarDineroCajero2("Ana", c);
		SacarDineroCajero2 h2 = new SacarDineroCajero2("Juan", c);

		h1.start();
		h2.start();
	}
}
