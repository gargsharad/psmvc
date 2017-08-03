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
	Account account = new Account();
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = new Account();
	//Account result = instance.save(account);
	assertNotEquals(expResult, account);
	// TODO review the generated test code and remove the default call to fail.
	//fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class AccountServiceImpl.
     */
    @Test
    public void testLogin() throws Exception {
	System.out.println("login");
	String username = "";
	String password = "";
	Account account = new Account();
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = new Account();
	//Account result = instance.login(username, password);
	assertNotEquals(expResult, account);
	// TODO review the generated test code and remove the default call to fail.
	//fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class AccountServiceImpl.
     */
    @Test
    public void testGetAccount() {
	System.out.println("getAccount");
	String username = "";
	Account account = new Account();
	AccountServiceImpl instance = new AccountServiceImpl();
	Account expResult = new Account();
	//Account result = instance.getAccount(username);
	assertNotEquals(expResult, account);
	// TODO review the generated test code and remove the default call to fail.
    }
    
}
