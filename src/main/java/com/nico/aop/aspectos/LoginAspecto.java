package com.nico.aop.aspectos;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.nico.aop.Cliente;

@Aspect
@Component
public class LoginAspecto {

	@Pointcut("execution(public * insertaCliente*())")
	private void prefInsercionClienteSinArgs() {}

	@Pointcut("execution(public * com.nico.aop.*.get*())")
	private void todosGetters() {}

	@Pointcut("execution(public void com.nico.aop.*.set*(..))")
	private void todosSetters() {}

	@Pointcut("todosGetters() || todosSetters()")
	private void todosGettersOSetters() {}

	@Pointcut("execution(public * encuentraClientes())")
	private void prefEncuentraClientes() {}

	@Pointcut("execution(public void com.nico.aop.dao.ClienteDAO.eliminarCliente())")
	private void eliminarCliente() {}

	@Pointcut("execution(public void com.nico.aop.dao.ClienteDAO.contarClientes())")
	private void cuentaCantidadClientes() {}

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

	@After("todosGettersOSetters()")
	public void despuesGetterOSetter() {
		System.out.println("Getter ó setter ejecutado");
	}

	@AfterReturning(pointcut = "prefEncuentraClientes()", returning = "clientes")
	public void despuesDeRetornarClientes(List<Cliente> clientes) {
		clientes.forEach(c -> {
			if (c.getTipo().equals("VIP"))
				System.out.println("Existen clientes VIP en el listado");
		});
	}

	@AfterThrowing(pointcut = "eliminarCliente()", throwing = "excepcion")
	public void despuesExcepcionEliminarCliente(Throwable excepcion) {
		System.out.println("Logs guardados para seguimiento del error");
		System.out.println("Se ha enviado un mail con los logs al equipo de desarrollo");
	}

	@Around("cuentaCantidadClientes()")
	public void antesYDespuesCuentaCliente(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Antes de la cuenta de clientes");
		jp.proceed();
		System.out.println("Después de la cuenta de clientes");
	}

}
