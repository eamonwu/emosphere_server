package com.emosphere.emosphere.domain;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserLoginParam {
    @Length(min = 11,max = 11,message = "非法手机号码")
    String phone;
    @NotBlank(message = "密码不能为空")
    String pwd;
}
