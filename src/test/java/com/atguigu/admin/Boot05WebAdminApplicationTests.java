package com.atguigu.admin;

import com.atguigu.admin.bean.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
//        log.info("记录总数：{}",aLong);

//                Object o = jdbcTemplate.queryForObject("select * from account_tbl where id = 1", Account.class);
//        System.out.println(o);

//        Account account = jdbcTemplate.queryForObject("select * from account_tbl where id = 1", Account.class);
//        System.out.println(account);

//        Integer integer = jdbcTemplate.queryForObject("select count(*) from account_tbl", Integer.class);
//        System.out.println(integer);

        Account account = jdbcTemplate.queryForObject("select * from account_tbl where id = 1",new BeanPropertyRowMapper<>(Account.class));
        System.out.println(account);


    }

}
