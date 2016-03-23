package br.com.projeto.test.commons;

import org.junit.After;
import org.junit.BeforeClass;

import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Livro;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;
import br.com.spektro.minispring.core.query.QueryExecutorService;

public class TestBase{
	
	@BeforeClass
	public static void setUp(){
		ContextSpecifier.setContext("br.com.projeto");
		ConfigDBMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}
	@After
	public void setDown() {
		QueryExecutorService.executeQuery("DELETE FROM " + Cliente.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Emprestimo.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Funcionario.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Livro.TABLE);

		QueryExecutorService
				.executeQuery("ALTER SEQUENCE SEQ_PROJETO_CLIENTE RESTART WITH 1");
		QueryExecutorService
				.executeQuery("ALTER SEQUENCE SEQ_PROJETO_EMPRESTIMO RESTART WITH 1");
		QueryExecutorService
				.executeQuery("ALTER SEQUENCE SEQ_PROJETO_FUNCIONARIO RESTART WITH 1");
		QueryExecutorService
				.executeQuery("ALTER SEQUENCE SEQ_PROJETO_LIVRO RESTART WITH 1");
		;
	}
	
	
}