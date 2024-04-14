<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="/addPatient" theme="simple" validate="true">
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
    <s:if test="hasActionErrors()">
        <div style="font-weight: bold; font-family: Arial" ;>
            <s:actionerror cssClass="errorMessage"/>
        </div>
    </s:if>
    <s:if test="hasFieldErrors()">
        <div style="font-weight: bold; font-family: Arial" ;>
            <s:fielderror cssClass="errorMessage"/>
        </div>
    </s:if>
    <s:hidden name="patientInformation.id"/>
    <fieldset>
        <legend><h3>Patient Information</h3></legend>
        <table style="width: 100%;" cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Enrollment No"/></td>
                <td><s:textfield name="patientInformation.enrollmentNo"/></td>
                <td><s:text name="Id"/></td>
                <td><s:textfield name="patientInformation.enrollmentId"/></td>
            </tr>
            <tr>
                <td><s:text name="Name"/></td>
                <td><s:textfield name="patientInformation.name"/></td>
                <td><s:text name="Name of arm"/></td>
                <td><s:select headerKey="" headerValue="Select"
                              list="NameOfArmList"
                              name="patientInformation.nameOfArm"/></td>
            </tr>
            <tr>
                <td><s:text name="Age"/></td>
                <td><s:textfield name="patientInformation.age"/></td>
                <td><s:text name="Gender"/></td>
                <td><s:select headerKey="" headerValue="Select"
                              list="GenderList"
                              name="patientInformation.gender"/></td>
            </tr>
            <tr>
                <td><s:text name="Religion"/></td>
                <td><s:textfield name="patientInformation.religion"/></td>
                <td><s:text name="Ethnic Orign"/></td>
                <td><s:select headerKey="" headerValue="Select"
                              list="EthnicOriginList"
                              name="patientInformation.ethnicOrign"/></td>
            </tr>
            <tr>
                <td><s:text name="Education"/></td>
                <td><s:textfield name="patientInformation.education"/></td>
                <td><s:text name="Education Head"/></td>
                <td><s:textfield name="patientInformation.educationHead"/></td>
            </tr>
            <tr>
                <td><s:text name="Occupation self"/></td>
                <td><s:textfield name="patientInformation.occupationSelf"/></td>
                <td><s:text name="Occupation Head"/></td>
                <td><s:textfield name="patientInformation.occupationHead"/></td>
            </tr>
            <tr>
                <td><s:text name="Martial Status"/></td>
                <td><s:textfield name="patientInformation.martialStatus"/></td>
                <td><s:text name="Family Income (Rs.)"/></td>
                <td><s:textfield name="patientInformation.familyIncome"/></td>
            </tr>
            <tr>
                <td><s:text name="Kuppuswamy"/></td>
                <td><s:textfield name="patientInformation.kuppuswamy"/></td>
                <td><s:text name="Kuppuswamy Total Score"/></td>
                <td><s:textfield name="patientInformation.kuppuswamyTotal"/></td>
            </tr>
            <tr>
                <td><s:text name="Sleeping Area"/></td>
                <td><s:textfield name="patientInformation.sleepingArea"/></td>
                <td><s:text name="Living Area"/></td>
                <td><s:textfield name="patientInformation.livingArea"/></td>
            </tr>
            <tr>
                <td><s:text name="Water Source"/></td>
                <td><s:textfield name="patientInformation.waterSource"/></td>
                <td><s:text name="Waste Management"/></td>
                <td><s:textfield name="patientInformation.wasteManagement"/></td>
            </tr>
            <tr>
                <td><s:text name="Is Seizures Last Five Years"/></td>
                <td><s:checkbox name="patientInformation.seizuresLastFiveYears"/></td>
                <td><s:text name="Current Seizure Frequency"/></td>
                <td><s:textfield name="patientInformation.currentSeizureFrequency"/></td>
            </tr>
            <tr>
                <td><s:text name="Family history of seizure"/></td>
                <td><s:checkbox name="patientInformation.familyHistoryOfSeizures"/></td>
                <td><s:text name="Relationship (seizure)"/></td>
                <td><s:textfield name="patientInformation.seizuresRelationship"/></td>
            </tr>
            <tr>
                <td><s:text name="Epilepsy Year"/></td>
                <%--<td><s:textfield name="patientInformation.epilepsyYear" type="date"
                                 format="dd-MM-yyyy" theme="simple"/></td>--%>
                <td><s:textfield name="patientInformation.epilepsyYear"/></td>
                <td><s:text name="Duration Of Epilepsy"/></td>
                <td><s:textfield name="patientInformation.durationOfEpilepsy"/></td>
            </tr>
            <tr>
                <td><s:text name="Syndrome"/></td>
                <td><s:textfield name="patientInformation.syndrome"/></td>
                <td><s:text name="Co Morbidity"/></td>
                <td><s:textfield name="patientInformation.coMorbidity"/></td>
            </tr>
            <tr>
                <td><s:text name="Initial Investigations"/></td>
                <td><s:select multiple="true"
                              list="InitialInvestigationsList"
                              name="patientInformation.initialInvestigations"/></td>
                <td><s:text name="Initial Investigations Cost"/></td>
                <td><s:textfield name="patientInformation.initialInvestigationsCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Social Class"/></td>
                <td><s:textfield name="patientInformation.socialClass"/></td>
                <td><s:text name="Neuropsychological Counselling"/></td>
                <td><s:checkbox name="patientInformation.neuropsychologicalCounselling"/></td>
            </tr>
            <tr>
                <td><s:text name="Neuropsychological Counselling count"/></td>
                <td><s:textfield name="patientInformation.neuropsychologicalCounsellingCount"/></td>
                <td><s:text name="Total Neuropsychological Counselling Cost"/></td>
                <td><s:textfield name="patientInformation.neuropsychologicalCounsellingCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="patientInformation.comment"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <s:if test="%{ patientInformation == null || patientInformation.id == null }">
                    <td colspan="2" align="right"><s:submit value="Save" action="addPatient" theme="simple"
                                                            cssClass="formButton"/></td>
                </s:if>
                <s:else>
                    <td colspan="2" align="right"><s:submit value="Update" action="updatePatient" theme="simple"
                                                            cssClass="formButton"/></td>
                </s:else>

                <td colspan="2" align="left"><s:submit value="Home" action="home" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>