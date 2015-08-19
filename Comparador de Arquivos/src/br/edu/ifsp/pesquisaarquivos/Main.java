package br.edu.ifsp.pesquisaarquivos;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {	
		List<Extensao> exs = new ArrayList<Extensao>();
		
		exs.add(new Extensao(".docx", true));
		exs.add(new Extensao(".txt", true));
		
		Pasta p = new Pasta("d:\\documentos",arrayToExtensao(exs));
		
		p.obterArquivos();
	}

	
	public void criarExtensoes(){
		
	}
	
	public void criaPastas(){
		
	}
	
	public void obterArquivos(){
		
	}
	
	public static Extensao[] arrayToExtensao(List<Extensao> extLocal){
		int i;
		Extensao[] retExt = new Extensao[extLocal.size()];
		for (i=0;i < extLocal.size(); i++){
			retExt[i] = extLocal.get(i);
		}
		
		return retExt;
	}
}