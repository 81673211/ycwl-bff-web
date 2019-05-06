package com.fred.ycwl.bff.web.client.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fred.ycwl.bff.web.client.pet.PetCategoryClient;
import com.fred.ycwl.common.web.Response;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/5 16:57
 */
@Component
public class PetCategoryClientFallback implements PetCategoryClient {
    @Override
    public Response<List<Map<String, Object>>> list(String type) {
        System.out.println("------------");
        return null;
    }
}
