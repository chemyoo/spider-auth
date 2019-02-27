package pers.chemyoo.core;

import java.util.Map;

import pers.chemyoo.utils.Utils;

public class DeleteAction implements IAction {
	
	@Override
	public String doAction(Map<String, String> params) {
		if(!Utils.checkNotNull(params, Message.USER)) {
			return Message.NOT_EMPTY;
		}
		if(!Utils.checkPermission(params.get(Message.ADMIN))) {
			return Message.NO_RIGHT;
		}
		if(Utils.deleteDir(params.get(Message.USER))) {
			return Message.SUCCESS;
		} 
		return Message.FAILURE;
	}

}
