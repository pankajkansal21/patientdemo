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
                <td width="25%"><s:textfield name="hospitalAdmissionVO.hospitalizationDate"/></td>
                <td width="25%"><s:text name="Investigation Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.investigationCost"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Transportation cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.transportationCost"/></td>
                <td width="25%"><s:text name="Food Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.foodCost"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Medicine Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.medicineCost"/></td>
                <td width="25%"><s:text name="Total Admission cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.cost"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Comments"/></td>
                <td width="25%"><s:textarea name="hospitalAdmissionVO.comment"/></td>
            </tr>
            <tr>
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
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.firstAccompanyingPersonVO.working"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.firstAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.firstAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.firstAccompanyingPersonVO.wagesLost"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Second Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.secondAccompanyingPersonVO.working"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.secondAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.secondAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.secondAccompanyingPersonVO.wagesLost"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Third Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.thirdAccompanyingPersonVO.working"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.thirdAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.thirdAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.thirdAccompanyingPersonVO.wagesLost"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><h3>Fourth Accompanying Person</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td width="25%"><s:text name="Working"/></td>
                <td width="25%"><s:checkbox name="hospitalAdmissionVO.fourthAccompanyingPersonVO.working"/></td>
                <td width="25%"><s:text name="Occupation"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.fourthAccompanyingPersonVO.occupation"/></td>
            </tr>
            <tr>
                <td width="25%"><s:text name="Accommodation Cost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.fourthAccompanyingPersonVO.accommodationCost"/></td>
                <td width="25%"><s:text name="Wages Lost"/></td>
                <td width="25%"><s:textfield name="hospitalAdmissionVO.fourthAccompanyingPersonVO.wagesLost"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>
    <table>
        <tr>
            <td colspan="2">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2" align="right"><s:submit value="Save" action="addHospitalAdmission" theme="simple"
                                                    cssClass="formButton"/></td>
            <td colspan="2" align="left"><s:submit value="Back" action="backFromHospitalAdmission" theme="simple"
                                                   cssClass="formButton"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>