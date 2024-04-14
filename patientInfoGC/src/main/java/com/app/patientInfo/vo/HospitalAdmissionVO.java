package com.app.patientInfo.vo;

import com.app.patientInfo.model.HospitalAdmission;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class HospitalAdmissionVO {

    private Integer id;
    private Date hospitalizationDate;
    private Double cost;
    private String comment;

    private Double transportationCost;
    private Double foodCost;
    private Double medicineCost;
    private Double investigationCost;
    private HospitalAccompanyingPersonVO firstAccompanyingPersonVO;
    private HospitalAccompanyingPersonVO secondAccompanyingPersonVO;
    private HospitalAccompanyingPersonVO thirdAccompanyingPersonVO;
    private HospitalAccompanyingPersonVO fourthAccompanyingPersonVO;

    public HospitalAdmission toEntity() {
        return toEntity(new HospitalAdmission());
    }

    public HospitalAdmission toEntity(HospitalAdmission hospitalAdmission) {
        hospitalAdmission.setId(id);
        hospitalAdmission.setComment(comment);
        hospitalAdmission.setHospitalizationDate(hospitalizationDate);
        hospitalAdmission.setCost(cost);
        hospitalAdmission.setFoodCost(foodCost);
        hospitalAdmission.setInvestigationCost(investigationCost);
        hospitalAdmission.setTransportationCost(transportationCost);
        hospitalAdmission.setMedicineCost(medicineCost);

        if (firstAccompanyingPersonVO != null) {
            hospitalAdmission.setFirstAccompanyingPerson(firstAccompanyingPersonVO.toEntity());
        }

        if (secondAccompanyingPersonVO != null) {
            hospitalAdmission.setSecondAccompanyingPerson(secondAccompanyingPersonVO.toEntity());
        }

        if (thirdAccompanyingPersonVO != null) {
            hospitalAdmission.setThirdAccompanyingPerson(thirdAccompanyingPersonVO.toEntity());
        }

        if (fourthAccompanyingPersonVO != null) {
            hospitalAdmission.setFourthAccompanyingPerson(fourthAccompanyingPersonVO.toEntity());
        }

        hospitalAdmission.setFirstAccompanyingPerson(firstAccompanyingPersonVO.toEntity());
        hospitalAdmission.setSecondAccompanyingPerson(secondAccompanyingPersonVO.toEntity());
        return hospitalAdmission;
    }
}
