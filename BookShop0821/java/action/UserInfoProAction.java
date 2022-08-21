package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.*;
import vo.ActionForward;
import vo.UserDTO;

public class UserInfoProAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" UserInfoProAction 실행");

		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		String viewId = request.getParameter("id");
		UserInfoProService service = new UserInfoProService();
		UserDTO user = service.getUser(viewId);
   		user.setUser_id(request.getParameter("user_id"));
   		user.setUser_passwd(request.getParameter("user_passwd"));
   		user.setUser_name(request.getParameter("user_name"));
   		user.setUser_address(request.getParameter("user_address"));
   		user.setUser_phone(request.getParameter("user_phone"));
   		user.setUser_email(request.getParameter("user_email"));

		if (id != null){
			forward = new ActionForward();
			session.setAttribute("sId", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./mypage/user_info.jsp");
		}
		if (id != null){
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./mypage/user_delete.jsp");
		}
		if (id != null){
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./mypage/my_page");
		}
		return forward;
	}
}
