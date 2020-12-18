package com.mysql.demo.entity;

import static com.mysql.demo.common.Const.PRIVATE_KEY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    private String username;
    @Column(name = "password")
    @ColumnTransformer(
        read = "CAST(AES_DECRYPT(UNHEX(password), "+ PRIVATE_KEY + ") as char(128))",
        write = "HEX(AES_ENCRYPT(?," + PRIVATE_KEY + "))"  )
    private String password;

}
