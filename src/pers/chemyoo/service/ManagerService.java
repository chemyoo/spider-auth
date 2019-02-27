package pers.chemyoo.service;

import javax.servlet.annotation.WebServlet;

@WebServlet(displayName="用户管理", urlPatterns={"/manager"},loadOnStartup = 1,name="manager")
public class ManagerService extends BaseServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8656173116288917848L;

}
