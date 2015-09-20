package br.edu.ifsp.pesquisaarquivos;

import java.util.*;
/*
 * Software de Compara��o de testos de arquivo feito durante as Aulas de Java do 
 * IFSP, durante as Aulas de B1LP2.
 * 
 * @author <a href="http://github.com/edu-ricardo">Eduardo Ricardo</a>
 * @description Aula de Java
 * @version 0.0.1
 */


public class Main {
	public static List<Extensao> exs = new ArrayList<Extensao>();
	public static Set<Pasta> pastas = new HashSet<Pasta>();
	public static List<Arquivo> arqs = new ArrayList<Arquivo>();
	
	public static void main(String[] args) {	
		criaPastas();
		System.out.println("P�s Criapastas()");
		while (Pasta.getnDreds() > 0){
			try {				
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Pr�-Carrega()");
		carregaListaArquivos();
		System.out.println("Pr�-Carrega()");			
		for (int i = 0; i < arqs.size(); i++) {
			if (arqs.get(i).getCaminho().endsWith(".pdf")){
				//System.out.println(arqs.get(i).getCaminho());
				arqs.get(i).lerArquivos();
			}
		}
	}
	
	public static void carregaListaArquivos(){		
		for (Pasta pAux : pastas) {
			List<String> arq = pAux.getCaminhoArquivos();			
			System.out.println(arq.size());
			for (int i = 0; i < arq.size(); i++) {
				arqs.add(FactoryArquivo.criaArquivo(arq.get(i)));				
			}
		} 
		
	}
	
	public static void criaPastas(){
		exs.add(new Extensao(".docx", true));
		exs.add(new Extensao(".txt", true));
		exs.add(new Extensao(".pdf", true));
		exs.add(new Extensao(".doc", true));

//		pastas.add(new Pasta("d:\\pdf",arrayToExtensao(exs)));
		pastas.add(new Pasta("d:\\pdf2",arrayToExtensao(exs)));
		//pastas.add(new Pasta("d:\\",arrayToExtensao(exs)));
		//pastas.add(new Pasta("c:\\",arrayToExtensao(exs)));
		
		for (Pasta p : pastas){
			p.obterArquivos();
		}

		while ( Pasta.getnDreds() > 0 ){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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
