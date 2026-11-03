package com.foxgo.platform.module.system.dal.mysql.notice;

import com.foxgo.platform.framework.common.pojo.PageResult;
import com.foxgo.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.foxgo.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.foxgo.platform.module.system.controller.admin.notice.vo.NoticePageReqVO;
import com.foxgo.platform.module.system.dal.dataobject.notice.NoticeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper extends BaseMapperX<NoticeDO> {

    default PageResult<NoticeDO> selectPage(NoticePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NoticeDO>()
                .likeIfPresent(NoticeDO::getTitle, reqVO.getTitle())
                .eqIfPresent(NoticeDO::getStatus, reqVO.getStatus())
                .orderByDesc(NoticeDO::getId));
    }

}
