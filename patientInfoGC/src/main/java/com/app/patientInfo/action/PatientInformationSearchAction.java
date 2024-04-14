package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.PatientInformationVO;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@Getter
@Setter
public class PatientInformationSearchAction extends BaseAction {

    private List<PatientInformationVO> patients = new ArrayList<>();
    private String patientName;
    private String enrollmentNo;
    private String enrollmentId;
    private Integer patientId;
    private PatientInformationVO patientInformation;

    @Autowired
    private PatientInformationService patientInformationService;

    public String show() {
        if (!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    public String search() {
        if (!isValidUser()) {
            return LOGIN;
        }

        if (isBlank(enrollmentNo) && isBlank(enrollmentId) && isBlank(patientName)) {
            addActionError("Please enter value for Enrollment No or Enrollment Id or Patient Name.");
            return INPUT;
        }

        if (StringUtils.isNotBlank(enrollmentNo)) {
            patients = patientInformationService.findByEnrollmentNo(enrollmentNo);
        } else if (StringUtils.isNotBlank(enrollmentId))
            patients = patientInformationService.findByEnrollmentId(enrollmentId);
        else {
            patients = patientInformationService.findByName(patientName);
        }

        if (patients == null || patients.isEmpty()) {
            addActionError("No patient found matching this criteria. Please try again.");
        }
        return SUCCESS;
    }

    public String deletePatient() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.delete(patientId);
        addActionError("Patient deleted successfully.");
        patients = patientInformationService.findByName(patientName);
        return SUCCESS;
    }

    public String getPatient() {
        if (!isValidUser()) {
            return LOGIN;
        }

        patientInformation = patientInformationService.getPatient(patientId);
        return SUCCESS;
    }

}
