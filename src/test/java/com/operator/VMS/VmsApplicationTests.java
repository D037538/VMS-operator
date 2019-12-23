package com.operator.VMS;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import junit.framework.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.model.Visitor;
import com.operator.service.OperatorService;

@SpringBootTest
class VmsApplicationTests {
	@Autowired
	private OperatorService operatorService;
/**
 * 
 * @throws JsonProcessingException
 */
	@Test
	void testGetByVisitorId() throws JsonProcessingException {
		Visitor visitor = operatorService.getListByVisitorId(1);
		Assert.assertEquals("pragati", visitor.getName());
		//assert.assertequals("p@gmail.com", visitor.getEmail());
	}
  

}
