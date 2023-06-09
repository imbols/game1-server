package com.example.game.login.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
        @Index(columnList = "roleId", unique = true)
})
public class User {
    @Id
    private String username;
    private String password;
    private Integer roleId;
    private String token;

    @CreatedDate
    @Column(columnDefinition = "timestamp NULL DEFAULT NOW()")
    private Date createTime;
}
