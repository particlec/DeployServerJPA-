package com.example.analofurnitureinterface.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class PersonVO {
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private Date createTime;
}
