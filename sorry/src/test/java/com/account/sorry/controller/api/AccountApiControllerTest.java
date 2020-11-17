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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        AccountVO firstAccount  = new AccountVO().builder()
                .title("중식")
                .payDate(LocalDateTime.now().minusDays(1L))
                .price(3_000L)
                .consumerType(AccountType.consume)
                .build();

        AccountVO secondAccount = new AccountVO().builder()
                .title("중식")
                .payDate(LocalDateTime.now().minusDays(1L))
                .price(3_000L)
                .consumerType(AccountType.consume)
                .build();

        //when
       when(accountService.findAll(any())).thenReturn(Arrays.asList(
               firstAccount,secondAccount
       ));

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account")
                                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].title",is("중식")))
                .andExpect(jsonPath("$[0].price",is(3000)))
                .andExpect(jsonPath("$[0].consumerType", is(AccountType.consume.getValue())));
    }


    @Test
    public void 가계부_날짜별_조회() throws Exception{
        //given
        AccountVO firstAccount  = new AccountVO().builder()
                .title("책구매")
                .payDate(LocalDateTime.now().minusDays(1L))
                .price(1_000L)
                .consumerType(AccountType.invest)
                .build();

        AccountVO secondAccount = new AccountVO().builder()
                .title("선물구매")
                .payDate(LocalDateTime.now().minusDays(10L))
                .price(4_000L)
                .consumerType(AccountType.consume)
                .build();



        //when
        when(accountService.findByPayDateBetween(any(),any()))
                            .thenReturn(Arrays.asList(firstAccount));

        //then
        LocalDate findBeforeDate = LocalDate.of(2020,11,10);
        LocalDate findAfterDate = LocalDate.of(2020,11,12);

        mockMvc.perform( MockMvcRequestBuilders.get("/api/v1/accounts/search")
                                                .param("beforeDate", findBeforeDate.toString())
                                                .param( "afterDate", findAfterDate.toString())
                                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title" , is("책구매")))
                .andExpect(jsonPath("$[0].price", is(1000)))
                .andExpect(jsonPath("$[0].consumerType",is(AccountType.invest.getValue())));
    }



    @Test
    public void request_ContentType이_JSON이_아닐경우() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account"))
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void request_accept_JSON_response가_JSON이_아닐경우() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void 가계부_수정() throws Exception {
        //given
        Long findId = 1L;
        AccountVO firstAccount  = new AccountVO().builder()
                                                .id(findId)
                                                .title("수정전_가계부")
                                                .payDate(LocalDateTime.now().minusDays(1L))
                                                .price(1_000L)
                                                .consumerType(AccountType.invest)
                                                .build();

        //when
        when(accountService.findById(any())).thenReturn(firstAccount);



    }


}