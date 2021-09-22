package com.example.analofurnitureinterface.dao;
import com.example.analofurnitureinterface.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {
    //根据名称准确查询
    List<Person> findByName(String name);

    Page<Person> findAll(Specification<Person> specification, Pageable pageable);
}
