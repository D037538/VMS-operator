package com.operator.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operator.model.Visitor;
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long>{
}

