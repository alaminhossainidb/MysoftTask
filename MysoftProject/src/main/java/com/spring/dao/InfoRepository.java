package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Information;

@Repository
public interface InfoRepository extends JpaRepository<Information, Long>{

}
