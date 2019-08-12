package com.mymovements.service;

import java.io.BufferedReader;
import java.util.ArrayList; 
import java.util.List; 
import com.mymovements.config.LancamentoConfig;
import com.mymovements.converter.ConverterData;
import com.mymovements.dto.PagamentoDTO;
/**
 * Classe Client para invocar o serviço Rest das informações de Pagamentos
 * @author igor.leonardo.silva
 *
 */
public class PagamentosService extends CallService {

	public PagamentosService() {
	}

	/**
	 * 
	 * @return
	 */
	public List<PagamentoDTO> pagamentoDTO() { 
		List<PagamentoDTO> rList = new ArrayList<>();
		try {
			String endpoint = LancamentoConfig.ENDPOINT_PAGAMENTO;
			BufferedReader br = getResponseBufferedReader(endpoint);
			rList = ConverterData.pagamentoDTO(br);  
		} catch (Exception e) { 
			System.out.println("Erro na chamada de serviço "+e.getMessage());
			return rList;
		} 
		return rList;
	}

}
