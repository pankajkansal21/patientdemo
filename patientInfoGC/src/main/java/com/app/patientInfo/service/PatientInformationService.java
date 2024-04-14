package com.app.patientInfo.service;

import com.app.patientInfo.vo.AdditionalInvestigationVO;
import com.app.patientInfo.vo.CivilHospitalVisitVO;
import com.app.patientInfo.vo.HospitalAdmissionVO;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientMedicineVO;
import com.app.patientInfo.vo.PatientVisitVO;
import com.app.patientInfo.vo.SeizureFrequencyVO;

import java.util.Date;
import java.util.List;

public interface PatientInformationService {
    Integer addPatient(PatientInformationVO patientInformationVO);

    PatientInformationVO updatePatient(PatientInformationVO patientInformationVO);

    PatientInformationVO getPatient(Integer id);

    List<PatientInformationVO> findByName(String Name);

    List<PatientInformationVO> findByEnrollmentNo(String enrollmentNo);

    List<PatientInformationVO> findByEnrollmentId(String enrollmentId);

    List<PatientMedicineVO> findByStartAndEndDate(Integer patientId, Date startDate, Date endDate);

    void delete(Integer id);

    PatientVisitVO getPatientVisit(Integer patientVisitId);

    void addVisit(Integer patientId, PatientVisitVO patientVisitVO);

    void deleteVisit(Integer visitId, Integer patientInformationId);

    void addMedicine(Integer id, PatientMedicineVO patientMedicineVO);

    void deleteMedicine(Integer patientInformationId, Integer medicineId);

    void addSeizureFrequency(Integer patientInformationId, SeizureFrequencyVO seizureFrequencyVO);

    void deleteSeizureFrequency(Integer id, Integer patientInformationId);

    void addAdditionalInvestigation(Integer patientInformationId, AdditionalInvestigationVO additionalInvestigationVO);

    void deleteAdditionalInvestigation(Integer id, Integer patientInformationId);

    void addHospitalAdmission(Integer patientInformationId, HospitalAdmissionVO hospitalAdmissionVO);

    void deleteHospitalAdmission(Integer id, Integer patientInformationId);

    void addCivilHospitalVisit(Integer patientInformationId, CivilHospitalVisitVO civilHospitalVisitVO);

    void updateCivilHospitalVisit(Integer patientInformationId, CivilHospitalVisitVO civilHospitalVisitVO);

    HospitalAdmissionVO viewHospitalAdmission(Integer id);
}
