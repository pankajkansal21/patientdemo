package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.CivilHospitalVisitVO;
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
public class CivilHospitalVisitAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private CivilHospitalVisitVO civilHospitalVisitVO;

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
            requiredStrings = {
                    @RequiredStringValidator(fieldName = "civilHospitalVisitVO.transportMode", message = "Enter value for Transport mode."),
                    @RequiredStringValidator(fieldName = "civilHospitalVisitVO.occupation", message = "Enter value for Occupation."),
                    @RequiredStringValidator(fieldName = "civilHospitalVisitVO.workStatus", message = "Enter value for Work status.")},
            requiredFields = {
                    @RequiredFieldValidator(fieldName = "civilHospitalVisitVO.hospitalDistance", message = "Enter value for Distance from home (in Km)."),
                    @RequiredFieldValidator(fieldName = "civilHospitalVisitVO.costToCome", message = "Enter value for Cost to reach hospital."),
                    @RequiredFieldValidator(fieldName = "civilHospitalVisitVO.costToGoHome", message = "Enter value for Cost to go back home.")}
    )
    public String addCivilHospitalVisit() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addCivilHospitalVisit(patientInformation.getId(), civilHospitalVisitVO);
        addActionMessage("Civil hospital visit added successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String showEdit() {
        if (!isValidUser()) {
            return LOGIN;
        }

        civilHospitalVisitVO = patientInformationService.getPatient(patientInformation.getId()).getCivilHospitalVisitVO();
        return SUCCESS;
    }

    public String updateCivilHospitalVisit() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.updateCivilHospitalVisit(patientInformation.getId(), civilHospitalVisitVO);
        addActionMessage("Civil hospital visit updated successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }
}
