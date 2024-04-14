package com.app.patientInfo.model;

import com.app.patientInfo.vo.HospitalAccompanyingPersonVO;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class HospitalAccompanyingPerson {

    private Boolean working;
    private String occupation;
    private Double accommodationCost;
    private Double wagesLost;

    public HospitalAccompanyingPersonVO toVO() {
        HospitalAccompanyingPersonVO hospitalAccompanyingPersonVO = new HospitalAccompanyingPersonVO();
        hospitalAccompanyingPersonVO.setWorking(working);
        hospitalAccompanyingPersonVO.setOccupation(occupation);
        hospitalAccompanyingPersonVO.setAccommodationCost(accommodationCost);
        hospitalAccompanyingPersonVO.setWagesLost(wagesLost);
        return hospitalAccompanyingPersonVO;
    }

}
