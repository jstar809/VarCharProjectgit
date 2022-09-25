package board;

public class BoardVO {
	private int bnum;
	private String mid;
	private String mnickname;
	private String btitle;
	private String bcontent;
	private int bcnt; // 0825 더보기 cnt추가
	private String bdate;
	private String searchTitle;
	private int res;			// 게시글 삭제 여부 1이면 전부삭제 -1 이면 알수없음
//	private String searchTitle; // db와 연관없음.
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMnickname() {
		return mnickname;
	}
	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getSearchTitle() {
		return searchTitle;
	}
	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
	
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", mid=" + mid + ", mnickname=" + mnickname + ", btitle=" + btitle
				+ ", bcontent=" + bcontent + ", bcnt=" + bcnt + ", bdate=" + bdate + ", searchTitle=" + searchTitle
				+ ", res=" + res + "]";
	}
	
	
	}
	
	
	

