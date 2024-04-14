package com.app.patientInfo.model;

import com.app.patientInfo.vo.HospitalAdmissionVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class HospitalAdmission {

    @Id
    @GeneratedValue
    private Integer id;
    private Date hospitalizationDate;
    private double cost;
    private String comment;

    private Double transportationCost;
    private Double foodCost;
    private Double medicineCost;
    private Double investigationCost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "working", column = @Column(name = "first_accompanying_person_working")),
            @AttributeOverride(name = "occupation", column = @Column(name = "first_accompanying_person_occupation")),
            @AttributeOverride(name = "accommodationCost", column = @Column(name = "first_accompanying_person_accommodation_cost")),
            @AttributeOverride(name = "wagesLost", column = @Column(name = "first_accompanying_person_wages_lost")),
    })
    private HospitalAccompanyingPerson firstAccompanyingPerson;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "working", column = @Column(name = "second_accompanying_person_working")),
            @AttributeOverride(name = "occupation", column = @Column(name = "second_accompanying_person_occupation")),
            @AttributeOverride(name = "accommodationCost", column = @Column(name = "second_accompanying_person_accommodation_cost")),
            @AttributeOverride(name = "wagesLost", column = @Column(name = "second_accompanying_person_wages_lost")),
    })
    private HospitalAccompanyingPerson secondAccompanyingPerson;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "working", column = @Column(name = "third_accompanying_person_working")),
            @AttributeOverride(name = "occupation", column = @Column(name = "third_accompanying_person_occupation")),
            @AttributeOverride(name = "accommodationCost", column = @Column(name = "third_accompanying_person_accommodation_cost")),
            @AttributeOverride(name = "wagesLost", column = @Column(name = "third_accompanying_person_wages_lost")),
    })
    private HospitalAccompanyingPerson thirdAccompanyingPerson;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "working", column = @Column(name = "fourth_accompanying_person_working")),
            @AttributeOverride(name = "occupation", column = @Column(name = "fourth_accompanying_person_occupation")),
            @AttributeOverride(name = "accommodationCost", column = @Column(name = "fourth_accompanying_person_accommodation_cost")),
            @AttributeOverride(name = "wagesLost", column = @Column(name = "fourth_accompanying_person_wages_lost")),
    })
    private HospitalAccompanyingPerson fourthAccompanyingPerson;


    @ManyToOne
    @JoinColumn(name = "patient_information_id", nullable = false)
    private PatientInformation patientInformation;

    public HospitalAdmissionVO toVO() {
        HospitalAdmissionVO hospitalAdmissionVO = new HospitalAdmissionVO();
        hospitalAdmissionVO.setId(id);
        hospitalAdmissionVO.setComment(comment);
        hospitalAdmissionVO.setHospitalizationDate(hospitalizationDate);
        hospitalAdmissionVO.setCost(cost);
        hospitalAdmissionVO.setFoodCost(foodCost);
        hospitalAdmissionVO.setInvestigationCost(investigationCost);
        hospitalAdmissionVO.setTransportationCost(transportationCost);
        hospitalAdmissionVO.setMedicineCost(medicineCost);
        if(firstAccompanyingPerson != null) {
            hospitalAdmissionVO.setFirstAccompanyingPersonVO(firstAccompanyingPerson.toVO());
        }

        if(secondAccompanyingPerson != null) {
            hospitalAdmissionVO.setSecondAccompanyingPersonVO(secondAccompanyingPerson.toVO());
        }

        if(thirdAccompanyingPerson != null) {
            hospitalAdmissionVO.setThirdAccompanyingPersonVO(thirdAccompanyingPerson.toVO());
        }

        if(fourthAccompanyingPerson != null) {
            hospitalAdmissionVO.setFourthAccompanyingPersonVO(fourthAccompanyingPerson.toVO());
        }

        return hospitalAdmissionVO;
    }
}
