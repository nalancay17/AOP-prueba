package com.nico.aop.dao;

import org.springframework.stereotype.Component;

import com.nico.aop.Cliente;

@Component
public class ClienteVipDAO {

	public String insertaClienteVIP() {
		System.out.println("Inserción de cliente VIP");
		return "Inserción correcta";
	}

	public void actualizaClienteVIP() {
		System.out.println("Actualiza cliente VIP sin argumento");
	}

	public void actualizaClienteVIP(Cliente c) {
		System.out.println("Actualiza cliente VIP con argumento");
	}

}
