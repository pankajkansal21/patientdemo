package com.app.patientInfo.service;

import com.app.patientInfo.vo.MedicineVO;

import java.util.List;

public interface MedicineService {

    void addMedicine(MedicineVO medicineVO);

    List<MedicineVO> getAllMedicines();

    void deleteMedicine(Integer id);

}
