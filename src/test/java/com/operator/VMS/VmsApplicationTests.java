/*
 * package com.operator.VMS;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * import java.util.stream.Collectors; import java.util.stream.Stream; import
 * org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.fasterxml.jackson.core.JsonProcessingException; import
 * com.operator.model.Operator; import com.operator.model.Visitor; import
 * com.operator.repository.OperatorRepository; import
 * com.operator.repository.VisitorRepository; import
 * com.operator.service.OperatorService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class VmsApplicationTests {
 * 
 * @Autowired private OperatorService service; //mock repository
 * 
 * @MockBean private OperatorRepository repository;
 * 
 * @MockBean private VisitorRepository visitorRepository;
 * 
 *//**
	 * It test get operator list
	 */
/*
 * @Test public void getOperstorsTest() { when(repository.findAll()).thenReturn(
 * Stream.of(new Operator(1, "Anushree", "Anushree", "Anushree",
 * 1)).collect(Collectors.toList())); assertEquals(1,
 * service.getAllOperator().size()); }
 *//**
	 * It test get visitor list
	 * 
	 * @throws JsonProcessingException
	 */
/*
 * @Test public void getVisitorsTest() throws JsonProcessingException {
 * when(visitorRepository.findAll()).thenReturn(Stream.of(new Visitor(1,
 * "Anushree", "anu@gmail.com", 0, "9845671230", "Deola", "India", "Maharastra",
 * "Pune", "adhar card", "Ekta", "ekta@gmail.com", "naukari", "interview",
 * 0)).collect(Collectors.toList()));
 * assertEquals(13,service.getAllVisitorList().length); }
 *//**
	 * It test save operator operation
	 */
/*
 * @Test public void saveOperator() { Operator operator = new Operator(1,
 * "Anushree", "Anushree", "Anushree", 1);
 * when(repository.save(operator)).thenReturn(operator); assertEquals(operator,
 * service.registerOperator(operator)); }
 *//**
	 * update vistor status
	 */
/*
 * @Test public void updateVisitorStatus() {
 * 
 * assertEquals(1,1); }
 *//**
	 * It test save delete operation
	 *//*
		 * @Test public void deleteOperator() { Operator operator = new Operator(1,
		 * "Anushree", "Anushree", "Anushree", 1); service.deleteOperator(operator);
		 * verify(repository, times(1)).delete(operator); } }
		 */