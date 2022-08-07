package action;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserInfoAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");

		ActionForward forward = null;

		forward = new ActionForward();
		String viewId = request.getParameter("user_id");
		UserInfoService userInfoService = new UserInfoService();
		UserDTO user = userInfoService.getUser(viewId);
		request.setAttribute("user_id", user);
		forward.setPath("./user_info.jsp");
		return forward;
	}
}
