package com.null01.mapper;

import com.null01.model.TableInfo;

import java.util.List;

/**
 * 表结构转换为实体信息
 * Created by Roxy on 2019/7/21.
 */
public interface EntityConvertor {

    List<TableInfo> metadataToEntity(List<TableInfo> tableList);
}
