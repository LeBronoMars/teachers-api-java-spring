package com.sanmateo.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by rsbulanon on 4/14/17.
 */
@Data
public class AppUserLoginDto {

    @ApiModelProperty(example = "nedflanders")
    private String username;

    @ApiModelProperty(example = "P@ssw0rd")
    private String password;
}
