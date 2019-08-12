package com.mymovements.service;
  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
/**
 * Super classe que contem o metodo para chamada de Servi�o Rest
 * @author igor.leonardo.silva
 *
 */
public class CallService { 
	 
	
	/**
	 * Metodo construtor
	 */
	public CallService() {  
		
	}  
	/**
	 * Metodo que faz chamada do servi�o e returna StringBuilder
	 * @param endpoint
	 * @return
	 */
	protected StringBuilder getResponse(String endpoint){
		StringBuilder resposta = new StringBuilder(); 
        try {
            URL url = new URL(endpoint); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json;charset=utf-8");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("encoding","UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();    
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
          	String s = "";
          	while (null != ((s = br.readLine()))) {
          		resposta.append(s);
          	} 
          	br.close(); 
        } catch (MalformedURLException e) { 
            System.out.println(e.getMessage()+" Erro na chamada de servi�o");
            return resposta;
        } catch (IOException e) {
        	System.out.println(e.getMessage()+" Erro na chamada de servi�o");
            return resposta;
        } 
        return resposta;        
	}
	
	/**
	 * Metodo que faz chamada do servi�o e returna BufferedReader
	 * @param endpoint
	 * @return
	 */
	protected BufferedReader getResponseBufferedReader(String endpoint){ 
		BufferedReader br = null;
        try {
            URL url = new URL(endpoint); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json;charset=utf-8");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("encoding","UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();    
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
          	return br;
        } catch (MalformedURLException e) {
        	System.out.println(e.getMessage()+" Erro na chamada de servi�o");
            return br;
        } catch (IOException e) {
        	System.out.println(e.getMessage()+" Erro na chamada de servi�o");
            return br;
        }      
	}
 
}
