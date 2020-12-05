package com.github.DiamondPRO02.repository.user;

import com.github.DiamondPRO02.repository.Mapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return User.builder()
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .balance(resultSet.getInt("balance"))
                    .build();
        }

        return null;
    }
}
