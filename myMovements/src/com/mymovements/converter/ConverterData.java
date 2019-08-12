package com.mymovements.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 
import com.mymovements.data.PagamentoData;
import com.mymovements.data.RecebimentoData;
import com.mymovements.dto.MovimentacaoDTO;
import com.mymovements.dto.PagamentoDTO;
import com.mymovements.dto.RecebimentoDTO;
import com.mymovements.util.LancamentoUtil;

public class ConverterData {

	public ConverterData() {
	} 
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static RecebimentoData converterDtoToDataRecebimento(RecebimentoDTO dto){
		RecebimentoData data = new RecebimentoData();
		data.setData(LancamentoUtil.strToDate(dto.getData()));  
		String linhaLtrim = LancamentoUtil.ltrim(dto.getDescricao());
		String linhaRtrim=  LancamentoUtil.rtrim(linhaLtrim); 
		data.setDescricao(linhaRtrim);
		data.setMoeda(dto.getMoeda());
		data.setValor(LancamentoUtil.strToDouble(dto.getValor()));
		return data; 
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static PagamentoData converterDtoToDataPagamento(PagamentoDTO dto){
		PagamentoData data = new PagamentoData();
		data.setData(LancamentoUtil.strToDate(dto.getData()));
		
		String linhaLtrim = LancamentoUtil.ltrim(dto.getDescricao());
		String linhaRtrim=  LancamentoUtil.rtrim(linhaLtrim);
		
		data.setDescricao(linhaRtrim);
		data.setMoeda(dto.getMoeda());
		data.setValor(LancamentoUtil.strToDouble(dto.getValor()));
		data.setCategoria(categoria( dto));
		return data; 
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static String categoria(PagamentoDTO dto){
		if(null == dto.getCategoria() || dto.getCategoria().isEmpty() || dto.getCategoria().equalsIgnoreCase("")){
			return "Sem Categoria";
		}else
			return dto.getCategoria();
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static MovimentacaoDTO convertToMovimentacaoDTO(Object data){
		MovimentacaoDTO dto = new MovimentacaoDTO();
	    if(data  instanceof RecebimentoData){
	    	RecebimentoData recebimento = (RecebimentoData) data;
	    	dto.setData(recebimento.getData());
	    	

			String linhaLtrim = LancamentoUtil.ltrim(dto.getDescricao());
			String linhaRtrim=  LancamentoUtil.rtrim(linhaLtrim);
	    	
	    	dto.setDescricao(linhaRtrim);
	    	dto.setMoeda(recebimento.getMoeda()); 
	    	dto.setValor(recebimento.getValor()); 
	    }else{
	    	PagamentoData pagamento = (PagamentoData) data;
	    	dto.setData(pagamento.getData());
	    	

			String linhaLtrim = LancamentoUtil.ltrim(dto.getDescricao());
			String linhaRtrim=  LancamentoUtil.rtrim(linhaLtrim);
	    	
	    	dto.setDescricao(linhaRtrim);
	    	dto.setMoeda(pagamento.getMoeda());
	    	dto.setValor(pagamento.getValor()); 
	    	dto.setCategoria(pagamento.getCategoria());  
	    }   
		return dto; 
	}	
	
	
	
	/**
	 * 
	 * @param sArray
	 * @return
	 */
	public static PagamentoData convertStringPagamentoData(String [] sArray){
		PagamentoData data = new PagamentoData();   
		data.setData(LancamentoUtil.strToDate(sArray[0]));
		data.setDescricao(sArray[1]); 
		data.setValor(LancamentoUtil.strToDouble(sArray[2])); 
		if(sArray.length > 3){ 
			if(null!= sArray[3]){
				String aux = sArray[3].trim(); 
				aux = aux.replaceAll(" ",""); 
				data.setCategoria(aux); 
			}else  if(sArray[3].isEmpty() || sArray[3].equalsIgnoreCase(" ")|| sArray[3].equalsIgnoreCase("")){ 
				data.setCategoria("Sem categoria"); 
			} else{
				data.setCategoria("Sem categoria");
			}
			
		}else{
			data.setCategoria("Sem categoria"); 
		}
		return data;
	}
	
	
	  /**
		 * 
		 * @param sArray
		 * @return
		 */
	   public static RecebimentoData convertStringRecebimentoData(String [] sArray){
			RecebimentoData data = new RecebimentoData();   
			data.setData(LancamentoUtil.strToDate(sArray[0]));
			data.setDescricao(sArray[1]); 
			data.setValor(LancamentoUtil.strToDouble(sArray[2]));
			return data;
		} 
	   
	   /**
		 * 
		 * @param br
		 * @return
		 */
		public static List<RecebimentoDTO> recebimentoDTO(BufferedReader br){
			List<RecebimentoDTO> rList = new ArrayList<>();
			String s = "";
			Boolean startObjec = false;
			RecebimentoDTO dto = null;
	      	try {
				while (null != ((s = br.readLine()))) { 
					s = LancamentoUtil.removerEspacoLT(s); 
					if(s.equalsIgnoreCase("[")|| s.equalsIgnoreCase("]")){
						
					}else{ 
						if(s.equalsIgnoreCase("{")){ 
							  startObjec = true; 
							  dto = new RecebimentoDTO();
						}else
						if(s.equalsIgnoreCase("}")||s.equalsIgnoreCase(",")||s.equalsIgnoreCase("},")){ 
							  startObjec = false; 
							  rList.add(dto);
						}else  
						if(s.equalsIgnoreCase(",")){ 
							  startObjec = false;  
						} 
						
						if(startObjec && !s.equalsIgnoreCase("{")){
							String param[] = s.split(":"); 
							setParamRecebimentoDTO(param,dto); 
						} 
					}  
				}
			 	br.close(); 
			} catch (IOException e) { 
				e.printStackTrace();
			}   
	      	return rList;
		}
	   
		/**
		 * 
		 * @param param
		 * @param dto
		 */
		public static void setParamRecebimentoDTO(String param[],RecebimentoDTO dto){
			String key = LancamentoUtil.removerAspas(param[0]);
			String value = LancamentoUtil.removerAspas(param[1]); 
			if(key.equalsIgnoreCase("data")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setData(value); 
			}
			if(key.equalsIgnoreCase("descricao")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setDescricao(value); 
			}
			if(key.equalsIgnoreCase("moeda")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setMoeda(value); 
			}
			if(key.equalsIgnoreCase("valor")){
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setValor(value); 
			} 
		} 
		
		
		/**
		 * 
		 * @param param
		 * @param dto
		 */
		public static void setParamPagamentoDTO(String param[],PagamentoDTO dto){
			String key = LancamentoUtil.removerAspas(param[0]);
			String value = LancamentoUtil.removerAspas(param[1]); 
			if(key.equalsIgnoreCase("data")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setData(value); 
			}
			if(key.equalsIgnoreCase("descricao")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setDescricao(value); 
			}
			if(key.equalsIgnoreCase("moeda")){
				value = LancamentoUtil.removerVirgula(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setMoeda(value); 
			}
			if(key.equalsIgnoreCase("valor")){
				value = LancamentoUtil.removerUltimoCaracter(value);
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setValor(value); 
			} 
			if(key.equalsIgnoreCase("categoria")){ 
				value = LancamentoUtil.removerEspacoLT(value); 
				dto.setCategoria(value); 
			} 
		} 
	
		
		
		
		  /**
				 * 
				 * @param br
				 * @return
				 */
	       public static List<PagamentoDTO> pagamentoDTO(BufferedReader br) {
		            List<PagamentoDTO> rList = new ArrayList<>();
					String s = "";
					Boolean startObjec = false;
					PagamentoDTO dto = null;
			      	try {
						while (null != ((s = br.readLine()))) { 
							s = LancamentoUtil.removerEspacoLT(s); 
							if(s.equalsIgnoreCase("[")|| s.equalsIgnoreCase("]")){
								
							}else{ 
								if(s.equalsIgnoreCase("{")){ 
									  startObjec = true; 
									  dto = new PagamentoDTO();
								}else
								if(s.equalsIgnoreCase("}")||s.equalsIgnoreCase(",")||s.equalsIgnoreCase("},")){ 
									  startObjec = false; 
									  rList.add(dto);
								}else  
								if(s.equalsIgnoreCase(",")){ 
									  startObjec = false;  
								} 
								
								if(startObjec && !s.equalsIgnoreCase("{")){
									String param[] = s.split(":"); 
									setParamPagamentoDTO(param,dto); 
								} 
							}  
						}
					 	br.close(); 
					} catch (IOException e) { 
						e.printStackTrace();
					}   
			      	return rList;
				}
}
