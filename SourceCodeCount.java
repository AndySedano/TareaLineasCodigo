public class SourceCodeCount {
	
	public static void main(String[] args){
		
		//Crea un nuevo archivo
		Archivo a = new Archivo("./prueba.java");
		//Crea un nuevo contador de lineas
		Loc loc = new Loc();
		loc.setLanguage("./prueba.java");
		//Lineas de codigo
		int lines = 0;
		
		//Itera sobre todos los elementos (lineas) del archivo
		while ( !a.isEmpty() ) {
			if(loc.checkString(a.getNextLine())){
				lines++;
			}
		}
		
		System.out.println(lines);

	}
}