package com.nico.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteVipDAO {

	public String insertaClienteVIP() {
		System.out.println("Inserción de cliente VIP");
		return "Inserción correcta";
	}

}
