package pers.chemyoo.service;

import javax.servlet.annotation.WebServlet;

@WebServlet(displayName="用户管理", urlPatterns={"/delete"},loadOnStartup = 1,name="delete")
public class DeleteService extends BaseServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6601908099908164474L;

}
