package com.example.test1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.test1.entity.User;
import com.example.test1.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public List<User> listAll() {
        return userMapper.selectList(null);
    }

    public User queryById(User user) {
        return userMapper.selectById(user.getId());
    }

    public List<User> queryByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name", name); //参数为表中的列名，要查询的条件 相当于 WHERE name LIKE	%name%
        return userMapper.selectList(userQueryWrapper);
    }


    //添加一条数据
    public int add(User user) {
        return userMapper.insert(user);
    }
    //添加多条数据
    public void add(List<User> users) {
        for (User user : users) {
            add(user);
        }
    }

    // 根据条件更新
    public void changeBy(User user, String column, Object val) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq(column, val);
        int num = userMapper.update(user, userQueryWrapper);
        System.out.println("影响行数：" + num);
    }

    // 通过ID修改信息
    public Integer changeUserById(User user) {
        return userMapper.updateById(user);
    }

    public int deleteById(User user) {
        return userMapper.deleteById(user.getId());
    }

}
