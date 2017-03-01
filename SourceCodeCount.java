public class SourceCodeCount {
	
	public static void main(String[] args){

		//Crea un nuevo archivo
		Archivo a = new Archivo("./prueba.java", Archivo.Lang.JAVA);
		
		//Itera sobre todos los elementos (lineas) del archivo
		while ( !a.isEmpty() ) {
			System.out.println(a.getNextLine());

		}

	}
}