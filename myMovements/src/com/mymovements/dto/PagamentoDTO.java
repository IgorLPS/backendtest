package com.mymovements.dto;  
import java.io.Serializable; 
/**
 * 
 * @author igor.leonardo.silva
 *
 */
public class PagamentoDTO extends LancamentoDTO implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8407126931127050447L;
	private String categoria;
 
 
	public PagamentoDTO(String categoria) {
		super();
		this.categoria = categoria;
	}
	
	public PagamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoDTO(String data, String descricao, String moeda, String valor) {
		super(data, descricao, moeda, valor);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PagamentoDTO [categoria=" + categoria +"  "+super.toString()+"]";
	} 
    
	
	
	 
}
	