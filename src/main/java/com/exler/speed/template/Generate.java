package com.exler.speed.template;

import com.exler.speed.entity.DefaultConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description: TODO
 * @Company: BIG-FINTECH
 * @ProjectName: iRich
 * @author: Exler(yz)
 * @GmtCreate: 2019/8/26 14:45
 */
public class Generate {
    public void generate(DefaultConfig config, String filePath, String suffix) {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //模板所在目录，相对于当前classloader的classpath
        resolver.setPrefix("templates/");
        //模板文件后缀
        resolver.setSuffix(".java");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //渲染模板
        FileWriter write = null;
        try {
            write = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        templateEngine.process(suffix, config.getContext(), write);
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        generate.generate(null, null, null);

    }
}
