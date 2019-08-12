package com.mymovements.dto;  
import java.io.Serializable; 
/**
 * 
 * @author igor.leonardo.silva
 *
 */
public class RecebimentoDTO extends LancamentoDTO implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8407126931127050447L;

	public RecebimentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecebimentoDTO(String data, String descricao, String moeda, String valor) {
		super(data, descricao, moeda, valor);
		// TODO Auto-generated constructor stub
	}   
	
}
	