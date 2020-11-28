package com.qingchi.base.platform.qq;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author qinkaiyuan
 * @date 2019-10-24 16:25
 */
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JacksonXmlRootElement(localName = "xml")
public class QQPayResult {
    private String return_code;
    private String return_msg;
    private String retcode;
    private String retmsg;
    private String appid;
    private String mch_id;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String nonce_str;
    private String trade_type;
    private String prepay_id;
    private String code_url;

    public boolean hasError() {
        return "FAIL".equals(return_code);
    }
}
