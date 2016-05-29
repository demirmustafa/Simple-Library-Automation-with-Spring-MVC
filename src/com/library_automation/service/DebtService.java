package com.library_automation.service;

import com.library_automation.classes.Debt;
import com.library_automation.classes.User;

public interface DebtService {
	
	public void createDebt(User user);
	
	public Debt getMyTotalDebt(User user);
	
	public void setMyTotalDebt(Debt debt);

}
