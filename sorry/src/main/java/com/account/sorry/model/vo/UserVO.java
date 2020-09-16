package com.account.sorry.model.vo;

import com.account.sorry.model.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserVO {

    private Long id;
    private String userId;
    private String userPwd;

    @Builder
    public UserVO(Long id, String userId, String userPwd){
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .id(this.id)
                .userId(this.userId)
                .userPwd(this.userPwd)
                .build();
    }

}
