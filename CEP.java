package desafio.classe;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CEP {
	
	/*ATRIBUTOS*/

	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String cep;
	
	
	/*ENCAPSULAMENTO*/
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	/*METODOS*/
	
	public List<String> separaValores(BufferedReader r) throws IOException{
		
		String resp = null;
		List <String> lis = new ArrayList<String>();
		
				while((resp = r.readLine()) != null)
					if(resp.contains("<td") && resp.contains("</td>"))
						lis.add(resp.substring(resp.indexOf(">")+1, resp.indexOf("/")-1));
	
		if (!lis.isEmpty()) 
			 return lis;
		
		return null;
		
	}
	
	public void montaObj(List<String> l){
		
		this.setLogradouro(l.get(0));
		this.setBairro(l.get(1));
		this.setLocalidade(l.get(2));
		this.setUf(l.get(3));
		this.setCep(l.get(4));
		
	}



}
