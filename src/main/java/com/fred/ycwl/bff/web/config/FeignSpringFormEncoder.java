package com.fred.ycwl.bff.web.config;

import static java.util.Collections.singletonMap;

import java.lang.reflect.Type;

import org.springframework.web.multipart.MultipartFile;

import feign.RequestTemplate;
import feign.form.spring.SpringFormEncoder;
import lombok.val;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/13 13:57
 */
public class FeignSpringFormEncoder extends SpringFormEncoder {
    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) {
        if (!bodyType.equals(MultipartFile.class)) {
            super.encode(object, bodyType, template);
            return;
        }
        // Important:统一parameter中的参数名
        val data = singletonMap("file", object);
        super.encode(data, MAP_STRING_WILDCARD, template);
    }
}
