package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MemberUpdateAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 
				 	HttpSession session = request.getSession();
			   		MemberDTO member = new MemberDTO();
			   		
			   		member.setMember_id(request.getParameter("member_id"));
			   		member.setMember_name(request.getParameter("member_name"));
			   		member.setMember_passwd(request.getParameter("member_passwd"));
			   		member.setMember_address(request.getParameter("member_address"));
			   		member.setMember_phone(request.getParameter("member_phone"));
			   		member.setMember_email(request.getParameter("member_email"));
			   		
			   		MemberUpdateService memberUpdateService = new MemberUpdateService();
			   		boolean updateResult = memberUpdateService.updateMember(member);
			   		ActionForward forward = null;
			   		if(updateResult){
			   	    forward = new ActionForward();
			   		session.setAttribute("member_id", member.getMember_id());
			   		forward.setRedirect(true);
			   		forward.setPath("./member_updaate.me");
			   		}
			   		else{
			   			response.setContentType("text/html;charset=UTF-8");
				   		PrintWriter out=response.getWriter();
				   		out.println("<script>");
				   		out.println("alert('내정보 수정실패!');");
				   		out.println("location.href='./member_info.me';");
				   		out.println("</script>");
			   		}
			   		return forward;
			}
		}
