package action;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MypageAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();

		user.setUser_id(request.getParameter("user_id"));

		MypageService mypageService = new MypageService();
		boolean loginResult = mypageService.login(user);
		ActionForward forward = null;
		if (loginResult) {
			forward = new ActionForward();
			session.setAttribute("user_id", user.getUser_id());
			forward.setRedirect(true);
			forward.setPath("/my_page.jsp");
		}
		return forward;
	}
}
