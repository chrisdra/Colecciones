package Metodo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.Persona;

public class ArchivoExcel {

	public ArrayList<Persona> leer(){
		
		ArrayList<Persona> listap = new ArrayList<Persona>();
		String csvFile = "datos.csv";
		BufferedReader br = null;
		String line = "";
		int monto;
		
		String cvsSplitby = ",";
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) !=null) {
				String[] datos = line.split(cvsSplitby);
				monto = Integer.parseInt(datos[3].toString());
				listap.add(new Persona(datos[0],datos[1],datos[2],monto));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listap;
	}
	
	
}
