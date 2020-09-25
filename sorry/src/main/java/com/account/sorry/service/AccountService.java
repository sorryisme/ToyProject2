package com.account.sorry.service;

import com.account.sorry.model.vo.AccountVO;

public interface AccountService {

    AccountVO saveAccount(AccountVO accountVO) throws Exception;
}
