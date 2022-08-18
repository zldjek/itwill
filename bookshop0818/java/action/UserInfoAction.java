package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserInfoService;
import vo.ActionForward;
import vo.UserDTO;

public class UserInfoAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = null;
		forward = new ActionForward();
		String viewId = request.getParameter("id");
		UserInfoService service = new UserInfoService();
		UserDTO user = service.getUser(viewId); 
		request.setAttribute("id", user);
		
		if (id != null){
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./UserUpdate.me");
		}
		if (id != null){
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./UserDelete.me");
		}
		if (id != null){
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./#");
		}
		return forward;
	}
}
