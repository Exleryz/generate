package com.exler.speed;

import com.exler.speed.convert.yaml.YamlConvert;
import com.exler.speed.entity.DefaultConfig;
import com.exler.speed.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.io.File;

@Slf4j
public class GenerateApplication {

    public static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        GenerateApplication generateApplication = new GenerateApplication();
        // mvc结构代码生成方法 开始
        generateApplication.start();
    }

    private void start() {
        // 获取 yml 配置 参数
        YamlConvert convert = new YamlConvert();
        DefaultConfig config = convert.getConfigProperties();

        // 创建项目路径
        File gen = new File(config.getGenerateDir());
        if (!gen.exists()) {
            boolean flag = gen.mkdirs();
            System.out.println("项目路径生成" + flag);
        } else {
            log.info("项目路径已存在");
        }

        // 生成 结构 and 代码
        FileUtil.generate(config, config.getControllerDirName(), config.getEntityNameU(), config.getControllerSuffix());
        // 判断是否生成serviceInterface
        if (config.getServiceInterface()) {
            FileUtil.generate(config, config.getServiceDirName(), config.getEntityNameU(), config.getServiceSuffix());
        }
        FileUtil.generate(config, config.getServiceImplDirName(), config.getEntityNameU(), config.getServiceImplSuffix());
        FileUtil.generate(config, config.getDaoDirName(), config.getEntityNameU(), config.getDaoSuffix());
    }

}
