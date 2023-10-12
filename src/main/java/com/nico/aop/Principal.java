package com.nico.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nico.aop.dao.ClienteDAO;

public class Principal {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		ClienteDAO clienteDao = contexto.getBean("clienteDAO", ClienteDAO.class);
		clienteDao.insertaCliente();
		contexto.close();
	}
}
