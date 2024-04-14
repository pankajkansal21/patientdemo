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
    <s:if test="hasActionErrors()">
        <div style="font-weight: bold; font-family: Arial" ;>
            <s:actionerror cssClass="errorMessage"/>
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div style="font-weight: bold; font-family: Arial" ;>
            <s:actionmessage cssClass="success-message"/>
        </div>
    </s:if>

    <s:hidden name="patientInformation.id"></s:hidden>

    <fieldset>
        <legend><h3>Patient Medicine Search</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Start Date (mm/dd/yy)"/></td>
                <td><s:textfield name="startDate"/></td>
                <td><s:text name="End Date (mm/dd/yy)"/></td>
                <td><s:textfield name="endDate"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td align="right" colspan="2"><s:submit value="Search" action="searchPatientMedicine" theme="simple" cssClass="formButton"/></td>
                <td align="left" colspan="2"><s:submit value="Back" action="backFromMedicine" theme="simple" cssClass="formButton"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </fieldset>

    <s:if test="%{ (patientMedicineVOs!=null) && (!patientMedicineVOs.isEmpty()) }">
        <fieldset>
            <legend><h3>Patient Medicine Search Results</h3></legend>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td align="center" colspan="4"><h3>Total medicine cost &nbsp;&nbsp; <s:property value="totalMedicineCost"/></h3>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th><s:text name="Medicine Name"/></th>
                    <th><s:text name="Medicine Strength"/></th>
                    <th><s:text name="Medicine Date"/></th>
                    <th><s:text name="Price per unit"/></th>
                    <th><s:text name="Units"/></th>
                    <th><s:text name="Commnent"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patientMedicineVOs" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="deleteLink" action="deletePatientMedicine">
                            <s:param name="medicineId" value="%{id}"/>
                            <s:param name="patientInformation.id" value="%{patientInformation.id}"/>
                            <s:param name="startDate"><s:property value="startDate"/></s:param>
                            <s:param name="endDate"><s:property value="endDate"/></s:param>
                        </s:url>
                        <td align="center"><s:property value="medicineName"/></td>
                        <td align="center"><s:property value="medicineStrength"/></td>
                        <td align="center"><s:property value="date"/></td>
                        <td align="center"><s:text name="medicineCost"/></td>
                        <td align="center"><s:text name="units"/></td>
                        <td align="center"><s:text name="comment"/></td>
                        <td align="center"><s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </fieldset>
    </s:if>
</s:form>
</body>
</html>