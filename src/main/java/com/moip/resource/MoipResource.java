package com.moip.resource;

import com.moip.Moip;


public abstract class MoipResource {
	protected transient Moip moip;
	
	public void setMoip(Moip moip) {
		this.moip = moip;
	}
}
