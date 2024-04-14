package com.app.patientInfo.model;

import com.app.patientInfo.vo.SeizureFrequencyVO;
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
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class SeizureFrequency implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Integer seizuresCount;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "patient_information_id", nullable = false)
    private PatientInformation patientInformation;

    public SeizureFrequencyVO toVO() {
        SeizureFrequencyVO seizureFrequencyVO = new SeizureFrequencyVO();
        seizureFrequencyVO.setId(id);
        seizureFrequencyVO.setDate(date);
        seizureFrequencyVO.setCost(cost);
        seizureFrequencyVO.setSeizuresCount(seizuresCount);
        return seizureFrequencyVO;
    }
}
