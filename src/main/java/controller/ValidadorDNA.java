package controller;

import java.util.Arrays;

/**
 * 
 * Classe responsável por validar o DNA recebido
 *
 * @author Willian Carlos	 
 */
public class ValidadorDNA {
	
	    public boolean validarTamanhoECaracteres(String[] dna){
	        
	        if(Arrays.stream(dna).anyMatch(sequencia -> sequencia.length() == dna.length)){
	        	if(validarCaracteres(dna))
	        		return true;
	        }
	        return false;
	       
	    }
	    private boolean validarCaracteres(String[] dna) {
	        String str = "";
	        
	        for(String sequencia: dna)
	        	str+=sequencia;
	        
	        String resultadoReplace =str.replaceAll("A","").replaceAll("T","").replaceAll("G","").replaceAll("C","");
	        //caso 
	        if(!resultadoReplace.isEmpty())
	            return false;
	        else
	        	return true;
	        
	    }

}
