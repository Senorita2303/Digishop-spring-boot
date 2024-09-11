package com.example.digishop.base.mapper;

import com.example.digishop.base.domain.dto.query.NodeQueryDto;
import com.example.digishop.base.domain.entity.ServerNode;
import com.example.digishop.base.domain.vo.NodeVo;
import com.example.digishop.core.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 节点管理数据持久层
 *
 * @author SunTao
 * @since 2022-11-09
 */
public interface ServerNodeMapper extends BaseMapper<ServerNode> {
    /**
     * 查询节点列表
     *
     * @param queryDto 查询参数
     * @return nodeList
     */
    List<NodeVo> selectNodeList(NodeQueryDto queryDto);

    /**
     * 查询节点详情
     *
     * @param nodeId 节点序列
     * @return NodeVo
     */
    NodeVo selectNodeDetail(@Param("nodeId") Long nodeId);

    /**
     * 根据IP和用户查询节点信息
     *
     * @param ip IP地址
     * @param sshUser 用户信息
     * @return ServerNode
     */
    ServerNode selectByHostAndUser(@Param("ip") String ip, @Param("sshUser") String sshUser);
}