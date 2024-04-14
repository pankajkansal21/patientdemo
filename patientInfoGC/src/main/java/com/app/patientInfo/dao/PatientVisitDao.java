package com.app.patientInfo.dao;

import com.app.patientInfo.model.PatientVisit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientVisitDao extends CrudRepository<PatientVisit, Integer> {


}
