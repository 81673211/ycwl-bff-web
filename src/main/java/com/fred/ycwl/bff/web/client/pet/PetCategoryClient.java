package com.fred.ycwl.bff.web.client.pet;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fred.ycwl.bff.web.client.fallback.PetCategoryClientFallback;
import com.fred.ycwl.common.web.Response;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/5 15:14
 */
@FeignClient(value = "ycwl-pet-server", fallback = PetCategoryClientFallback.class)
public interface PetCategoryClient {

    @GetMapping(value = "/pet/category/list")
    Response<List<Map<String, Object>>> list(@RequestParam("type") String type);
}
