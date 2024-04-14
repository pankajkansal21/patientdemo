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
    <s:hidden name="patientInformation.id"></s:hidden>
    <fieldset>
        <legend><h3>Patient Visit</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Visit Type"/></td>
                <td><s:property value="patientVisit.visitType"/></td>
                <td><s:text name="Visit Date (mm/dd/yy)"/></td>
                <td><s:property value="patientVisit.visitDate"/></td>
            </tr>
            <tr>
                <td><s:text name="Visit Cost"/></td>
                <td><s:property value="patientVisit.visitCost"/></td>
                <td><s:text name="Illness Affect Your Employment"/></td>
                <td><s:checkbox name="patientVisit.illnessImpactedEmployment" disabled="true"/></td>
            </tr>
            <tr>
                <td><s:text name="Distance (in km)"/></td>
                <td><s:property value="patientVisit.distance"/></td>
                <td><s:text name="Transportation Mode"/></td>
                <td><s:property value="patientVisit.transportMode"/></td>
            </tr>
            <tr>
                <td><s:text name="Total Travel Cost"/></td>
                <td><s:property value="patientVisit.totalTravelCost"/></td>
                <td><s:text name="Time Spent On Visit (In minutes)"/></td>
                <td><s:property value="patientVisit.timeSpentInVisit"/></td>
            </tr>
            <tr>
                <td><s:text name="Wages Lost"/></td>
                <td><s:checkbox name="patientVisit.wagesLost" disabled="true"/></td>
                <td><s:text name="Amount To Be Paid For Leave"/></td>
                <td><s:property value="patientVisit.leaveCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Accompanying Person"/></td>
                <td><s:checkbox name="patientVisit.accompanyingPerson" disabled="true"/></td>
                <td><s:text name="Accompanying Person Working"/></td>
                <td><s:checkbox name="patientVisit.accompanyingPersonWorking" disabled="true"/></td>
            </tr>
            <tr>
                <td><s:text name="Accompanying Person Wages Lost"/></td>
                <td><s:checkbox name="patientVisit.accompanyingPersonWagesLost" disabled="true"/></td>
                <td><s:text name="Amount To Be Paid For Leave by Accompanying Person"/></td>
                <td><s:property value="patientVisit.accompanyingPersonLeaveCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Accompanying Person Relation"/></td>
                <td><s:property value="patientVisit.accompanyingPersonRelation"/></td>
                <td> </td>
                <td> </td>
            </tr>
            <tr>
                <td><s:text name="Any Investigations in Interim Visit"/></td>
                <td><s:checkbox name="patientVisit.investigationDuringInterimVisit" disabled="true"/></td>
                <td><s:text name="Interim Visit's Investigations Cost"/></td>
                <td><s:property value="patientVisit.investigationCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Interim Visit's Medicine Cost"/></td>
                <td><s:property value="patientVisit.interimVisitMedicineCost"/></td>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="patientVisit.comment" readonly="true"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="4" align="center"><s:submit value="Back" action="backFromVisit" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>