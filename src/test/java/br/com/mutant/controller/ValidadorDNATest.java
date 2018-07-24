package br.com.mutant.controller;

import controller.ValidadorDNA;
import junit.framework.TestCase;
import model.DNA;

/**
 * 
 * Classe Junit para testes TDD no ValidadorDNA
 *
 * @author Willian Carlos
 */
public class ValidadorDNATest extends TestCase{

	private DNA dnaTrue;
	private DNA dnaInvalidoComprimento;
	private DNA dnaInvalidoAltura;
	private DNA dnaCaractereInvalido;
	private DNA dnaValidoMinimo;
	ValidadorDNA validadorTest;


	public void setUp(){
		validadorTest = new ValidadorDNA();
		dnaTrue = new DNA(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
		dnaInvalidoComprimento = new DNA(new String[]{"TTGCT","CAGTG","TTATG","AGAAG","CCCCT","TCACT"});
		dnaInvalidoAltura = new DNA(new String[]{"TTGCT","CAGTG","TTATG","AGAAG"});
		dnaCaractereInvalido = new DNA(new String[]{"XTGCT","CAGTG","TTATG","AGAAG","CCCCT"});
		dnaValidoMinimo = new DNA(new String[]{"CCCC","TTTT","GGGG","AAAA"});
	}
	
	
	public void testeDNAValido()
    {
    	boolean testeDnaValido = validadorTest.validarTamanhoECaracteres(dnaValidoMinimo.getDna());
    	
    	assertTrue(testeDnaValido);

    }

	
	public void testeDNAInvalidoComprimento()
    {
  
    	boolean testeDnainvalidoCompriemnto = validadorTest.validarTamanhoECaracteres(dnaInvalidoComprimento.getDna());
    	assertFalse(testeDnainvalidoCompriemnto);

    }
	public void testeDNAInvalidoAltura()
    {
        boolean testeDnainvalidoAltura = validadorTest.validarTamanhoECaracteres(dnaInvalidoAltura.getDna());
    	assertFalse(testeDnainvalidoAltura);
    	

    }
	
	public void testeCaractereInvalido(){
		
		boolean testeDnaCaractereInvalido = validadorTest.validarTamanhoECaracteres(dnaCaractereInvalido.getDna());
		assertFalse(testeDnaCaractereInvalido);
	}
}
