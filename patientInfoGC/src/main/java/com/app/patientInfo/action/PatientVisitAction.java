package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientVisitVO;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
@Setter
public class PatientVisitAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private PatientVisitVO patientVisit;

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
            requiredStrings = {@RequiredStringValidator(fieldName = "patientVisit.visitType", message = "Select value for Visit Type.")},
            requiredFields = {
                            @RequiredFieldValidator(fieldName = "patientVisit.visitDate", message = "Enter value for Visit Date."),
                            @RequiredFieldValidator(fieldName = "patientVisit.visitCost", message = "Enter value for Visit Cost.")}
    )
    public String addVisit() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addVisit(patientInformation.getId(), patientVisit);
        addActionMessage("Patient visit added successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String viewVisit() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientVisit = patientInformationService.getPatientVisit(patientVisit.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String deleteVisit() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.deleteVisit(patientVisit.getId(), patientVisit.getPatientInformationVO().getId());
        addActionMessage("Patient visit deleted successfully.");
        patientInformation = patientInformationService.getPatient(patientVisit.getPatientInformationVO().getId());
        return SUCCESS;
    }

    public List<String> getVisitTypeList() {
        return Arrays.asList("Interim visit", "Unscheduled visit", "Emergency visit", "Referral visit");
    }
}
