package com.library_automation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Debt;
import com.library_automation.classes.User;
import com.library_automation.dao.DebtsDAO;

@Service
public class DebtServiceImpl implements DebtService {
	
	@Autowired
	private DebtsDAO debtsDAO;

	@Override
	public void createDebt(User user) {
		// TODO Auto-generated method stub
		debtsDAO.createDebt(user.getId());

	}

	@Override
	public Debt getMyTotalDebt(User user) {
		// TODO Auto-generated method stub
		return debtsDAO.getMyTotalDebt(user.getId());
	}

	@Override
	public void setMyTotalDebt(Debt debt) {
		// TODO Auto-generated method stub
		debtsDAO.setMyTotalDebt(debt.getUser().getId(), debt.getTotal_debt());

	}

}
