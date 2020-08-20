package com.demo.test.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName(value = "mp_user") // 直接指定数据库表名
@ToString
//@Api(value = "用户表Api文档")
public class User {

    @TableId(value = "user_id")
//    @NotNull(message = "用户ID必填！")
//    @ApiModelProperty(value = "用户ID", required = true)
    private Long id;

    @TableField("user_name")
//    @ApiModelProperty(value = "用户名")
    private String name;

//    @ApiModelProperty(value = "用户age")
    private Integer age;

//    @ApiModelProperty(value = "用户email")
    private String email;

    @TableField("create_time")
    private Date date;

    /**
     * 字段不参与mp对应关系
     * 1.transient 不参与序列化
     * 2.static 需要新加静态getter setter方法
     * 3.@TableField(exist = false) 表示不是数据库中表的字段
     */
    @TableField(exist = false)
//    @ApiModelProperty(value = "临时属性，不对应数据库字段")
    private String tempField;

}
