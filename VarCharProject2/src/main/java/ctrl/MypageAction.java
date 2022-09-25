package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class MypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		// 로그인한 사용자 정보를 전부 가져와야하기 때문에 id값을 세션에서 가져온다.
		HttpSession session = request.getSession();
		mvo.setMid((String)session.getAttribute("userId"));
		//		mvo.setMid(request.getParameter("mid"));
		//		mvo.setMname(request.getParameter("mname"));

		// 아무 입력하지 않았을 때 기존의 값을 넣어 변경하지 않는다.
		mvo = mdao.selectOne_M(mvo);

		// id,pw로 받아온 값으로 사용자 한명의 모든 데이터를 가져온다.
		String changeMnickname = request.getParameter("changeMnickname");
		String changeMpw = request.getParameter("changeMpw");
		String changeMphone = request.getParameter("changeMphone");
		String changeMadd = request.getParameter("changeMadd");
		String changeMemail = request.getParameter("changeMemail");

		// 닉네임 변경 부분
			mvo.setMnickname(changeMnickname);
		// 비밀번호 변경 부분
			mvo.setMpw(changeMpw);
		// 전화번호 변경 부분
			mvo.setMphone(changeMphone);
		// 주소 변경 부분
			mvo.setMadd(changeMadd);
		// 이메일 변경 부분
			mvo.setMemail(changeMemail);

		// 회원 정보 변경
		if(mdao.update(mvo)) {
			forward=new ActionForward();
			forward.setPath("mypage.do"); // 마이페이지, 메인 중 이동할 페이지 선택
			forward.setRedirect(true);
		}
		return forward;

	}

}