package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class InsertMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		mvo.setMname(request.getParameter("mname"));
		mvo.setMnickname(request.getParameter("mnickname"));
		mvo.setMadd(request.getParameter("madd"));
		mvo.setMemail(request.getParameter("memail"));
		mvo.setMphone(request.getParameter("mphone"));
		mvo.setRole(request.getParameter("role"));
		if(mdao.insert(mvo)) {
		forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		} else {
			throw new Exception("insertM 오류");
		}
		// TODO Auto-generated method stub
		return forward;
	}
	
}
