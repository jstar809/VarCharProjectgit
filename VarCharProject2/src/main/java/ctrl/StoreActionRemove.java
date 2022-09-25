package ctrl;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.CarVO;

public class StoreActionRemove implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(); //찜을 세션정보로 저장할 예정
		System.out.println("세션에서 받아온 배열 값"+session.getAttribute("sdatas"));  
		ArrayList<CarVO> sdatas=(ArrayList<CarVO>)session.getAttribute("sdatas");
		
		// 이터레이터를 이용하여 특정 객체 삭제
		Iterator<CarVO> itr = sdatas.iterator(); 
		while (itr.hasNext()) {
			CarVO rdata = (CarVO)itr.next();
			String cnum1=request.getParameter("cnum");  // 삭제 버튼(x) 클릭시 받아오는 값
			String cnum2=Integer.toString(rdata.getCnum());	//세션에 저장 되어 있는 값
		//	System.out.println("cnum1"+cnum1);
		//	System.out.println("cnum2"+cnum2);
			System.out.println(cnum1.equals(cnum2));
			if (cnum1.equals(cnum2)) {                
				itr.remove(); 
				//System.out.println("삭제 성공");
				
				}else{
				//	System.out.println("삭제 실폐");
					
				}
			}
		System.out.println("세션세팅 전에 확인(리무브 ver) sdatas"+sdatas);
		session.setAttribute("sdatas", sdatas);
		ActionForward forward=new ActionForward();
		forward.setPath("filterSearch.do");
		forward.setRedirect(false);		
		return forward;
	}

}
