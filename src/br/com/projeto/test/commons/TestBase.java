package br.com.projeto.test.commons;

import org.junit.BeforeClass;

import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;

public class TestBase{
	
	@BeforeClass
	public static void setUp(){
		ContextSpecifier.setContext("br.com.projeto");
		ConfigDBMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}
	
	
	
}