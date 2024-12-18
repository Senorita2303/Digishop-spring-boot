package com.example.digishop.base.controller;

import com.example.digishop.core.annotation.ApiVersion;
import com.example.digishop.core.annotation.Router;
import com.example.digishop.core.base.BaseConst;
import com.example.digishop.core.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 *
 * @author SunTao
 * @since 2022-10-19
 */
@RestController
@Api(value = "HealthCheckController", tags = { "健康检查控制器" })
public class HealthCheckController {
    /**
     * 健康检查
     *
     * @return Result.success
     */
    @GetMapping("/healthCheck")
    @ApiOperation(value = "健康检查", notes = "不需要token")
    @ApiVersion(group = { BaseConst.ApiVersion.V_4_0_0 })
    @Router(name = "健康检查", code = "healthCheck", level = BaseConst.PermLevel.OPEN)
    public Result healthCheck() {
        return Result.success();
    }
}