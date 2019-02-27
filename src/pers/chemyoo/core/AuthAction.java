package pers.chemyoo.core;

import java.util.Map;

import pers.chemyoo.utils.Utils;

public class AuthAction implements IAction {

	@Override
	public String doAction(Map<String, String> params) {
		if(Utils.exsits(params.get(Message.USER), params.get(Message.PASS))) {
			return Message.SUCCESS;
		} 
		return Message.USER_NOT_EXISTS;
	}

}
