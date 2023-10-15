package com.nico.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspecto {

	@Pointcut("execution(public * insertaCliente*())")
	private void prefInsercionClienteSinArgs() {}

	@Before("prefInsercionClienteSinArgs()")
	public void antesInsertarCliente() {
		System.out.println("El usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}

	@After("execution(public void com.nico.aop.dao.ClienteVipDAO.actualizaClienteVIP(com.nico.aop.Cliente, ..))")
	public void despuesActualizarCliente() {
		System.out.println("Perfil correcto para actualizar cliente");
	}

	@Before("prefInsercionClienteSinArgs()")
	public void verificarRequisitosCliete() {
		System.out.println("El cliente cumple los requisitos para ser agregado a la BBDD");
	}

	@Before("prefInsercionClienteSinArgs()")
	public void verificarRequisitosTabla() {
		System.out.println("Se puede insertar el cliente en la tabla");
	}

}
