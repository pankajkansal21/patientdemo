package com.app.patientInfo.vo;

import com.app.patientInfo.model.HospitalAccompanyingPerson;
import lombok.Data;

import java.io.Serializable;

@Data
public class HospitalAccompanyingPersonVO implements Serializable {

    private Integer id;
    private Boolean working;
    private String occupation;
    private Double accommodationCost;
    private Double wagesLost;

    public HospitalAccompanyingPerson toEntity() {
        HospitalAccompanyingPerson hospitalAccompanyingPerson = new HospitalAccompanyingPerson();
        hospitalAccompanyingPerson.setWorking(working);
        hospitalAccompanyingPerson.setOccupation(occupation);
        hospitalAccompanyingPerson.setAccommodationCost(accommodationCost);
        hospitalAccompanyingPerson.setWagesLost(wagesLost);
        return hospitalAccompanyingPerson;
    }
}
