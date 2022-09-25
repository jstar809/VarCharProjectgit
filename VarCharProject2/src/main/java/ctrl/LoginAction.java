package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();
		
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		
		mvo = mdao.selectOne(mvo);
		if(mvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("uid", mvo.getMid());
		} else {
			System.out.println("로그 : 로그인 실패 !");
		}
		forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		// TODO Auto-generated method stub
		return forward;
	}
	
}
