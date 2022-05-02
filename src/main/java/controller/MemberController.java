package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.AddService;
import service.ListService;
import service.MemberService;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청/응답 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// URLMapping
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
	
		// StduentService 인스턴스
		MemberService service = null;
		
		// ActionForward 인스턴스
		ActionForward af = null;
		
		switch(command) {
		// 단순 페이지 이동
		case "memberManage.do":
			af = new ActionForward("member/manage.jsp",false);
			break;
			
		// 서비스 실행
		case "add.do":
			service = new AddService();
			break;
		case "list.do":	// http://localhost:9090/AJAX/list.do -> 얘를 브라우저 주소창에 입력해서 결과를 간단하게 확인할 수 있다. or postman(?) 이라는 tool을 이용할 수도 있다.
			service = new ListService();
			break;
		}
		
		if(service!=null) {
			service.execute(request, response);
		}
		if(af!=null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		} // end of if
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
