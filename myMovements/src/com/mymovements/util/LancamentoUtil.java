package com.mymovements.util;
 
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Classe com metodos de formatação e padronização de dados.
 * @author igor.leonardo.silva
 *
 */
public class LancamentoUtil {

	public LancamentoUtil() {
	} 
	/**
	 * 
	 * @param s
	 * @return
	 */
	public  static Double strToDouble(String s){
		String aux = s.trim(); 
		aux = aux.replaceAll(" ",""); 
	    Double valorDouble = Double.parseDouble(aux.replaceAll("\\.","").replace(",",".")); 
		return valorDouble;
	} 
	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String convertDoubleToView(Double d){
		Locale ptBr = new Locale("pt", "BR"); 
		return NumberFormat.getCurrencyInstance(ptBr).format(d).replace("R$","");
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
   public static Date strToDate(String s){
	    String aux = s.trim();    
		String symbol = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy"); 
		Date data = new Date();
		if(s.contains("-")){   
			symbol = "/";
			aux = aux.concat(symbol+"2019");
			aux = aux.replace("-",symbol).toLowerCase();
			format = new SimpleDateFormat("dd/MMM/yyyy",new Locale("en", "IN")); 
		}else{
			symbol = "/";
			format = new SimpleDateFormat("dd/MMM/yyyy"); 
			aux = aux.concat(symbol+"2019");
		}   
		 try { 
			 aux = aux.replaceAll(" ","");  
		     data = format.parse(aux); 
		} catch (ParseException e) { 
			e.printStackTrace();
			return data;
		} 
		 return data;
   }  
   
   /**
	 * 
	 * @param s
	 * @return
	 */
  public static String strToStrMonth(Date date){ 
	  String pattern = "dd/MMMM";
	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
	  String dateStr = null; 
		 try { 
			 dateStr = simpleDateFormat.format(date); 
		} catch ( Exception e) { 
			e.printStackTrace();
			return dateStr;
		} 
		 String[] month = dateStr.split("/");
		 return month[1];
  } 
   
   
   /**
	 * 
	 * @param s
	 * @return
	 */
  public static String strToStrDate(Date date){ 
	  String pattern = "dd/MMM";
	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
	  String dateStr = null; 
		 try { 
			 dateStr = simpleDateFormat.format(date); 
		} catch ( Exception e) { 
			e.printStackTrace();
			return dateStr;
		} 
		 return dateStr;
  }  
   
  /**
 	 * 
 	 * @param s
 	 * @return
 	 */
   public static String formatDateToView(Date date){ 
 	  String pattern = "dd/MMMM/YY";
 	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
 	  String dateStr = null; 
 		 try { 
 			 dateStr = simpleDateFormat.format(date); 
 		} catch ( Exception e) { 
 			e.printStackTrace();
 			return dateStr;
 		} 
 		 return dateStr;
   } 
  
 	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	/**
	 * 
	 * @param args
	 * @return
	 */
	public static Boolean contemCaracterEspecial(String args) {
		Pattern pattern = Pattern.compile("[^\\w]");
		Matcher matcher = pattern.matcher(args);
		return matcher.find();
	}
	
	
	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static Boolean isNegative(String valor){
		return strToDouble(valor) <0;
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static Boolean equalsCategoria(String s1,String s2){
		String s1Aux = removerAcentos(s1);
		String s2Aux = removerAcentos(s2); 
		return s1Aux.equalsIgnoreCase(s2Aux);
	}
	/**
	 * 
	 * @param toTrim
	 * @return
	 */
	public static String rtrim(String toTrim) {
		if(null == toTrim){
			return new String();
		}
	    char[] val = toTrim.toCharArray();
	    int len = val.length;

	    while (len > 0 && val[len - 1] <= ' ') {
	        len--;
	    }
	    return len < val.length ? toTrim.substring(0, len) : toTrim;
	}
    /**
     * 
     * @param toTrim
     * @return
     */
	public static String ltrim(String toTrim) {
		if(null == toTrim){
			return new String();
		}
	    int st = 0;
	    char[] val = toTrim.toCharArray();
	    int len = val.length;

	    while (st < len && val[st] <= ' ') {
	        st++;
	    }
	    return st > 0 ? toTrim.substring(st, len) : toTrim;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String removerAspas(String linha){ 
		return linha.replaceAll("\"", "");
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String removerEspacoLT(String str){
		String s = ltrim(str); 
		return ltrim(s);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String removerVirgula(String str){
		return str.replaceAll(",", "");
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String removerUltimoCaracter(String str){
		int tamanho = str.length();
		return str.substring(0, tamanho-1);
	}
	
}
