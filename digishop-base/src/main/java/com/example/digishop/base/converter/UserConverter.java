package com.example.digishop.base.converter;

import com.example.digishop.base.domain.dto.UserDto;
import com.example.digishop.base.domain.entity.User;
import com.example.digishop.base.domain.vo.UserVo;
import com.example.digishop.core.base.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * UserConverter
 *
 * @author SunTao
 * @since 2022-06-29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter extends BaseConverter<User, UserDto, UserVo> {

}