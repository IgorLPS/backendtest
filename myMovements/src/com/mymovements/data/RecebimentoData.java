/**
 * 
 */
package com.mymovements.data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Classe referente aos recebimentos
 * Exe:
 *  "data": "10 / jul",
    "descricao": "Marcelo B.",
    "moeda": "R$",
    "valor": "50,00"
 * @author igor.leonardo.silva
 *
 */
public class RecebimentoData extends LancamentoData  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640030791282033650L;

	/**
	 * 
	 */
	public RecebimentoData() {
		// TODO Auto-generated constructor stub
	}
    /**
     * 
     * @param data
     * @param descricao
     * @param moeda
     * @param valor
     */
	public RecebimentoData(Date data, String descricao, String moeda, Double valor) {
		super(data, descricao, moeda, valor); 
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecebimentoData [data=" + data + ", descricao=" + descricao + ", moeda=" + moeda + ", valor=" + valor
				+ "]";
	}
	

}
