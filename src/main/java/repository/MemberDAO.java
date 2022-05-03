package repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.MemberDTO;

public class MemberDAO {

	// singleton, factory 작업
	
	// 필드값
	private SqlSessionFactory factory;
	
	
	// 싱글톤 작업
	private static MemberDAO instance = new MemberDAO();
	
	// 생성자
	private MemberDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 메소드
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private final String MAPPER = "mybatis.mapper.member.";
	
	// 모든 메소드들은 factory로 부터 SqlSession을 얻는다!
	// SqlSession ss = facotry.openSession();
	// ss.select~~.. 등등
	// ss.close()
	
	
	// 1. member 추가
	public int insertMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);				// insert, delete, update문 돌릴 때 false 적어줘야한다!!!! (***)
		int res = ss.insert(MAPPER + "insertMember", member);
		if(res > 0) {
			ss.commit();
		}
		ss.close();
		
		return res;
	}
	
	// 2. member 조회 (1)
	public List<MemberDTO> selectMemberList(){
		SqlSession ss = factory.openSession();
		List<MemberDTO> members = ss.selectList(MAPPER + "selectMemberList");
		ss.close();
		
		return members;
	}
	
	// 3. member 수 조회
	public int getMemeberCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(MAPPER + "getMemeberCount");
		ss.close();
		
		return count;
	}
	
	// 4. member 조회 - map으로 (2) 
	public Map<String, Object> selectMembersMap(){
		SqlSession ss = factory.openSession();
		
		Map<String, Object> members = new HashMap<String, Object>();
		
		List<MemberDTO> memberList = ss.selectList(MAPPER + "selectMemberList");
		int count = ss.selectOne(MAPPER + "getMemeberCount");
		
		members.put("count", count);
		members.put("members", memberList);
		
		ss.close();
		
		return members;
	}
	
	// 5. 상세조회
	public MemberDTO selectMemberByNo(Long no) {
		SqlSession ss = factory.openSession();
		MemberDTO member = ss.selectOne(MAPPER +"selectMemberByNo", no);
		ss.close();
		
		return member;
	}
	
	// 6. 수정
	public int updateMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);				// insert, delete, update문 돌릴 때 false 적어줘야한다!!!! (***)
		int res = ss.update(MAPPER + "updateMember", member);
		if(res > 0) {
			ss.commit();
		}
		ss.close();
		
		return res;
	}
	
	// 7. 삭제
	public int deleteMember(Long no) {
		SqlSession ss = factory.openSession(false);				// insert, delete, update문 돌릴 때 false 적어줘야한다!!!! (***)
		int res = ss.delete(MAPPER + "deleteMember", no);
		if(res > 0) {
			ss.commit();
		}
		ss.close();
		
		return res;
	}

}
