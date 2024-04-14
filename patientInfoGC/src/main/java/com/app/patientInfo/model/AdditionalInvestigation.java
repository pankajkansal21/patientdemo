package com.app.patientInfo.model;

import com.app.patientInfo.vo.AdditionalInvestigationVO;
import lombok.Getter;
import lombok.Setter;

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
public class AdditionalInvestigation {

    @Id
    @GeneratedValue
    private Integer id;
    private String investigationType;
    private Date investigationDate;
    private double cost;
    private String comment;

    @ManyToOne
    @JoinColumn(name="patient_information_id", nullable=false)
    private PatientInformation patientInformation;

    public AdditionalInvestigationVO toVO() {
        AdditionalInvestigationVO additionalInvestigationVO = new AdditionalInvestigationVO();
        additionalInvestigationVO.setId(id);
        additionalInvestigationVO.setComment(comment);
        additionalInvestigationVO.setInvestigationType(investigationType);
        additionalInvestigationVO.setInvestigationDate(investigationDate);
        additionalInvestigationVO.setCost(cost);
        return additionalInvestigationVO;
    }
}
