package com.app.patientInfo.vo;

import com.app.patientInfo.model.PatientMedicine;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PatientMedicineVO implements Serializable {

    private Integer id;
    private String medicineName;
    private Date date;
    private Double medicineCost;
    private String medicineStrength;
    private String comment;
    private PatientInformationVO patientInformationVO;
    private Integer medicineId;
    private Integer units;

    public PatientMedicine toEntity() {
        PatientMedicine patientMedicine = new PatientMedicine();
        patientMedicine.setId(id);
        patientMedicine.setComment(comment);
        patientMedicine.setDate(date);
        patientMedicine.setUnits(units);
        return patientMedicine;
    }

}
