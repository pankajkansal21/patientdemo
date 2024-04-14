package com.app.patientInfo.action;

import com.app.patientInfo.service.MedicineService;
import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.MedicineVO;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientMedicineVO;
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
public class PatientMedicineAction extends BaseAction {

    private List<PatientInformationVO> patients;
    private PatientInformationVO patientInformation;
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
            requiredFields = {
                    @RequiredFieldValidator(fieldName = "patientMedicineVO.medicineId", message = "Select Medicine Name."),
                    @RequiredFieldValidator(fieldName = "patientMedicineVO.units", message = "Enter value for Units."),
                    @RequiredFieldValidator(fieldName = "patientMedicineVO.date", message = "Enter value for Medicine Date.")}
    )
    public String addMedicine() {
        if(!isValidUser()) {
            return LOGIN;
        }

        patientInformationService.addMedicine(patientInformation.getId(), patientMedicineVO);
        addActionMessage("Patient medicine added successfully.");
        patientInformation = patientInformationService.getPatient(patientInformation.getId());
        return SUCCESS;
    }

    public List<MedicineVO> getMedicines() {
        return medicineService.getAllMedicines();
    }

}
