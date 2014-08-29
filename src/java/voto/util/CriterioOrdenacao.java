/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package voto.util;

import org.apache.commons.lang.ObjectUtils;


public class CriterioOrdenacao {

	private String propriedade;
	private boolean ascendente;

	public CriterioOrdenacao(String propriedade) {
		this(propriedade, true);
	}

	public CriterioOrdenacao(String propriedade, boolean ascendente) {
		if (propriedade == null) {
			throw new IllegalArgumentException("propriedade não pode ser null");
		}

		setPropriedade(propriedade);
		setAscendente(ascendente);
	}

	@Override
	public int hashCode() {
		final int primo = 31;
		int hash = 1;
		hash = primo * hash + (ascendente ? 1231 : 1237);
		hash = primo * hash + ((propriedade == null) ? 0 : propriedade.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		CriterioOrdenacao criterio = (CriterioOrdenacao) obj;
		return ObjectUtils.equals(propriedade, criterio.propriedade)
			&& ascendente == criterio.ascendente;
	}

	public String getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(String propriedade) {
		this.propriedade = propriedade;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

}
