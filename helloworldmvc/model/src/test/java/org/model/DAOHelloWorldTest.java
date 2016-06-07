package org.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DAOHelloWorldTest {
	private DAOHelloWorld dao;
	 @Before
	 public void setUp() throws Exception {
		 this.dao = DAOHelloWorld.getInstance();
		 this.dao.open();
	 }
	 @Test
	 public void testGetHelloWorld() throws SQLException {
		 String result = this.dao.getQuerySelectFirstHelloWorld();
		 assertEquals("Hello World", result);
	 }
	 
	 @After
	 public void setDown() throws SQLException {
		 this.dao.close();
	 }
}
