package com.account.sorry.controller.api;

import com.account.sorry.model.vo.AccountVO;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/api/v1/account"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AccountApiController {


    @PostMapping("/save")
    public ResponseEntity<AccountVO> saveAccount(@RequestBody List<AccountVO> accountVO) {
        log.info(accountVO.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AccountVO());
    }

}
