package com.app.patientInfo.service.impl;

import com.app.patientInfo.dao.MedicineDao;
import com.app.patientInfo.service.MedicineService;
import com.app.patientInfo.vo.MedicineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public void addMedicine(MedicineVO medicineVO) {
        medicineDao.save(medicineVO.toEntity());
    }

    @Override
    public List<MedicineVO> getAllMedicines() {
        List<MedicineVO> medicineVOs = new ArrayList<>();
        medicineDao.findAll().forEach(medicine -> medicineVOs.add(medicine.toVO()));
        return medicineVOs;
    }

    @Override
    public void deleteMedicine(Integer id) {
        medicineDao.deleteById(id);
    }

}
