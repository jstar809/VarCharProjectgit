package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class CheckIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		
		mvo.setMid(request.getParameter("mid"));
		
		if(mdao.selectAll(mvo) != null) {
			forward = new ActionForward();
			forward.setPath("main.do"); //중복확인이니까 main으로 가는건 아님! 수정해야 함 
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
