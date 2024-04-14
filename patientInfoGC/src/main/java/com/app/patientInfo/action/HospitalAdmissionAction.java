package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.HospitalAdmissionVO;
import com.app.patientInfo.vo.PatientInformationVO;
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
public class HospitalAdmissionAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
    private HospitalAdmissionVO hospitalAdmissionVO;

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
                    @RequiredFieldValidator(fieldName = "hospitalAdmissionVO.hospitalizationDate", message = "Enter value for Hospital Admission Date."),
                    @RequiredFieldValidator(fieldName = "hospitalAdmissionVO.cost", message = "Enter value for Total Admission cost.")}
    )
    public String addHospitalAdmission() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addHospitalAdmission(patientInformation.getId(), hospitalAdmissionVO);
        addActionMessage("Hospital Admission added successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String view() {
        if (!isValidUser()) {
            return LOGIN;
        }

        hospitalAdmissionVO = patientInformationService.viewHospitalAdmission(hospitalAdmissionVO.getId());
        return SUCCESS;
    }

    @SkipValidation
    public String deleteHospitalAdmission() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.deleteHospitalAdmission(hospitalAdmissionVO.getId(), patientInformation.getId());
        addActionMessage("Hospital Admission deleted successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }
}
