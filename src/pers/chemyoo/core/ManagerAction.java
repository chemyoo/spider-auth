package pers.chemyoo.core;

import java.util.Map;

import pers.chemyoo.utils.Utils;

public class ManagerAction implements IAction {

	@Override
	public String doAction(Map<String, String> params) {
		if(!Utils.checkNotNull(params, Message.USER, Message.PASS)) {
			return Message.NOT_EMPTY;
		}
		if(!Utils.checkPermission(params.get(Message.ADMIN))) {
			return Message.NO_RIGHT;
		}
		if(Utils.createDir(params.get(Message.USER), params.get(Message.PASS))) {
			return Message.SUCCESS;
		} 
		return Message.FAILURE;
	}

}
