<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addSeizureFrequency" theme="simple">
    <%@include file="menuAndErrors.jsp" %>

    <s:hidden name="patientInformation.id"></s:hidden>
    <fieldset>
        <legend><h3>Seizure Frequency</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Seizure Frequency Date (mm/dd/yy)"/></td>
                <td><s:textfield name="seizureFrequencyVO.date"/></td>
                <td><s:text name="Seizure Frequency Cost"/></td>
                <td><s:textfield name="seizureFrequencyVO.cost"/></td>
            </tr>
            <tr>
                <td><s:text name="No. of seizures"/></td>
                <td><s:textfield name="seizureFrequencyVO.seizuresCount"/></td>
                <td> </td>
                <td> </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="right"><s:submit value="Save" action="addSeizureFrequency" theme="simple"
                                                        cssClass="formButton"/></td>
                <td colspan="2" align="left"><s:submit value="Back" action="backFromSeizureFrequency" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>