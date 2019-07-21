package com.null01.generator;

import com.null01.model.TableInfo;
import com.null01.util.IOUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Writer;

/**
 * 生成类文件
 * Created by Roxy on 2019/7/21.
 */
@Component
public class EntityGenerator {
    @Value("${generating.path}")
    private String generatingPath;

    private static final Logger logger = LoggerFactory.getLogger(EntityGenerator.class);
    /**
     * 生成实体类文件
     */
    public void entityGenerate(TableInfo tableInfo) throws Exception{
        Writer out = null;
        try{
            Configuration cfg = FmConfiguration.getInstance().getConf();
            Template template = cfg.getTemplate("entity.ftl");
            out = IOUtil.getInstance().getBufferedWriter(generatingPath);
            template.process(tableInfo, out);
            out.flush();
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }
}
