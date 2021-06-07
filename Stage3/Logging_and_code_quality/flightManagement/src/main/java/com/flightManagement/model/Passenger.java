package com.flightManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Passenger {
	private String name;
	private boolean vip;
	
	public boolean isVip() {
		return this.vip;
	}
}
