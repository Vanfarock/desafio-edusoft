package controllers;

import java.util.ArrayList;

public class CalculadorMediaAritmetica implements CalculadorMedia {

	public double calcularMedia(ArrayList<Double> valores) {
		if (valores.size() > 0) {
			double total = getTotal(valores);
			return total / valores.size();
		}
		return 0;
	}
	
	private double getTotal(ArrayList<Double> valores) {
		double soma = 0;
		for (Double valor : valores) {
			soma += valor;
		}
		return soma;
	}
}
