package com.operator.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import org.apache.jasper.JasperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasper.DBconnection;
import com.operator.dto.OperatorDto;
import com.operator.model.Operator;
import com.operator.model.Visitor;
import com.operator.repository.OperatorRepository;
import com.operator.repository.UpdateVisitor;
import com.operator.repository.VisitorRepository;
import java.sql.Connection;

@Service
public class OperatorService {
	DBconnection db = new DBconnection();
	Connection conn = db.getconnection();
	@Autowired
	private OperatorRepository operatorRepository;
	@Autowired
	private VisitorRepository visitorRepository;
	@Autowired
	private UpdateVisitor updateVisitor;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClientBuilder;

	/**
	 * method for register operator
	 * 
	 * @param operatorDto
	 * @return
	 */
	public Operator registerOperator(Operator operator) {
		/*
		 * Operator operator = new Operator();
		 * operator.setOperatorName(operatorDto.getOperatorName());
		 * operator.setOperatorCode(operatorDto.getOperatorCode());
		 */operatorRepository.save(operator);
		return operator;
	}

	/**
	 * method for get list of operator
	 * 
	 * @return
	 */
	public List<Operator> getAllOperator() {
		return operatorRepository.findAll();
	}
      
	public Optional<Operator> getOperatorById(long id) {
		
		return operatorRepository.findById(id);
		
	}
	/**
	 * method for call visitor microservice get all visitor list
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public Visitor[] getAllVisitorList() throws JsonProcessingException {
		String url = "http://localhost:8084/visitor/visitorList";
		Visitor[] visitorlist = restTemplate.getForObject(url, Visitor[].class);
		return visitorlist;
	}

	/**
	 * methos for get visitor list by id
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public Visitor getListByVisitorId(long id) throws JsonProcessingException {
		int status = 1;

		String url = "http://localhost:8084/visitor/visitorList/"+id;
		Visitor visitorlist = restTemplate.getForObject(url, Visitor.class);
		System.out.println("RESPONSE " + visitorlist.getStatus());
		ObjectMapper mapper = new ObjectMapper();
		String visitorjson = mapper.writeValueAsString(visitorlist);
		System.out.println("expense list is:" + visitorjson);
		System.out.println("URL" + url);
		/*
		Alternative WebClient way
		Movie movie = webClientBuilder.build().get().uri("http://localhost:8084/visitor/visitorList/"+id)
		.retrieve().bodyToMono(Visitor.class).block();
		*/
		return visitorlist;

	}

/**
 * method for update status
 * @param id
 * @return
 */
	public String updateVisitorStatus(long id) {
		// TODO Auto-generated method stub
		if (visitorRepository.findById(id).isPresent()) {
			Visitor visitor = visitorRepository.findById(id).get();
		
					updateVisitor.updateStatusById(id);
					//visitor.setStatus(1);
				//Visitor updateVisitor = visitorRepository.save(visitor);
			
		}
		return "Visitor updated successfully";

	}


/**
 * method for generate Ticket print
 * @param id
 * @param response
 * @return
 * @throws IOException
 * @throws SQLException
 * @throws JRException
 */
	public int ticketPrint(long id, HttpServletResponse response) throws IOException, SQLException, JRException {
		System.out.println("ticket visitor id" + id);
		InputStream stream = getClass().getResourceAsStream("/TicketPrint.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(stream);
		Map<String, Object> params = new HashMap<>();
		params.put("visitor_id", id);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return 0;
	}
	
	
	public String sendMailToContactPerson()
	{
		//call email microservice
		return "Mail send successfully";
		
	}
	
	/**
	 * send mail to the visitor
	 * 
	 * @return
	 */
	public String sendMailToVIsitor() {
		//call email microservice
		return null;

	}
//http://localhost:8888/email/sendemail	
	
	public String deleteOperator(Operator operator) {
		operatorRepository.delete(operator);
		return "delete successfully";
	}
	//return employee as null
		public Visitor getVisitorNull() throws VisitorServiceException {

			return null;
		}

	    //throw exception
		public Visitor getVisitorException() throws VisitorServiceException {

			throw new VisitorServiceException();
		}
}
