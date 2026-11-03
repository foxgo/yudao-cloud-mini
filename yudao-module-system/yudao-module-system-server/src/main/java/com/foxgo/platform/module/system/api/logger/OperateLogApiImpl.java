package com.foxgo.platform.module.system.api.logger;

import com.foxgo.platform.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import com.foxgo.platform.framework.common.pojo.CommonResult;
import com.foxgo.platform.framework.common.pojo.PageResult;
import com.foxgo.platform.framework.common.util.object.BeanUtils;
import com.foxgo.platform.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.foxgo.platform.module.system.api.logger.dto.OperateLogRespDTO;
import com.foxgo.platform.module.system.dal.dataobject.logger.OperateLogDO;
import com.foxgo.platform.module.system.service.logger.OperateLogService;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.foxgo.platform.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
@Primary // 由于 OperateLogCommonApi 的存在，必须声明为 @Primary Bean
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public CommonResult<Boolean> createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
        return success(true);
    }

    @Override
    public CommonResult<PageResult<OperateLogRespDTO>> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return success(BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class));
    }

}
