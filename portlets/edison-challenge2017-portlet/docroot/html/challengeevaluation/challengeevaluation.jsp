<%@page import="kisti.edison.challenge.service.ChallengeEvaluationLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants" %>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@page import="com.liferay.portlet.asset.model.AssetLinkConstants" %>
<%@page import="com.liferay.portlet.asset.model.AssetLink" %>


<%@include file="/html/init.jsp"%>
<c:choose>
<c:when test="<%=!themeDisplay.isSignedIn()%>">
	<script>
		window.location.href = "${themeDisplay.getURLSignIn()}";
	</script>
</c:when>
</c:choose>


<liferay-ui:error key="challenge-cannot-be-displayed" message="challenge-cannot-be-displayed" />

<%
	Challenge challenge = (Challenge) renderRequest
			.getAttribute(WebKeys.CHALLENGE);

	User currentUser = PortalUtil.getUser(request);
	String challengeFieldName = ParamUtil.getString(request, "challengeFieldName");
	
	long challengeTeamId = ParamUtil.getLong(request, "challengeTeamId");
	ChallengeTeam challengeTeam = ChallengeTeamLocalServiceUtil.getChallengeTeam(challengeTeamId);
	List<ChildChallenge> childChallenges = null;
	if(challenge != null){
		childChallenges = ChildChallengeLocalServiceUtil.getChildChallenges(scopeGroupId, challenge.getChallengeId(), "Running");
		challengeFieldName = challenge.getField(themeDisplay.getLocale());
	}
	if(challenge != null && childChallenges != null){
%>


<aui:nav cssClass="nav-tabs">

	<%
		List<Challenge> challenges = null;
		Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator");
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		if(UserLocalServiceUtil.hasRoleUser(role.getRoleId(), currentUser.getUserId())){
			challenges = ChallengeServiceUtil.getChallenges(groupId);
		}else{
			challenges = ChallengeLocalServiceUtil.getChallengesByEvaluationRole(groupId, currentUser.getUserId(), companyId);
		}
		
		for (int i = 0; i < challenges.size(); i++) {
			Challenge curChallenge = (Challenge) challenges.get(i);
			String cssClass = StringPool.BLANK;
			if (curChallenge.getChallengeId() == challenge.getChallengeId()) {
				cssClass = "active";
				challengeFieldName = curChallenge.getField(themeDisplay.getLocale());
			}
				
		if (ChallengePermission.contains(
			permissionChecker, curChallenge.getChallengeId(), "VIEW")) {
					
	%>
	
	

		<portlet:renderURL var="viewPageURL">
			<portlet:param name="mvcPath" value="/html/challengeevaluation/view.jsp" />
			<portlet:param name="challengeFieldName" value="<%=curChallenge.getField(themeDisplay.getLocale())%>" />
		</portlet:renderURL>

		<aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
			label="<%=HtmlUtil.escape(curChallenge.getField(themeDisplay.getLocale()))%>" />
	<% 
			}
		}
	%>
</aui:nav>

<!-- Team information -->
<div class="blog-container" style="background: #fff;border-width:1px;border-color:#e5ded8!important;border-style:solid;">
	<div class="blog-header">
		<div class="blog-author">
			<div style="color:black;font-size:80px;margin-top:20px;margin-left:15px;margin-bottom:15px;position:relative;"><%=challengeTeam.getTeamName() %></div>
			<br clear="left">
		</div>
	</div>
	<div class="blog-body">
		<div class="blog-summary" style="width:100%; margin-top:5px;">
		<p>
			<strong><%=LanguageUtil.get(pageContext,"challenge-user-field") %></strong><br>
			<%=challengeTeam.getSubject(themeDisplay.getLocale()) %><br><br>
			<strong><%=LanguageUtil.get(pageContext,"challenge-user-papername") %></strong><br>
			<%=challengeTeam.getPaperName(themeDisplay.getLocale()) %><br><br>
			<strong><%=LanguageUtil.get(pageContext,"challenge-user-paperabstract") %></strong><br>
			<%=challengeTeam.getPaperAbstract(themeDisplay.getLocale()) %><br><br>
			<strong><%=LanguageUtil.get(pageContext,"challenge-scienceapp") %></strong><br>
			<%=ChallengeTeamLocalServiceUtil.getTeamAppListString(themeDisplay.getCompanyId(), challengeTeam.getChallengeTeamId()) %><br><br>
			<strong><%=LanguageUtil.get(pageContext,"challenge-scienceappcount") %></strong><br>
			<%=ChallengeTeamLocalServiceUtil.getTeamSimulationNumber(themeDisplay.getCompanyId(), challengeTeam.getChallengeTeamId()) %><br><br>
			<strong><%=LanguageUtil.get(pageContext,"challenge-cputime") %></strong><br>
			<%=ChallengeTeamLocalServiceUtil.getCPUUseage(themeDisplay.getCompanyId(), challengeTeam.getChallengeTeamId()) %><br><br>
		</p>
		</div>
		<div class="blog-tags">
			<div style="color:#e5ded8;font-size:30px;margin-left:15px;margin-bottom:15px;position:relative;">Download</div>
			<ul>
				<portlet:resourceURL var="getMyTeamPaperFile">
					<portlet:param name="type" value="paperFile"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId())  %>" />
				</portlet:resourceURL> 
				<portlet:resourceURL var="getMyTeamPaperFilePDF">
					<portlet:param name="type" value="paperFilePDF"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId())  %>" />
				</portlet:resourceURL>
				<portlet:resourceURL var="getMyTeamPresentationFile">
					<portlet:param name="type" value="presentationFile"/>
					<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeam.getChallengeTeamId()) %>" />
				</portlet:resourceURL>
				<c:if test="<%=challengeTeam.isPaperStatusDOC() %>">
					<li style="margin-left:0; margin-top:10px;"><a href="<%=getMyTeamPaperFile%>"><%=challengeTeam.getPaperFileName() %></a></li>
				</c:if>
				<c:if test="<%=challengeTeam.isPaperStatusPDF() %>">
					<li style="margin-left:0; margin-top:10px;"><a href="<%=getMyTeamPaperFilePDF%>"><%=challengeTeam.getPaperPDFFileName() %></a></li>
				</c:if>
				<c:if test="<%=challengeTeam.isPresentationStatus() %>">
					<li style="margin-left:0; margin-top:10px;"><a href="<%=getMyTeamPresentationFile%>"><%=challengeTeam.getPresentationFileName() %></a></li>
				</c:if>
			</ul>
		</div>
		<div class="blog-footer" style="border-top:1px solid #e5ded8;">
			<ul>
				<li class="published-date"><%=challengeTeam.getCreateDate() %></li>
			</ul>
		</div>
	</div>
</div>


<!-- Evaluation Information -->
<div class="blog-container">
	<div class="blog-header">
		<div class="blog-author">
			<div style="float:left; width:15%"><div class="blog-author-icon" style='background:url("<%=currentUser.getPortraitURL(themeDisplay)%>")'></div></div>
			<div style="float:left; width:85%"><h3><%=currentUser.getScreenName()%></h3></div>
		</div>
	</div>
	<div class="blog-body">
		<div class="blog-title">	
		</div>
		<portlet:actionURL name="addChallengeEvaluationScore" var="addChallengeEvaluationScore">
			<portlet:param name="challengeTeamId" value="<%=String.valueOf(challengeTeamId) %>"/>
			<portlet:param name="challengeFieldName" value="<%=String.valueOf(challengeFieldName) %>"/>
		</portlet:actionURL>
		<form id="<portlet:namespace/>evluationForm" enctype="multipart/form-data" method="POST" action="<%=addChallengeEvaluationScore%>">
		<div class="blog-summary" style="width:100%; margin-top:5px;"><p>
			<br><br>
			
			<table class="table" style="width:95%">
				<colgroup>
					<col width="70%" />
					<col width="15%" />
					<col width="15%" />
				</colgroup>
				<tr>
					<th><%=LanguageUtil.get(pageContext,"challenge-evauation-assessment") %></th>
					<th><%=LanguageUtil.get(pageContext,"challenge-evaluation-distribution") %></th>
					<th><%=LanguageUtil.get(pageContext,"challenge-evaluation-score") %></th>
				</tr>
				
				<%
					List<ChallengeEvaluationManagement> challengeEvaluationManagementList = null;
					challengeEvaluationManagementList = ChallengeEvaluationManagementLocalServiceUtil.getChallengeEvaluationManagementes(scopeGroupId, challengeTeam.getChildChallengeId());
				
					for(ChallengeEvaluationManagement challengeEvaluationManagement : challengeEvaluationManagementList){
				%>
					<tr>
						<td><%=challengeEvaluationManagement.getAssessmentItem(themeDisplay.getLocale()) %></td>
						<td><%=challengeEvaluationManagement.getDistribution()%></td>
						<td>
							<%
								boolean test = false;
								String nameSpace = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request));
								String id = nameSpace+String.valueOf(challengeEvaluationManagement.getChallengeEvaluationManagementId());
						
								List<ChallengeEvaluationScore> scoreList = new ArrayList<ChallengeEvaluationScore>(); 
								scoreList = ChallengeEvaluationScoreLocalServiceUtil
								.getChallengeEvaluationScoreByGroupIdAndChallengeTeamIdAndUserId(scopeGroupId, 
										challengeTeamId, currentUser.getUserId());
								
							%>
							

							<c:choose>
								<c:when test="<%=scoreList.size()>0 %>">
									<%	
										ChallengeEvaluationScore inputScoreFromUser=null;
										for(ChallengeEvaluationScore currentScore : scoreList){
											if(currentScore.getChallengeEvaluationManagementId() == challengeEvaluationManagement.getChallengeEvaluationManagementId()){
												inputScoreFromUser = currentScore;
											}
										}
									%>
									<input type="text" style="width:40px;" name="<%=id %>" id="<%=id %>" value="<%=String.valueOf(inputScoreFromUser.getScore())%>" onkeyPress='inpuOnlyNumber();' onkeyUp='checkDistributionNum("<%=id %>", "<%=challengeEvaluationManagement.getDistribution()%>");'/>
								</c:when>
								<c:otherwise>
									<input type="text" style="width:40px;" size="10"  name="<%=id %>" id="<%=id %>" value="" onkeyPress='inpuOnlyNumber();' onkeyUp='checkDistributionNum("<%=id %>", "<%=challengeEvaluationManagement.getDistribution()%>");'/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				<%}%>
			
			</table>
			
		</div>
		<div class="blog-footer">
			<ul>
				<li class="published-date"><%=new Date() %></li>
					<portlet:renderURL var="viewPageURL">
						<portlet:param name="mvcPath" value="/html/challengeevaluation/view.jsp" />
						<portlet:param name="challengeFieldName" value="<%=challengeFieldName%>" />
					</portlet:renderURL>
					<li class="comments" onclick="javascript: window.location.href ='<%=viewPageURL%>' ">
						<%=LanguageUtil.get(pageContext, "challenge-cancel") %>
					</li>
					<li class="comments" onclick="javascript: $('#submitEvaluationForm').click()">
						<%=LanguageUtil.get(pageContext, "challenge-evaluation") %>
					</li>
			</ul>
		</div>
		<input type="submit" id="submitEvaluationForm" style="display:none;"/>
		</form>
	</div>
</div>

<%}%>


<script>
function inpuOnlyNumber() 
{	
	if(event.keyCode >= 48 && event.keyCode <= 57) {
			return true;
    }else {
		event.returnValue = false;
	}
}
function checkDistributionNum(id, distribution){
	//console.log("Test Input");
	console.log("Distribution : " + distribution);
	//console.log("id : " + id);
	var currentInput = $("#"+id);
	console.log("Input value1 : " +  currentInput.val());
	
	if(currentInput.val()*1 > distribution*1){
		console.log("test input true");
		currentInput.val('');
	}
}

</script>