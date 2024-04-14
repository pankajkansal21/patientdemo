package com.app.patientInfo.vo;

import com.app.patientInfo.model.PatientVisit;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PatientVisitVO implements Serializable {

    private Integer id;
    private String visitType;
    private Date visitDate;
    private Double visitCost;
    private String comment;
    private PatientInformationVO patientInformationVO;
    private Double distance;
    private String transportMode;
    private Double totalTravelCost;
    private Boolean wagesLost;
    private Double leaveCost;
    private Boolean accompanyingPerson;
    private Boolean accompanyingPersonWorking;
    private String accompanyingPersonRelation;
    private Boolean accompanyingPersonWagesLost;
    private Double accompanyingPersonLeaveCost;
    private Boolean investigationDuringInterimVisit;
    private Double investigationCost;
    private Double interimVisitMedicineCost;
    private Double timeSpentInVisit;
    private Boolean illnessImpactedEmployment;

    public PatientVisit toEntity() {
        PatientVisit patientVisit = new PatientVisit();
        patientVisit.setId(id);
        patientVisit.setComment(comment);
        patientVisit.setVisitType(visitType);
        patientVisit.setVisitDate(visitDate);
        patientVisit.setVisitCost(visitCost);
        patientVisit.setDistance(distance);
        patientVisit.setTransportMode(transportMode);
        patientVisit.setTotalTravelCost(totalTravelCost);
        patientVisit.setWagesLost(wagesLost);

        if(wagesLost) {
            patientVisit.setLeaveCost(leaveCost);
        } else {
            patientVisit.setLeaveCost(null);
        }

        patientVisit.setAccompanyingPerson(accompanyingPerson);
        if(accompanyingPerson) {
            patientVisit.setAccompanyingPersonWorking(accompanyingPersonWorking);
            patientVisit.setAccompanyingPersonRelation(accompanyingPersonRelation);
            patientVisit.setAccompanyingPersonWagesLost(accompanyingPersonWagesLost);
            patientVisit.setAccompanyingPersonLeaveCost(accompanyingPersonLeaveCost);
        } else {
            patientVisit.setAccompanyingPersonWorking(null);
            patientVisit.setAccompanyingPersonRelation(null);
            patientVisit.setAccompanyingPersonWagesLost(null);
            patientVisit.setAccompanyingPersonLeaveCost(null);
        }

        patientVisit.setInvestigationDuringInterimVisit(investigationDuringInterimVisit);
        if(investigationDuringInterimVisit) {
            patientVisit.setInvestigationCost(investigationCost);
            patientVisit.setInterimVisitMedicineCost(interimVisitMedicineCost);
        } else {
            patientVisit.setInvestigationCost(null);
            patientVisit.setInterimVisitMedicineCost(null);
        }

        patientVisit.setTimeSpentInVisit(timeSpentInVisit);
        patientVisit.setIllnessImpactedEmployment(illnessImpactedEmployment);
        return patientVisit;
    }
}
