package model;

import java.io.Serializable;
import java.util.Arrays;


/**
 * 
 * Classe responsável por conter os atributos do Objeto DNA
 *
* @author Willian Carlos <wcsp.1989@gmail.com.br>
 */
public class DNA implements Serializable {

	private static final long serialVersionUID = 364000012371206383L;
	
	private Integer id;

	private String [] dna;
	
	private boolean mutant;
	
	public DNA(String[] dnaConstrutor){
		this.dna=dnaConstrutor;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isMutant() {
		return mutant;
	}
	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dna);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (mutant ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DNA other = (DNA) obj;
		if (!Arrays.equals(dna, other.dna))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mutant != other.mutant)
			return false;
		return true;
	}
	public String[] getDna() {
		return dna;
	}
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	
	
	
}
