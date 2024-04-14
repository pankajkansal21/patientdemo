<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="addMedicine" theme="simple">
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
    <fieldset>
        <legend><h3>Medicine Details</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Name"/></td>
                <td><s:textfield name="medicineVO.name"/></td>
                <td><s:text name="Strength"/></td>
                <td><s:textfield name="medicineVO.strength"/></td>
            </tr>
            <tr>
                <td><s:text name="Price per unit"/></td>
                <td><s:textfield name="medicineVO.price"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" align="right"><s:submit value="Save" action="addMedicine" theme="simple"
                                                        cssClass="formButton"/></td>
                <td colspan="2" align="left"><s:submit value="Home" action="home" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>