package com.example.digishop.base.converter;

import com.example.digishop.base.domain.dto.PermissionDto;
import com.example.digishop.base.domain.entity.Permission;
import com.example.digishop.base.domain.vo.PermissionVo;
import com.example.digishop.core.base.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * PermissionConverter
 *
 * @author SunTao
 * @since 2022-06-29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionConverter extends BaseConverter<Permission, PermissionDto, PermissionVo> {

}