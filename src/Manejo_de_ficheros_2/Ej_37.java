package Manejo_de_ficheros_2;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Ej_37 {

	public static void main(String[] args) {
		/*
		 * 37. Crea un programa que nos solicite por consola el expediente, nombre del
		 * alumno y su nota hasta que le indiquemos salir. Los datos no tendrán
		 * duplicados y estarán ordenados por expediente. Para mantener la persistencia
		 * de los datos se guardarán en un fichero notasAlumno.xml con el siguiente
		 * resultado:
		 */
		//dkgflkdfgnlkdfgawdawd

		TreeMap<Integer, Alumno> datos = new TreeMap<Integer, Alumno>();
		boolean continuar = false;
		try {
			// Creamos la factoría
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			// Creamos el DocumentBuilder
			DocumentBuilder db = factoria.newDocumentBuilder();
			// Creamos un DOM vacío
			Document documento = db.newDocument();
			// Establecemos la versión
			documento.setXmlVersion("1.0");
			// Creamos elementos y añadimos al DOM
			Element elemento1 = documento.createElement("alumnos");
			documento.appendChild(elemento1);

			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Indica el expediente: ");
				String expediente = sc.nextLine();
				System.out.println("Indica el nombre del alumno: ");
				String nombre = sc.nextLine();
				System.out.println("Indica la nota: ");
				String nota = sc.nextLine();

				Element eAlumno = documento.createElement("alumno");
				Element eExpediente = documento.createElement("numExpediente");
				Element eNombre = documento.createElement("nombreAlumno");
				Element eNota = documento.createElement("nota");

				Text tExpediente = documento.createTextNode(expediente);
				Text tNombre = documento.createTextNode(nombre);
				Text tNota = documento.createTextNode(nota);

				elemento1.appendChild(eAlumno);
				eAlumno.appendChild(eExpediente);
				eAlumno.appendChild(eNombre);
				eAlumno.appendChild(eNota);

				System.out.println("¿Quieres crear otro alumno?: ");
				String respuesta = sc.nextLine();

				if (!respuesta.equalsIgnoreCase("si")) {
					continuar = false;
				}
			} while (continuar);
		} catch (Exception e) {

		}
	}

}
