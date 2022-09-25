package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action	{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String naver=(String)session.getAttribute("naver");
		// 로그 아웃 할떄 네이버로 로그인 했는지 구분하기위해 사용
		// 세션을 저장한곳은 naver로그인 액션에 있음 
		
		if(naver.equals("naver")) {
			
		}
		//System.out.println(session.getAttribute("naver"));
		
		// session.invalidate();
		session.removeAttribute("mid");
		
		forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}
	
}
