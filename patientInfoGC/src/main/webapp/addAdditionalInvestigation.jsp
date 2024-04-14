<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addAdditionalInvestigation" theme="simple">
    <%@include file="menuAndErrors.jsp" %>

    <s:hidden name="patientInformation.id"></s:hidden>
    <fieldset>
        <legend><h3>Additional Investigation</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Additional Investigation Type"/></td>
                <td><s:textfield name="additionalInvestigationVO.investigationType"/></td>
                <td><s:text name="Additional Investigation Date (mm/dd/yy)"/></td>
                <td><s:textfield name="additionalInvestigationVO.investigationDate"/></td>
            </tr>
            <tr>
                <td><s:text name="Additional Investigation Cost"/></td>
                <td><s:textfield name="additionalInvestigationVO.cost"/></td>
                <td><s:text name="Comments"/></td>
                <td><s:textarea name="additionalInvestigationVO.comment"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="right"><s:submit value="Save" action="addAdditionalInvestigation" theme="simple"
                                                        cssClass="formButton"/></td>
                <td colspan="2" align="left"><s:submit value="Back" action="backFromAdditionalInvestigation" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>