package com.francetelecom.yoyo.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.francetelecom.yoyo.dao.MarketDaoJpa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public abstract class InitSpringContextTests {

	@Autowired
	protected MarketDaoJpa marketDaoJpa;

}