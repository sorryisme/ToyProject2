package com.account.sorry.repository;


import com.account.sorry.model.Entity.UserEntity;
import com.account.sorry.model.VO.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest  {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void 회원가입(){
        //given
        String userId = "sorryisme";
        String userPwd = "rlawltjd39!";
        UserVO saveUserVO = UserVO.builder()
                                    .id(null)
                                    .userId(userId)
                                    .userPwd(userPwd)
                                    .build();

        UserEntity saveUserEntity = saveUserVO.toEntity();

        //when
        UserEntity savedUser =userRepository.save(saveUserEntity);

        //then
        Assertions.assertThat(savedUser.getId()).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isEqualTo(userId);
        Assertions.assertThat(savedUser.getUserPwd()).isEqualTo(userPwd);
    }
}
