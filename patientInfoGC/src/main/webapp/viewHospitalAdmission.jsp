<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addHospitalAdmission" theme="simple">
    <%@include file="menuAndErrors.jsp" %>

    <s:hidden name="patientInformation.id"/>
    <s:hidden name="hospitalAdmissionVO.id"/>
    <fieldset>
        <legend><h3>Hospital Admission</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Hospital Admission Date (mm/dd/yy)"/></td>
                <td width="25%"><s:date name="hospitalAdmissionVO.hospitalizationDate" format="MM/dd/yyyy"/></td>
                <td width="25%"><s:text name="Investigation Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.investigationCost"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Transportation cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.transportationCost"/></td>
                <td width="25%"><s:text name="Food Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.foodCost"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Medicine Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.medicineCost"/></td>
                <td width="25%"><s:text name="Total Admission cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.cost"/></td>
            </tr>
            <tr>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="hospitalAdmissionVO.comment" readonly="true"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>First Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.firstAccompanyingPersonVO.working" disabled="true"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.firstAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.firstAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.firstAccompanyingPersonVO.wagesLost"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Second Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.secondAccompanyingPersonVO.working" disabled="true"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.secondAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.secondAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.secondAccompanyingPersonVO.wagesLost"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Third Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.thirdAccompanyingPersonVO.working" disabled="true"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.thirdAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.thirdAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.thirdAccompanyingPersonVO.wagesLost"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Fourth Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.fourthAccompanyingPersonVO.working" disabled="true"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.fourthAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.fourthAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:property value="hospitalAdmissionVO.fourthAccompanyingPersonVO.wagesLost"/></td>
            </tr>
        </table>
    </fieldset>
    <table>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2" align="right"><s:submit value="Delete" action="deleteHospitalAdmission" theme="simple"
                                                    cssClass="formButton"/></td>
            <td colspan="2" align="left"><s:submit value="Back" action="backFromHospitalAdmission" theme="simple"
                                                   cssClass="formButton"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>