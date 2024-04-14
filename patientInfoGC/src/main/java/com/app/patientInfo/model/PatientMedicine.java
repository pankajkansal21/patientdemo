package com.app.patientInfo.model;

import com.app.patientInfo.vo.PatientMedicineVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class PatientMedicine implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int units;
    private String comment;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name="medicine_id", nullable=false)
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name="patient_information_id", nullable=false)
    private PatientInformation patientInformation;

    public PatientMedicineVO toVO() {
        PatientMedicineVO patientMedicineVO = new PatientMedicineVO();
        patientMedicineVO.setId(id);
        patientMedicineVO.setComment(comment);
        patientMedicineVO.setMedicineName(medicine.getName());
        patientMedicineVO.setMedicineStrength(medicine.getStrength());
        patientMedicineVO.setMedicineCost(medicine.getPrice());
        patientMedicineVO.setDate(date);
        patientMedicineVO.setUnits(units);
        return patientMedicineVO;
    }
}
