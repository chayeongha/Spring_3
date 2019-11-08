package com.cyh.s3;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class sqlSessionTest extends TestAbstractCase {

	
	
	@Inject
	private SqlSession sqlsession;
	
	
	@Test 
	public void sqlTest() {
		assertNotNull(sqlsession);
	}

	@Inject
	private DataSource dataSource;
	
	@Test
	public void dataSourceTest() {
		assertNotNull(dataSource);
	}
	
		
}
