package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrl.ActionForward;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그");
		ActionForward forward=new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(true);		//보내주는 친구가 없어 일단 리다이렉트로 ㄱㄱ
		return forward;
				
	}
	
}
