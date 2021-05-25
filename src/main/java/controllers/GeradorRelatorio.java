package controllers;

import java.util.ArrayList;

public interface GeradorRelatorio<T> {
	public void gerarRelatorio(ArrayList<T> dados, String filePath);
}
