package com.noticeboard.user.service;

public class MenuVO {
	private String menuCode;
	private String menuName;
	private String upperMenuCode;
	private int menuLevel;
	private String menuUrl;
	private String useYesorno;
	private String displayYesorno;
	private int sortSequences;
	private boolean admin = false;
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUpperMenuCode() {
		return upperMenuCode;
	}
	public void setUpperMenuCode(String upperMenuCode) {
		this.upperMenuCode = upperMenuCode;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getUseYesorno() {
		return useYesorno;
	}
	public void setUseYesorno(String useYesorno) {
		this.useYesorno = useYesorno;
	}
	public String getDisplayYesorno() {
		return displayYesorno;
	}
	public void setDisplayYesorno(String displayYesorno) {
		this.displayYesorno = displayYesorno;
	}
	public int getSortSequences() {
		return sortSequences;
	}
	public void setSortSequences(int sortSequences) {
		this.sortSequences = sortSequences;
	}
}
