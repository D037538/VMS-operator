package com.operator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.operator.model.Visitor;
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long>{
	/*
	 * @Modifying
	 * 
	 * @Query("update Visitor v set v.status = ?1 where v.id = ?1") int
	 * setStatusForEARAttachment(@Param("id") Long id,@Param("status") Integer
	 * status);
	 */
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query(value="update Visitor v set v.status =?1 where v.id =?id",nativeQuery
	 * = true)
	 *///void updateStatus(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);
	 // @Query("update Visitor v set v.status =?1 where v.id =:id") List<Integer>
	 // void updateStatus(@Param("id") Integer id,@Param("status") Integer status);
	 
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("update Visitor set status=1 where id=1") public List<Object[]>
	 * updateVisitorStatus();
	 * 
	 */
	 //@Modifying
	 //@Query("update MyJPAObject m set m.status = ?1 where m.id in ?2")
	/* @Query("update Visitor c set c.status =?1 where c.id =?id")
	 List<Visitor> updateStatus(@Param("id") Integer id);
	*/ }
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query(value ="update Visitor v set v.status=:1 where v.id =id", nativeQuery
	 * = true) public List<Object[]> updateVisitorStatus(@Param("id") Long id);
	 *///void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);

