/**
 * 
 */
package com.mymovements.dto;

import java.io.Serializable;

/**
 * @author igor.leonardo.silva
 *
 */
public class LancamentoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2650314020475889457L;
	protected String data;
	protected String descricao;
	protected String moeda;
	protected String valor;
	/**
	 * 
	 */
	public LancamentoDTO() {
		// TODO Auto-generated constructor stub
	} 
		/**
		 * 
		 * @param data
		 * @param descricao
		 * @param moeda
		 * @param valor
		 * @param categoria
		 */
		public LancamentoDTO(String data, String descricao, String moeda, String valor ) { 
			this.data = data;
			this.descricao = descricao;
			this.moeda = moeda;
			this.valor = valor; 
		}
	 
		/**
		 * @return the data
		 */
		public String getData() {
			return data;
		}
		/**
		 * @param data the data to set
		 */
		public void setData(String data) {
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
		public String getValor() {
			return valor;
		}
		/**
		 * @param valor the valor to set
		 */
		public void setValor(String valor) {
			this.valor = valor;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "LancamentoDTO [data=" + data + ", descricao=" + descricao + ", moeda=" + moeda + ", valor=" + valor
					+ "]";
		}

		 
}
