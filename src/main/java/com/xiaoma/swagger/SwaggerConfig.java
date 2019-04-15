package com.xiaoma.swagger;


import com.xiaoma.utils.MD5Util;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot 集成Swagger
 * @author mmh
 * @date 2017/8/24
 */

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "spring.swagger")
public class SwaggerConfig {

    private String request;

    private String title;

    private String description;

    private String terms;

    private String contact;

    private String version;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Bean
    public Docket createRestApi() {

        Long time = System.currentTimeMillis();
        ParameterBuilder timestampPar = new ParameterBuilder();
        timestampPar.name("Timestamp")
                .description("时间戳")
                .defaultValue(String.valueOf(time))
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();

        String key = "READER";
        ParameterBuilder signInfoPar = new ParameterBuilder();
        signInfoPar.name("SignInfo")
                .description("时间戳签名")
                .defaultValue(MD5Util.code(time + key))
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();

        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token")
                .description("登录标识")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        List<Parameter> aParameters = new ArrayList<Parameter>();
//        aParameters.add(versionPar.build());
//        aParameters.add(clientPar.build());
        aParameters.add(timestampPar.build());
        aParameters.add(signInfoPar.build());
        aParameters.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(aParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage(request))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API中文文档描述
     * @return api说明
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标题：阅读器-Restful风格-接口文档")
                .description("描述：广告主服务接口、媒体主服务接口、管理后台服务接口...")
                .termsOfServiceUrl(terms)
                .contact(new Contact("心向大海","https://blog.csdn.net/Mrmamenghui","xiaoma800820@sina.com"))
                .version("版本号：1.0.1")
                .build();
    }
}
