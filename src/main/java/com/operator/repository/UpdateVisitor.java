/*
 * package com.operator.repository;
 * 
 * import org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.operator.model.Visitor;
 * 
 * @Repository public class UpdateVisitor {
 * 
 * @Autowired private SessionFactory sessionFactory; public void
 * updateVisitorStatus(int id, int status) { Visitor
 * visitor=(Visitor)sessionFactory.getCurrentSession().get(Visitor.class, id);
 * visitor.setStatus(1);
 * sessionFactory.getCurrentSession().saveOrUpdate(visitor);
 * 
 * } }
 */