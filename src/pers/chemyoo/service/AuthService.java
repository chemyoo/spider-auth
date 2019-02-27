package pers.chemyoo.service;

import javax.servlet.annotation.WebServlet;

@WebServlet(displayName="用户认证", urlPatterns={"/auth"},loadOnStartup = 1,name="auth")
public class AuthService extends BaseServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5741957572164620505L;

}
