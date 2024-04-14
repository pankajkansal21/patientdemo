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