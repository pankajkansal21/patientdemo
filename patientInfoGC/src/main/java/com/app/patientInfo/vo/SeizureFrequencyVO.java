package com.app.patientInfo.vo;

import com.app.patientInfo.model.SeizureFrequency;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SeizureFrequencyVO implements Serializable {

    private Integer id;
    private Date date;
    private Double cost;
    private Integer seizuresCount;

    public SeizureFrequency toEntity() {
        SeizureFrequency seizureFrequency = new SeizureFrequency();
        seizureFrequency.setId(id);
        seizureFrequency.setDate(date);
        seizureFrequency.setCost(cost);
        seizureFrequency.setSeizuresCount(seizuresCount);
        return seizureFrequency;
    }
}
