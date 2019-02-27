package pers.chemyoo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.chemyoo.core.ActionEnum;
import pers.chemyoo.core.Charset;
import pers.chemyoo.core.IAction;

/** 
 * @author Author : jianqing.liu
 * @version version : created time：2018年9月27日 下午5:46:14 
 * @since since from 2018年9月27日 下午5:46:14 to now.
 * @description class description
 */
public abstract class BaseServlet extends HttpServlet {
	
	private static Logger log = Logger.getGlobal();

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5341216471522033720L;
	
	public void process(HttpServletRequest req, HttpServletResponse resp, IAction action) throws IOException {
		String charset = Charset.UTF_8.getCharset();
		req.setCharacterEncoding(charset);//加这句是为了适应POST请求乱码...
		resp.setCharacterEncoding(charset);    
		resp.setContentType("application/json; charset=" + charset);
		resp.getWriter().write(action.doAction(getParams(req)));
		log.info("FINESHED");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("POST START");
		this.doGet(req, resp);
		log.info("POST END");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("GET START");
		String type = req.getServletPath();
		if(type != null)
			this.process(req, resp, getAction(type.replace("/", "")));
		log.info("GET END");
	}
	
	public IAction getAction(String type) {
		return ActionEnum.valueOf(type.toUpperCase()).getAction();
	}
	
	public Map<String, String> getParams(HttpServletRequest req){
		Map<String, String> params = new HashMap<>();
		for(Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
			String[] values = entry.getValue();
			if(values != null && values.length > 0) {
				params.put(entry.getKey().toLowerCase(), values[0]);
			} else {
				params.put(entry.getKey().toLowerCase(), null);
			}
		}
		return params;
	}
	
}
