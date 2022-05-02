package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import domain.MemberDTO;
import repository.MemberDAO;

public class ListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 응답 데이터 형식
		// JSON
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 예시 -> json 라이브러리 사용해서 만들 것!
		/*
			[
				{
					"no" : 1,
					"id" : "user1",
					"name" : "사용자1",
					"gender" : "female",
					"address" : "서울시 금천구"
				},
				{
					"no" : 2,
					"id" : "user2",
					"name" : "사용자2",
					.
					.
				},
				....
		
		*/
		List<MemberDTO> members = MemberDAO.getInstance().selectMemberList();
		JSONArray arr = new JSONArray(members);
		
		// 응답하기
		PrintWriter out = response.getWriter();
		out.write(arr.toString());
		out.flush();
		out.close();
	}

}
