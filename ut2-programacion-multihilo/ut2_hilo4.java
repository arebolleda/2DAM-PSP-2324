
public class Hilo4 extends Thread {
	
  // Método run -> funcionalidad del hilo: muestra detalles del hilo
  public void run() {
     System.out.println(
  	   "Dentro del Hilo  : " + Thread.currentThread().getName() + 
 	   "\n\tPrioridad    : " + Thread.currentThread().getPriority() + 
       "\n\tID           : " + Thread.currentThread().getId() +	  	  
       "\n\tHilos activos: " + Thread.currentThread().activeCount());
  }
  //
  public static void main(String[] args) {
	
    //El método principal main también es un Hilo!!!
	Thread.currentThread().setName("Este es el Hilo Principal ...");
    //Método Thread.currentThread().getName() -> devuelve el nombre del Hilo
    System.out.println(Thread.currentThread().getName());
    //Método Thread.currentThread().toString() -> devuelve un string que representa al hilo: Thread [nombre_hilo, prioridad, grupo hilos]
	System.out.println(Thread.currentThread().toString());		
	  
	
	Hilo4 h = null;	
	
	for (int i = 1; i < 4; i++) {
	  h = new Hilo4(); //creamos hilo
	  h.setName("Hilo número "+i);    //damos nombre al hilo
	  h.setPriority(i+1);     //damos prioridad
	  h.start();              //iniciamos hilo	  
	  
	  System.out.println(
		"Informacion del " + h.getName() + ": "+ h.toString());	  
      }
	System.out.println("3 HILOS CREADOS...");	
	System.out.println("Hilos activos: " +Thread.activeCount());	
  }//
  
}// Hilo4
