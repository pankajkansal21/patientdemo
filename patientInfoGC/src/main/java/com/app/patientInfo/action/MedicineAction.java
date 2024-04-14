package com.app.patientInfo.action;

import com.app.patientInfo.service.MedicineService;
import com.app.patientInfo.vo.MedicineVO;
import com.opensymphony.xwork2.ActionSupport;
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
public class MedicineAction extends BaseAction {

    private MedicineVO medicineVO;

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
                    @RequiredStringValidator(fieldName = "medicineVO.name", message = "Enter value for Name."),
                    @RequiredStringValidator(fieldName = "medicineVO.strength", message = "Enter value for Strength.")},
            requiredFields = {
                    @RequiredFieldValidator(fieldName = "medicineVO.price", message = "Enter value for Price per unit.")}
    )
    public String save() {
        if(!isValidUser()) {
            return LOGIN;
        }

        medicineService.addMedicine(medicineVO);
        addActionMessage("Medicine Added successfully.");
        medicineVO = new MedicineVO();
        return SUCCESS;
    }

    @SkipValidation
    public String view() {
        if(!isValidUser()) {
            return LOGIN;
        }

        return SUCCESS;
    }

    @SkipValidation
    public String delete() {
        if(!isValidUser()) {
            return LOGIN;
        }

        medicineService.deleteMedicine(medicineVO.getId());
        addActionMessage("Medicine deleted successfully.");
        return SUCCESS;
    }

    public List<MedicineVO> getMedicines() {
        return medicineService.getAllMedicines();
    }

}
