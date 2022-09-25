package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberVO;
import member.NaverDAO;

public class NaverLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();

		NaverDAO ndao=new NaverDAO();
		MemberVO mvo=new MemberVO();
		//System.out.println("1"+request.getParameter("mid"));
		
		mvo.setMid((String)request.getParameter("mid"));
		mvo.setMname((String)request.getParameter("mname"));
		mvo.setMnickname((String)request.getParameter("mnickname"));
		mvo.setMemail((String)request.getParameter("memail"));
		//회원가입과 동시에 로그인 
		if(ndao.insertMember(mvo)) {//회원 가입 
			System.out.println("로그:네이버 로그인 성공");
			forward.setPath("main.do");
			forward.setRedirect(false);//값을 전달해줘야 하므로 false
			//로그인
			HttpSession session=request.getSession();
			session.setAttribute("mid", mvo.getMid());
			//회원 닉네임이 필요할때 사용
			session.setAttribute("mnickname", mvo.getMnickname());
			//로그아웃할때 네이버인지 구분하기위해 세션을 사용
			session.setAttribute("naver", "naver");
			
		}else {// 실폐시 로그인 화면으로 이동(새로고침)
			System.out.println("로그:네이버 로그인 실폐");
			forward.setPath("login.jsp");
			forward.setRedirect(true);

		}
		
		return forward;
	}
	
}
