package com.example.digishop.base.converter;

import com.example.digishop.base.domain.dto.DictDto;
import com.example.digishop.base.domain.entity.Dict;
import com.example.digishop.base.domain.vo.DictVo;
import com.example.digishop.core.base.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * DictConverter
 *
 * @author SunTao
 * @since 2022-09-21
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictConverter extends BaseConverter<Dict, DictDto, DictVo> {

}