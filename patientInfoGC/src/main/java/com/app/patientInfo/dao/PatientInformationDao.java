package com.app.patientInfo.dao;

import com.app.patientInfo.model.PatientInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientInformationDao extends CrudRepository<PatientInformation, Integer> {

    List<PatientInformation> findByNameStartingWithIgnoreCase(String name);

    List<PatientInformation> findByEnrollmentNoStartingWithIgnoreCase(String enrollmentNo);

    List<PatientInformation> findByEnrollmentIdStartingWithIgnoreCase(String enrollmentId);
}
