import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class Archivo {

	//Para leer archivos mas facil
	private FileReader fr;
	private BufferedReader br;

	//Constructor mágico
	public Archivo(String path) {
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException ex) {
			System.out.println("No se encontro el archivo " + path);
			fr = null;
		}
	}

	//Regresa la siguiente linea
	public String getNextLine() {
		try {
			return br.readLine();
		} catch (IOException ex) {
			System.out.println("Error reading file");
			ex.printStackTrace();
		}
		return null;
	}
	
	//Rrgresa verdadaero o falso si ya no hay siguiente linea
	public Boolean isEmpty(){
		try {
			return !br.ready();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}