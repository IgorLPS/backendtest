/**
 * 
 */
package com.mymovements.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author igor.leonardo.silva
 * 
 * 
 * Exe
 *  "data": "10 / jul",
    "descricao": "Marcelo B.",
    "moeda": "R$",
    "valor": "50,00"s
    
 * Super classe que tem os campos comuns para Pagamento e Recebimento
 *
 */ 
public class LancamentoData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8407126931127050447L; 
	
	protected Date data;
	protected String descricao;
	protected String moeda;
	protected Double valor; 
	
	/**
	 * 
	 */
	public LancamentoData() {
	}
 
	/**
	 * 
	 * @param data
	 * @param descricao
	 * @param moeda
	 * @param valor
	 * @param categoria
	 */
	public LancamentoData(Date data, String descricao, String moeda, Double valor ) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.moeda = moeda;
		this.valor = valor; 
	}
 
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the moeda
	 */
	public String getMoeda() {
		return moeda;
	}
	/**
	 * @param moeda the moeda to set
	 */
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	} 
	
	
	
}
