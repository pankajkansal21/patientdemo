package com.app.patientInfo.vo;

import com.app.patientInfo.model.PatientInformation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PatientInformationVO implements Serializable {

    private Integer id;
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
    private Integer epilepsyYear;
    private Integer durationOfEpilepsy;
    private String syndrome;
    private String coMorbidity;
    private String kuppuswamyTotal;
    private String kuppuswamy;
    private String initialInvestigations;
    private Double initialInvestigationsCost;
    private Boolean neuropsychologicalCounselling;
    private Integer neuropsychologicalCounsellingCount;
    private Double neuropsychologicalCounsellingCost;
    private CivilHospitalVisitVO civilHospitalVisitVO;

    private Boolean familyHistoryOfSeizures;
    private String seizuresRelationship;

    private Set<PatientVisitVO> patientVisitVOs = new HashSet<>();
    private Set<PatientMedicineVO> patientMedicineVOs = new HashSet<>();
    private Set<SeizureFrequencyVO> seizureFrequencyVOs = new HashSet<>();
    private Set<AdditionalInvestigationVO> additionalInvestigationVOs = new HashSet<>();
    private Set<HospitalAdmissionVO> hospitalAdmissionVOs = new HashSet<>();

    public PatientInformation toEntity(PatientInformation patientInformation) {
        patientInformation.setEnrollmentNo(enrollmentNo);
        patientInformation.setEnrollmentId(enrollmentId);
        patientInformation.setName(name);
        patientInformation.setNameOfArm(nameOfArm);
        patientInformation.setAge(age);
        patientInformation.setGender(gender);
        patientInformation.setReligion(religion);
        patientInformation.setComment(comment);
        patientInformation.setEthnicOrign(ethnicOrign);
        patientInformation.setEducation(education);
        patientInformation.setOccupationSelf(occupationSelf);
        patientInformation.setOccupationHead(occupationHead);
        patientInformation.setFamilyIncome(familyIncome);
        patientInformation.setSocialClass(socialClass);
        patientInformation.setMartialStatus(martialStatus);
        patientInformation.setSleepingArea(sleepingArea);
        patientInformation.setLivingArea(livingArea);
        patientInformation.setWasteManagement(wasteManagement);
        patientInformation.setWasteManagement(wasteManagement);
        patientInformation.setSeizuresLastFiveYears(seizuresLastFiveYears);
        patientInformation.setCurrentSeizureFrequency(currentSeizureFrequency);
        patientInformation.setFamilyHistoryOfSeizures(familyHistoryOfSeizures == null ? false : familyHistoryOfSeizures);
        if (familyHistoryOfSeizures) {
            patientInformation.setSeizuresRelationship(seizuresRelationship);
        } else {
            patientInformation.setSeizuresRelationship(null);
        }
        patientInformation.setEpilepsyYear(epilepsyYear);
        patientInformation.setDurationOfEpilepsy(durationOfEpilepsy);
        patientInformation.setSyndrome(syndrome);
        patientInformation.setCoMorbidity(coMorbidity);
        patientInformation.setKuppuswamy(kuppuswamy);
        patientInformation.setKuppuswamyTotal(kuppuswamyTotal);
        patientInformation.setInitialInvestigations(initialInvestigations);
        patientInformation.setInitialInvestigationsCost(initialInvestigationsCost);
        patientInformation.setNeuropsychologicalCounselling(neuropsychologicalCounselling);
        patientInformation.setEducationHead(educationHead);
        patientInformation.setWaterSource(waterSource);
        if (neuropsychologicalCounselling) {
            patientInformation.setNeuropsychologicalCounsellingCount(neuropsychologicalCounsellingCount);
            patientInformation.setNeuropsychologicalCounsellingCost(neuropsychologicalCounsellingCost);
        } else {
            patientInformation.setNeuropsychologicalCounsellingCount(null);
            patientInformation.setNeuropsychologicalCounsellingCost(null);
        }

        return patientInformation;
    }

    public PatientInformation toEntity() {
        PatientInformation patientInformation = new PatientInformation();
        return toEntity(patientInformation);
    }

    public Double getTotalCost() {
        Double cost = 0.0;
        if(neuropsychologicalCounsellingCost != null) {
            cost += neuropsychologicalCounsellingCost;
        }

        if(initialInvestigationsCost != null) {
            cost += initialInvestigationsCost;
        }
        cost += patientVisitVOs.stream().mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
        cost += getTotalMedicineCost();
        cost += getTotalSeizureFrequencyCost();
        cost += getTotalAdditionalInvestigationCost();
        cost += getTotalHospitalAdmissionCost();
        if(getCivilHospitalVisitVO() != null && getCivilHospitalVisitVO().getTotalCost() != null) {
            cost += getCivilHospitalVisitVO().getTotalCost();
        }

        return cost;
    }

    public Double getTotalHospitalAdmissionCost() {
        return hospitalAdmissionVOs.stream().mapToDouble(HospitalAdmissionVO::getCost).sum();
    }

    public Double getTotalAdditionalInvestigationCost() {
        return additionalInvestigationVOs.stream().mapToDouble(AdditionalInvestigationVO::getCost).sum();
    }

    public Double getTotalSeizureFrequencyCost() {
        return seizureFrequencyVOs.stream().mapToDouble(SeizureFrequencyVO::getCost).sum();
    }

    public Double getTotalInterimVisitCost() {
        return patientVisitVOs.stream()
                .filter(patientVisitVO -> patientVisitVO.getVisitType().equalsIgnoreCase("Interim visit"))
                .mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
    }

    public Double getTotalUnscheduledVisitCost() {
        return patientVisitVOs.stream()
                .filter(patientVisitVO -> patientVisitVO.getVisitType().equalsIgnoreCase("Unscheduled visit"))
                .mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
    }

    public Double getTotalEmergencyVisitCost() {
        return patientVisitVOs.stream()
                .filter(patientVisitVO -> patientVisitVO.getVisitType().equalsIgnoreCase("Emergency visit"))
                .mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
    }

    public Double getTotalReferralVisitCost() {
        return patientVisitVOs.stream()
                .filter(patientVisitVO -> patientVisitVO.getVisitType().equalsIgnoreCase("Referral visit"))
                .mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
    }

    public Double getTotalVisitCost() {
        return patientVisitVOs.stream().mapToDouble(patientVisitVO -> patientVisitVO.getVisitCost()).sum();
    }

    public Double getTotalMedicineCost() {
        return patientMedicineVOs.stream()
                .mapToDouble(patientMedicineVO -> patientMedicineVO.getMedicineCost() * patientMedicineVO.getUnits()).sum();
    }



}
