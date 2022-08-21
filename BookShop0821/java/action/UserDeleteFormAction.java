package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserDeleteFormService;
import vo.ActionForward;
import vo.UserDTO;

public class UserDeleteFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserDeleteFormAction");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = null;
		UserDTO deleteId = new UserDTO();
		deleteId.setUser_id(request.getParameter("user_id"));
		UserDeleteFormService service = new UserDeleteFormService();
		boolean deleteResult = service.deleteUser(deleteId);

		if (deleteResult) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./mypage/user_delete.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보삭제 실패.');");
			out.println("location.href='/#';");
			out.println("</script>");
		}
		return forward;
	}
}
