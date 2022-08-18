package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserUpdateViewService;
import vo.ActionForward;
import vo.UserDTO;

public class UserUpdateViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		ActionForward forward = null;
		forward = new ActionForward();
		String viewId = request.getParameter("id");
		UserUpdateViewService service = new UserUpdateViewService();
		UserDTO user = service.getUser(viewId);
		request.setAttribute("id", user);
		forward.setRedirect(false);
		forward.setPath("/UserUpdateView.me");
		return forward;
	}

}
