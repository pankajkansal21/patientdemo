package com.app.patientInfo.model;

import com.app.patientInfo.vo.PatientInformationVO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.FetchMode.SELECT;

@Entity
@Getter
@Setter
@Table(schema = "patient_info")
public class PatientInformation implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = false)
    private String enrollmentNo;
    private String enrollmentId;
    private String name;
    private String nameOfArm;
    private Integer age;
    private String gender;
    private String religion;
    private String comment;
    private String ethnicOrign;
    private String education;
    private String occupationSelf;
    private String occupationHead;
    private String educationHead;
    private String familyIncome;
    private String socialClass;
    private String martialStatus;
    private String sleepingArea;
    private String livingArea;
    private String waterSource;
    private String wasteManagement;
    private Boolean seizuresLastFiveYears;
    private String currentSeizureFrequency;
    private Boolean familyHistoryOfSeizures;
    private String seizuresRelationship;
    private Integer epilepsyYear;
    private Integer durationOfEpilepsy;
    private String syndrome;
    private String coMorbidity;
    private String kuppuswamyTotal;
    private String kuppuswamy;
    private String initialInvestigations;
    private Boolean neuropsychologicalCounselling;
    private Integer neuropsychologicalCounsellingCount;
    private Double neuropsychologicalCounsellingCost;
    private Double initialInvestigationsCost;

    @OneToOne(mappedBy = "patientInformation", cascade = ALL, orphanRemoval = true)
    private CivilHospitalVisit civilHospitalVisit;

    @OneToMany(mappedBy = "patientInformation", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(value = SELECT)
    private Set<PatientVisit> patientVisits = new HashSet<>();

    @OneToMany(mappedBy = "patientInformation", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(value = SELECT)
    private Set<PatientMedicine> patientMedicines = new HashSet<>();

    @OneToMany(mappedBy = "patientInformation", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(value = SELECT)
    private Set<SeizureFrequency> seizureFrequencies = new HashSet<>();

    @OneToMany(mappedBy = "patientInformation", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(value = SELECT)
    private Set<AdditionalInvestigation> additionalInvestigations = new HashSet<>();

    @OneToMany(mappedBy = "patientInformation", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(value = SELECT)
    private Set<HospitalAdmission> hospitalAdmissions = new HashSet<>();


    public void addVisit(PatientVisit patientVisit) {
        getPatientVisits().add(patientVisit);
        patientVisit.setPatientInformation(this);
    }

    public void addMedicine(PatientMedicine patientMedicine) {
        getPatientMedicines().add(patientMedicine);
        patientMedicine.setPatientInformation(this);
    }

    public void addSeizureFrequency(SeizureFrequency seizureFrequency) {
        getSeizureFrequencies().add(seizureFrequency);
        seizureFrequency.setPatientInformation(this);
    }

    public void addAdditionalInvestigation(AdditionalInvestigation additionalInvestigation) {
        getAdditionalInvestigations().add(additionalInvestigation);
        additionalInvestigation.setPatientInformation(this);
    }

    public void addHospitalAdmission(HospitalAdmission hospitalAdmission) {
        getHospitalAdmissions().add(hospitalAdmission);
        hospitalAdmission.setPatientInformation(this);
    }

    public PatientInformationVO toVO() {
        PatientInformationVO patientInformationVO = new PatientInformationVO();
        patientInformationVO.setId(getId());
        patientInformationVO.setEnrollmentNo(getEnrollmentNo());
        patientInformationVO.setEnrollmentId(getEnrollmentId());
        patientInformationVO.setName(getName());
        patientInformationVO.setNameOfArm(getNameOfArm());
        patientInformationVO.setAge(getAge());
        patientInformationVO.setGender(getGender());
        patientInformationVO.setReligion(getReligion());
        patientInformationVO.setComment(getComment());
        patientInformationVO.setEthnicOrign(getEthnicOrign());
        patientInformationVO.setEducation(getEducation());
        patientInformationVO.setOccupationSelf(getOccupationSelf());
        patientInformationVO.setOccupationHead(getOccupationHead());
        patientInformationVO.setFamilyIncome(getFamilyIncome());
        patientInformationVO.setSocialClass(getSocialClass());
        patientInformationVO.setMartialStatus(getMartialStatus());
        patientInformationVO.setSleepingArea(getSleepingArea());
        patientInformationVO.setLivingArea(getLivingArea());
        patientInformationVO.setWasteManagement(getWasteManagement());
        patientInformationVO.setWasteManagement(getWasteManagement());
        patientInformationVO.setSeizuresLastFiveYears(getSeizuresLastFiveYears());
        patientInformationVO.setCurrentSeizureFrequency(getCurrentSeizureFrequency());
        patientInformationVO.setEpilepsyYear(getEpilepsyYear());
        patientInformationVO.setDurationOfEpilepsy(getDurationOfEpilepsy());
        patientInformationVO.setSyndrome(getSyndrome());
        patientInformationVO.setCoMorbidity(getCoMorbidity());
        patientInformationVO.setKuppuswamy(getKuppuswamy());
        patientInformationVO.setKuppuswamyTotal(getKuppuswamyTotal());
        patientInformationVO.setInitialInvestigations(getInitialInvestigations());
        patientInformationVO.setInitialInvestigationsCost(initialInvestigationsCost);
        patientInformationVO.setNeuropsychologicalCounselling(getNeuropsychologicalCounselling());
        patientInformationVO.setEducationHead(getEducationHead());
        patientInformationVO.setWaterSource(getWaterSource());
        patientInformationVO.setFamilyHistoryOfSeizures(familyHistoryOfSeizures);
        patientInformationVO.setSeizuresRelationship(seizuresRelationship);
        patientInformationVO.setNeuropsychologicalCounsellingCount(neuropsychologicalCounsellingCount);
        patientInformationVO.setNeuropsychologicalCounsellingCost(neuropsychologicalCounsellingCost);
        patientVisits.forEach(patientVisit -> patientInformationVO.getPatientVisitVOs().add(patientVisit.toVO()));
        patientMedicines.forEach(patientMedicine -> patientInformationVO.getPatientMedicineVOs().add(patientMedicine.toVO()));
        seizureFrequencies.forEach(seizureFrequency -> patientInformationVO.getSeizureFrequencyVOs().add(seizureFrequency.toVO()));
        additionalInvestigations.forEach(additionalInvestigation -> patientInformationVO.getAdditionalInvestigationVOs().add(additionalInvestigation.toVO()));
        hospitalAdmissions.forEach(hospitalAdmission -> patientInformationVO.getHospitalAdmissionVOs().add(hospitalAdmission.toVO()));
        if(civilHospitalVisit != null) {
            patientInformationVO.setCivilHospitalVisitVO(civilHospitalVisit.toVO());
        }

        return patientInformationVO;
    }
}
