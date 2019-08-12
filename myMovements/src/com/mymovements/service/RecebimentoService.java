package com.mymovements.service;

import java.io.BufferedReader; 
import java.util.ArrayList; 
import java.util.List;
import com.mymovements.config.LancamentoConfig;
import com.mymovements.converter.ConverterData;
import com.mymovements.dto.RecebimentoDTO; 
/**
 * 
 * Classe Client para invocar o serviço Rest das informações de recebimentos
 * @author igor.leonardo.silva
 *
 */
public class RecebimentoService extends CallService{ 
	public RecebimentoService() { 
	}
	/**
	 *  
	 * @return
	 */
	public List<RecebimentoDTO> recebimentoDTO() {
            List<RecebimentoDTO> rList = new ArrayList<>();
            try {
                String endpoint = LancamentoConfig.ENDPOINT_RECEBIMENTO;
                BufferedReader br = getResponseBufferedReader(endpoint);
                rList = ConverterData.recebimentoDTO(br)  ; 
            } catch (Exception e) {
            	System.out.println("Erro na chamada de serviço "+e.getMessage());
                return rList;
            }   
        return rList;
    } 
	 
}
