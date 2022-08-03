package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MemberInfoAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 	
				 	HttpSession session = request.getSession();
			   		String id = (String)session.getAttribute("member_id");
			   		
			   		ActionForward forward = null;
			   		
			   		if(id == null) {
			   			forward = new ActionForward();
						forward.setRedirect(true);
						forward.setPath("./loginFrom.me");
			   		}else { 
			   			forward = new ActionForward();
			   			String infoId = request.getParameter("member_id");
			   			MemberInfoService myInfoService = new MemberInfoService();
			   			MemberDTO memberInfo = myInfoService.getMemberInfo(infoId);
			   			request.setAttribute("memberInfo", memberInfo);
			   			forward.setPath("/member_info.jsp");
			   		}
			   		return forward;
			}
		}

