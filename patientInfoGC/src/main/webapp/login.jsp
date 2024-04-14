<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form>
    <table theme="simple">
        <tr>
            <td align="left" colspan="2"><img src="/patient/welcome.jpg" style="width: 90%; height: 100%;"></td>
            <td valign="top" colspan="1" style="font-weight: bold; font-family: Arial"><br/><br/><br/>
                <table theme="simple">
                    <tr>
                        <s:if test="hasActionErrors()">
                            <div style="font-weight: bold; font-family: Arial" ;>
                                <s:actionerror cssClass="errorMessage"/>
                            </div>
                        </s:if>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <s:text name="User name"/>
                        </td>
                        <td valign="top" theme="simple">
                            <s:textfield label="User name" name="username" theme="simple"/> <br/>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <s:text name="Password"/>
                        </td>
                        <td valign="top">
                            <s:password name="userpass" theme="simple"/> <br/> <br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2">
                            <s:submit value="Login" action="login" theme="simple" cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>