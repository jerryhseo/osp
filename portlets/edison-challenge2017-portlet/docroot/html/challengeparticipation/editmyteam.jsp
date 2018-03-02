<%@include file="/html/init.jsp"%>

<%
	boolean curretIsLeader = false;
	long challengeTeamId = ParamUtil.getLong(request, "challengeTeamId");
	
	User currentUser = PortalUtil.getUser(request);
	List<ChildChallenge> childChallenges = ChildChallengeLocalServiceUtil.getChildChallenges(scopeGroupId, "Running");
	
	ChallengeTeam challengeTeam = ChallengeTeamLocalServiceUtil.getChallengeTeam(challengeTeamId);
	ChildChallenge childChallenge = ChildChallengeLocalServiceUtil.getChildChallenge(challengeTeam.getChildChallengeId());
	Challenge challenge = ChallengeLocalServiceUtil.getChallenge(childChallenge.getChallengeId());
	ChallengeTeamMember leaderMember = ChallengeTeamMemberLocalServiceUtil.getChallengeTeamLeaderMember(challengeTeam.getChallengeTeamId(), scopeGroupId);
	if(leaderMember.getApplyUserId()==currentUser.getUserId()){
		curretIsLeader=true;
	}
	String phone1="", phone2="", phone3="";
	if(leaderMember.getPhone().length()>3){
		String editPhone = leaderMember.getPhone().substring(4, leaderMember.getPhone().length());
		System.out.println("\n\n\n\n\n\ntest phone : ");
		System.out.println("test phone1 : "+ leaderMember.getPhone());
		System.out.println("test phone2 : "+ editPhone);
		int index = editPhone.indexOf('-');
		phone1 = leaderMember.getPhone().substring(0, 3);
		phone2 = editPhone.substring(0, index);
		phone3 = editPhone.substring(index+1, editPhone.length());
	}
	//Challenge challenge = ChallengeLocalServiceUtil.getChallenge(ChildChallengeLocalServiceUtil.getChildChallenge(childChallengeId).getChallengeId());
	
	String userUniversityCode = "University";
	String userMajor = "Major";
	
	
	userUniversityCode = currentUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY).toString();
	userMajor = currentUser.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR).toString();
	
	
	long companyId = currentUser.getCompanyId();
	ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId,ExpandoTable.class.getName(),EdisonExpando.TALBE_NAME);
	ExpandoValue universityValue = ExpandoValueLocalServiceUtil.getValue(companyId, table.getClassNameId(), EdisonExpando.TALBE_NAME, EdisonExpando.CDNM, Long.valueOf(userUniversityCode));
%>

<portlet:actionURL name="addChallengeTeam" var="addChallengeTeamURL" >
	<portlet:param name="challengeTeamId" value="<%= String.valueOf(challengeTeamId) %>"/>
</portlet:actionURL>


<div class="form-style-5">
<form id="<portlet:namespace/>updateTeamForm" enctype="multipart/form-data" method="POST" action="<%=addChallengeTeamURL%>">
	<fieldset>
		<legend><span class="number">1</span><%=LanguageUtil.get(pageContext, "challenge-user-field") %></legend>
		<!-- Apply Field Name Selection -->
		<div style="float: left; width: 20%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-user-field") %></label></div>
		<div style="float: left; width: 70%; padding:10px;">
			<select name="<portlet:namespace/>inputSubject"
					id="<portlet:namespace/>inputSubject">
					<%
						for (ChildChallenge child : childChallenges) {
							String option = "<option value=" + child.getChildChallengeId() + ">";
							String field = ChallengeLocalServiceUtil.getChallenge(child.getChallengeId())
									.getField(themeDisplay.getLocale());
							option += field;
							option += "</option>";
							out.println(option);
						}
					%>
			</select>
			<script>
				$('#<portlet:namespace/>inputSubject').val("<%=challengeTeam.getChildChallengeId()%>");
			</script>
		</div>
	</fieldset>
	<!-- Basic Apply User Information -->
	<fieldset>
		<legend><span class="number">2</span><%=LanguageUtil.get(pageContext, "challenge-team-leaderinformation") %></legend>
		<!-- Current User Name : Team Leader -->
		<div>
		<div style="float: left; width: 10%; padding:10px; "><label><%=LanguageUtil.get(pageContext, "challenge-team-teamleadername") %></label></div>
		<div style="float: left; width: 30%; padding:10px; padding-right:85px;"><input type="text" id="<portlet:namespace/>inputUserName" style="height:35px;" name="<portlet:namespace/>inputUserName" value="<%=leaderMember.getApplyUserName() %>" disabled="<%=true %>"></input></div>
		
		<!-- Current User E-mail : Team Leader -->
		<div style="float: left; width: 10%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-team-teamleaderemail") %></label></div>
		<div style="float: left; width: 30%; padding:10px;"><input type="text" id="<portlet:namespace/>inputUserEmail" style="height:35px;" name="<portlet:namespace/>inputUserEmail" value="<%=leaderMember.getEmail() %>" disabled="<%=true %>"></div>
		</div>
		
		<!-- Current User Institute : Team Leader -->
		<div>
		<div style="float: left; width: 10%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-team-teamleaderuniversity") %></label></div>
		<div style="float: left; width: 30%; padding:10px; padding-right:85px;"><liferay-ui:input-localized id="inputUserUniversity" style="height:35px;" name="inputUserUniversity" disabled="<%=true %>" xml="<%=leaderMember.getInstitute()%>"/></div>
		
		<!-- Current User Major : Team Leader -->
		<div style="float: left; width: 10%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-team-teamleadermajor") %></label></div>
		<div style="float: left; width: 30%; padding:10px; margin-bottom:20px;"><input type="text" style="height:35px;" id="inputUserMajor" name="inputUserMajor" value="<%=leaderMember.getMajor(themeDisplay.getLocale())%>" disabled="<%=true %>"></input></div>
		</div>
		
		<!-- Current User Phone Number : Team Leader -->
		<div>
		<div style="float: left; width: 10%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-team-phone") %></label></div>
		<div style="float: left; width: 30%; padding:10px; padding-right:85px;">
			<span>
				<select style="float: left; width: 20%; padding:10px;" id="<portlet:namespace/>phone1" name="<portlet:namespace/>phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
				</select>
				<script type="text/javascript">
					$('#<portlet:namespace/>phone1').val("<%=phone1%>");
				</script>
				<label style="float: left; width: 1%; margin-top:8px;">-</label>
				<input style="float: left; width: 20%; padding:10px; height:35px;" type="text" id="<portlet:namespace/>phone2" name="<portlet:namespace/>phone2" size="4" onkeypress="onlyNumber();" value="<%=phone2 %>"/>
				<label style="float: left; width: 1%; margin-top:8px;">-</label>
				<input style="float: left; width: 20%; padding:10px; height:35px;" type="text" id="<portlet:namespace/>phone3" name="<portlet:namespace/>phone3" size="4" onkeypress="onlyNumber();" value="<%=phone3 %>"/>
			</span>
		</div>

		<!-- Current User Grade : Team Leader -->
		<div style="float: left; width: 10%; padding:10px;"><label><%=LanguageUtil.get(pageContext, "challenge-team-teamleadergrade") %></label></div>
		<div style="float: left; width: 30%; padding:10px;">
			<select name="<portlet:namespace/>inputGrade" id="<portlet:namespace/>inputGrade">
				<option value="1"><liferay-ui:message key="challenge-grade-1"></liferay-ui:message></option>
				<option value="2"><liferay-ui:message key="challenge-grade-2"></liferay-ui:message></option>
				<option value="3"><liferay-ui:message key="challenge-grade-3"></liferay-ui:message></option>
				<option value="4"><liferay-ui:message key="challenge-grade-4"></liferay-ui:message></option>
				<option value="5"><liferay-ui:message key="challenge-grade-5"></liferay-ui:message></option>
				<option value="6"><liferay-ui:message key="challenge-grade-6"></liferay-ui:message></option>
				<option value="7"><liferay-ui:message key="challenge-grade-7"></liferay-ui:message></option>
			</select>
			<script type="text/javascript">
					$('#<portlet:namespace/>inputGrade').val("<%=leaderMember.getGrade()%>");
			</script>
		</div>
		</div>
	</fieldset>
		
	<!-- Apply Team Information -->
	<fieldset>
		<legend><span class="number">3</span><%=LanguageUtil.get(pageContext, "challenge-team") %></legend>
		
		<!-- Team Name : Apply Team Information -->
		<label><liferay-ui:message key="challenge-team-name"></liferay-ui:message></label>
		<input type="text" style="height:35px;" required="required" autofocus="autofocus" name="<portlet:namespace/>inputTeamName" id="<portlet:namespace/>inputTeamName" value="<%=challengeTeam.getTeamName() %>"></input>
		
		<!-- Team Paper Name : Apply Team Information -->
		<label style="margin-top:5px;"><%=LanguageUtil.get(pageContext, "challenge-user-papername") %></label>
		<liferay-ui:input-localized  type="textarea" name="inputPaperName" id="inputPaperName" xml="<%=challengeTeam.getPaperName() %>"></liferay-ui:input-localized>
		
		<!-- Team Paper Abstract : Apply Team Information -->
		<label style="margin-top:5px;"><%=LanguageUtil.get(pageContext, "challenge-user-paperabstract") %></label>
		<liferay-ui:input-localized type="textarea" rows="10" name="inputPaperAbstract" id="inputPaperAbstract" xml="<%=challengeTeam.getPaperAbstract() %>"></liferay-ui:input-localized>

		<!-- Team Paper File Upload : Apply Team Information -->
		<label style="margin-top:20px;"><%=LanguageUtil.get(pageContext, "challenge-user-papersubmission") %></label>
		<!-- DOC File Upload : Apply Team Information -->
		
		<%
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat EndDay = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			String now2 =  simpleFormat.format(now);
			Date endDay = childChallenge.getPaperEndDay();
			String endDay2 = simpleFormat.format(endDay);
			int dayResult = now.compareTo(endDay);
			
			System.out.println("\n\n\n\n\ntest date");
			System.out.println("now : " + now2);
			System.out.println("End Dat : "+endDay2);
			System.out.println("Result : "+dayResult+"\n\n\n\n");
		%>
		<c:if test="<%=dayResult < 0%>">
		<div class="filebox bs3-primary preview-image">
			<input class="upload-name" value="<%=LanguageUtil.get(pageContext, "challenge-team-file-select") %>" disabled="disabled" style="width: 200px;">
			<label for="<portlet:namespace/>papersubmission" style="margin-bottom:0px;">UpLoad</label> 
			<input type="file" name="<portlet:namespace/>papersubmission" id="<portlet:namespace/>papersubmission" class="upload-hidden" accept=".doc, .docx" />
			<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;">.doc, .docx</label>
			<c:if test="<%=challengeTeam.isPaperStatusDOC() %>">
				<portlet:resourceURL var="getMyTeamPaperFile">
					<portlet:param name="type" value="paperFile"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId())  %>" />
				</portlet:resourceURL>
				<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;" onclick="javascript: location.href='<%=getMyTeamPaperFile %>';">
					<img src="<%=request.getContextPath()%>/images/file_download2.png" style="width:15px;height:12px;margin-top:2px;"/>
					<%=challengeTeam.getPaperFileName()%>
				</label>
			</c:if>
		</div>
		
		<!-- PDF File Upload : Apply Team Information -->
		<div class="filebox bs3-primary preview-image" style="margin-top:5px;">
			<input class="upload-name" value="<%=LanguageUtil.get(pageContext, "challenge-team-file-select") %>" disabled="disabled" style="width: 200px;">
			<label for="<portlet:namespace/>papersubmissionPDF" style="margin-bottom:0px;">UpLoad</label> 
			<input type="file" name="<portlet:namespace/>papersubmissionPDF" id="<portlet:namespace/>papersubmissionPDF" class="upload-hidden" accept=".pdf" />
			<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;">.pdf</label>
			<c:if test="<%=challengeTeam.isPaperStatusPDF() %>">
				<portlet:resourceURL var="getMyTeamPaperFilePDF">
					<portlet:param name="type" value="paperFilePDF"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId())  %>" />
				</portlet:resourceURL>
				<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;" onclick="javascript: location.href='<%=getMyTeamPaperFilePDF %>';">
					<img src="<%=request.getContextPath()%>/images/file_download2.png" style="width:15px;height:12px;margin-top:2px;"/>
					<%=challengeTeam.getPaperPDFFileName()%>
				</label>
			</c:if>
		</div>
		</c:if>
		
		<!-- Team Presentation File Upload : Apply Team Information -->
		<label style="margin-top:15px;"><%=LanguageUtil.get(pageContext, "challenge-user-presentationsubmission") %></label>
		<div class="filebox bs3-primary preview-image">
			<input class="upload-name" value="<%=LanguageUtil.get(pageContext, "challenge-team-file-select") %>" disabled="disabled" style="width: 200px;">
			<label for="<portlet:namespace/>presentationsubmission" style="margin-bottom:0px;">UpLoad</label> 
			<input type="file" name="<portlet:namespace/>presentationsubmission" id="<portlet:namespace/>presentationsubmission" id="<portlet:namespace/>presentationsubmission" class="upload-hidden" accept=".ppt, .pptx" />
			<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;">.ppt, .pptx</label>
		
			<c:if test="<%=challengeTeam.isPresentationStatus() %>">
				<portlet:resourceURL var="getMyTeamPaperFilePresentation">
					<portlet:param name="type" value="presentationFile"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId())  %>" />
				</portlet:resourceURL>
				<label style="margin-bottom:0px; background-color: #1abc9c; border-color:#1abc9c;" onclick="javascript: location.href='<%=getMyTeamPaperFilePresentation %>';">
					<img src="<%=request.getContextPath()%>/images/file_download2.png" style="width:15px;height:12px;margin-top:2px;"/>
					<%=challengeTeam.getPresentationFileName()%>
				</label>
			</c:if>
		</div>
	</fieldset>
	
	<fieldset style="margin-top: 20px">
			<legend><span class="number">4</span><%=LanguageUtil.get(pageContext, "challenge-info-agreement-guide")%></legend>
			<label style="font-size:16px;"><%=LanguageUtil.get(pageContext, "challenge-info-agreement-subject")%></label>
			<div id='<portlet:namespace/>agreementArea' style="width:70%!important;margin-left:20px;">
				<label>1. <%=LanguageUtil.get(pageContext, "challenge-info-agreement-purpose1")%></label>
				<label>(1)<%=LanguageUtil.get(pageContext, "challenge-info-agreement-purpose2")%></label>
				<label>(2)<%=LanguageUtil.get(pageContext, "challenge-info-agreement-purpose3")%></label>
				<br>
				
				<label>2. <%=LanguageUtil.get(pageContext, "challenge-info-agreement-period1")%></label>
				<label>(1)<%=LanguageUtil.get(pageContext, "challenge-info-agreement-period2")%></label>
				<label>(2)<%=LanguageUtil.get(pageContext, "challenge-info-agreement-period3")%></label>
				<br>
				
				<label>3. <%=LanguageUtil.get(pageContext, "challenge-info-agreement-list4")%></label>
				<label><%=LanguageUtil.get(pageContext, "challenge-info-agreement-list5")%></label>
				<br>
				
				<label>4. <%=LanguageUtil.get(pageContext, "challenge-info-agreement-list1")%></label>
				<!-- 필수 정보 -->
				<label><%=LanguageUtil.get(pageContext, "challenge-info-agreement-list2")%></label>
				<label><%=LanguageUtil.get(pageContext, "challenge-info-agreement-question")%></label>
				<label><input type="radio" name="<portlet:namespace/>agreement1" value="agree" checked="checked"/>
					<%=LanguageUtil.get(pageContext, "challenge-info-agreement-agree")%></label>
				<label><input type="radio" name="<portlet:namespace/>agreement1" value="disagree"/>
					<%=LanguageUtil.get(pageContext, "challenge-info-agreement-disagree")%></label>
				<br>
				<!-- 선택 정보 -->
				<label><%=LanguageUtil.get(pageContext, "challenge-info-agreement-list3")%></label>
				<label><%=LanguageUtil.get(pageContext, "challenge-info-agreement-question")%></label>
				<label class="nowrap"><input type="radio" name="<portlet:namespace/>agreement2" value="<%=true %>" checked="checked"/>
					<%=LanguageUtil.get(pageContext, "challenge-info-agreement-agree")%></label>
				<label class="nowrap"><input type="radio" name="<portlet:namespace/>agreement2" value="<%=false %>"/>
					<%=LanguageUtil.get(pageContext, "challenge-info-agreement-disagree")%></label>
		
				
			</div>	
		</fieldset>
	
	<fieldset>
		<input id="<portlet:namespace/>teamsubmitButton" name="<portlet:namespace/>teamsubmitButton" type="submit" value='<%=LanguageUtil.get(pageContext, "challenge-team-update") %>' style="float:left;"/>
		<input type="reset" value='<%=LanguageUtil.get(pageContext, "challenge-reset") %>' style="float:left;"/>
		<input type="button" onclick="javascript:history.go(-1);" value='<%=LanguageUtil.get(pageContext, "challenge-cancel") %>' style="float:left;"/>
	</fieldset>
</form>
</div>



<!-- script, jquery -->
<script src="https://code.jquery.com/jquery-2.2.3.min.js" ></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js" ></script>
<link type="text/css" href="https://code.jquery.com/ui/1.11.4/themes/south-street/jquery-ui.css" rel="stylesheet" />
<script>
$(document).ready(function() {
	if('<%=challengeTeam.getAggrement()%>'=='false'){
		$('input[name=<portlet:namespace/>agreement2][value="false"]').prop('checked',true).click();
	}
});

$("input[name=<portlet:namespace/>agreement1]").click(function() {
	check_submit();
});
function check_submit() {
	if ($("input[name=<portlet:namespace/>agreement1]:checked").val() == 'disagree') {
		$(":submit").attr("disabled", true);
		alert("If you are not agreement that using and collection of personal information, you cannot participate this software challenge.");
		alert("<%=LanguageUtil.get(pageContext, "challenge-info-agreement-list5")%>");
	} else {
		$(":submit").removeAttr("disabled");
	}
}


$("input[name=<portlet:namespace/>agreement2]").click(function() {
	set_phoneValue();
});
function set_phoneValue() {
	console.log("test set Phone 0 : "+$("input[name=<portlet:namespace/>agreement2]:checked").val());
	if($("input[name=<portlet:namespace/>agreement2]:checked").val()=="false"){
		console.log("test set phone1 : ");
		$("#<portlet:namespace/>phone1").val("010").attr("disabled", true);
		$("#<portlet:namespace/>phone2").val("0000").attr("disabled", true);
		$("#<portlet:namespace/>phone3").val("0000").attr("disabled", true);
	}else{
		console.log("test set phone2");
		$("#<portlet:namespace/>phone1").attr("disabled", false).val("010");
		$("#<portlet:namespace/>phone2").attr("disabled", false).val("");
		$("#<portlet:namespace/>phone3").attr("disabled", false).val("");
	}
}


function onlyNumber(obj) {
	$(obj).keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/g,""));
		if($(this).val().length > 4){
			$(this).val($(this).val().substring(0, 4));
		}
        
    }); 
}
</script>
