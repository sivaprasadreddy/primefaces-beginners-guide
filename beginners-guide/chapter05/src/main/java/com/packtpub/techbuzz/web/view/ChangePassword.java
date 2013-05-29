package com.packtpub.techbuzz.web.view;

/**
 * @author Siva
 *
 */
public class ChangePassword 
{

	private String currentPwd;
	private String newPwd;
	private String confPwd;
	
	public String getCurrentPwd() {
		return currentPwd;
	}
	public void setCurrentPwd(String currentPwd) {
		this.currentPwd = currentPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfPwd() {
		return confPwd;
	}
	public void setConfPwd(String confPwd) {
		this.confPwd = confPwd;
	}
}
