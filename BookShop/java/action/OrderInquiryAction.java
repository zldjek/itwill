package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class OrderInquiryAction implements Action{
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
		
		 	OrderDTO order=new OrderDTO();
	   		boolean inquiryResult=false;
	   		
	   		order.setOrder_inquiry(request.getParameter("order_inquiry"));
	   		OrderInquiryService orderInquiryService = new OrderInquiryService();
	   		inquiryResult=orderInquiryService.inquiryOrder(order);
	   		
	   		ActionForward forward = null;
	   		if(inquiryResult==false){
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('상품질문 실패')");
	   			out.println("history.back()");
	   			out.println("</script>");
		   	}
	   		else{
	   	    forward = new ActionForward();
	   		forward.setRedirect(true);
	   		forward.setPath("/orderInquiry.bo");
	   		}
	   		return forward;
	   	
	   	
	 }	
}
