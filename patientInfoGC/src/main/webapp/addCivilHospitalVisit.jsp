<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<%@include file="headers.jsp" %>
<body>
<s:form action="/addCivilHospitalVisit" theme="simple" validate="true">
    <%@include file="menuAndErrors.jsp" %>

    <s:hidden name="patientInformation.id"/>
    <fieldset>
        <legend><h3>Civil Hospital Visit</h3></legend>
        <table style="width: 100%;" cellpadding="5" cellspacing="5">
            <tr>
                <td><s:text name="Distance from home (in Km)"/></td>
                <td><s:textfield name="civilHospitalVisitVO.hospitalDistance"/></td>
                <td><s:text name="Transport mode"/></td>
                <td><s:textfield name="civilHospitalVisitVO.transportMode"/></td>
            </tr>
            <tr>
                <td><s:text name="Cost to reach hospital"/></td>
                <td><s:textfield name="civilHospitalVisitVO.costToCome"/></td>
                <td><s:text name="Cost to go back home"/></td>
                <td><s:textfield name="civilHospitalVisitVO.costToGoHome"/></td>
            </tr>
            <tr>
                <td><s:text name="Work status"/></td>
                <td><s:textfield name="civilHospitalVisitVO.workStatus"/></td>
                <td><s:text name="Occupation"/></td>
                <td><s:textfield name="civilHospitalVisitVO.occupation"/></td>
            </tr>
            <tr>
                <td><s:text name="Time spent in hospital"/></td>
                <td><s:textfield name="civilHospitalVisitVO.timeSpentInHospital"/></td>
                <td><s:text name="Amount paid to employer for leave"/></td>
                <td><s:textfield name="civilHospitalVisitVO.employeeCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Accompanying person"/></td>
                <td><s:checkbox name="civilHospitalVisitVO.accompanyingPerson"/></td>
                <td><s:text name="Work status of accompanying person"/></td>
                <td><s:textfield name="civilHospitalVisitVO.accompanyingPersonWorkStatus"/></td>
            </tr>
            <tr>
                <td><s:text name="Occupation of accompanying person"/></td>
                <td><s:textfield name="civilHospitalVisitVO.accompanyingPersonOccupation"/></td>
                <td><s:text name="Amount paid to employer for leave by accompanying person"/></td>
                <td><s:textfield name="civilHospitalVisitVO.accompanyingPersonEmployeeCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Food cost"/></td>
                <td><s:textfield name="civilHospitalVisitVO.foodCost"/></td>
                <td><s:text name="Total Cost"/></td>
                <td><s:textfield name="civilHospitalVisitVO.totalCost"/></td>
            </tr>
            <tr>
                <td><s:text name="Comment"/></td>
                <td><s:textarea name="civilHospitalVisitVO.comment"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <s:if test="%{ civilHospitalVisitVO == null || civilHospitalVisitVO.id == null }">
                    <td colspan="2" align="right"><s:submit value="Save" action="addCivilHospitalVisit" theme="simple"
                                                            cssClass="formButton"/></td>
                </s:if>
                <s:else>
                    <td colspan="2" align="right"><s:submit value="Update" action="updateCivilHospitalVisit" theme="simple"
                                                            cssClass="formButton"/></td>
                </s:else>

                <td colspan="2" align="left"><s:submit value="Back" action="backFromCivilHospitalVisit" theme="simple"
                                                       cssClass="formButton"/></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>