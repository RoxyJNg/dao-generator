package com.null01.generator;

import com.null01.dbmetadata.DbConnection;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * FreeMarker配置
 * Created by Roxy on 2019/7/21.
 */
@Component
public class FmConfiguration {
    @Value("${spring.freemarker.template-loader-path}")
    private String templatePath;

    @Value("${spring.freemarker.charset}")
    private String encoding;

    private static final Logger logger = LoggerFactory.getLogger(FmConfiguration.class);

    public Configuration getConf(){
        System.err.println(templatePath);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        try {
            Resource resource = new ClassPathResource(templatePath);
            File file = resource.getFile();
            cfg.setDirectoryForTemplateLoading(file);
            cfg.setDefaultEncoding(encoding);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        return cfg;
    }
}
