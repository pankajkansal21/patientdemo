package com.app.patientInfo.model;

import com.app.patientInfo.vo.MedicineVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class Medicine implements Serializable {

    @Id
    @GeneratedValue/*(strategy = GenerationType.SEQUENCE)*/
    private Integer id;
    private String name;
    private String strength;
    private double price;

    public MedicineVO toVO() {
        MedicineVO medicine = new MedicineVO();
        medicine.setId(id);
        medicine.setName(name);
        medicine.setPrice(price);
        medicine.setStrength(strength);
        return medicine;
    }

}
