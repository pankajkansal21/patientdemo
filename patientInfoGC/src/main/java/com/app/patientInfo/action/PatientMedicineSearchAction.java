package com.app.patientInfo.action;

import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientMedicineVO;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
public class PatientMedicineSearchAction extends BaseAction {

    private List<PatientMedicineVO> patientMedicineVOs = new ArrayList<>();
    private Date startDate;
    private Date endDate;
    private PatientInformationVO patientInformation;
    private Integer medicineId;

    @Autowired
    private PatientInformationService patientInformationService;

    public String show() {
        if(!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    public String search() {
        if(!isValidUser()) {
            return LOGIN;
        }

        if (startDate == null || endDate == null) {
            addActionError("Start date and end date can not be null.");
            return INPUT;
        }

        patientMedicineVOs = patientInformationService.findByStartAndEndDate(patientInformation.getId(), startDate, endDate);
        if (patientMedicineVOs == null || patientMedicineVOs.isEmpty()) {
            addActionError("No patient monthly medicine found matching this criteria. Please try again.");
        }
        return SUCCESS;
    }

    public Double getTotalMedicineCost() {
        return patientMedicineVOs.stream()
                .mapToDouble(patientMedicineVO -> patientMedicineVO.getMedicineCost() * patientMedicineVO.getUnits()).sum();
    }

    public String deleteMedicine() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.deleteMedicine(patientInformation.getId(), medicineId);
        addActionMessage("Medicine deleted successfully.");
        search();
        return SUCCESS;
    }

}
