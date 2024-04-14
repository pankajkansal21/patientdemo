package com.app.patientInfo.vo;

import com.app.patientInfo.model.AdditionalInvestigation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdditionalInvestigationVO {

    private Integer id;
    private String investigationType;
    private Date investigationDate;
    private Double cost;
    private String comment;

    public AdditionalInvestigation toEntity() {
        AdditionalInvestigation additionalInvestigation = new AdditionalInvestigation();
        additionalInvestigation.setId(id);
        additionalInvestigation.setComment(comment);
        additionalInvestigation.setInvestigationType(investigationType);
        additionalInvestigation.setInvestigationDate(investigationDate);
        additionalInvestigation.setCost(cost);
        return additionalInvestigation;
    }

}
