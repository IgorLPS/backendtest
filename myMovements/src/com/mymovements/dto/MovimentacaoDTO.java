package com.mymovements.dto;

import java.io.Serializable;
import java.util.Date;

import com.mymovements.util.LancamentoUtil;
/**
 * Objeto Merge que ira para a View
 * 
 * @author igor.leonardo.silva
 *
 */
public class MovimentacaoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2650314020475889457L;
	protected Date data;
	protected String descricao;
	protected String moeda;
	protected Double valor;
	protected String categoria;
	
	
	public MovimentacaoDTO() {
		// TODO Auto-generated constructor stub
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
		return "MovimentacaoDTO [data=" + formatDate(data) + ", descricao=" + descricao + ", moeda=" + moeda + ", valor=" + valor
				+ ", categoria=" + categoria + "]";
	}
	 
    /**
     * 
     * @param data
     * @return
     */
	public String formatDate(Date data){
		return LancamentoUtil.strToStrDate( data);
	}
	/**
	 * 
	 * @return
	 */
	public String getStringDate(){
		return formatDate(data);
	}
}
