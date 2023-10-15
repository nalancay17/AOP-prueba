package com.nico.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nico.aop.dao.ClienteDAO;
import com.nico.aop.dao.ClienteVipDAO;

public class Principal {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		ClienteDAO clienteDao = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteVipDAO clienteVipDao = contexto.getBean("clienteVipDAO", ClienteVipDAO.class);
		clienteDao.insertaCliente();

		System.out.println();

		clienteVipDao.insertaClienteVIP();
		contexto.close();
	}
}
