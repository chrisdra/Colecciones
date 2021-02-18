package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Metodo.ArchivoExcel;
import Modelo.Persona;

public class Main {

	public static void main(String[] args) {
		
		List<String> nombre = new ArrayList<String>();
		List<String> correo = new ArrayList<String>();
		Set<String> ciudad = new HashSet<>();
		List<Integer> monto = new ArrayList<Integer>();
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		//se crea persona con sus respectivos atributos
		ArchivoExcel ex = new ArchivoExcel();
		personas = ex.leer();
		
		//se traspasa los datos de las personas a las listas correspondientes
		for (Persona per : personas) {
			nombre.add(per.getNombre());
			correo.add(per.getCorreo());
			ciudad.add(per.getCiudad());
			monto.add(per.getMonto());
		}
		
		// Comienza la busqueda seleccionando cual buscar primero
		buscarGiselleMarshall(nombre, personas);
		buscarCorreoImperdiet(correo, personas);
		contarCiudades(ciudad);
		correosElite (correo);
		MultiplicarMontos(monto);
		PromedioMontos(monto);
		menorMonto(monto, personas);
		mayorMonto(monto, personas);
		
	}
	
	//Buscando a Giselle Marshall
	public static void buscarGiselleMarshall (List<String> nombre, ArrayList<Persona> personas ) {
		
		System.out.println("Vamos a obtener los datos de Giselle Marshall" + "\n");
		if (nombre.contains("Giselle Marshall")) {
			int i = nombre.indexOf("Giselle Marshall");
			
			System.out.println("nombre: " + personas.get(i).getNombre());
			System.out.println("correo: " + personas.get(i).getCorreo());
			System.out.println("ciudad: " + personas.get(i).getCiudad());
			System.out.println("monto: " + personas.get(i).getMonto());
			System.out.println(" " + "\n");
		}
	}
	
	//Buscando correo imperdiet.non@enim.org
	public static void buscarCorreoImperdiet (List<String> correo, ArrayList<Persona> personas ) {
		
		System.out.println("Vamos a obtener los datos a traves del correo imperdiet.non@enim.org" + "\n");
		if (correo.contains("imperdiet.non@enim.org")) {
			int i = correo.indexOf("imperdiet.non@enim.org");
			
			System.out.println("nombre: " + personas.get(i).getNombre());
			System.out.println("correo: " + personas.get(i).getCorreo());
			System.out.println("ciudad: " + personas.get(i).getCiudad());
			System.out.println("monto: " + personas.get(i).getMonto());
			System.out.println(" " + "\n");
		}
	}
	
	//Total de ciudades no repetidas
	public static void contarCiudades (Set<String> ciudad) {
		
		System.out.println("Ciudades no repetidas: "+ciudad.size()+"\n");
		//ciudad.forEach(System.out::println);
	}
	
	//Buscando correos con la palabra elite
	public static void correosElite (List<String> correo) {
		
		System.out.println("Correos con la siglas elit"+"\n");
		correo.stream().filter(correos -> correos.contains("elit")).forEach(System.out::println);
		System.out.println(" ");
		int cont = 0;
		for (String buscar : correo) {
			if(buscar.contains("elit")) {
				cont++;
			}
		}
		System.out.println("Total correos con elit: "+cont+"\n");
	}
	
	//Se multiplicaran los montos por 3 y se buscaran los mayores a 29000
	public static void MultiplicarMontos (List<Integer> monto) {
		
		List<Integer> multi = monto.stream().map(m -> m*3).collect(Collectors.toList());
		//System.out.println(multi);
		System.out.println("Montos mayores a 29000");
		for(int valor : multi) {
			if(valor>29000) {
				System.out.println(valor);
			}
		}
		System.out.println("");
	}
	
	//Sacar promedio de todos los montos
	public static void PromedioMontos (List<Integer> monto) {
		
		int suma = 0;
		for (int valor : monto) {
			suma = suma+valor;
		}
		System.out.println("el promedio de los montos es: "+suma/monto.size()+"\n");
	}
	
	//Datos de la persona con el menor monto
	public static void menorMonto (List<Integer> monto, ArrayList<Persona> personas ) {
		
		System.out.println("La persona con el monto menor es" + "\n");
		int min = Collections.min(monto);
		
		for (Persona per : personas) {
			if (per.getMonto() == min) {
				System.out.println("nombre: " + per.getNombre());
				System.out.println("correo: " + per.getCorreo());
				System.out.println("ciudad: " + per.getCiudad());
				System.out.println("monto: " + per.getMonto());
				System.out.println(" " + "\n");
			}
		}
	}
	
	//Datos de la persona con el mayor monto
	public static void mayorMonto (List<Integer> monto, ArrayList<Persona> personas ) {
		
		System.out.println("La persona con el monto mayor es" + "\n");
		int max = Collections.max(monto);
		
		for (Persona per : personas) {
			if (per.getMonto() == max) {
				System.out.println("nombre: " + per.getNombre());
				System.out.println("correo: " + per.getCorreo());
				System.out.println("ciudad: " + per.getCiudad());
				System.out.println("monto: " + per.getMonto());
				System.out.println(" " + "\n");
			}
		}
	}

}
