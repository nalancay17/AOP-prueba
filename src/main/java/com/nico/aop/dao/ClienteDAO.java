package com.nico.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nico.aop.Cliente;

@Component
public class ClienteDAO {

	public void insertaCliente() {
		System.out.println("Cliente insertado correctamente");
	}

	public List<Cliente> encuentraClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("María", "Normal"));
		clientes.add(new Cliente("Ana", "Normal"));
		clientes.add(new Cliente("Sandra", "VIP"));
		clientes.add(new Cliente("Antonio", "VIP"));
		
		System.out.println("Búsqueda de clientes finalizada");
		return clientes;
	}

}
