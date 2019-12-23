package com.operator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.operator.model.Operator;


@Repository
public interface OperatorRepository  extends JpaRepository<Operator, Long>{
	

}
