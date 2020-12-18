package com.mysql.demo.entity;

import static com.mysql.demo.utils.AesEncodeUtil.PRIVATE_KEY;
import static com.mysql.demo.utils.AesEncodeUtil.decrypt2Str;
import static com.mysql.demo.utils.AesEncodeUtil.encrypt2Str;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public void setName(String name) throws Exception {
        this.name = encrypt2Str(name, PRIVATE_KEY);
    }

    public String getName() throws Exception {
        return decrypt2Str(name, PRIVATE_KEY);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
