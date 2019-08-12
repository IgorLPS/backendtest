/**
 * 
 */
package com.mymovements.service;
 
import java.util.List;  
import com.mymovements.fileio.LancamentoFile; 

/**
 * @author igor.leonardo.silva
 *
 */
public class LancamentoService {
	LancamentoFile lancamentoFile;

	/**
	 * 
	 */
	public LancamentoService() { 
		lancamentoFile = new LancamentoFile();
	} 
	
	/**
	 *  
	 * @return
	 */
	public List<String> lancamentosArquivo( ){ 
			return lancamentoFile.lerArquivoTexto(); 
	} 
	  

}
