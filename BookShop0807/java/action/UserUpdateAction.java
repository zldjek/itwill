package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserUpdateAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();

		user.setUser_id(request.getParameter("user_id"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_passwd(request.getParameter("user_passwd"));
		user.setUser_address(request.getParameter("user_address"));
		user.setUser_phone(request.getParameter("user_phone"));
		user.setUser_email(request.getParameter("user_email"));

		UserUpdateService userUpdateService = new UserUpdateService();
		boolean updateResult = userUpdateService.updateUser(user);
		ActionForward forward = null;
		if (updateResult) {
			forward = new ActionForward();
			session.setAttribute("user_id", user.getUser_id());
			forward.setRedirect(true);
			forward.setPath("/user_updaate.me");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('내정보 수정실패!');");
			out.println("location.href='/user_info.me';");
			out.println("</script>");
		}
		return forward;
	}
}
