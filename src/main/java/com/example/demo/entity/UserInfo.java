package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zp
 * @since 2019-12-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    @TableField("userName")
    private String userName;

    private String password;

    @TableField(exist = false)
    private String sessionId;

    @TableField(exist = false)
    private String token;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", sex=" + sex +
            ", userName=" + userName +
            ", password=" + password +
        "}";
    }
}
