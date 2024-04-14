<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addPatient" theme="simple">
    <table>
        <tr>
            <s:include value="menu.jsp"/>
        </tr>
        <tr></tr>
    </table>
    <s:if test="hasActionMessages()">
        <div style="font-weight: bold; font-family: Arial" ;>
            <s:actionmessage cssClass="success-message"/>
        </div>
    </s:if>
    <fieldset>
        <legend><h3>Patient Information</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <s:hidden name="patientInformation.id"></s:hidden>
            <tr>
                <td><s:text name="Enrollment No"/></td>
                <td><s:property value="patientInformation.enrollmentNo"/></td>
                <td><s:text name="Id"/></td>
                <td><s:property value="patientInformation.enrollmentId"/></td>
            </tr>
            <tr>
                <td><s:text name="Name"/></td>
                <td><s:property value="patientInformation.name"/></td>
                <td><s:text name="Name of arm"/></td>
                <td><s:property value="patientInformation.nameOfArm"/></td>
            </tr>
            <tr>
                <td><s:text name="Age"/></td>
                <td><s:property value="patientInformation.age"/></td>
                <td><s:text name="Gender"/></td>
                <td><s:property value="patientInformation.gender"/></td>
            </tr>
            <tr>
                <td><s:text name="Religion"/></td>
                <td><s:property value="patientInformation.religion"/></td>
                <td><s:text name="Ethnic Orign"/></td>
                <td><s:property value="patientInformation.ethnicOrign"/></td>
            </tr>
            <tr>
                <td><s:text name="Education"/></td>
                <td><s:property value="patientInformation.education"/></td>
                <td><s:text name="Education Head"/></td>
                <td><s:property value="patientInformation.educationHead"/></td>
            </tr>
            <tr>
                <td><s:text name="Occupation self"/></td>
                <td><s:property value="patientInformation.occupationSelf"/></td>
                <td><s:text name="Occupation Head"/></td>
                <td><s:property value="patientInformation.occupationHead"/></td>
            </tr>
            <tr>
                <td><s:text name="Martial Status"/></td>
                <td><s:property value="patientInformation.martialStatus"/></td>
                <td><s:text name="Family Income (Rs.)"/></td>
                <td><s:property value="patientInformation.familyIncome"/></td>
            </tr>
            <tr>
                <td><s:text name="Kuppuswamy"/></td>
                <td><s:property value="patientInformation.kuppuswamy"/></td>
                <td><s:text name="Kuppuswamy Total Score"/></td>
                <td><s:property value="patientInformation.kuppuswamyTotal"/></td>
            </tr>
            <tr>
                <td><s:text name="Sleeping Area"/></td>
                <td><s:property value="patientInformation.sleepingArea"/></td>
                <td><s:text name="Living Area"/></td>
                <td><s:property value="patientInformation.livingArea"/></td>
            </tr>
            <tr>
                <td><s:text name="Water Source"/></td>
                <td><s:property value="patientInformation.waterSource"/></td>
                <td><s:text name="Waste Management"/></td>
                <td><s:property value="patientInformation.wasteManagement"/></td>
            </tr>
            <tr>
                <td><s:text name="Is Seizures Last Five Years"/></td>
                <td><s:property value="patientInformation.seizuresLastFiveYears"/></td>
                <td><s:text name="Current Seizure Frequency"/></td>
                <td><s:property value="patientInformation.currentSeizureFrequency"/></td>
            </tr>
            <tr>
                <td><s:text name="Family history of seizure"/></td>
                <td><s:property value="patientInformation.familyHistoryOfSeizures"/></td>
                <td><s:text name="Relationship (seizure)"/></td>
                <td><s:property value="patientInformation.seizuresRelationship"/></td>
            </tr>
            <tr>
                <td><s:text name="Epilepsy Year"/></td>
                <td><s:property value="patientInformation.epilepsyYear"/></td>
                <td><s:text name="Duration Of Epilepsy"/></td>
                <td><s:property value="patientInformation.durationOfEpilepsy"/></td>
            </tr>
            <tr>
                <td><s:text name="Syndrome"/></td>
                <td><s:property value="patientInformation.syndrome"/></td>
                <td><s:text name="Co Morbidity"/></td>
                <td><s:property value="patientInformation.coMorbidity"/></td>
            </tr>
            <tr>
                <td><s:text name="Initial Investigations"/></td>
                <td><s:property value="patientInformation.initialInvestigations"/></td>
                <td><s:text name="Initial Investigations Cost"/></td>
                <td><s:property value="patientInformation.initialInvestigationsCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Social Class"/></td>
                <td><s:property value="patientInformation.socialClass"/></td>
                <td><s:text name="Neuropsychological Counselling"/></td>
                <td><s:property value="patientInformation.neuropsychologicalCounselling"/></td>
            </tr>
            <tr>
                <td><s:text name="Neuropsychological Counselling count"/></td>
                <td><s:property value="patientInformation.neuropsychologicalCounsellingCount"/></td>
                <td><s:text name="Total Neuropsychological Counselling Cost"/></td>
                <td><s:property value="patientInformation.neuropsychologicalCounsellingCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Grand Total cost"/></td>
                <td><s:property value="patientInformation.totalCost"/></td>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="patientInformation.comment" readonly="true"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Edit" action="showEditPatient" theme="simple" cssClass="formButton"/>&nbsp;&nbsp;
                    <s:submit value="Home" action="home" theme="simple" cssClass="formButton"/>&nbsp; &nbsp;
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Patient Visits</h3></legend>
        <s:if test="%{ (patientInformation.patientVisitVOs!=null) && (!patientInformation.patientVisitVOs.isEmpty()) }">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <th><s:text name="Visit Type"/></th>
                    <th><s:text name="Visit Date"/></th>
                    <th><s:text name="Visit Cost"/></th>
                    <th><s:text name="Commnent"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patientInformation.patientVisitVOs" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="viewLink" action="viewVisit">
                            <s:param name="patientVisit.id" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <s:url var="deleteLink" action="deleteVisit">
                            <s:param name="patientVisit.id" value="%{id}"/>
                            <s:param name="patientVisit.patientInformationVO.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <td align="center"><s:property value="visitType"/></td>
                        <td align="center"><s:date name="visitDate" format="MM/dd/yyyy"/></td>
                        <td align="center"><s:text name="visitCost"/></td>
                        <td align="center"><s:text name="comment"/></td>
                        <td align="center"><s:a href="%{viewLink}">View</s:a> &nbsp;&nbsp; <s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Total Interim Visit Cost"/></td>
                    <td colspan="1"><s:property value="patientInformation.totalInterimVisitCost"/></td>
                    <td colspan="1"><s:text name="Total Unscheduled Visit Cost"/></td>
                    <td colspan="1"><s:property value="patientInformation.totalUnscheduledVisitCost"/></td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Total Emergency Visit Cost"/></td>
                    <td colspan="1"><s:property value="patientInformation.totalEmergencyVisitCost"/></td>
                    <td colspan="1"><s:text name="Total Referral Visit Cost"/></td>
                    <td colspan="1"><s:property value="patientInformation.totalReferralVisitCost"/></td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Grand Total Visit Cost"/></td>
                    <td colspan="1"><s:property value="patientInformation.totalVisitCost"/></td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </table>
        </s:if>
        <s:else>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>&nbsp;No patient visit yet.</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </table>
        </s:else>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Add Visit" action="showAddVisit" theme="simple" cssClass="formButton"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend><h3>Patient Medicine</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <s:if test="%{ (patientInformation.patientMedicineVOs!=null) && (!patientInformation.patientMedicineVOs.isEmpty()) }">
                <tr>
                    <td colspan="1"><s:text name="Total Medicine Cost"/>&nbsp;&nbsp; <s:property
                            value="patientInformation.totalMedicineCost"/></td>
                    <td colspan="1">&nbsp;&nbsp;</td>
                    <td colspan="1"> &nbsp;&nbsp;</td>
                    <td colspan="1"> &nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </s:if>
            <s:else>
                <tr>
                    <td colspan="1">&nbsp;No medicine given to patient yet.</td>
                    <td colspan="1">&nbsp;&nbsp;</td>
                    <td colspan="1">&nbsp;&nbsp;</td>
                    <td colspan="1">&nbsp;&nbsp;</td>
                </tr>
            </s:else>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Add Medicine" action="showAddPatientMedicine" theme="simple"
                              cssClass="formButton"/>
                    <s:submit value="View Medicines" action="showSearchPatientMedicine" theme="simple"
                              cssClass="formButton"/>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend><h3>Seizure Frequencies</h3></legend>
        <s:if test="%{ (patientInformation.seizureFrequencyVOs!=null) && (!patientInformation.seizureFrequencyVOs.isEmpty()) }">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <th><s:text name="Seizure Frequency Date"/></th>
                    <th><s:text name="Seizure Frequency Cost"/></th>
                    <th><s:text name="No. of seizures"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patientInformation.seizureFrequencyVOs" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="deleteLink" action="deleteSeizureFrequency">
                            <s:param name="seizureFrequencyVO.id" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <td align="center"><s:date name="date" format="MM/dd/yyyy"/></td>
                        <td align="center"><s:property value="cost"/></td>
                        <td align="center"><s:property value="seizuresCount"/></td>
                        <td align="center"><s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Total Seizure Frequency Cost"/> &nbsp;&nbsp; <s:property
                            value="patientInformation.totalSeizureFrequencyCost"/></td>&nbsp;
                    <td colspan="1"></td>
                    <td colspan="1"></td>
                    <td colspan="1">&nbsp;</td>
                </tr>
            </table>
        </s:if>
        <s:else>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td colspan="1">&nbsp;No Seizure Frequency added for patient yet.</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </table>
        </s:else>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Add Seizure Frequency" action="showAddSeizureFrequency" theme="simple"
                              cssClass="formButton"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend><h3>Additional Investigation</h3></legend>
        <s:if test="%{ (patientInformation.additionalInvestigationVOs!=null) && (!patientInformation.additionalInvestigationVOs.isEmpty()) }">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <th><s:text name="Additional Investigation Type"/></th>
                    <th><s:text name="Additional Investigation Date"/></th>
                    <th><s:text name="Additional Investigation Cost"/></th>
                    <th><s:text name="Commnent"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patientInformation.additionalInvestigationVOs" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="deleteLink" action="deleteAdditionalInvestigation">
                            <s:param name="additionalInvestigationVO.id" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <td align="center"><s:property value="investigationType"/></td>
                        <td align="center"><s:date name="investigationDate" format="MM/dd/yyyy"/></td>
                        <td align="center"><s:text name="cost"/></td>
                        <td align="center"><s:text name="comment"/></td>
                        <td align="center"><s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Total Additional Investigation Cost"/>&nbsp;&nbsp; <s:property
                            value="patientInformation.totalAdditionalInvestigationCost"/></td>
                    <td colspan="1"/>
                    <td colspan="1"/>
                    <td colspan="1"/>
                </tr>
            </table>
        </s:if>
        <s:else>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>&nbsp;No Additional Investigation added for patient yet.</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </table>
        </s:else>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Add Additional Investigation" action="showAddAdditionalInvestigation"
                              theme="simple" cssClass="formButton"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend><h3>Hospital Admissions</h3></legend>
        <s:if test="%{ (patientInformation.hospitalAdmissionVOs!=null) && (!patientInformation.hospitalAdmissionVOs.isEmpty()) }">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <th><s:text name="Hospital Admission Date"/></th>
                    <th><s:text name="Total Admission Cost"/></th>
                    <th><s:text name="Commnent"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patientInformation.hospitalAdmissionVOs" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="viewLink" action="viewHospitalAdmission">
                            <s:param name="hospitalAdmissionVO.id" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <s:url var="deleteLink" action="deleteHospitalAdmission">
                            <s:param name="hospitalAdmissionVO.id" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                        </s:url>
                        <td align="center"><s:date name="hospitalizationDate" format="MM/dd/yyyy"/></td>
                        <td align="center"><s:text name="cost"/></td>
                        <td align="center"><s:text name="comment"/></td>
                        <td align="center"><s:a href="%{viewLink}">View</s:a> &nbsp;&nbsp; <s:a href="%{deleteLink}">Delete</s:a> </td>
                    </tr>
                </s:iterator>
            </table>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                    <td colspan="1">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="1"><s:text name="Total Cost of all admissions"/>&nbsp;&nbsp; <s:property
                            value="patientInformation.totalHospitalAdmissionCost"/></td>
                    <td colspan="1"/>
                    <td colspan="1"/>
                    <td colspan="1"/>
                </tr>
            </table>
        </s:if>
        <s:else>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>&nbsp;No Hospital Admission added for patient yet.</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
            </table>
        </s:else>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <s:submit value="Add Hospital Admission" action="showAddHospitalAdmission" theme="simple"
                              cssClass="formButton"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend><h3>Civil Hospital Visit</h3></legend>
        <s:if test="%{ (patientInformation.civilHospitalVisitVO!=null)}">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td><s:text name="Distance from home (in Km)"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.hospitalDistance"/></td>
                    <td><s:text name="Transport mode"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.transportMode"/></td>
                </tr>
                <tr>
                    <td><s:text name="Cost to reach hospital"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.costToCome"/></td>
                    <td><s:text name="Cost to go back home"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.costToGoHome"/></td>
                </tr>
                <tr>
                    <td><s:text name="Work status"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.workStatus"/></td>
                    <td><s:text name="Occupation"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.occupation"/></td>
                </tr>
                <tr>
                    <td><s:text name="Time spent in hospital"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.timeSpentInHospital"/></td>
                    <td><s:text name="Amount paid to employer for leave"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.employeeCost"/></td>
                </tr>
                <tr>
                    <td><s:text name="Accompanying person"/></td>
                    <td><s:checkbox name="patientInformation.civilHospitalVisitVO.accompanyingPerson" disabled="true"/></td>
                    <td><s:text name="Work status of accompanying person"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.accompanyingPersonWorkStatus"/></td>
                </tr>
                <tr>
                    <td><s:text name="Occupation of accompanying person"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.accompanyingPersonOccupation"/></td>
                    <td><s:text name="Amount paid to employer for leave by accompanying person"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.accompanyingPersonEmployeeCost"/></td>
                </tr>
                <tr>
                    <td><s:text name="Food cost"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.foodCost"/></td>
                    <td><s:text name="Total Cost"/></td>
                    <td><s:property value="patientInformation.civilHospitalVisitVO.totalCost"/></td>
                </tr>
                <tr>
                    <td><s:text name="Comment"/></td>
                    <td><s:textarea name="patientInformation.civilHospitalVisitVO.comment" readonly="true"/></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>

            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4" align="center">
                        <s:submit value="Edit Civil Hospital Visit" action="showUpdateCivilHospitalVisit" theme="simple"
                                  cssClass="formButton"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </s:if>
        <s:else>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>&nbsp;No Civil Hospital Visit added for patient yet.</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4" align="center">
                        <s:submit value="Add Civil Hospital Visit" action="showAddCivilHospitalVisit" theme="simple"
                                  cssClass="formButton"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </s:else>
    </fieldset>

</s:form>
</body>
</html>