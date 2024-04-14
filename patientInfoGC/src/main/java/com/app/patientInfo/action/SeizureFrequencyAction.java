package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.SeizureFrequencyVO;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
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
public class SeizureFrequencyAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private SeizureFrequencyVO seizureFrequencyVO;

    @Autowired
    private PatientInformationService patientInformationService;

    @SkipValidation
    public String show() {
        if (!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    @Validations(
            requiredFields = {
                    @RequiredFieldValidator(fieldName = "seizureFrequencyVO.date", message = "Enter value for Seizure Frequency Date."),
                    @RequiredFieldValidator(fieldName = "seizureFrequencyVO.cost", message = "Enter value for Seizure Frequency Cost."),
                    @RequiredFieldValidator(fieldName = "seizureFrequencyVO.seizuresCount", message = "Enter value for No. of seizures.")}
    )
    public String addSeizureFrequency() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addSeizureFrequency(patientInformation.getId(), seizureFrequencyVO);

        addActionMessage("Seizure Frequency added successfully.");

        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String deleteSeizureFrequency() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.deleteSeizureFrequency(seizureFrequencyVO.getId(), patientInformation.getId());
        addActionMessage("Seizure Frequency deleted successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }
}
