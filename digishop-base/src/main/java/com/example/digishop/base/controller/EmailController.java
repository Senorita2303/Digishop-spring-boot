package com.example.digishop.base.controller;

import com.example.digishop.base.util.Constants;
import com.example.digishop.cache.util.GlobalCacheHelper;
import com.example.digishop.core.annotation.ApiVersion;
import com.example.digishop.core.annotation.Router;
import com.example.digishop.core.base.BaseConst;
import com.example.digishop.core.model.Result;
import com.example.digishop.notify.mail.MailReceiver;
import com.example.digishop.notify.mail.MailService;
import com.example.digishop.util.Assert;
import com.example.digishop.util.RegexUtils;
import com.example.digishop.util.StringUtils;
import com.example.digishop.util.UuidUtils;
import com.example.digishop.util.math.RandomUtils;
import com.example.digishop.util.time.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 邮箱管理
 *
 * @author SunTao
 * @since 2022-08-03
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
@Api(value = "EmailController", tags = { "邮箱控制器" })
public class EmailController {
    private final MailService mailService;

    private final TemplateEngine templateEngine;

    /**
     * 发送邮箱验证码
     *
     * @param email 对方邮箱
     * @return 验证码缓存key
     */
    @PostMapping("sendCode")
    @ApiOperation(value = "发送邮箱验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "email", value = "邮箱地址", required = true, dataTypeClass = String.class)
    })
    @ApiVersion(group = { BaseConst.ApiVersion.V_4_0_0 })
    @Router(name = "发送邮箱验证码", code = "sendCode", level = BaseConst.PermLevel.OPEN)
    public Result sendCode(@RequestParam String email) {
        Assert.isTrue(StringUtils.isBlank(email), "邮箱不能为空");
        Assert.isTrue(!RegexUtils.match(email, RegexUtils.Const.EMAIL_REGEX), "邮箱格式不正确");

        // 获取邮件内容
        String random = RandomUtils.sixCode();
        Context ctx = new Context();
        ctx.setVariable("code", random);
        ctx.setVariable("year", DateUtils.formatNow("yyyy"));
        String emailContext = templateEngine.process("sendMailCode", ctx);
        MailReceiver receiver = MailReceiver.setReceive(email);
        mailService.sendHtmlMail(receiver, BaseConst.SYS_NAME, emailContext);

        // 缓存验证码
        Constants.CacheKey emailCode = Constants.CacheKey.emailCode;
        String uuid = emailCode.cacheKey().concat(":").concat(email).concat(":").concat(UuidUtils.generateShortUuid());
        GlobalCacheHelper.put(uuid, random, emailCode.duration());
        return Result.success("发送成功").data(uuid);
    }
}