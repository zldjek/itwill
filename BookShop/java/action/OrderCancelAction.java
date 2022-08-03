package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class OrderCancelAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		HttpSession session=request.getSession();
		String num=(String)session.getAttribute("num");

		ActionForward forward = null;
		if(num==null){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/orderCancek.bo");
		}else if(!num.equals("admin")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('주문상품이없습니다.');");
			out.println("location.href='/orderLookup.bo';");
			out.println("</script>");
		}
		else{
			String CancelNum=request.getParameter("num");
			OrderCancelService orderCancelService = new OrderCancelService();
			boolean CancelResult = orderCancelService.CancelOrder(CancelNum);

			if(CancelResult){
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./orderCancelAction.bo");
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('주문상품 삭제실패.');");
				out.println("location.href='/orderCancel.me';");
				out.println("</script>");
			}
		}
		return forward;
	}
}
