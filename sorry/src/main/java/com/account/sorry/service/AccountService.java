package com.account.sorry.service;

import com.account.sorry.model.vo.AccountVO;

import java.util.List;

public interface AccountService {

    AccountVO saveAccount(AccountVO accountVO) throws Exception;

    List<AccountVO> findAll(AccountVO accountVO) throws Exception;

}
