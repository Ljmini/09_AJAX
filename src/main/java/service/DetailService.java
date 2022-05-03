package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import domain.MemberDTO;
import repository.MemberDAO;

public class DetailService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 파라미터로 넘어오는 no처리
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		long no = Long.parseLong(optNo.orElse("0"));

		// 응답 데이터 형식
		// JSON
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답데이터 예시
		/*
		 (1)
		 {
		 	"no" : 1,
		 	"id" : "user1",
		 	"name" : "사용자1",
		 	"gender" : "female",
		 	"address" : "서울시 금천구"
		 }
		 
		 (2) 객체 안에 result, member 객체
		 2-1. 조회가 되었을 때!
		 
		 {
		 	"result" : true,
		 	"member" : {
		 		"no" : 1,
			 	"id" : "user1",
			 	"name" : "사용자1",
			 	"gender" : "female",
			 	"address" : "서울시 금천구"
		 	}
		 }
		 
		  2-2. 조회되지 않았을 때!
		  {
		  	"result" : false
		  }
		*/
		

		// (1)
		/*
		 * JSONObject obj = new
		 * JSONObject(MemberDAO.getInstance().selectMemberByNo(no));
		 * 
		 * // 응답하기 PrintWriter out = response.getWriter(); out.write(obj.toString());
		 * out.flush(); out.close();
		 */
		
		
		// (2)
		MemberDTO member = MemberDAO.getInstance().selectMemberByNo(no);
		boolean result = (member!=null);		// null이 아니면 true, null 이면 false가 들어간다.
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		obj.put("member", member==null? null : new JSONObject(member));
		
		PrintWriter out = response.getWriter(); 
		out.write(obj.toString());
		out.flush(); 
		out.close();
		
	}

}
