package com.account.sorry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {

   @PostMapping("/account/save")
   @ResponseBody
   public Map<String,Object> saveAccount(){
       return new HashMap<String, Object>();
   }
}
