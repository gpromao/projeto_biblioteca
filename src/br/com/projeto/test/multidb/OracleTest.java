package br.com.projeto.test.multidb;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projeto.test.dao.ClienteDAOTest;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;

public class OracleTest {

	@BeforeClass
	public static void setUp() {
		ContextSpecifier.setContext("br.com.projeto");
		ConfigDBMapper.setDefaultConnectionName("oracle");
		LiquibaseRunnerService.run();
	}

	@Test
	public void blah() {
		new ClienteDAOTest().testSave();
		new ClienteDAOTest().testUpdate();
		new ClienteDAOTest().testDelete();
		new ClienteDAOTest().testFindAll();
	}
}
