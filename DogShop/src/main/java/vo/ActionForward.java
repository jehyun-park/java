package vo;

//������ �ϴµ� �ʿ��� ������ ����
public class ActionForward {
	private boolean redirect; // �� ���� false �� ����ġ������� ������, true�� �����̷�Ʈ������� ������
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