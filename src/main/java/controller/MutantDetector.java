package controller;

import java.util.ArrayList;

import dao.MutanteDAO;
import model.DNA;

/**
 * 
 * Classe responsável por conter os métodos para detectar os mutantes
 *
 * @author Willian Carlos	 
 */
public class MutantDetector 
{
    
    int sequenciaDNA_len;
    int contadorSeq4;
    MutanteDAO dao = new MutanteDAO();

    public boolean isMutant(DNA dna){
    
    	String[] sequenciaDNA = dna.getDna();
    	
        ArrayList<char[]> array = new ArrayList<char[]>();
 
        int len;
        int maxComprimento = 0;
        int maxAltura;
        contadorSeq4 = 0;
        sequenciaDNA_len = 4;//sequencia de 4(>2x) para ser mutante
        maxAltura = sequenciaDNA.length;

        //converter para array de chars
        for (String i: sequenciaDNA){
        	
            array.add(i.toCharArray());

            len = i.length();
            
            if(maxComprimento < len){
                maxComprimento = len;
            }
        }
        //preencher a matriz
        char[][] matriz = new char[maxAltura][maxComprimento];
        for(int i=0; i<maxAltura; i++){
            char[] tmp = array.get(i);

            //checar na horizontal
            checarSequenciaAtual(tmp);
            if(contadorSeq4 > 1){
                return true;
            }

            int tmp_len = tmp.length;
            
            for(int j=0; j<maxComprimento; j++){
                
                char elem = (j < tmp_len) ? tmp[j] : 0;

                matriz[i][j] = elem;
            }
        }
        
        //checar na vertical
        for(int j=0; j<maxComprimento; j++){
        	
            char[] tmp = new char[maxAltura];
            
            for(int i=0; i<maxAltura; i++){
                tmp[i] = matriz[i][j];
            }

            checarSequenciaAtual(tmp);

            if(contadorSeq4 > 1)
                return true;
            }

       
        int rest;
        int compItems;
        
        //diagonal (0,0)->(n,n)\
        for(int i=0; i<=maxAltura - sequenciaDNA_len; i++){
            rest = maxAltura - i;
            compItems = (rest < maxComprimento) ? rest : maxComprimento;
            char[] tmp = new char[compItems];

            for(int j=0; j<compItems; j++){
                tmp[j] = matriz[j+i][j];
            }
            checarSequenciaAtual(tmp);
        }
        for(int i=1; i<=maxComprimento - sequenciaDNA_len; i++){
            rest = maxComprimento - i;
            compItems = (rest < maxAltura) ? rest : maxAltura;
            char[] tmp = new char[compItems];

            for(int j=0; j<compItems; j++){
                tmp[j] = matriz[j][j+i];
            }
            checarSequenciaAtual(tmp);
            if(contadorSeq4 > 1)
                return true;
        }
        // diagonal (0,n)->(n,0)/
        for(int i=maxAltura-1; i >= sequenciaDNA_len-1; i--){
            rest = i+1;
            compItems = (rest < maxComprimento) ? rest : maxComprimento;
            char[] tmp = new char[compItems];
            for(int j=0; j<compItems; j++){
                tmp[j] = matriz[i-j][j];
            }

            checarSequenciaAtual(tmp);
            if(contadorSeq4 > 1)
                return true;
            
        }
        for(int i=1; i<=maxComprimento - sequenciaDNA_len; i++){
            rest = maxComprimento - i;
            compItems = (rest < maxAltura) ? rest : maxAltura;
            char[] tmp = new char[compItems];

            for(int j=0; j<compItems; j++){
                tmp[j] = matriz[maxComprimento-1-j][j+i];
            }

            checarSequenciaAtual(tmp);
            if(contadorSeq4 > 1)
                return true;
        }

        return false;
    }
    
    private void checarSequenciaAtual(char[] item){
        int l = item.length;
        char flag;

        if(l < sequenciaDNA_len){
            return;
        }

        for(int i=0; i<l-sequenciaDNA_len+1; i++){ 
        	
            flag = item[i];

            //checa o primeiro eo ultimo item na janela(sequenciaDNA_len)
            for(int j=i+sequenciaDNA_len-1; j>i; j--){
                if(flag != item[j])
                    break;
                if(j > i+1)
                    continue;
                
                contadorSeq4++;
                
                if(contadorSeq4 > 1)
                    return;
                
                i += sequenciaDNA_len -1;
            }
        }
    }

}
