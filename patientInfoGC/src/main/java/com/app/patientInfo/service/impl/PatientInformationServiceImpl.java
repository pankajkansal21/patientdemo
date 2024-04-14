package com.app.patientInfo.service.impl;

import com.app.patientInfo.dao.HospitalAdmissionDao;
import com.app.patientInfo.dao.MedicineDao;
import com.app.patientInfo.dao.PatientInformationDao;
import com.app.patientInfo.dao.PatientMedicineDao;
import com.app.patientInfo.dao.PatientVisitDao;
import com.app.patientInfo.model.PatientInformation;
import com.app.patientInfo.model.PatientMedicine;
import com.app.patientInfo.model.PatientVisit;
import com.app.patientInfo.service.PatientInformationService;
import com.app.patientInfo.vo.AdditionalInvestigationVO;
import com.app.patientInfo.vo.CivilHospitalVisitVO;
import com.app.patientInfo.vo.HospitalAdmissionVO;
import com.app.patientInfo.vo.PatientInformationVO;
import com.app.patientInfo.vo.PatientMedicineVO;
import com.app.patientInfo.vo.PatientVisitVO;
import com.app.patientInfo.vo.SeizureFrequencyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PatientInformationServiceImpl implements PatientInformationService {

    @Autowired
    private PatientInformationDao patientInformationDao;

    @Autowired
    private PatientMedicineDao patientMedicineDao;

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private PatientVisitDao patientVisitDao;

    @Autowired
    private HospitalAdmissionDao hospitalAdmissionDao;

    @Transactional
    public Integer addPatient(PatientInformationVO patientInformationVO) {
        return patientInformationDao.save(patientInformationVO.toEntity()).getId();
    }

    @Override
    public PatientInformationVO updatePatient(PatientInformationVO patientInformationVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationVO.getId());
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformationVO.toEntity(patientInformation);
            patientInformationDao.save(patientInformation);
            return patientInformation.toVO();
        }
        return null;
    }

    @Override
    @Transactional
    public PatientInformationVO getPatient(Integer id) {
        Optional<PatientInformation> patientInformation = patientInformationDao.findById(id);
        if (patientInformation.isPresent()) {
            return patientInformation.get().toVO();
        }
        return null;
    }

    @Override
    @Transactional
    public List<PatientInformationVO> findByName(String name) {
        List<PatientInformation> patientInformationList = patientInformationDao.findByNameStartingWithIgnoreCase(name);
        if (patientInformationList != null) {
            return patientInformationList.stream().map(patientInformation -> patientInformation.toVO()).collect(toList());
        }
        return null;
    }

    @Override
    public List<PatientInformationVO> findByEnrollmentNo(String enrollmentNo) {
        List<PatientInformation> patientInformationList = patientInformationDao.findByEnrollmentNoStartingWithIgnoreCase(enrollmentNo);
        if (patientInformationList != null) {
            return patientInformationList.stream().map(patientInformation -> patientInformation.toVO()).collect(toList());
        }
        return null;
    }

    @Override
    public List<PatientInformationVO> findByEnrollmentId(String enrollmentId) {
        List<PatientInformation> patientInformationList = patientInformationDao.findByEnrollmentIdStartingWithIgnoreCase(enrollmentId);
        if (patientInformationList != null) {
            return patientInformationList.stream().map(patientInformation -> patientInformation.toVO()).collect(toList());
        }
        return null;
    }

    @Override
    public List<PatientMedicineVO> findByStartAndEndDate(Integer patientId, Date startDate, Date endDate) {
        List<PatientMedicine> results = patientMedicineDao.findByStartAndEndDate(patientId, startDate, endDate);
        if (results != null) {
            return results.stream().map(patientMedicine -> patientMedicine.toVO()).collect(toList());
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        patientInformationDao.deleteById(id);
    }

    @Override
    public PatientVisitVO getPatientVisit(Integer patientVisitId) {
        return patientVisitDao.findById(patientVisitId).orElse(new PatientVisit()).toVO();
    }

    @Override
    @Transactional
    public void addVisit(Integer patientId, PatientVisitVO patientVisitVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.addVisit(patientVisitVO.toEntity());
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    @Transactional
    public void deleteVisit(Integer visitId, Integer patientInformationId) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        PatientInformation patientInformation = patientInformationOptional.get();
        patientInformation.getPatientVisits().removeIf(patientVisit -> patientVisit.getId().equals(visitId));
        patientInformationDao.save(patientInformation);
    }

    @Override
    @Transactional
    public void addMedicine(Integer patientId, PatientMedicineVO patientMedicineVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            PatientMedicine patientMedicine = patientMedicineVO.toEntity();
            patientMedicine.setMedicine(medicineDao.findById(patientMedicineVO.getMedicineId()).get());
            patientInformation.addMedicine(patientMedicine);
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public void deleteMedicine(Integer patientInformationId, Integer medicineId) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        PatientInformation patientInformation = patientInformationOptional.get();
        patientInformation.getPatientMedicines().removeIf(patientMedicine -> patientMedicine.getId().equals(medicineId));
        patientInformationDao.save(patientInformation);
    }

    @Override
    public void addSeizureFrequency(Integer patientInformationId, SeizureFrequencyVO seizureFrequencyVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.addSeizureFrequency(seizureFrequencyVO.toEntity());
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public void deleteSeizureFrequency(Integer id, Integer patientInformationId) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        PatientInformation patientInformation = patientInformationOptional.get();
        patientInformation.getSeizureFrequencies().removeIf(seizureFrequency -> seizureFrequency.getId().equals(id));
        patientInformationDao.save(patientInformation);
    }

    @Override
    public void addAdditionalInvestigation(Integer patientInformationId, AdditionalInvestigationVO additionalInvestigationVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.addAdditionalInvestigation(additionalInvestigationVO.toEntity());
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public void deleteAdditionalInvestigation(Integer id, Integer patientInformationId) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        PatientInformation patientInformation = patientInformationOptional.get();
        patientInformation.getAdditionalInvestigations().removeIf(additionalInvestigation -> additionalInvestigation.getId().equals(id));
        patientInformationDao.save(patientInformation);
    }

    @Override
    public void addHospitalAdmission(Integer patientInformationId, HospitalAdmissionVO hospitalAdmissionVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.addHospitalAdmission(hospitalAdmissionVO.toEntity());
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public void deleteHospitalAdmission(Integer id, Integer patientInformationId) {
        PatientInformation patientInformation = patientInformationDao.findById(patientInformationId).get();
        patientInformation.getHospitalAdmissions().removeIf(hospitalAdmission -> hospitalAdmission.getId().equals(id));
        patientInformationDao.save(patientInformation);
    }

    @Override
    public void addCivilHospitalVisit(Integer patientInformationId, CivilHospitalVisitVO civilHospitalVisitVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.setCivilHospitalVisit(civilHospitalVisitVO.toEntity());
            patientInformation.getCivilHospitalVisit().setPatientInformation(patientInformation);
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public void updateCivilHospitalVisit(Integer patientInformationId, CivilHospitalVisitVO civilHospitalVisitVO) {
        Optional<PatientInformation> patientInformationOptional = patientInformationDao.findById(patientInformationId);

        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            patientInformation.setCivilHospitalVisit(civilHospitalVisitVO.toEntity(patientInformation.getCivilHospitalVisit()));
            patientInformationDao.save(patientInformation);
        }
    }

    @Override
    public HospitalAdmissionVO viewHospitalAdmission(Integer id) {
        return hospitalAdmissionDao.findById(id).orElse(null).toVO();
    }

}
