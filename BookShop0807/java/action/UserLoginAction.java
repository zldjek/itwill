package action;

import java.io.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

public class UserLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();

		user.setUser_id(request.getParameter("user_id"));
		user.setUser_passwd(request.getParameter("user_passwd"));

		UserLoginService userLoginService = new UserLoginService();
		boolean loginResult = userLoginService.login(user);
		ActionForward forward = null;
		if (loginResult) {
			forward = new ActionForward();
			session.setAttribute("user_id", user.getUser_id());
			forward.setRedirect(true);
			forward.setPath("/mypageAction.me");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alret('로그인실패');");
			out.println("location.href='/#';");
			out.println("</script>");
		}

		return forward;
	}

}
