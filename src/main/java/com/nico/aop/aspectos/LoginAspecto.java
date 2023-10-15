package com.nico.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspecto {

	@Before("execution(public * insertaCliente*())")
	public void antesInsertarCliente() {
		System.out.println("El usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}

	@After("execution(public void com.nico.aop.dao.ClienteVipDAO.actualizaClienteVIP(com.nico.aop.Cliente, ..))")
	public void despuesActualizarCliente() {
		System.out.println("Perfil correcto para actualizar cliente");
	}

}
