package com.fred.ycwl.bff.web.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fred.ycwl.bff.web.client.FileUploadClient.MultipartSupportConfig;
import com.fred.ycwl.bff.web.config.FeignSpringFormEncoder;
import com.fred.ycwl.common.web.Response;

import feign.codec.Encoder;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/6 14:10
 */
@FeignClient(value = "ycwl-file", configuration = MultipartSupportConfig.class, url = "http://localhost:8901")
public interface FileUploadClient {

    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<Map<String, Object>> upload(@RequestPart("file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {

        @Bean
        public Encoder feignFormEncoder() {
            return new FeignSpringFormEncoder();
        }
    }
}
