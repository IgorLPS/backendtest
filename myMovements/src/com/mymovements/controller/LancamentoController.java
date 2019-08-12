package com.mymovements.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import com.mymovements.dto.MovimentacaoDTO;
import com.mymovements.facade.*;
import com.mymovements.util.LancamentoUtil;
/**
 * Classe para expor metodos para ser consumidos por alguma View
 * 
 * @author igor.leonardo.silva
 *
 */
public class LancamentoController {
	private LancamentoFacade lancamentoFacade;
	/**
	 * Metodo construtor, inicializa Facade
	 */
	public LancamentoController() {
		lancamentoFacade = new LancamentoFacade(); 
	}   
	/**
	 * Lista do log de movimentações de forma ordenada;
	 * 
	 * @return
	 */
	public List<MovimentacaoDTO> movimentacaoOrdenada(){ 
		verificarListas();
		return lancamentoFacade.todosLancamentos();
	}
	
	/**
	 * Metodo para expor informações sobre o total de gastos por categoria;
	 * @return
	 */
	public String gastosPorCategoria(){
		verificarListas();
		HashMap<String,Double> gastosPorCategoria = lancamentoFacade.gastosPorCategoria(); 
		String outPut = new String();
		  for (Map.Entry<String, Double> entrys : gastosPorCategoria.entrySet()) {
		      String key = entrys.getKey();
		      Double value = entrys.getValue();  
		      outPut = outPut.concat(key+":"+LancamentoUtil.convertDoubleToView(value)).concat("\n"); 
		    } 
	   return outPut;
	}
	
	/**
	 * Metodo para expor informações sobre a categoria com maior gasto
	 * @return
	 */
	public String maiorGastoCategoria(){
		verificarListas();
		HashMap<String,Double> maxCategoria = lancamentoFacade.maxCategoria();
		String outPut = new String();
		  for (Map.Entry<String, Double> entrys : maxCategoria.entrySet()) {
		      String key = entrys.getKey();
		      Double value = entrys.getValue(); 
		      outPut = outPut.concat(key+":"+LancamentoUtil.convertDoubleToView(value)).concat("\n");
		    } 
	   return outPut;
	}
	
	/**
	 * Metodo para expor informação sobre o total de gastos por Mês;
	 * @return
	 */
	public String maiorGastoMes(){
		verificarListas();
		HashMap<String,Double> maxCategoria = lancamentoFacade.maxMes();
		String outPut = new String();
		  for (Map.Entry<String, Double> entrys : maxCategoria.entrySet()) {
		      String key = entrys.getKey();
		      Double value = entrys.getValue(); 
		      outPut = outPut.concat(key.toUpperCase()+":"+LancamentoUtil.convertDoubleToView(value)).concat("\n");
		    } 
	   return outPut;
	}
	 
	
	/**
	 * metodo para expor o total de gasto
	 * quanto de dinheiro o cliente gastou;
	 * @return
	 */
	public Double totalGasto(){ 
		verificarListas();
	   return lancamentoFacade.totalGasto();
	}
	 
	/**
	 * Metodo para expor informações sobre o total recebido
	 * quanto de dinheiro o cliente recebeu;
	 * @return
	 */
	public Double totalRecebido(){ 
		verificarListas();
	   return lancamentoFacade.totalRecebido();
	}
	
	/**
	 * Metodo para expor informação sobre o saldo total do cliente.
	 * saldo total de movimentações do cliente.
	 * @return
	 */
	public Double saldoTotal(){ 
		verificarListas();
	   return lancamentoFacade.saldoTotal();
	}
	
	/**
	 * Metodo para acionar metodos de Load, para carregar os dados
	 */
	public void atualizarDados(){
		lancamentoFacade.loadData();
	}
	
	/**
	 * Metodo que aciona a verificação se as listas estão preenchidas
	 */
	public void verificarListas(){
		lancamentoFacade.verificarListas();
	}
	
	
	 /**
	  * Metodo para expor uma lista de configurações
	  * informar qual categoria cliente gastou mais;
	  * @param movimentacao
	  * @return
	  */
	public HashMap<String,String> configList(){
		return lancamentoFacade.configList();
	} 
	
}
