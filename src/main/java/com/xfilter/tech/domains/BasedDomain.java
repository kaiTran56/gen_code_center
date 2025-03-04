package com.xfilter.tech.domains;

import com.xfilter.tech.constants.CommonFunction;
import com.xfilter.tech.constants.CommonConstant;
import com.xfilter.tech.enums.CommonActCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public abstract class BasedDomain<T> {
    private String uuid = CommonFunction.getUUID();
    private Date createdDate = new Date();
    private Date updatedDate = new Date();
    private String createdUser = CommonConstant.APP_CODE;
    private String updatedUser = CommonConstant.APP_CODE;
    private String actionCode = CommonActCode.CALL_HELLO_WORLD.getCode();
    private String actionResult = CommonActCode.CALL_REQUEST_SUCCESS.getCode();
    private String appCode = CommonConstant.APP_CODE;
}
