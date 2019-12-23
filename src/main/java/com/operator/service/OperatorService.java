package com.operator.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import org.apache.jasper.JasperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	RestTemplate restTemplate = new RestTemplate();

	/**
	 * method for register operator
	 * 
	 * @param operatorDto
	 * @return
	 */
	public Operator registerOperator(OperatorDto operatorDto) {
		Operator operator = new Operator();
		operator.setOperatorName(operatorDto.getOperatorName());
		operator.setOperatorCode(operatorDto.getOperatorCode());
		operatorRepository.save(operator);
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

		String url = "http://localhost:8084/visitor/visitorList/" + id;
		Visitor visitorlist = restTemplate.getForObject(url, Visitor.class);
		System.out.println("RESPONSE " + visitorlist.getStatus());
		ObjectMapper mapper = new ObjectMapper();
		String visitorjson = mapper.writeValueAsString(visitorlist);
		System.out.println("expense list is:" + visitorjson);
		System.out.println("URL" + url);
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
			if (visitor.getId() == id) {
				if (visitor.getStatus() == 0)
					visitor.setStatus(1);
				Visitor updateVisitor = visitorRepository.save(visitor);
			}
		}
		return "Visitor updated successfully";

	}


/**
 * method for generate Ticket print
 * @param visitor_id
 * @param response
 * @return
 * @throws IOException
 * @throws SQLException
 * @throws JRException
 */
	public int ticketPrint(int visitor_id, HttpServletResponse response) throws IOException, SQLException, JRException {
		System.out.println("ticket visitor id" + visitor_id);
		InputStream stream = getClass().getResourceAsStream("/TicketPrint.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(stream);
		Map<String, Object> params = new HashMap<>();
		params.put("visitor_id", visitor_id);
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
}