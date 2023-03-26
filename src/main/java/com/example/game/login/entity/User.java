package com.example.game.login.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    private String username;
    private String password;
    private String roleId;

    @CreatedDate
    @Column(columnDefinition = "timestamp NULL DEFAULT NOW()")
    private Date createTime;
}
