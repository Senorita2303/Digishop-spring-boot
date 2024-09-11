package com.example.digishop.base.converter;

import com.example.digishop.base.domain.dto.NodeDto;
import com.example.digishop.base.domain.entity.ServerNode;
import com.example.digishop.base.domain.vo.NodeVo;
import com.example.digishop.core.base.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * ServerNodeConverter
 *
 * @author SunTao
 * @since 2022-11-09
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerNodeConverter extends BaseConverter<ServerNode, NodeDto, NodeVo> {

}