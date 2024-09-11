package com.example.digishop.base.mapper;

import com.example.digishop.base.domain.dto.query.VersionQueryDto;
import com.example.digishop.base.domain.entity.Version;
import com.example.digishop.core.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 版本维护持久层
 *
 * @author SunTao
 * @since 2022-10-14
 */
public interface VersionMapper extends BaseMapper<Version> {
    /**
     * 查询版本列表
     *
     * @param queryDto 查询参数
     * @return versionList
     */
    List<Version> selectVersionList(VersionQueryDto queryDto);

    /**
     * 查询版本信息
     *
     * @param versionName 版本名称
     * @return Version
     */
    Version selectByVersionName(@Param("versionName") String versionName);
}