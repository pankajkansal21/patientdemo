package com.app.patientInfo.action;

import com.app.patientInfo.service.MedicineService;
import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientMedicineVO;
import com.app.patientInfo.vo.PatientVisitVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Component
@Getter
@Setter
public class PatientInformationAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private PatientVisitVO patientVisit;
    private PatientMedicineVO patientMedicineVO;

    @Autowired
    private PatientInformationService patientInformationService;

    @Autowired
    private MedicineService medicineService;

    @SkipValidation
    public String show() {
        if(!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(fieldName = "patientInformation.enrollmentNo", message = "Enter value for Enrollment No."),
                    @RequiredStringValidator(fieldName = "patientInformation.name", message = "Enter value for Name.")}
            /*conversionErrorFields = {@ConversionErrorFieldValidator(fieldName = "patientInformation.age", message = "Age must be integer.")}*/
    )
    public String add() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addPatient(patientInformation);
        addActionMessage("Patient Added successfully.");
        patientInformation = new PatientInformationVO();
        return SUCCESS;
    }

    @SkipValidation
    public String showEditPatient() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        if (patientInformation == null) {
            addActionError(format("Patient not found for id : %s", patientInformation.getId()));
            return INPUT;
        }
        return SUCCESS;
    }

    public String updatePatient() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformation = patientInformationService.updatePatient(patientInformation);
        addActionMessage("Patient Updated successfully.");
        return SUCCESS;
    }

    public List<String> getNameOfArmList() {
        return Arrays.asList("Home based care", "Clinic based care");
    }

    public List<String> getGenderList() {
        return Arrays.asList("Male", "Female");
    }

    public List<String> getEthnicOriginList() {
        return Arrays.asList("Punjabi", "Migrant");
    }

    public List<String> getInitialInvestigationsList() {
        return Arrays.asList("EEG", "CT Scan", "MRI");
    }
}