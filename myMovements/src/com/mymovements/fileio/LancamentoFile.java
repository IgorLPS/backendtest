/**
 * 
 */
package com.mymovements.fileio; 
import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List; 
import com.mymovements.config.LancamentoConfig;
import com.mymovements.util.LancamentoUtil; 
/**
 * @author igor.leonardo.silva
 *
 */
public class LancamentoFile { 
	/**
	 * 
	 */
	public LancamentoFile() {
		// TODO Auto-generated constructor stub
	}
    /**
     * 
     * @return
     */
	public List<String> lerArquivoTexto() {   
		List<String> linhas = new ArrayList<>();
		try { 
			BufferedReader arqIn = new BufferedReader(new InputStreamReader(new FileInputStream(LancamentoConfig.ARQUIVO), "UTF-8"));  
			Boolean header = true;
			while (arqIn.ready()) { 
				if(header){
					String head = arqIn.readLine();
				}else{  
					String linha = arqIn.readLine(); 
					//System.out.println(linha);
					String linhaLtrim = LancamentoUtil.ltrim(linha);
					String linhaRtrim=  LancamentoUtil.rtrim(linhaLtrim);
					linhas.add(linhaRtrim);
				}
				header=false;
			}
			arqIn.close(); 
		} catch (IOException ex) {
			ex.printStackTrace();
			return linhas;
		}  
		return linhas;
	}  
}
