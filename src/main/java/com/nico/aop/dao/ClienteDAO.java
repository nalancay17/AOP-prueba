package com.nico.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDAO {

	public void insertaCliente() {
		System.out.println("Cliente insertado correctamente");
	}
}
