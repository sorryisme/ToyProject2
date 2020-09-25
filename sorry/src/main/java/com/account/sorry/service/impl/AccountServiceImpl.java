package com.account.sorry.service.impl;

import com.account.sorry.model.entity.AccountEntity;
import com.account.sorry.model.vo.AccountVO;
import com.account.sorry.repository.AccountRepository;
import com.account.sorry.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountVO saveAccount(AccountVO accountVO) throws Exception {
        AccountEntity savedAccount = accountRepository.save(accountVO.toEntity());
        return savedAccount.toAccountVO();
    }
}
