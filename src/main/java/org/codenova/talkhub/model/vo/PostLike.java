package org.codenova.talkhub.model.vo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostLike {
    private int id;
    private String userId;
    private int postId;
    private Date createdAt;

    /*
        lombok: Lombok은 반복적인 코드(Getter, Setter, toString 등)를 자동으로 생성해 주는 라이브러리입니다. 빌더 패턴, Null 체크 등 다양한 기능을 간단하게 구현할 수 있습니다.

     */


}
