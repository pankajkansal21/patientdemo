package com.app.patientInfo.vo;

import com.app.patientInfo.model.Medicine;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MedicineVO implements Serializable {

    private Integer id;
    private String name;
    private String strength;
    private Double price;

    public Medicine toEntity() {
        Medicine medicine = new Medicine();
        medicine.setId(id);
        medicine.setName(name);
        medicine.setPrice(price);
        medicine.setStrength(strength);
        return medicine;
    }

    public String getMedicineLabel() {
        return name + " - " + strength + " - " + price + "  ";
    }

}
