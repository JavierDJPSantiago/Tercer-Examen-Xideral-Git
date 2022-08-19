package com.caluladora;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.lang.Math;
import java.text.DecimalFormat;

public class Calculadora {

	//Variables static para métodos ejecutaOperacionesConEnteros y ejecutaOperacionesConDecimales
	private static double numero1;
	private static double numero2;
	private static int numero1EnInt;
	private static int numero2EnInt;

	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la calculadora, ¿Qué operación desea realizar? Seleccione un número de opción =>" + "\n" + 
		"1: Suma" + "\n" + 
		"2: Resta" + "\n" + 
		"3: Multiplicación" + "\n" +
		"4: División" + "\n" +
		"5: Potencia" + "\n" +
		"6: Raíz" + "\n" + 
		"7: Número mas grande" + "\n" + 
		"8: Número mas pequeño");
		
		//Objeto scanner para ingreso de valores solicitados al usuario que utiliza la calculadora 
		Scanner usuario = new Scanner(System.in);
		
		//Valor para la selección de la operación
		int seleccionDeNumero = usuario.nextInt();

		System.out.println("Por favor inserte un número en formato decimal (Ejemplo: 5.0): ");
		
		//Primer número decimal solicitado al usuario
		numero1 = usuario.nextDouble();

		System.out.println("Por favor inserte un segundo número en formato decimal (Ejemplo: 2.0): ");
		
		//Segundo número decimal solicitado al usuario
		numero2 = usuario.nextDouble();
		
		//Casteo de números ingresados por el usuario, necesario para operaciones de tipo double
		numero1EnInt = (int) numero1;
		numero2EnInt = (int) numero2;

		
		
		// Grupo de funciones lambda con la interface DoubleBinaryOperator

		// Lambda para realizar potencia
		DoubleBinaryOperator potencia = (x, y) -> Math.pow(x, y);

		// Lambda para realizar raíz
		DoubleBinaryOperator raiz = (x, y) -> Math.pow(x, (1 / y));

		// Lambda para conocer número mas grande
		DoubleBinaryOperator masGrande = (x, y) -> Math.max(x, y);

		// Lambda para conocer número mas pequeño
		DoubleBinaryOperator masPequeño = (x, y) -> Math.min(x, y);
	
	
		
		// Grupo de funciones lambda con la interface IntBinaryOperator
		
		// Lambda para realizar una suma
		IntBinaryOperator suma = (x, y) -> Math.addExact(x, y);

		// Lambda para realizar una resta
		IntBinaryOperator resta = (x, y) -> Math.subtractExact(x, y);
	

		// Lambda para realizar una multiplicación
		IntBinaryOperator multi = (x, y) -> Math.multiplyExact(x, y);
		
		// Lambda para realizar una multiplicación
		IntBinaryOperator div = (x, y) -> Math.floorDiv(x, y);
		
		
		
		// Lista para operaciones: suma, resta, multiplicación y división
		List<IntBinaryOperator> listaDeOperacionesConEnteros = new ArrayList<>();

		// Lista para operaciones: potencia, raíz, número mayor y número menor
		List<DoubleBinaryOperator> listaDeOperacionesConDecimales = new ArrayList<>();

		
		
		/*
		 * Switch para seleccionar una operación
		 * Cada case contiene el nombre de la operación
		 * Cada case ejecuta los metodos correspondientes a las operaciones añadidas a la lista
		*/
		switch (seleccionDeNumero) {
		case 1:
			listaDeOperacionesConEnteros.add(suma);
			System.out.println("Suma: ");
			ejecutaOperacionesConEnteros(listaDeOperacionesConEnteros);
			break;
		case 2:
			listaDeOperacionesConEnteros.add(resta);
			System.out.println("Resta: ");
			ejecutaOperacionesConEnteros(listaDeOperacionesConEnteros);
			break;
		case 3:
			listaDeOperacionesConEnteros.add(multi);
			System.out.println("Multiplicación: ");
			ejecutaOperacionesConEnteros(listaDeOperacionesConEnteros);
			break;
		case 4:
			listaDeOperacionesConEnteros.add(div);
			System.out.println("División: ");
			ejecutaOperacionesConEnteros(listaDeOperacionesConEnteros);
			break;
		case 5:
			listaDeOperacionesConDecimales.add(potencia);
			System.out.println("Potencia: ");
			ejecutaOperacionesConDecimales(listaDeOperacionesConDecimales);
			break;
		case 6:
			listaDeOperacionesConDecimales.add(raiz);
			System.out.println("Raíz: ");
			ejecutaOperacionesConDecimales(listaDeOperacionesConDecimales);
			break;
		case 7:
			listaDeOperacionesConDecimales.add(masGrande);
			System.out.println("Número mas grande: ");
			ejecutaOperacionesConDecimales(listaDeOperacionesConDecimales);
			break;
		case 8:
			listaDeOperacionesConDecimales.add(masPequeño);
			System.out.println("Número mas pequeño: ");
			ejecutaOperacionesConDecimales(listaDeOperacionesConDecimales);
			break;

		default:
			System.out.println("Por favor seleccione una opción disponible");
		}

	}

	
	
	



	//Método para ejecutar las operaciones añadidas en la lista: listaDeOperacionesConDecimales
	static void ejecutaOperacionesConDecimales(List<DoubleBinaryOperator> listOperaciones) {
		for (DoubleBinaryOperator ope : listOperaciones) {
			try {
				System.out.println(ope.applyAsDouble(numero1, numero2));
			} catch (UnsupportedOperationException unsupportedOperationException) {
				System.out.println("No es posible esta operación");
			}
		}
	}

	
	
	
	//Método para ejecutar las operaciones añadidas en la lista: listaDeOperacionesConEnteros
	static void ejecutaOperacionesConEnteros(List<IntBinaryOperator> listOperaciones) {

		for (IntBinaryOperator ope : listOperaciones) {
			try {
				System.out.println(ope.applyAsInt(numero1EnInt, numero2EnInt));
			} catch (UnsupportedOperationException unsupportedOperationException) {
				System.out.println("No es posible esta operación");
			}
		}
	}

}
