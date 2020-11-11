package com.account.sorry.service.impl;

import com.account.sorry.model.entity.AccountEntity;
import com.account.sorry.model.vo.AccountVO;
import com.account.sorry.repository.AccountRepository;
import com.account.sorry.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AccountVO> findAll(AccountVO accountVO) throws Exception {
        List<AccountEntity> accountEntityList = accountRepository.findAll();
        return accountEntityList.stream().map(AccountEntity::toAccountVO).collect(Collectors.toList());
    }

    @Override
    public List<AccountVO> findByPayDateBetween(LocalDate beforeDate, LocalDate afterDate) {
        List<AccountEntity> accountEntityList = accountRepository.findByPayDateBetween(beforeDate,afterDate);
        return accountEntityList.stream().map(AccountEntity::toAccountVO).collect(Collectors.toList());
    }
}
