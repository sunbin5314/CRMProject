<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户拜访列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js">

</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/visit/updateVisit.action"
		method=post>
		<input type="hidden" name="visitid" value="${visit.visitid} "/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：拜访记录管理 &gt; 修改拜访记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>拜访客户：</td>
								<td>
									<select id="cusid" name="customerModel.cid">
										<option value="">--请选择--</option>
									</select>
								</td>
								<td>用户名称：</td>
								<td>
									<select id="userid" name="user.uid">
										<option value="">--请选择--</option>
									</select>
								</td>
							</tr>
							<TR>
								<td>拜访地址：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="visitaddress" value="${visit.visitaddress}" >
								</td>
							</TR>
							<TR>
								<td>拜访内容：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="visitContent" value="${visit.visitContent}">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
<script type="text/javascript">
$(function(){
	//juery ajax获取所属客户
	$.post("${pageContext.request.contextPath}/linkman/allCustomerJson.action",function(data){
		//jquery遍历
		$(data).each(function(i,n){
			$("#cusid").append("<option value='"+n.cid+"'>"+n.cname+"</option")
		})
		/*把当前客户和所有客户做比较,如果和哪个相同就默认选中*/
		$("#cusid option[value='${visit.customerModel.cid}']").attr("selected","selected");
	})
})

$(function(){
	//juery ajax获取用户
	$.post("${pageContext.request.contextPath}/visit/allUserJson.action",function(data){
		//jquery遍历
		$(data).each(function(i,n){
			$("#userid").append("<option value='"+n.uid+"'>"+n.username+"</option")
		})
		/*把当前客户和用户做比较,如果和哪个相同就默认选中*/
		$("#userid option[value='${visit.user.uid}']").attr("selected","selected");
	})
})

</script>

</HTML>
