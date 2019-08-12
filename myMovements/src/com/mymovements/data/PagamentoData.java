/**
 * 
 */
package com.mymovements.data;

import java.io.Serializable;
import java.util.Date;

import com.mymovements.util.LancamentoUtil; 

/**
 * @author igor.leonardo.silva
 * 
 *   "data": "11/jul",
    "descricao": "Auto Posto Shell",
    "moeda": "R$",
    "valor": "-50,00",
    "categoria": "transporte"
    
    Classe que representa a entidade Pagamento
 *
 */
public class PagamentoData extends LancamentoData implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private String categoria; 
	
	/**
	 * 
	 */
	public PagamentoData() {
		super(); 
	}
	/**
	 * 
	 * @param data
	 * @param descricao
	 * @param moeda
	 * @param valor
	 * @param categoria
	 */
	public PagamentoData(Date data, String descricao, String moeda, Double valor, String categoria) {
		super(data,descricao,moeda,valor); 
		this.categoria = categoria;
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
		return "PagamentoData [categoria=" + categoria + ", data=" + data + ", descricao=" + descricao + ", moeda="
				+ moeda + ", valor=" + valor + "]";
	}
	 /**
	  * 
	  * @return
	  */
	 public String getMonth(){
		 return LancamentoUtil.strToStrMonth(data);
	 }
	 /**
	  * 
	  * @param d1
	  * @param d2
	  * @return
	  */
	 public static int valorCompare(double d1, double d2) {
	        return new Double(d2).compareTo(d1);
	    }

}
