<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addPatientMedicine" theme="simple">
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
        <legend><h3>Patient Medicine</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Medicine Name"/></td>
                <td colspan="3" align="left"><s:select list="Medicines" listKey="id" listValue="medicineLabel"
                              name="patientMedicineVO.medicineId"/></td>
            </tr>
            <tr>
                <td><s:text name="Units"/></td>
                <td><s:textfield name="patientMedicineVO.units"/></td>
                <td><s:text name="Medicine Date (mm/dd/yy)"/></td>
                <td><s:textfield name="patientMedicineVO.date"/></td>
            </tr>
            <tr>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="patientMedicineVO.comment"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="right"><s:submit value="Save" action="addPatientMedicine" theme="simple"
                                                        cssClass="formButton"/></td>
                <td colspan="2" align="left"><s:submit value="Back" action="backFromMedicine" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>