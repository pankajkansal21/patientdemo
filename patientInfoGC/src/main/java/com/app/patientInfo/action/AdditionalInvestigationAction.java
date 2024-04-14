package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.AdditionalInvestigationVO;
import com.app.patientInfo.vo.PatientInformationVO;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class AdditionalInvestigationAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private AdditionalInvestigationVO additionalInvestigationVO;

    @Autowired
    private PatientInformationService patientInformationService;

    @SkipValidation
    public String show() {
        if(!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    @Validations(
            requiredStrings = {@RequiredStringValidator(fieldName = "additionalInvestigationVO.investigationType", message = "Enter value for Additional Investigation Type.")},
            requiredFields = {
                            @RequiredFieldValidator(fieldName = "additionalInvestigationVO.date", message = "Enter value for Additional Investigation Date."),
                            @RequiredFieldValidator(fieldName = "additionalInvestigationVO.cost", message = "Enter value for Additional Investigation Cost.")}
    )
    public String addAdditionalInvestigation() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addAdditionalInvestigation(patientInformation.getId(), additionalInvestigationVO);
        addActionMessage("Additional Investigation added successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String deleteAdditionalInvestigation() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.deleteAdditionalInvestigation(additionalInvestigationVO.getId(), patientInformation.getId());
        addActionMessage("Additional Investigation deleted successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }
}
