package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.MypageService;
import vo.ActionForward;
import vo.UserDTO;

public class MypageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String)request.getAttribute("id");
		session.setAttribute("id", id);
		UserDTO dto = new UserDTO();
		dto.setUser_id(request.getParameter("user_id"));

		MypageService service = new MypageService();
		boolean idCheck = service.id(dto);
		if (!idCheck) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/UserInfo.me");
		}
		else if (!idCheck) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/UserUpdate.me");
		}
		else if (!idCheck) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/UserDelete.me");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mypage/user_login.jsp");
		}
		return forward;
	}
}
