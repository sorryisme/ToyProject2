package com.account.sorry.controller.api;

import com.account.sorry.model.vo.AccountVO;
import com.account.sorry.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountApiController.class)
class AccountApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountService accountService;




    @Test
    public void 가계부_전체_조회() throws Exception{
        //given
        //String mockAccount =

       // when(accountService.findAll(any())).thenReturn();

        //when

        //then

    }

}