package pers.chemyoo.core;

import javax.el.MethodNotFoundException;

public enum ActionEnum {
	AUTH{
		public IAction getAction() {
			return new AuthAction();
		}
	},DELETE{
		public IAction getAction() {
			return new DeleteAction();
		}
	},MANAGER{
		public IAction getAction() {
			return new ManagerAction();
		}
	};
	
	
	public IAction getAction() {
		throw new MethodNotFoundException();
	}
}
