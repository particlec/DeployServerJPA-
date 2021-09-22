package com.example.analofurnitureinterface.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pm_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nickname;
    private String telnum;
    @Temporal(TemporalType.TIMESTAMP)
    private Date signDate;
    //spring boot jpa 需要提供默认的构造函数
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    //此处省略get和set方法
}

