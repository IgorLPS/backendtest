package com.mymovements.facade; 
 
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import com.mymovements.config.LancamentoConfig;
import com.mymovements.converter.ConverterData;
import com.mymovements.data.PagamentoData;
import com.mymovements.data.RecebimentoData;
import com.mymovements.dto.MovimentacaoDTO;
import com.mymovements.dto.PagamentoDTO;
import com.mymovements.dto.RecebimentoDTO;
import com.mymovements.service.LancamentoService;
import com.mymovements.service.PagamentosService;
import com.mymovements.service.RecebimentoService;
import com.mymovements.util.LancamentoUtil;
/**
 * 
 * Classe Facade que contem invocação das classes de chamadas de serviço, da classe de leitura de arquivo .log, e a lógica
 * 
 * @author igor.leonardo.silva
 *
 */
public class LancamentoFacade {
	RecebimentoService recebimentoService;
	PagamentosService pagamentosService;
	LancamentoService lancamentoService;
	List<RecebimentoData> recebimentoList;
	List<PagamentoData> pagamentoList;
	List<String> linhasArquivo;
	List<MovimentacaoDTO> movimentacao;
	/**
	 * Metodo construtor, inicializar as listas e classes services
	 */
	public LancamentoFacade() {
		recebimentoService = new RecebimentoService();
		pagamentosService = new PagamentosService(); 
		lancamentoService = new LancamentoService();
		recebimentoList = new ArrayList<>();
		pagamentoList = new ArrayList<>();
		linhasArquivo = new ArrayList<>(); 
	}   
	
	/**
	 * Verificar se as listas estão vazias e carregar
	 */
	public void verificarListas(){
		if(this.pagamentoList.isEmpty() || this.recebimentoList.isEmpty()){
			loadData();	
		} 
	}
	/**
	 * Carregar informações
	 */
	public void loadData(){
		recebimentoList = recebimentoDatList();
		pagamentoList =  pagamentoDataList();
		linhasArquivo = lancamentoService.lancamentosArquivo();
		carregarDadosArquivo();    
		movimentacao = mergeLancamentos();
	} 
	
	/**
	 * Lista dos Recebimentos
	 * 
	 * @return
	 */
	public List<RecebimentoData> recebimentoDatList(){
		List<RecebimentoDTO> dtoList = recebimentoService.recebimentoDTO();
		List<RecebimentoData> dataList = new ArrayList<>();
		dtoList.stream().forEach(dto -> dataList.add(ConverterData.converterDtoToDataRecebimento(dto)));
		return dataList;
	}
	
	/**
	 * Lista de Pagamento
	 * 
	 * @return
	 */
	public List<PagamentoData> pagamentoDataList(){
	    List<PagamentoDTO> dtoList = pagamentosService.pagamentoDTO();
		List<PagamentoData> dataList = new ArrayList<>();
		dtoList.stream().forEach(dto -> dataList.add(ConverterData.converterDtoToDataPagamento(dto)));
		return dataList;
	}    
    /**
     * Carregar as listas do arquivo log, e faz divisão e inseri os dados de acordo com Pagamento e recebimento
     * 
     */
	public void carregarDadosArquivo(){ 
	     for(String linha : this.linhasArquivo) {
			   String [] sArray = linha.split(";");
				if(LancamentoUtil.isNegative(sArray[2])){  
					this.pagamentoList.add(ConverterData.convertStringPagamentoData(sArray));
				}else{ 
					this.recebimentoList.add(ConverterData.convertStringRecebimentoData(sArray));
				}
			}
	}  
	
	/**
	 *  Mesclando informações; convertendo objetos para objetos Pagamento e Recebimento para  MovimentacaoDTO, 
	 *  ordenando por Data.
	 *  Metodo chamado no metodo load, para preencher List<MovimentacaoDTO> movimentacao
	 */ 
	public List<MovimentacaoDTO> mergeLancamentos(){
		List<MovimentacaoDTO> movimentacao = new ArrayList<>();
		this.recebimentoList.stream().forEach(r -> movimentacao.add(ConverterData.convertToMovimentacaoDTO(r)));
		this.pagamentoList.stream().forEach(p -> movimentacao.add(ConverterData.convertToMovimentacaoDTO(p)));  
		Collections.sort(movimentacao , new Comparator<MovimentacaoDTO>() { 
			public int compare(MovimentacaoDTO o1, MovimentacaoDTO o2) { 
				return o1.getData().compareTo(o2.getData()); 
				} 
			} 
		); 
		return movimentacao;
	}
	
	/**
	 * exibir o log de movimentações de forma ordenada;
	 * Informações obtida na lista mergeLancamentos() que foi preenchida no metodo load
	 */ 
	public List<MovimentacaoDTO> todosLancamentos(){ 
		return movimentacao;
	} 
	
	 /**
	  * informar qual categoria cliente gastou mais;
	  * @param movimentacao
	  * @return
	  */
	public HashMap<String,Double> maxCategoria(){    
		HashMap<String,Double> gastosPorCategoria = new HashMap<>();
		Double valueMax = 0.0;
		String keyMax = "";
		  for (Map.Entry<String, Double> entrys : gastosPorCategoria().entrySet()) {
		      String key = entrys.getKey();
		      Double value = entrys.getValue();  
		      Double valuePositive = value;
		      if(valuePositive > valueMax){
		    	  valueMax = value;
		    	  keyMax = key;
		      } 
		    }
		gastosPorCategoria.put(keyMax, valueMax); 
		return gastosPorCategoria;
	} 
	 /**
	  * Lista filtrada de todas as categorias, normalizando caracteres
	  * @return
	  */
	 public List<String> categoriasList(){
			List <String> categoriaList = new ArrayList<>(); 
			pagamentoList.stream().collect(Collectors.groupingBy(PagamentoData::getCategoria)).forEach((a,b) -> categoriaList.add(a));   
			return filtrarCategoria(categoriaList);
	 }
	 /**
	  * Gastos por Categoria
	  * @param Categoria
	  * @return
	  */
	public HashMap<String,Double> gastosPorCategoria(){   
		HashMap<String,Double> gastosPorCategoria = new HashMap<>();  
		  for(String c: categoriasList()){ 
			Double d = 0.0;
			for(PagamentoData p: this.pagamentoList){
				if(LancamentoUtil.equalsCategoria(c,p.getCategoria())){
					d = d+p.getValor();
				}
			} 
			gastosPorCategoria.put(c, d*-1);
		}  
		return gastosPorCategoria;
	} 
	
	
	/**
	  * informar qual Mês o cliente gastou mais;
	  * @param movimentacao
	  * @return
	  */
	public HashMap<String,Double> maxMes(){    
		HashMap<String,Double> gastosPorMes = new HashMap<>();
		Double valueMax = 0.0;
		String keyMax = new String();
		  for (Map.Entry<String, Double> entrys : gastosPorMes().entrySet()) {
			  String key = entrys.getKey();
		      Double value = entrys.getValue();  
		      Double valuePositive = value*-1;
		      if(valuePositive > valueMax){
		    	  valueMax = value*-1;
		    	  keyMax = key;
		      } 
		    }
	    gastosPorMes.put(""+keyMax , valueMax); 
		return gastosPorMes;
	} 
	 /**
	  * Lista filtrada dos meses
	  * @return
	  */
	 public List<String> mesList(){
		 List <String> mesList = new ArrayList<>(); 
		 pagamentoList.stream().collect(Collectors.groupingBy(PagamentoData::getMonth)).forEach((a,b) -> mesList.add(a));  
		 return mesList;
	 }

	 /**
	  * Gastos por Mês, lista consolidade os meses e seus gastos.
	  * Utilizado para informar qual foi o mês que cliente mais gastou;
	  * @param movimentacao
	  * @return
	  */
	public HashMap<String,Double> gastosPorMes(){   
		HashMap<String,Double> gastosPorMes = new HashMap<>();  
		BiPredicate<PagamentoData,String> testar = (a,b) -> LancamentoUtil.strToStrMonth(a.getData()).equalsIgnoreCase(b);
		for(String month: mesList()){ 
			Double d = 0.0;  
			for(PagamentoData p: this.pagamentoList){ 
				if(testar.test(p,month)){ 
					d = d+p.getValor();
				}
			}   
			gastosPorMes.put(month, d); 
		} 
		return gastosPorMes;
	} 
	
	/**
	 * quanto de dinheiro o cliente gastou;
	 * Pagamentos
	 * @return
	 */
	public Double totalGasto(){   
	    List<Double> valorList = new ArrayList<>();
	    this.pagamentoList.stream().forEachOrdered(v -> valorList.add(v.getValor()));
		Double totalGasto = valorList.stream().mapToDouble(value -> value).sum();
		return  totalGasto*-1;
	} 
	
	/**
	 * quanto de dinheiro o cliente recebeu
	 * @return totalRecebido
	 */
	public Double totalRecebido(){ 
	    List<Double> valorList = new ArrayList<>();
	    this.recebimentoList.stream().forEachOrdered(v -> valorList.add(v.getValor())); 
		return  valorList.stream().mapToDouble(value -> value).sum();
	}
	 
	/**
	 * saldo total de movimentações do cliente.
	 * Total Recebido - o total Gasto
	 * @return totalRecebido
	 */
	public Double saldoTotal(){  
	   return totalRecebido()-totalGasto();
	}  
	
	
	/**
	 * 
	 * Lista de categorias, normalizando o nome
	 * @param categoriaList
	 * @return
	 */
	private List <String> filtrarCategoria(List <String> categoriaList){
		List <String> newCategoriaList = new ArrayList<>();
		for(String s: categoriaList){
			String categoria = findCategoria(categoriaList,s);
			if(null != categoria && !contain( newCategoriaList,  categoria)){ 
				newCategoriaList.add(categoria);
			}
		}
		return newCategoriaList;
	}
	/**
	 * Metodo para verificar se contem determinada categoria na lista
	 * @param newCategoriaList
	 * @param categoria
	 * @return
	 */
	private Boolean contain(List <String> newCategoriaList,String categoria){
		for(String s: newCategoriaList){
			 if(categoria.toLowerCase().equalsIgnoreCase(s.toLowerCase())){
				 return true;
			 }
		}
		return false;
	}
	/**
	 */
	private String findCategoria(List <String> categoriaList,String categoria){ 
		List<String> listAux = new ArrayList<>();
		for(String c:categoriaList){
			if(LancamentoUtil.equalsCategoria(c,categoria)){
				listAux.add(c);
			}
		} 
		if(listAux.size() ==1){
			return listAux.get(0);
		} 
		for(String c:listAux){
		   if(LancamentoUtil.contemCaracterEspecial(c)){
			return c;
			}
		} 
		return null;
	}  
	
	 /**
	  * Metodo para mostrar as informações de configuração 
	  * @param 
	  * @return
	  */
	public HashMap<String,String> configList(){    
		HashMap<String,String> configList = new HashMap<>();
		configList.put("EndPoint Pagamento",  LancamentoConfig.ENDPOINT_PAGAMENTO);
		configList.put("EndPoint Recebimento",  LancamentoConfig.ENDPOINT_RECEBIMENTO);
		configList.put("Path Arquivo log",  LancamentoConfig.ARQUIVO);
		return configList;
	} 

	 
	
	
}
