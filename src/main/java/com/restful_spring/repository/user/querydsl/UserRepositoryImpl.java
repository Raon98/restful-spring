package com.restful_spring.repository.user.querydsl;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restful_spring.dto.user.response.UserDto;
import com.restful_spring.entity.user.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl {
   private final JPAQueryFactory queryFactory;

   public UserDto findByName(String name){
       QUser user = QUser.user;

       return queryFactory.select(Projections.fields(UserDto.class,
                       user.id.as("id"),
                       user.name.as("name")
               ))
               .from(user)
               .where(user.name.eq(name))
               .fetchOne();
   }





}
