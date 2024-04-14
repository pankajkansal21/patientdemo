<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="viewMedicines" theme="simple">
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
    <fieldset>
        <legend><h3>Medicine Details</h3></legend>
        <table cellpadding="5" cellspacing="5">
            <s:if test="%{ (medicines!=null) && (!medicines.isEmpty()) }">
                <tr>
                    <th><s:text name="Medicine Name"/></th>
                    <th><s:text name="Medicine Strength"/></th>
                    <th><s:text name="Price per unit"/></th>
                    <th><s:text name="Actions"/></th>
                </tr>

                <s:iterator value="medicines" status="count">
                    <tr class="<s:if test="#count.index%2==0">even</s:if><s:else>odd</s:else>">
                        <s:url var="deleteLink" action="deleteMedicine">
                            <s:param name="medicineVO.id" value="%{id}"/>
                        </s:url>
                        <td align="center"><s:property value="name"/></td>
                        <td align="center"><s:property value="strength"/></td>
                        <td align="center"><s:text name="price"/></td>
                        <td align="center"><s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </s:if>
            <s:else>
                <tr><td>No medicine found. Please add new medicines.</td></tr>
            </s:else>
        </table>
        <table>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td align="center">
                    <s:submit value="Add Medicine" action="showAddMedicine" theme="simple" cssClass="formButton"/>&nbsp;&nbsp;
                    <s:submit value="Home" action="home" theme="simple" cssClass="formButton"/>&nbsp; &nbsp;
                </td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>