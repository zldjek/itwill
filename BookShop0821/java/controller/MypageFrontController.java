package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.MypageAction;
import action.UserLoginProAction;
import action.UserDeleteFormAction;
import action.UserInfoProAction;
import action.UserUpdateFormAction;
import action.UserUpdateViewAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MypageFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess 호출");
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath();
		System.out.println("command  : " + command);
		ActionForward forward = null;
		Action action = null;
		// 로그인
		if (command.equals("/UserLoginForm.me")) {
			System.out.println("UserLoginForm.me 실행" );
			forward = new ActionForward();
			forward.setPath("./mypage/user_login.jsp");
			forward.setRedirect(true);
		} else if(command.equals("/UserLoginPro.me")) {
			System.out.println("UserLoginPro.me 실행");
			action = new UserLoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MypageAction.me")) {
			System.out.println("MypageAction.me 실행");
			action = new MypageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} else if (command.equals("/UserInfoPro.me")) {
			System.out.println("/UserInfoPro.me 실행");
			action = new MypageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if (command.equals("/UserUpdateForm.me")) {
				System.out.println("UserUdateForm.me 실행" );
				action = new UserUpdateFormAction();
			 try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} else if (command.equals("/UserUpdateView.me")) {
				System.out.println("/UserUpdateView.me 실행");
				action = new UserUpdateViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/UserDeleteForm.me")) {
				System.out.println("UserDeleteForm.me 실행");
				action = new UserDeleteFormAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
		
				}
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
