package com.test.usercrud.repository;

import com.test.usercrud.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //예시. jpa의 경우에는, 비워있어도 잘 작동함. /hibernate 아니다.
    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
    // findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다
    //출처: https://goddaehee.tistory.com/209 [갓대희의 작은공간]

    public List<UserEntity> findById(String id);

    public List<UserEntity> findByName(String name);
    //like 키워드 검색 기능 추가.
    public List<UserEntity> findByNameLike(String keyword);

}
