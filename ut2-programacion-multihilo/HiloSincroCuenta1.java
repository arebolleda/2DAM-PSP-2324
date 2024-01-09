// Clase cuenta bancaria
class Cuenta {
	
    private int saldo ;
	
    Cuenta (int s) 
    {
        saldo = s;
    }
	
	int getSaldo() 
    {
        return saldo;
    }

	void restar(int cantidad)
    {
        saldo=saldo-cantidad;
    }
	
	void RetirarDinero(int cant, String nom) {	
		if (getSaldo() >= cant) {
			System.out.println(nom+" va a sacar 10€ -> Saldo Actual cuenta = "+getSaldo());
			try {
				Thread.sleep(40000);
			} catch (InterruptedException ex) {	}
			
			restar(cant);	// Se anota la retirada de dinero
			System.out.println("\t"+nom+ " retira -> "+cant + " Saldo Actual cuenta = "+getSaldo());	
		} else {
			System.out.println(nom+ " No puede retirar dinero, NO HAY SALDO("+getSaldo()+")" );
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO -> "+getSaldo());
		}		
	}//retirar
}

class SacarDineroCajero extends Thread {
	private Cuenta c;	
	public SacarDineroCajero(String n, Cuenta c) {		
		super(n);
		this.c = c;
	}
	public  void run() {		
		for (int x = 1; x<= 4; x++) {		
			c.RetirarDinero(10, getName());			
		}		
	}// run	
}

public class HiloSincroCuenta1 {
	public static void main(String[] args) {
		Cuenta c = new Cuenta(40);
		SacarDineroCajero h1 = new SacarDineroCajero("Ana", c);
		SacarDineroCajero h2 = new SacarDineroCajero("Juan", c);

		h1.start();
		h2.start();
	}
}
