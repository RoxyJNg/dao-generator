package com.null01.generator;

import com.null01.dbmetadata.DbConnection;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * FreeMarker配置
 * Created by Roxy on 2019/7/21.
 */
public class FmConfiguration {
    @Value("${spring.freemarker.template-loader-path}")
    private String templatePath;

    @Value("${spring.freemarker.charset}")
    private String encoding;

    private static final Logger logger = LoggerFactory.getLogger(FmConfiguration.class);

    private static FmConfiguration instance = new FmConfiguration();

    private FmConfiguration(){};

    public static FmConfiguration getInstance(){
        return instance;
    }

    public Configuration getConf(){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        try {
            cfg.setDirectoryForTemplateLoading(new java.io.File(templatePath));
            cfg.setDefaultEncoding(encoding);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        return cfg;
    }
}
