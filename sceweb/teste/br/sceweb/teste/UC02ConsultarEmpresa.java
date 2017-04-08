package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static Empresa empresa = new Empresa();
	static EmpresaDAO empresaDAO = new EmpresaDAO();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa.setNomeDaEmpresa("Casas Bahia S/A");
		empresa.setNomeFantasia("Casas Bahia");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("111111");
		empresaDAO.adiciona(empresa);
		System.out.println("alo");
	}

	@Test
	public void CT01UC02ConsultaEmpresa_cnpj_valido() {
		assertTrue(empresa.equals(empresaDAO.consultaEmpresa("60430951000122")));
	}

	@After
	public void tearDown() throws Exception {
		empresaDAO.exclui("60430951000122");
	}
}
