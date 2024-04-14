package com.app.patientInfo.dao;

import com.app.patientInfo.model.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineDao extends CrudRepository<Medicine, Integer> {

}
