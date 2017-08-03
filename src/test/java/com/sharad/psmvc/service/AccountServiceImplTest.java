/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharad.psmvc.service;

import com.sharad.psmvc.domain.Account;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sharad Garg
 */
public class AccountServiceImplTest {
    
    public AccountServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class AccountServiceImpl.
     */
    @Test
    public void testSave() {
	System.out.println("save");
	Account account = null;
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = null;
	Account result = instance.save(account);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class AccountServiceImpl.
     */
    @Test
    public void testLogin() throws Exception {
	System.out.println("login");
	String username = "";
	String password = "";
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = null;
	Account result = instance.login(username, password);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class AccountServiceImpl.
     */
    @Test
    public void testGetAccount() {
	System.out.println("getAccount");
	String username = "";
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = null;
	Account result = instance.getAccount(username);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
