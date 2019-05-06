package com.fred.ycwl.bff.web.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fred.ycwl.bff.web.client.FileUploadClient.MultipartSupportConfig;
import com.fred.ycwl.common.web.Response;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/6 14:10
 */
@FeignClient(value = "ycwl-file", configuration = MultipartSupportConfig.class)
public interface FileUploadClient {

    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<Map<String, Object>> upload(@RequestPart("file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        private static final List<HttpMessageConverter<?>> converters = new RestTemplate().getMessageConverters();

        private static final ObjectFactory<HttpMessageConverters> factory =
                () -> new HttpMessageConverters(MultipartSupportConfig.converters);

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(factory));
        }
    }
}
