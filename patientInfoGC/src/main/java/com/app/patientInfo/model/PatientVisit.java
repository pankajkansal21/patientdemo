package com.app.patientInfo.model;

import com.app.patientInfo.vo.PatientVisitVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class PatientVisit {

    @Id
    @GeneratedValue
    private Integer id;
    private String visitType;
    @Temporal(TemporalType.DATE)
    private Date visitDate;
    private double visitCost;
    private String comment;

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


    @ManyToOne
    @JoinColumn(name="patient_information_id", nullable=false)
    private PatientInformation patientInformation;

    public PatientVisitVO toVO() {
        PatientVisitVO patientVisitVO = new PatientVisitVO();
        patientVisitVO.setId(id);
        patientVisitVO.setComment(comment);
        patientVisitVO.setVisitType(visitType);
        patientVisitVO.setVisitDate(visitDate);
        patientVisitVO.setVisitCost(visitCost);
        patientVisitVO.setDistance(distance);
        patientVisitVO.setTransportMode(transportMode);
        patientVisitVO.setTotalTravelCost(totalTravelCost);
        patientVisitVO.setWagesLost(wagesLost);
        patientVisitVO.setLeaveCost(leaveCost);
        patientVisitVO.setAccompanyingPerson(accompanyingPerson);
        patientVisitVO.setAccompanyingPersonWorking(accompanyingPersonWorking);
        patientVisitVO.setAccompanyingPersonRelation(accompanyingPersonRelation);
        patientVisitVO.setAccompanyingPersonWagesLost(accompanyingPersonWagesLost);
        patientVisitVO.setAccompanyingPersonLeaveCost(accompanyingPersonLeaveCost);
        patientVisitVO.setInvestigationDuringInterimVisit(investigationDuringInterimVisit);
        patientVisitVO.setInvestigationCost(investigationCost);
        patientVisitVO.setInterimVisitMedicineCost(interimVisitMedicineCost);
        patientVisitVO.setTimeSpentInVisit(timeSpentInVisit);
        patientVisitVO.setIllnessImpactedEmployment(illnessImpactedEmployment);
        return patientVisitVO;
    }
}
