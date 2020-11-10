package com.account.sorry.controller.api;

import com.account.sorry.model.AccountType;
import com.account.sorry.model.vo.AccountVO;
import com.account.sorry.service.AccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountApiController.class)
class AccountApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountService accountService;


    AccountVO firstAccount;
    AccountVO secondAccount;

    @Before
    public void 가계부_기본_셋업(){
        firstAccount  = new AccountVO().builder()
                                        .title("중식")
                                        .payDate(LocalDateTime.now().minusDays(1L))
                                        .price(3_000L)
                                        .consumerType(AccountType.consume)
                                        .build();

        secondAccount = new AccountVO().builder()
                                        .title("중식")
                                        .payDate(LocalDateTime.now().minusDays(1L))
                                        .price(3_000L)
                                        .consumerType(AccountType.consume)
                                        .build();

    }

    @Test
    public void 가계부_전체_조회() throws Exception{
       //given
       when(accountService.findAll(any())).thenReturn(Arrays.asList(
               firstAccount,secondAccount
       ));

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account")
                                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].title",is("중식")))
                .andExpect(jsonPath("$[0].price",is(3_000L)))
                .andExpect(jsonPath("$[0].consumerType", is(AccountType.consume.getValue())));
        //then
    }

    @Test
    public void request_contentType_not_json() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account"))
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void response_contentType_not_json() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


}