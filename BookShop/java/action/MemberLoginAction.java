package action;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemberDTO member = new MemberDTO();
		
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_passwd(request.getParameter("member_passwd"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);
		ActionForward forward = null;
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getMember_id());
			forward.setPath("./mypage/mypage.me");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alret('로그인실패');");
			out.println("location.href='./mypage/member_join.me';");
			out.println("</script>");
		}
		
		return forward;
	}

}
