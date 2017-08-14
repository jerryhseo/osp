<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>

<liferay-portlet:actionURL secure="<%= request.isSecure() %>" var="termsOfUserAgreeUrl"  windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="myaction" value="termsOfUse" />
</liferay-portlet:actionURL>

<script type="text/javascript">
function deAgree(){
	history.back();
}	

function agreeCheck(){
	if(!document.getElementById("agree1").checked) {
		alert("홈페이지 이용약관에 동의하셔야 합니다.");
		form.agree1.focus();
		return false;
	} else {
		if(!document.getElementById("agree3").checked) {
			alert("개인정보 수집 및 이용에 동의하셔야 합니다.");
			form.agree3.focus();
			return false;
		}else{
			location.href = "<%= PortalUtil.getCreateAccountURL(request, themeDisplay) %>";
		}
	}
}
</script>

<style type="text/css">
	.logintitlebox {
		margin: 0 auto;
		width: 100%;
	}
	
	.logintitle {
		font-size: 27px;
		color: #000;
		padding: 0px 20px 12px 0px;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
		float: left;
	}
	
	.loginintro {
		vertical-align: bottom;
		font-size: 13px;
		color: #777777;
		padding: 15px 0px 12px 0px;
		float: left;
	}
	
	.joinbox {
		width: 94%;
		border: solid 6px #e5e5e5;
		text-align: center;
		padding: 22px 30px;
		text-align: left;
	}
	
	.jointitle{
		background: url(/edison-2016-hook/images/termsofuse/member_icon.gif) 0px 8px no-repeat;
		font-size: 19px;
		color: #6e6e6e;
		font-weight: 600;
		padding-left: 25px;
		text-align: left;
		line-height: 30px;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
	}
	
	.joinintro {
		vertical-align: bottom;
		font-size: 14px;
		color: #6e6e6e;
		padding: 15px 0px 25px 0px;
		line-height: 10px;
	}
	
	
	
	.textarea01 {
		width: 98%;
		margin: 0px;
		text-align: left;
		font-size: 14px;
		color: #777;
		line-height: 22px;
		border: solid 1px #cacaca;
		font-family: Arial, Nanum Barun Gothic,NanumGothic;
		float: left;
	}
	
	.joinwordbox {
		margin: 0 auto;
		width: 100%;
		padding-top: 15px;
		padding-bottom: 30px;
	}
	
	.joinword {
		padding-left: 15px;
		font-size: 14px;
		color: #000;
		line-height: 50px;
		float: left;
	}
	
	.joinword01 {
		padding-left: 90px;
		font-size: 14px;
		color: #6e6e6e;
		line-height: 50px;
		float: left;
		padding-top: 15px;
	}
	
	.borderline {
		height: 1px;
		border-bottom: 1px solid #e6e6e6;
	}
	.aui input[type="radio"], .aui input[type="checkbox"]{
		margin:0px;
	}
</style>

<aui:fieldset cssClass="body_layout">
	<form method="post" name="form">
		<div class="logintitlebox">
				<div class="logintitle"><liferay-ui:message key="edison-create-account-message" /></div>
				<div class="loginintro"><liferay-ui:message key="edison-create-account-course-message" /></div>
		</div>
		<div class="h20"></div>
		<div style="clear:left;"></div>
		<div class="joinbox">
			<div class="jointitle">홈페이지 이용약관</div>
			<div class="joinintro">
					<p>EDISON 사이트는 정보통신망법의 개인정보 취급방침을 준수하고 있습니다.</p>
					<p>아래의 이용약관 및 개인정보 보호방침을 반드시 읽어보신 후에 동의합니다에 체크해주시기 바랍니다. </p>
			</div>
			
			<textarea name="textarea3" cols="110"  rows="8" id="textarea3" class="textarea01"  style="padding:10px;resize: none;background-color: #f9f7f6;width:inherit;">
제 1 장 총칙

제 1 조 (목적)
이 약관은 EDISON 사이트가 제공하는 모든 서비스(이하 '서비스')의 이용 조건 및 절차, EDISON 및 이용자의 권리, 의무 및 책임 사항 등 기타 필요한 사항을 규정함을 목적으로 합니다.

제 2 조 (약관의 효력 및 변경)
① 이 약관은 EDISON 온라인 서비스 및 기타의 방법을 통하여 이를 공지함으로써 효력이 발생됩니다.
② EDISON 는 사정상 중요한 사유가 발생될 경우 사전 고지 없이 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 ①항과 같은 방법으로 공지함으로써 효력이 발생됩니다.
③ 회원은 변경된 약관에 동의하지 않을 경우 회원 탈퇴를 요청할 수 있으며, 변경된 약관의 효력 발생일 이후에도 서비스를 계속 사용할 경우 약관의 변경 사항에 동의한 것으로 간주됩니다.

제 3 조 (약관 외 준칙)
본 약관에 명시되지 아니한 사항에 대해서는 전기통신기본법, 전기통신사업법, 정보통신망 이용촉진 등에 관한 법률 및 기타 관련 법령의 규정에 따릅니다.

제 4 조 (용어의 정의)
이 약관에서 사용하는 주요한 용어의 정의는 다음과 같습니다.
1. 기본회원 : EDISON 와 서비스 이용 계약을 체결하고 이용자 아이디(ID)를 부여 받은 자를 말합니다.
2. 임시회원 : 자격이 있는 기본회원이 생성한 가상클래스에서 성명을 대치할 수 있는 명칭과 구분번호를 사용하여 임시로 생성된 아이디를 교육적인 목적으로 부여받은 자를 말합니다.
3. 비회원 : 회원에 가입하지 않고 서비스를 이용하는 자를 말합니다. 
4. 운영자 : 서비스의 전반적인 관리와 원활한 운영을 위하여 EDISON 에서 선정한 자를 말합니다. 

제 2 장 서비스 이용 계약 체결

제 5 조 (이용 계약의 성립)
① 사용자는 회원가입 시 "동의합니다."를 선택하면 이 약관에 동의하는 것으로 간주됩니다. 약관 변경 시에도 이와 동일하며, 변경된 약관에 동의하지 않을 경우 회원 등록 취소가 가능합니다.
② 이용 계약은 서비스 이용 희망자의 이용약관 동의 후 이용 신청에 대하여 EDISON 승낙함으로써 성립합니다.

제 6 조 (이용 신청)
회원으로 가입하여 서비스를 이용하기를 희망하는 자는 EDISON  요청하는 소정의 가입 신청 양식에서 요구하는 사항을 기록하여 신청합니다.

제 7 조 (이용 신청의 승낙)
① 제 6 조에 따른 이용 신청에 대하여, EDISON 는 특별한 사정이 없는 한 접수 순서대로 이용 신청을 승낙합니다.
② 다음 각 호에 해당하는 경우 EDISON 는 이용 신청에 대한 승낙을 제한할 수 있고, 그 사유가 해소될 때까지 승낙을 유보할 수 있습니다.
1. 서비스 관련 설비에 여유가 없는 경우
2. 기술상 지장이 있는 경우
3. 기타 EDISON 의 사정상 필요하다고 인정되는 경우
③ EDISON 는 다음 각 호에 해당하는 사항을 인지하는 경우 이용 신청을 승낙하지 아니할 수 있습니다.
1. 본인의 실명으로 신청하지 않은 경우
2. 다른 사람의 명의를 사용하여 신청한 경우
3. 이용 신청 시 필요 사항을 허위로 기재하여 신청한 경우
4. 사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청한 경우
5. 기타 EDISON 이 정한 이용 신청 요건이 미비된 경우
④ ②항 또는 ③항에 의하여 이용 신청의 승낙을 유보하거나 승낙하지 아니하는 경우, EDISON 는 이를 이용 신청자에게 알려야 합니다. 다만, EDISON 의 귀책 사유 없이 이용 신청자에게 통지할 수 없는 경우는 예외로 합니다.

제 8 조 (개인정보의 보호)
①EDISON 는 회원의 개인정보를 보호하고 존중합니다.
②EDISON 는 회원이 서비스를 이용함에 있어서 온라인 상에서EDISON 에게 제공한 개인정보가 보호받을 수 있도록 최선을 다하고 있습니다. 이에 통신비밀보호법, 전기통신사업법, 정보통신망 이용촉진 등에 관한 법률 등 서비스 제공자가 준수하여야 할 관련 법규를 바탕으로 개인정보 보호정책을 만들어 이를 준수하고 있습니다. 자세한 사항은EDISON 의 개인정보 보호정책을 참고하시기 바랍니다.
③EDISON 는 이용 신청 시 회원이 제공하는 정보, 커뮤니티 활동, 각종 이벤트 참가를 위하여 회원이 제공하는 정보, 기타 서비스 이용 과정에서 수집되는 정보 등을 통하여 회원에 관한 정보를 수집하며, 회원의 개인정보는 본 이용 계약의 이행과 본 이용 계약상의 서비스 제공을 위한 목적으로만 사용됩니다.
④EDISON 는 서비스 제공과 관련하여 취득한 회원의 신상정보를 본인의 승낙 없이 제 3자에게 누설 또는 배포할 수 없으며, 상업적 목적으로 사용할 수 없습니다. 다만, 다음의 각 호에 해당하는 경우에는 그러하지 아니합니다.
1. 정보통신서비스의 제공에 따른 요금 정산을 위하여 필요한 경우
2. 통계작성, 학술연구 또는 시장조사를 위하여 필요한 경우로써 특정 개인을 식별할 수 없는 형태로 가공하여 제공하는 경우
3. 관계 법령에 의하여 수사상 목적으로 정해진 절차와 방법에 따라 관계 기관의 요구가 있는 경우
4. 다른 법률에 특별한 규정이 있는 경우
5. 방송통신심위위원회 요청이 있는 경우
⑤EDISON 는 서비스를 통해 회원의 컴퓨터에 쿠키를 전송할 수 있습니다. 회원은 쿠키 수신을 거부하거나 쿠키 수신에 대해 경고하도록 브라우저 설정을 변경할 수 있습니다.

제 9 조 (계약 사항의 변경)
① 회원은 개인정보 관리를 통해 언제든지 본인의 개인정보를 열람하고 수정할 수 있습니다.
② 회원은 이용 신청 시 기재한 사항이 변경되었을 경우 온라인으로 수정을 해야 하며 회원정보를 변경하지 아니하여 발생되는 문제의 책임은 회원에게 있습니다.

제 3 장EDISON 과 회원의 권리 및 의무

제 10 조 (EDISON 의 의무)
①EDISON 는 다음 각 호의 사유가 발생한 경우를 제외하고 계속적, 안정적으로 서비스를 제공할 의무가 있습니다.
1. 서비스용 설비의 보수, 정기 점검 또는 공사로 인한 부득이한 경우
2. 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지한 경우
3. 전시, 사변, 천재지변 또는 이에 준하는 국가비상사태가 발생하거나 발생할 우려가 있는 경우
4. 설비 장애 또는 이용 폭주 등으로 인하여 서비스 이용에 지장이 있는 경우
②EDISON 는 회원으로부터 소정의 절차에 의해 제기되는 의견에 대해서는 적절한 절차를 거처 처리하며, 처리 시 일정 기간이 소요될 경우 회원에게 그 사유와 처리 일정을 알려주어야 합니다.

제 11 조 (회원의 의무)
① 회원은 관계 법령, 본 약관의 규정, 이용 안내 및 서비스 상에 공지한 주의사항,EDISON 이 통지하는 사항을 준수하여야 하며, 기타EDISON 의 업무에 방해되는 행위를 하여서는 안 됩니다.
② 회원은 서비스를 이용한 어떠한 영리행위도EDISON 의 사전 동의 없이는 할 수 없으며, 법에 저촉되는 자료를 배포 또는 게재할 수 없습니다.
③ 회원은 자신의 ID와 비밀번호를 유지 관리할 책임이 있으며 자신의 ID와 비밀번호를 사용하여 발생하는 모든 결과에 대해 전적인 책임이 있습니다. 또한 자신의 ID와 비밀번호가 자신의 승낙 없이 사용되었을 경우 즉시EDISON 에 통보하여야 하며, 통보를 하지 않음으로 인해 발생하는 모든 책임은 회원 본인이게 있습니다.
④ 회원은 서비스와 관련하여 다음 각 호에 해당하는 행위를 하여서는 안 됩니다.
1. 서비스를 이용하여 얻은 정보를EDISON 의 사전 승낙 없이 복사, 복제, 변경, 번역, 출판, 방송 기타의 방법으로 사용하거나 이를 타인에게 제공하는 행위
2. 음란물을 게재 또는 음란사이트를 링크하거나 유포하는 등 사회질서를 해치는 행위
3. 타인의 명예를 훼손하거나 모욕하는 행위, 타인의 지적재산권 등의 권리를 침해하는 행위
4. 해킹 또는 컴퓨터 바이러스를 유포하는 일, 타인의 의사에 반하여 광고성 정보 등 일정한 내용을 지속적으로 전송하는 행위
5. 다른 회원의 ID를 부정 사용하는 행위
6. 다른 사용자의 개인 정보를 수집, 저장하는 행위
7.EDISON  직원, 관리자 등을 포함한 타인을 사칭하는 행위
8. 서비스를 통해 전송된 컨텐츠의 발신인을 위조하는 행위
9. 타인을 스톡(stalk)하거나, 괴롭히는 행위
10. 서비스 운영에 지장을 주거나 줄 우려가 있는 일체의 행위, 기타 관계 법령에 위배되는 행위

제 12 조 (면책 조항)
①EDISON 는 회원이 서비스를 통해 게재 또는 전송한 정보, 자료, 사실에 관하여는 그 정확성, 신뢰성 등 내용에 대한 어떠한 보증도 하지 아니하며 회원의 서비스 자료에 대한 취사 선택 또는 이용으로 발생하는 손해 등에 대해 책임을 지지 아니합니다.
②EDISON 는 회원이 서비스를 이용하여 기대하는 손익이나 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 아니합니다.
③EDISON 는 회원 상호간 또는 회원과 제 3자 상호간에 서비스를 매개로 발생한 분쟁에 대해서는 개입할 의무가 없으며 이로 인한 손해를 배상할 책임도 없습니다.
④ 회원의 서비스 이용에 있어 회원의 귀책사유로 인하여 발생한 장애에는EDISON 의 책임이 면제됩니다.
⑤ 회원이 본 약관의 규정을 위반함으로 인하여EDISON 에 손해가 발생하는 경우, 이 약관을 위반한 회원은EDISON 에 발생하는 모든 손해를 배상하여야 하며, 동 손해로부터EDISON 를 면책시켜야 합니다.

제 13 조 (손해배상)
EDISON 이 제공하는 서비스와 관련하여 회원에게 어떠한 손해가 발생하더라도EDISON 의 중대한 과실에 의한 경우를 제외하고는EDISON 는 이에 대하여 책임을 부담하지 않습니다.

제 14 조 (양도 금지)
회원은 서비스의 이용 권한, 기타 이용 계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.
제 4 장 서비스 이용

제 15 조 (서비스 이용 범위)
회원은EDISON  회원 가입 시 발급된 ID 하나로EDISON  사이트 내에서 제공하는 서비스를 이용할 수 있습니다. 단, 별도로 제휴사에서 제공하는 컨텐츠의 경우 그렇지 아니한 경우도 있습니다.

제 16 조 (정보의 제공)
EDISON 는 회원이 서비스 이용 중 필요가 있다고 인정되는 다양한 정보를 공지사항이나 전자우편 등의 방법으로 회원에게 제공할 수 있습니다.

제 17 조 (컨텐츠 이용 요금)
①EDISON 이 제공하는 서비스는 기본적으로 무료입니다. 단, 유료 서비스 및 유료 정보에 대해서는 해당 정보에 명시된 요금을 지불하여야 사용 가능합니다.
② 향후 유료정보 서비스시, 범위와 가격표를 별도 공지합니다.

제 18 조 (회원의 게시물)
EDISON 는 회원이 게시하거나 등록하는 서비스 내의 내용물이 다음 각 호에 해당한다고 판단되는 경우에 사전 통지 없이 삭제할 수 있습니다.
1. 다른 회원 또는 제 3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우
2. 공공질서 및 미풍양속에 위반되는 내용인 경우
3. 범죄적 행위에 결부된다고 인정되는 내용일 경우
4.EDISON 의 저작권, 제 3자의 저작권 등 기타 권리를 침해하는 내용인 경우
5.EDISON 에서 규정한 게시 기간이나 용량을 초과한 경우
6. 음란물을 게재하거나 음란사이트를 링크하는 경우
7. 불법복제 또는 해킹을 조장하는 내용인 경우
8. 영리를 목적으로 하는 광고일 경우 
9. 게시판의 성격에 부합하지 않는 내용을 게시할 경우
10. 기타 관계법령에 위배된다고 판단되는 경우

제 19 조 (게시물의 저작권)
서비스에 게재된 자료에 대한 권리는 다음 각 호와 같습니다.
1. 게시물에 대한 권리와 책임은 게시자에게 있으며EDISON 는 게시자의 동의 없이 이를 서비스 내 게재 이외의 영리적 목적으로 사용할 수 없습니다. 단, 비영리적인 경우에는 그러하지 아니하며 또한EDISON 이 서비스 내의 게재권을 갖습니다.
2. 회원은 서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.

제 20 조 (서비스의 이용 시간)
①EDISON 는 회원의 이용 신청을 승낙한 때부터 즉시 서비스를 개시합니다. 단,EDISON 의 업무상 또는 기술상의 장애로 인하여 서비스를 개시하지 못하는 경우, 서비스에 공지하거나 회원에게 즉시 이를 통지합니다.
② 서비스의 이용은 연중 무휴 1일 24시간을 원칙으로 합니다. 다만EDISON 의 업무상 또는 기술상의 이유로 인하여 서비스의 전부 또는 일부가 일시 중지될 수 있으며, 운영상의 목적으로EDISON 이 정한 기간에 서비스의 전부 또는 일부가 일시 중지될 수도 있습니다. 이러한 경우에는EDISON 이 사전 또는 사후에 이를 공지합니다.
③EDISON 는 서비스 별로 이용 가능한 시간을 별도로 정할 수 있으며 이 경우 그 내용을 사전에 공지합니다.

제 21 조 (서비스 제공의 중지)
무료 서비스의 경우,EDISON 의 필요에 따라 언제든지 본 서비스의 전부 또는 일부를 수정하거나 중단할 수 있으며, 이 경우EDISON 이 전자우편 또는 인터넷 홈페이지 등을 통하여 회원에게 즉시 이를 고지합니다.

제 5장 계약 해지 및 서비스 이용 제한

제 22 조 (회원 탈퇴 및 이용 제한)
① 회원이 이용 계약을 해지하고자 하는 때에는 회원 본인이 직접EDISON  사이트 내의 회원정보 관리를 이용하여 회원 탈퇴를 요청해야 합니다.
②EDISON 는 회원이 다음 사항에 해당하는 행위를 하였을 경우, 사전 통지 없이 이용 계약을 해지하거나 또는 기간을 정하여 해당 회원의 서비스 이용을 차단할 수 있습니다.
1. 공공 질서 및 미풍 양속에 반하는 행위를 한 경우
2. 범죄적 행위에 관련되는 행위를 한 경우
3. 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행한 경우
4. 타인의 ID 및 비밀번호를 도용한 경우
5. 가입한 이름이 실명이 아닌 경우
6. 타인의 명예를 손상시키거나 타인에게 불이익을 주는 경우
7. 같은 사용자가 다른 ID로 이중 등록을 한 경우
8. 서비스에 위해를 가하는 등 건전한 이용을 저해하는 행위를 한 경우
9. 정보통신설비의 오작동이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우
10. 기타 관련 법령이나EDISON 이 정한 이용 조건에 위배되는 행위를 한 경우
③ 임시회원인 경우에는 임시회원자격을 해제할 때 자동 탈퇴 처리됩니다.

부 칙

1. (시행일) 이 약관은 2014년 9월 5일부터 시행합니다.
			</textarea>
			<div class="joinwordbox">
					<div class="joinword">홈페이지 이용 약관에 동의 하시겠습니까?</div>
					<div class="joinword01">
						<span>
							<label style="float: left;"><input name="agree1" id="agree1" type="radio" value="Y" /> 동의함   </label> 
							<label style="float: left;padding-left: 15px;"><input name="agree1" type="radio" value="" /> 동의하지 않음</label>
						</span>
					</div>
			</div>
			<div style="clear:left;"></div>
			<div class="borderline"></div>
			<div class="h20"></div>
			<div class="jointitle">개인정보 수집 및 이용 </div>
			<div class="h15"></div>
			<textarea name="textarea3" cols="110"  rows="8" id="textarea3" class="textarea01"  style="padding:10px;resize: none;background-color: #f9f7f6;width:inherit;">
[수집하는 개인정보의 항목]

가. 회사는 회원가입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 개인정보를 수집하고 있습니다. 

<일반회원가입> 
  - 필수항목 : 성명 또는 성명을 대체할 수 있는 별칭, 아이디, 비밀번호, 메일주소
  - 선택항목 : 전공 또는 부서

<임시회원생성> 
  - 필수항목 : 성명 또는 성명을 대체할 수 있는 별명, 자동생성된 아이디, 비밀번호 

나. 서비스 이용과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다. 
  - IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록

다. EDISON 서비스를 사용함에 있어서 추가적인 개인정보는 요구하지 않습니다. 

[개인정보 수집 목적]

EDISON 는 다음과 같은 이유로 개인정보를 수집합니다. 

가. EDISON 에 따른 서비스제공
- 주관 기관의 교육사업 신청, 선정 기관과의 협약 진행, 교육 과정 조회, 교육 대상자들의 교육 신청, 교육 모니터링

나. 회원관리
- 회원제 서비스 이용 및 제한적 본인 확인제에 따른 본인확인
- 불량회원의 부정 이용방지와 비인가 사용방지
- 가입의사 확인, 가입 및 가입횟수 제한
- 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달

다. EDISON  관리의 개선 및 보완에 활용

[개인정보 보유기간]

o 정보주체 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다.

가. 회사 내부 방침에 의한 정보보유 사유 
- 보존 이유 : 정부 일자리 지원 사업 중복 수혜방지
- 보존 기간 : 영구 보존

나. 관련법령에 의한 정보보유 사유
- 상법, 전자상거래 등에서의 소비자보호에 관한 법률 등 관계법령의 규정에 의하여 보존할 필요가 있는 경우 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다. 
- 계약 또는 청약철회 등에 관한 기록 
 보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률 
 보존 기간 : 5년 
- 대금결제 및 재화 등의 공급에 관한 기록 
 보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률 
 보존 기간 : 5년 
- 소비자의 불만 또는 분쟁처리에 관한 기록 
 보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률 
 보존 기간 : 3년

[개인정보 수집 동의 거부의 권리]

 EDISON 서비스는 기본 정보 이외에 전공 또는 부서 정보에 대한 추가정보를 수집하고 있습니다. 추가 정보는 통계 및 서비스 질의 향상을 위한 목적으로만 활용되며, 추가정보를 입력하면 추가정보 활용에 동의한 것으로 간주하지만 추가정보를 입력하지 않더라도 서비스의 이용에는 제한이 없습니다.
			</textarea>
			<div class="joinwordbox">
					<div class="joinword">개인정보 수집 및 이용에 동의 하시겠습니까?</div>
					<div class="joinword01">
						<span>
							<label style="float: left;"><input name="agree3" id="agree3" type="radio" value="Y" /> 동의함   </label> 
							<label style="float: left;padding-left: 15px;"><input name="agree3" type="radio" value="" /> 동의하지 않음</label>
						</span>
					</div>
			</div>
			<div style="clear:left;"></div>
			<div class="borderline"></div>
			<div class="buttonbox08">
				<input type="button" name="fullsize" id="fullsize" value="회원가입" onclick="agreeCheck();" class="button08"><span> <input type="button" name="fullsize" id="fullsize" onclick="deAgree();" value="취소" class="button08"></span>
			</div>
		</div>
	</form>
</aui:fieldset>