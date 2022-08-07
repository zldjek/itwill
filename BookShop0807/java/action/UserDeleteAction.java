package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = null;
		String deleteId = request.getParameter("id");
		UserDeleteService userDeleteService = new UserDeleteService();
		boolean deleteResult = userDeleteService.deleteUser(deleteId);

		if (deleteResult) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./UserDeleteAction.me");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보삭제 실패.');");
			out.println("location.href='/user_delete.me';");
			out.println("</script>");
		}
		return forward;
	}
}
