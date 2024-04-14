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
    <fieldset>
        <legend><h3>Patient Search</h3></legend>
        <table cellpadding="2" cellspacing="2">
            <tr><td><b>Please use one of field to search patient information<b></td></tr>
            <tr><td><b>&nbsp;&nbsp;<b></td></tr>
            <tr cellpadding="2" cellspacing="2">
                <td><s:text name="Enrollment No"/>&nbsp;&nbsp;<s:textfield name="enrollmentNo"/></td>
            </tr>
            <tr><td><b>OR<b></td></tr>
            <tr cellpadding="2" cellspacing="2">
                <td><s:text name="Enrollment Id"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="enrollmentId"/></td>
            </tr>
            <tr><td><b>OR<b></td></tr>
            <tr>
                <td><s:text name="Patient Name"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="patientName"/></td>
            </tr>
            <tr cellpadding="2" cellspacing="2">
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><s:submit value="Search" action="searchPatient" theme="simple" cssClass="formButton"/>
                    &nbsp;&nbsp;<s:submit value="Home" action="home" theme="simple" cssClass="formButton"/></td>
            </tr>

        </table>
    </fieldset>
    <table>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>

    <s:if test="%{ (patients!=null) && (!patients.isEmpty()) }">
        <fieldset>
            <legend><h3>Patient Search Results</h3></legend>
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <th><s:text name="Enrollment No"/></th>
                    <th><s:text name="Enrollment Id"/></th>
                    <th><s:text name="Name"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="patients" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="viewLink" action="viewPatient">
                            <s:param name="patientId" value="%{id}"/>
                        </s:url>
                        <s:url var="deleteLink" action="deletePatient">
                            <s:param name="patientId" value="%{id}"/>
                            <s:param name="patientName" value="%{patientName}"/>
                        </s:url>
                        <td align="center"><s:property value="enrollmentNo"/></td>
                        <td align="center"><s:text name="enrollmentId"/></td>
                        <td align="center"><s:text name="name"/></td>
                        <td align="center"><s:a href="%{viewLink}">View</s:a> &nbsp; &nbsp;<s:a
                                href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </fieldset>
    </s:if>
</s:form>
</body>
</html>