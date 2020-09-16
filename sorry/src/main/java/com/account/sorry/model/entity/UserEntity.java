package com.account.sorry.model.entity;

import com.account.sorry.model.vo.UserVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPwd;

    @Builder
    public UserEntity(Long id, String userId, String userPwd){
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public UserVO toUserVO(){
        return UserVO.builder()
                .id(this.id)
                .userId(this.userId)
                .userPwd(this.userPwd)
                .build();
    }

}
