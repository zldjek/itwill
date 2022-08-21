package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserLoginProService;
import vo.ActionForward;
import vo.UserDTO;

public class UserLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserLoginAction 호출됨!");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
   		UserDTO user = new UserDTO();
   		user.setUser_id(request.getParameter("user_id"));
   		user.setUser_passwd(request.getParameter("user_passwd"));
		UserLoginProService service = new UserLoginProService();
		boolean isLoginSuccess = service.loginUser(user);
		ActionForward forward = null;

		if(isLoginSuccess) {
			session.setAttribute("sId", user.getUser_id());
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./mypage/my_page.jsp");
			System.out.println("forward" + forward);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alret('로그인실패');");
			out.println("location.href='histiory.back();'");
			out.println("</script>");
		}
		return forward;
	}

}
