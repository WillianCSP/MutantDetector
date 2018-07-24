package br.com.mutant.controller;

import controller.MutantDetector;
import junit.framework.TestCase;
import model.DNA;

/**
 * 
 * Classe Junit para testes TDD no MutantDetector
 *
 * @author Willian Carlos
 */
public class MutantDetectorTest extends TestCase
{
  
	private DNA dnaTrue;
	private DNA dnaFalse;
	private DNA dnaVaidoMinimo;
	private DNA dnaVaidoMinimoDiagonalEsqDir;
	MutantDetector detector;


	public void setUp(){
		dnaTrue = new DNA(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
		dnaFalse = new DNA(new String[]{"TTGCTA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
		dnaVaidoMinimo = new DNA(new String[]{"TTTT","TTTT","TTTT","TTTT"});
		dnaVaidoMinimoDiagonalEsqDir = new DNA(new String[]{"ATGCGA","CATTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
		detector = new MutantDetector();
	}
	
	
	public void testApp()
    {
    	boolean testeTrue = detector.isMutant(dnaTrue);
    	boolean testeFalse = detector.isMutant(dnaFalse);

    	
    	assertTrue(testeTrue);
    	assertFalse(testeFalse);

    }
	
	public void testeDNAValidoMinimo()
	{
  	boolean testeDnaValido = detector.isMutant(dnaVaidoMinimo);
  	
  	assertTrue(testeDnaValido);

  	}
	public void testeDNAValidoMinimoDiagonalEsqDir()
	{
	  	boolean testeDnaValido = detector.isMutant(dnaVaidoMinimoDiagonalEsqDir);
	  	
	  	assertTrue(testeDnaValido);

	}
}
