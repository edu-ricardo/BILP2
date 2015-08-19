package br.edu.ifsp.pesquisaarquivos;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta {
	private String caminho;
	private Extensao extensoes[];
	private List<String> caminhoArquivos;
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public Extensao[] getExtensoes() {
		return extensoes;
	}
	public void setExtensoes(Extensao[] extensoes) {
		this.extensoes = extensoes;
	}
	public List<String> getCaminhoArquivos() {
		return caminhoArquivos;
	}
	public void setCaminhoArquivos(List<String> caminhoArquivos) {
		this.caminhoArquivos = caminhoArquivos;
	}
	
	public Pasta(String caminho, Extensao[] extensoes) {
		super();
		this.caminho = caminho;
		this.extensoes = extensoes;
		this.caminhoArquivos = new ArrayList<String>();
	}

	public void obterArquivos(){
		List<String> listaPastas = new ArrayList<String>();
		
		listaPastas.add(caminho);
		int contador = 0, contDoc = 0;
		do{
			File f = new File(listaPastas.get(0));
			for (int i = 0; i < f.listFiles().length; i++) {
				//System.out.println(f.listFiles()[i].getAbsolutePath());
				File altFile = new File(f.listFiles()[i].getAbsolutePath());
				if(altFile.isDirectory()){
					listaPastas.add(f.listFiles()[i].getAbsolutePath());
				}else{
					if (this.extensoes.length != 0){
						for(Extensao ext: this.extensoes){
							if( f.listFiles()[i].getAbsolutePath().endsWith(ext.getNome()) ){
								this.caminhoArquivos.add(f.listFiles()[i].getAbsolutePath());
								System.out.println(f.listFiles()[i].getAbsolutePath());
							}
						}
					}
				}
			}
			
			listaPastas.remove(0);
			contador++;
		}while(listaPastas.size()>0);
		System.out.println(contador);
		System.out.println("N�mero de .doc: " + contDoc);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasta other = (Pasta) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		return true;
	}
	
}