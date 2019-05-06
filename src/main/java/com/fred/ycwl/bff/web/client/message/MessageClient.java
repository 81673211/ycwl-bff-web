package com.fred.ycwl.bff.web.client.message;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/6 09:42
 */
//@FeignClient(value = "ycwl-message-service")
public interface MessageClient {

//    @PostMapping("/sms/send")
    void send(String content, String template);
}
