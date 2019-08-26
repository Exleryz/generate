package com.exler.speed.convert.yaml;

import com.exler.speed.entity.DefaultConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Exler(yz)
 */


@Slf4j
public class YamlConvert {

    public DefaultConfig getConfigProperties() {
        String application = "application.properties";
        // 获取输入流
        InputStream in = getClass().getClassLoader().getResourceAsStream(application);
        // 新建配置对象
        Properties p = new Properties();
        // 通过输入流加载
        try {
            p.load(in);
        } catch (IOException e) {
            log.error("{} 文件加载失败", application);
            // e.printStackTrace();
        }
        // 读取配置文件key
        String configFileName = p.getProperty("config.file.name");
        log.info("使用 {} 做为配置配置文件", configFileName);
        YamlProperties yaml = new YamlProperties();
        yaml.setResources(new ClassPathResource(configFileName));
        Properties properties;
        try {
            properties = yaml.getObject();
        } catch (Exception e) {
            log.error("{} 文件初始化失败，请检查文件路径，及配置的文件名", configFileName);
            // e.printStackTrace();
            return null;
        }
        DefaultConfig config = new DefaultConfig(properties);
        log.info("读取配置文件\n{}", config);

        return config;
    }
}
