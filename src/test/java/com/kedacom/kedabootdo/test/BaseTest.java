package com.kedacom.kedabootdo.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @Description: APS-Service.
 * @author: Hu Zhongyuan
 * @version: 2015/2/6
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContextUnitTest.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Test
    public void baseTest(){
    }

    /**
     */
    @Before
    public void setUp() {

    }
}
