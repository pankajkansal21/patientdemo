package com.app.patientInfo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
}
