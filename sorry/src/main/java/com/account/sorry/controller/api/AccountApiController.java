package com.account.sorry.controller.api;

import com.account.sorry.model.vo.AccountVO;


import com.account.sorry.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AccountApiController {

    private final AccountService accountService;


    @GetMapping("/account")
    public ResponseEntity<List<AccountVO>> findAllAccount() throws Exception{
        List<AccountVO> accountVOList = accountService.findAll(new AccountVO());
        return ResponseEntity.status(HttpStatus.OK).body(accountVOList);
    }

    @GetMapping("/accounts/search")
    public ResponseEntity<List<AccountVO>> findByPayDateBetween(@RequestParam("beforeDate") String beforeDate, @RequestParam("afterDate") String afterDate) throws Exception {

        LocalDate parseBeforeDate = LocalDate.parse(beforeDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate parseAfterDate = LocalDate.parse(beforeDate, DateTimeFormatter.ISO_LOCAL_DATE);

        List<AccountVO> accountVOList = accountService.findByPayDateBetween(parseBeforeDate, parseAfterDate);
        return ResponseEntity.status(HttpStatus.OK).body(accountVOList);
    }


    @PostMapping("/account")
    public ResponseEntity<AccountVO> saveAccount(@RequestBody List<AccountVO> accountVOList) throws Exception{
            accountVOList.forEach( accountVO -> {
                try {
                    accountService.saveAccount(accountVO);
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        return ResponseEntity.status(HttpStatus.CREATED).body(new AccountVO());
    }





}
