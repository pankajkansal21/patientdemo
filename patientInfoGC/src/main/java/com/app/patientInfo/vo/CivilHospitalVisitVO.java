package com.app.patientInfo.vo;

import com.app.patientInfo.model.CivilHospitalVisit;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CivilHospitalVisitVO {

    private Integer id;
    private Double hospitalDistance;
    private String transportMode;
    private Double costToCome;
    private Double costToGoHome;
    private String occupation;
    private Double employeeCost;
    private Boolean accompanyingPerson;
    private String workStatus;
    private String accompanyingPersonWorkStatus;
    private String accompanyingPersonOccupation;
    private Double accompanyingPersonEmployeeCost;
    private Double foodCost;
    private Double timeSpentInHospital;
    private Double totalCost;
    private String comment;

    public CivilHospitalVisit toEntity(CivilHospitalVisit civilHospitalVisit) {
        civilHospitalVisit.setHospitalDistance(hospitalDistance);
        civilHospitalVisit.setTransportMode(transportMode);
        civilHospitalVisit.setCostToCome(costToCome);
        civilHospitalVisit.setCostToGoHome(costToGoHome);
        civilHospitalVisit.setOccupation(occupation);
        civilHospitalVisit.setEmployeeCost(employeeCost);
        civilHospitalVisit.setAccompanyingPerson(accompanyingPerson);
        if(civilHospitalVisit.getAccompanyingPerson()) {
            civilHospitalVisit.setAccompanyingPersonWorkStatus(accompanyingPersonWorkStatus);
            civilHospitalVisit.setAccompanyingPersonOccupation(accompanyingPersonOccupation);
            civilHospitalVisit.setAccompanyingPersonEmployeeCost(accompanyingPersonEmployeeCost);
        } else {
            civilHospitalVisit.setAccompanyingPersonWorkStatus(null);
            civilHospitalVisit.setAccompanyingPersonOccupation(null);
            civilHospitalVisit.setAccompanyingPersonEmployeeCost(null);
        }

        civilHospitalVisit.setTimeSpentInHospital(timeSpentInHospital);
        civilHospitalVisit.setWorkStatus(workStatus);
        civilHospitalVisit.setFoodCost(foodCost);
        civilHospitalVisit.setComment(comment);
        civilHospitalVisit.setTotalCost(totalCost);
        return civilHospitalVisit;
    }

    public CivilHospitalVisit toEntity() {
        CivilHospitalVisit civilHospitalVisit = new CivilHospitalVisit();
        return toEntity(civilHospitalVisit);
    }
}
