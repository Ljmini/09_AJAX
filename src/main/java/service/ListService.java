package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import domain.MemberDTO;
import repository.MemberDAO;

public class ListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 응답 데이터 형식
		// JSON
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 예시 -> json 라이브러리 사용해서 만들 것!
		/* (1)
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
		
		/* (2)
		{
			"count" : 11,
			"members" : [
				{
					"no" : 1,
					"id": "user1",
					"name" : "사용자1",
					"gender" : "female",
					"address" : "서울시 금천구"
				},
				....
	
	*/
		
		
		
		// (1)
		/*List<MemberDTO> members = MemberDAO.getInstance().selectMemberList();
		JSONArray arr = new JSONArray(members);*/
		
		// (2)
		// DAO에서 Map 형식을 만들어서 보낼 수도 있지만
		// 여기서 DAO의 메소드 두개를 불러 결과값을 각각 JSONObject에 put할 수 있다.
		/* 내가 한 것!
		 * Map<String, Object> members = MemberDAO.getInstance().selectMembersMap();
		 * JSONObject obj = new JSONObject(members);
		 */
		
		// 선생님이 한 것!
		JSONObject obj = new JSONObject();
		obj.put("count", MemberDAO.getInstance().getMemeberCount());
		obj.put("members", MemberDAO.getInstance().selectMemberList());
		

	
		// 응답하기
		PrintWriter out = response.getWriter();
		//out.write(arr.toString());
		out.write(obj.toString());
		out.flush();
		out.close();
	}

}
