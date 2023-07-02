package main;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
//		JFrame frame= new JFrame();
//		frame.setSize(500, 500);
//		frame.setVisible(true);
		
		pedirDinero();
	}
	
	public static void pedirDinero()
	{
		String cantidadIngresar;
		do
		{
			cantidadIngresar = JOptionPane.showInputDialog("Introduce la cantidad de dinero a convertir");
			if(cantidadIngresar == null)
			{
				System.exit(0);
			}
		}while(tieneLetras(cantidadIngresar) == true || cantidadIngresar.isEmpty());
		double ingresoDouble = Double.parseDouble(cantidadIngresar);
		
		pedirTipoCambio(ingresoDouble);
	}
	
	public static void pedirTipoCambio(double ingresoDouble)
	{
		String opciones[] = {"De pesos a dolar", "De pesos a euro", "De pesos a yen", "De pesos a won coreano", "de dolar a pesos", "De euro a pesos", "De libras a pesos"};
		String opcionElegida = (String) JOptionPane.showInputDialog(null,"Elige la moneda a la que desesas convertir tu dinero","Monedas",JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]);
		if(opcionElegida == null)
		{
			System.exit(0);
		}
		double valorFinal = 0;
		
		int indiceElegido = -1;
        for (int i = 0; i < opciones.length; i++) {
            if (opcionElegida.equals(opciones[i])) {
                indiceElegido = i;
                break;
            }
        }
        
        regresoCambio(ingresoDouble, valorFinal, indiceElegido);
	}
	
	public static void regresoCambio(double ingresoDouble, double valorFinal, int indiceElegido)
	{
		switch(indiceElegido)
		{
			case 0:
				valorFinal = ingresoDouble * 0.058;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 1:
				valorFinal = ingresoDouble * 0.053;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 2:
				valorFinal = ingresoDouble * 8.43;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 3:
				valorFinal = ingresoDouble * 76.87;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 4:
				valorFinal = ingresoDouble * 17.12;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 5:
				valorFinal = ingresoDouble * 18.69;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			case 6:
				valorFinal = ingresoDouble * 21.76;
				JOptionPane.showMessageDialog(null, valorFinal);
				break;
			default:
				JOptionPane.showMessageDialog(null, "moneda no definida");
				break;
		}		
		
		confirmacion();
	}
	
	public static void confirmacion()
	{
		int confirmacion = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
        	pedirDinero();
        } else {
            System.exit(0);
        }
	}

	public static boolean tieneLetras(String numero)
	{
		String numeros = "1234567890";
		for(int i = 0; i<numero.length(); i++)
		{
			char character = numero.charAt(i);
			if(numeros.indexOf(character) == -1)
			{
				return true;
			}
		}
		return false;
	}
}
