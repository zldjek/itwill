package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserUpdateViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");

		ActionForward forward = null;
		forward = new ActionForward();
		String viewId = request.getParameter("user_id");
		UserUpdateViewService userUpdateViewService = new UserUpdateViewService();
		UserDTO user = userUpdateViewService.getUser(viewId);
		request.setAttribute("user_id", user);
		forward.setPath("/user_info_view.jsp");
		return forward;
	}

}
