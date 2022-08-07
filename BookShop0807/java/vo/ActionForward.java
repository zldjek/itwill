package vo;

public class ActionForward {
	// sendRedirect 또는 forward중 페이지 이동할지 결정
	private boolean isRedirect = false;
	// 이동할 페이지 경로값을 갖는 변수
	private String path = null;

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
