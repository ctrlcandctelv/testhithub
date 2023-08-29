package com.example.test1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "User")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String name;
    private String sex;
    private String pwd;
    private String email;

}
