package com.example.analofurnitureinterface.service;

import com.example.analofurnitureinterface.dao.PersonRepository;
import com.example.analofurnitureinterface.entity.Person;
import com.example.analofurnitureinterface.pojo.PersonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
@Resource
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void createPerson() {
        Person person = new Person();
        PersonVO personVO1 = new PersonVO();
        personVO1.setId(51735L);
        personVO1.setName("particle");
        personVO1.setAge(19);
        personVO1.setAddress("上海");
        personVO1.setCreateTime(new Date());
        BeanUtils.copyProperties(personVO1, person);
        personRepository.save(person);
    }

    public Page<PersonVO> queryPerson() {
//        Integer page=1;
//        Integer size
        Integer page = 1;

        Integer size = 10;

        PageRequest pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(page - 1, size,Sort.Direction.DESC, "id");  //分页信息

        Date startDate = new Date(1610517360000L);
        Date endDate = new Date(1634104560000L);
        Specification<Person> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (startDate != null && endDate != null && startDate.before(endDate)) {
                predicates.add(
                        builder.greaterThanOrEqualTo(root.get("createTime").as(Date.class), startDate));
                predicates.add(
                        builder.lessThanOrEqualTo(root.get("createTime").as(Date.class), endDate));
            }
            Predicate[] p = new Predicate[predicates.size()];
            return builder.and(predicates.toArray(p));
        };
        PersonVO personVO02 = new PersonVO();
        personVO02.setAddress("fang");
        personVO02.setCreateTime(new Date());
        personVO02.setAge(13);
        personVO02.setName("fang");
        personVO02.setId(5173L);

        log.info(String.valueOf(pageable));
        List<Person> personList = personRepository.findAll(specification);
        Page<Person> people = personRepository.findAll(specification, pageable);
        log.info(String.valueOf(people));
        return people.map(temporaryObj -> {
            PersonVO personVO = new PersonVO();
            BeanUtils.copyProperties(temporaryObj, personVO);
            return personVO;

        });

    }
}
