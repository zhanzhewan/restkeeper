package com.restkeeper.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 运营端管理员
 * </p>
 */
@Data
@Accessors(chain = true)
@TableName("t_operator_user")
@ApiModel(value="OperatorUser对象", description="运营端管理员信息")
public class OperatorUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(type = IdType.ASSIGN_ID)
    private String uid;

    @ApiModelProperty(value = "登录账号")
    @TableField(value = "loginname") //自动映射：1）字段与属性名称相同 2）login_name -> loginName
    private String loginname;

    @ApiModelProperty(value = "登录密码")
    @TableField(value = "loginpass")
    @JsonIgnore  // 这个注解就是不把这个字段返回
    private String loginpass;


}
