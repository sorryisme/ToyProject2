package com.account.sorry.controller.api;

import com.account.sorry.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@WebMvcTest(AccountApiController.class)
class AccountApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

}