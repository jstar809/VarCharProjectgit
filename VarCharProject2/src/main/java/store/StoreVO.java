package store;

//찜한 목록의 정보만 넣어논 VO version / id와 여기 목록 정보 담아논 배열은 storeset
public class StoreVO {
	private String cnum; //car 테이블의 pk값
	private String ctitle; //car 테이블의 제목
	private int cprice; //car 테이블의 가격
	private String cfuel; //car 테이블의 연료
	
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCfuel() {
		return cfuel;
	}
	public void setCfuel(String cfuel) {
		this.cfuel = cfuel;
	}
	@Override
	public String toString() {
		return "StoreVO [cnum=" + cnum + ", ctitle=" + ctitle + ", cprice=" + cprice + ", cfuel=" + cfuel + "]";
	}
	
}
