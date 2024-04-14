package com.app.patientInfo.dao;

import com.app.patientInfo.model.PatientMedicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientMedicineDao extends CrudRepository<PatientMedicine, Integer> {

    @Query("select pm from PatientMedicine pm where pm.patientInformation.id = :patientId and pm.date >= :startDate and pm.date <= :endDate")
    List<PatientMedicine> findByStartAndEndDate(@Param("patientId") Integer patientId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
