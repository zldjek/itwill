package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MypageAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
   		MemberDTO member=new MemberDTO();
   		
   		member.setMember_id(request.getParameter("member_id"));
   		member.setMember_passwd(request.getParameter("member_passwd"));
   		
   		MypageService mypageService = new MypageService();
   		boolean loginResult = mypageService.login(member);
   		ActionForward forward = null;
   		if(loginResult){
   	    forward = new ActionForward();
   		session.setAttribute("member_id", member.getMember_id());
   		forward.setRedirect(true);
   		forward.setPath("./mypage/mypage.me");
   		}
   		else{
   			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('로그인 실패');");
	   		out.println("location.href='./mypage/member_join.me';");
	   		out.println("</script>");
   		}
   		return forward;	
	}
}
