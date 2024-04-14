package com.app.patientInfo.dao;

import com.app.patientInfo.model.HospitalAdmission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalAdmissionDao extends CrudRepository<HospitalAdmission, Integer> {

}
