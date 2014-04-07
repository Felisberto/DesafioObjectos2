package desafio.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import desafio.classe.CEP;

public class DesafioObjectos2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));
		String cep = null;
		String url = null;
		List <String> resposta = new ArrayList<String>();
		CEP rua = new CEP();
		
		
		
			System.out.println("Digite um CEP");
			cep = ent.readLine();
			url = "http://www.buscacep.correios.com.br/servicos/dnec/consultaEnderecoAction.do?relaxation="+ cep +"&TipoCep=LOG&semelhante=N&cfm=1&Metodo=listaLogradouro&TipoConsulta=relaxation&StartRow=1&EndRow=10";
			
		
		
			try {
				
				HttpURLConnection con = (HttpURLConnection) new URL (url).openConnection();
				con.setDoOutput(true);
				
				OutputStreamWriter busca = new OutputStreamWriter(con.getOutputStream());
				busca.write(url);
				
				BufferedReader site = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				
				resposta = rua.separaValores(site);
					
								
				} catch (MalformedURLException e) {
						
							System.out.println("Erro de URL " + e.getMessage());
						
						// TODO Auto-generated catch block
						e.printStackTrace();
				  } catch (IOException e) {
						
							System.out.println("Erro de Entrada e saída " + e.getMessage());
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			
		
		if(resposta != null) {	
				rua.montaObj(resposta);
						
						
				System.out.println(rua.getLogradouro());
				System.out.println(rua.getBairro());
				System.out.println(rua.getLocalidade());
				System.out.println(rua.getUf());
				System.out.println(rua.getCep());
		}
		else
			 System.out.println("Valor não encontrado");
				
					
	}

}
