package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardVO;
import board.ReplyVO;
import member.MemberDAO;
import member.MemberVO;

public class DeleteMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		MemberDAO mdao = new MemberDAO();
		BoardDAO bdao = new BoardDAO();
		MemberVO mvo = new MemberVO();
		BoardVO bvo = new BoardVO();
		ReplyVO rvo = new ReplyVO();
		
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		bvo.setMid(request.getParameter("mid"));
		rvo.setMid(request.getParameter("mid"));
				if(mdao.delete(bvo, mvo)) {
				// delete 함수를 써야함 트랜잭션 & 회원 탈퇴시 선택할수있게끔
				HttpSession session = request.getSession();
				session.invalidate();
				forward = new ActionForward();
				forward.setPath("main.do");
				forward.setRedirect(true);
			} else {
			throw new Exception("탈퇴 실패");
		}
		// TODO Auto-generated method stub
		return forward;
	}
	
}
