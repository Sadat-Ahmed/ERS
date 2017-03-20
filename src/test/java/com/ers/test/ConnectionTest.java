package com.ers.test;

import org.junit.Test;

import ers.utilities.ConnectionFactory;
import junit.framework.TestCase;

import static org.junit.Assert.*;

public class ConnectionTest extends TestCase {

	@Test
	public void test(){
		try {
		assertNotNull(ConnectionFactory.getConnection());
		} catch (Exception e) {
			fail();
		}
		
	}
}
