package cl.tecnova.qa.curso_de_java;

public class Principal {

	public static void main(String[] args) {

	/*	int var1 = 1;
		//int var2 = 2;
		if(var1== 1) {
			System.out.println("si es 1");
		}else {
			System.out.println("no es 1");
		}
						for (int i = 0; i<=5; i++) {
			System.out.println("el contador es : " + i ); 
		}	
		
			while( var1 <3) {
				System.out.println("el valor de la variable: "+var1 );
				var1++;
						}
				*/
	
			Gato Gato1 = new Gato();
			Gato1.nombreDelGato();
			System.out.println("el valor de la variable: " + Gato1.nombreDelGato());
	
	}

}
