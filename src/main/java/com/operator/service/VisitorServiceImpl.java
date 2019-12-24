package com.operator.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operator.model.VisitorDto;
import com.operator.model.Visitor;
import com.operator.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements IVisitorService{
	
	@Autowired
	private VisitorRepository visitorRepository;

	@Override
	public String addVisitor(VisitorDto visitorDto) {
		// TODO Auto-generated method stub
		
		Visitor va = new Visitor();
		va.setAddress(visitorDto.getAddress());
		va.setCity(visitorDto.getCity());
		va.setContactPersonEmail(visitorDto.getContactPersonEmail());
		va.setContactPersonName(visitorDto.getContactPersonName());
		va.setCountry(visitorDto.getCountry());
		va.setEmail(visitorDto.getEmail());
		va.setId(visitorDto.getId());
		va.setIdProof(visitorDto.getIdProof());
		va.setMobileNo(visitorDto.getMobileNo());
		va.setName(visitorDto.getName());
		va.setReasonForVisit(visitorDto.getReasonForVisit());
		va.setReference(visitorDto.getReference());
		va.setState(visitorDto.getState());
	    visitorRepository.save(va);
	    
		return "Recored Added successfully";
		

	}

	/*
	 * @Override public List<Visitor> visitorList() { // TODO Auto-generated method
	 * stub return visitorRepository.findAll(); }
	 */

	/*
	 * @Override public Visitor GetByIdIn(long id) { // TODO Auto-generated method
	 * stub return visitorRepository.findById(id); }
	 */
	/*
	 * public List<Visitor> updateStatus() { List<Visitor> visitorlist =
	 * visitorRepository.findAll(); int status=1; for (Visitor visitor :
	 * visitorlist) { long id = 1; //if (id == 1) { //visitor.setStatus(0);
	 * //visitorRepository.updateVisitorStatus(id1); //
	 * visitorRepository.updateStatus(id); // System.out.println("status  is:" +
	 * visitor.getStatus());
	 * 
	 * 
	 * // } if(visitor.getStatus()==0) {
	 * //visitorRepository.setStatusForEARAttachment(id, status); } // }
	 * 
	 * 
	 * //if(visitor.getId()==2) { visitor.setStatus(1); }
	 * 
	 * } return visitorlist ;
	 * 
	 * }
	 */
//	@Override
//	public Visitor getVisitorById(long id) {
//		
//		return visitorRepository.findByVisitorId(id);
//	}
	public Visitor updateVisitorStatus(long id, VisitorDto visitorDto) {
		return null;

	}

	@Override
	public Visitor sendMailToContactPerson(long id) throws JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor updateVesitorStatus(long id, VisitorDto visitorDto) {
		// TODO Auto-generated method stub
		if(visitorRepository.findById(id).isPresent()) {
			Visitor visitor=	visitorRepository.findById(id).get();
			//visitor.setStatus(visitorDto.getStatus());
			visitor.setStatus(1);
			Visitor updateVisitor=visitorRepository.save(visitor);
		}
		return null;
	

	}

	@Override
	public List<Visitor> updateStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
