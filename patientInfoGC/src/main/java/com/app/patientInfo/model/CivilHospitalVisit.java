package com.app.patientInfo.model;

import com.app.patientInfo.vo.CivilHospitalVisitVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class CivilHospitalVisit {

    @Id
    @GeneratedValue
    private Integer id;
    private Double hospitalDistance;
    private String transportMode;
    private Double costToCome;
    private Double costToGoHome;
    private String workStatus;
    private String occupation;
    private Double employeeCost;
    private Boolean accompanyingPerson;
    private String accompanyingPersonWorkStatus;
    private String accompanyingPersonOccupation;
    private Double accompanyingPersonEmployeeCost;
    private Double foodCost;
    private Double timeSpentInHospital;
    private Double totalCost;
    private String comment;

    @OneToOne
    @JoinColumn(name = "patient_information_id", nullable = false)
    private PatientInformation patientInformation;

    public CivilHospitalVisitVO toVO() {
        CivilHospitalVisitVO civilHospitalVisitVO = new CivilHospitalVisitVO();
        civilHospitalVisitVO.setId(id);
        civilHospitalVisitVO.setHospitalDistance(hospitalDistance);
        civilHospitalVisitVO.setTransportMode(transportMode);
        civilHospitalVisitVO.setFoodCost(foodCost);
        civilHospitalVisitVO.setCostToCome(costToCome);
        civilHospitalVisitVO.setCostToGoHome(costToGoHome);
        civilHospitalVisitVO.setOccupation(occupation);
        civilHospitalVisitVO.setEmployeeCost(employeeCost);
        civilHospitalVisitVO.setAccompanyingPerson(accompanyingPerson);
        civilHospitalVisitVO.setAccompanyingPersonWorkStatus(accompanyingPersonWorkStatus);
        civilHospitalVisitVO.setAccompanyingPersonOccupation(accompanyingPersonOccupation);
        civilHospitalVisitVO.setAccompanyingPersonEmployeeCost(accompanyingPersonEmployeeCost);
        civilHospitalVisitVO.setComment(comment);
        civilHospitalVisitVO.setTimeSpentInHospital(timeSpentInHospital);
        civilHospitalVisitVO.setWorkStatus(workStatus);
        civilHospitalVisitVO.setTotalCost(totalCost);
        return civilHospitalVisitVO;
    }
}
