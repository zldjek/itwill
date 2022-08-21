package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserUpdateFormService;
import vo.ActionForward;
import vo.UserDTO;

public class UserUpdateFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();
		user.setUser_id(request.getParameter("user_id"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_passwd(request.getParameter("user_passwd"));
		user.setUser_address(request.getParameter("user_address"));
		user.setUser_phone(request.getParameter("user_phone"));
		user.setUser_email(request.getParameter("user_email"));

		UserUpdateFormService service = new UserUpdateFormService();
		boolean updateResult = service.updateUser(user);
		ActionForward forward = null;
		if (!updateResult) {
			forward = new ActionForward();
			session.setAttribute("id", user.getUser_id());
			forward.setRedirect(false);
			forward.setPath("./mypage/user_update.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('내정보 수정실패!');");
			out.println("location.href='/history.back();'");
			out.println("</script>");
		}
		return forward;
	}
}
