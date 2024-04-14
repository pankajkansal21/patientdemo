<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form>
    <table>
        <tr>
            <td align="left" colspan="2"><img src="/patient/welcome.jpg" style="width: 90%; height: 100%;"></td>
            <td valign="top" colspan="1" style="font-weight: bold; font-family: Arial"><br/><br/><br/>
                <table>
                    <tr>
                        <td valign="top">
                            Add new patient
                        </td>
                        <td valign="top">
                            <s:submit value="Register Patient" action="showAddPatient" theme="simple"
                                      cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            View patient information
                        </td>
                        <td valign="top">
                            <s:submit value="View Patient" action="showSearchPatient" theme="simple"
                                      cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            Add new medicine
                        </td>
                        <td valign="top">
                            <s:submit value="Add Medicine" action="showAddMedicine" theme="simple"
                                      cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            View medicines
                        </td>
                        <td valign="top">
                            <s:submit value="View Medicines" action="viewMedicines" theme="simple"
                                      cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            Logout
                        </td>
                        <td valign="top">
                            <s:submit value="Logout" action="logout" theme="simple"
                                      cssClass="formButton"/><br/><br/><br/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>