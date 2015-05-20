package br.com.moip.resource;

import br.com.moip.Moip;


public abstract class MoipResource {
	protected transient Moip moip;

	public void setMoip(Moip moip) {
		this.moip = moip;
	}
}
