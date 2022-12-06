package vo;

//포워딩 하는데 필요한 정보를 저장
public class ActionForward {
	private boolean redirect; // 이 값이 false 면 디스패치방식으로 포워딩, true면 리다이렉트방식으로 포워딩
	private String url; //
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}