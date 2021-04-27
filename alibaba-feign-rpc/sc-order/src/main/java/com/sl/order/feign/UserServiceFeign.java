package com.sl.order.feign;

import com.sl.common.model.UserModel;
import com.sl.framework.common.model.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-provider", fallback = UserServiceFeign.UserServiceFeignFallback.class)
public interface UserServiceFeign {

    @RequestMapping(value = "v1/user/{userId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    ApiResult<UserModel> getUserDetail(@PathVariable(value = "userId") Integer userId);

    @Component
    class UserServiceFeignFallback implements UserServiceFeign {
        @Override
        public ApiResult<UserModel> getUserDetail(Integer userId) {
            return new ApiResult().setCode(-1).setMessage("服务降级，该服务已下线");
        }
    }
}
