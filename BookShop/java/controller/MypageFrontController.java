package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import action.*;
import action.Action;
import vo.*;

@WebServlet("*.me")
public class MypageFrontController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String  RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/loginForm.me")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/loginForm.jsp");
		}else if(command.equals("./member_join.me")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member_join.jsp");
		// 로그인이 되었다면..마이페이지
		}else if(command.equals("/MypageAction.me")){
			action = new MypageAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
				  e.printStackTrace();
				}
		}else if(command.equals("/MemberInfoAction.me")){
			action = new MemberInfoAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/MemberUpdateAction.me")){
			action = new MemberUpdateAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/MemberdeleteAcrion.bo")){
			action = new MemberDeleteAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		// 상품페이지 조회		
		}else if(command.equals("/OrderLookupAction.me")){
			action = new OrderLookupAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/OrderCancelAction.me")){
			action = new OrderCancelAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		} else if(command.equals("/OrderInfo.me")){
			action = new OrderInquiryAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
	    } else if(command.equals("/OrderInquiry.me")){
			action = new OrderInquiryAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}

}
