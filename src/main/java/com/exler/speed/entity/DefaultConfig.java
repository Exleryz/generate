package com.exler.speed.entity;

import com.exler.speed.util.StringUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Properties;

/**
 * @author exler
 */

@Data
public class DefaultConfig {

    /**
     * 代码生成路径
     */
    private String generateDir;

    /**
     * 生成文件后缀名
     */
    private String fileSuffix;

    /**
     * 基础包名
     */
    private String packageName;

    /**
     * 需要生成的实体类名
     */
    private String entityName;

    /**
     * mvc层文件夹名
     */
    private String controllerDirName;
    private String serviceDirName;
    private String serviceImplDirName;
    private String daoDirName;

    /**
     * mvc层后缀
     */
    private String controllerSuffix;
    private String serviceSuffix;
    private String serviceImplSuffix;
    private String daoSuffix;

    /**
     * 是否需要生成 service接口
     */
    private Boolean serviceInterface;

    /**
     * 是否需要生成sql文件 .xml
     */
    private Boolean generateSql;

    public DefaultConfig(Properties properties) {
        String generateDir = properties.getProperty("default.config.generate.dir");
        if (StringUtils.isEmpty(generateDir)) {
            File file = new File("");
            // 对于getCanonicalPath()函数，"."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
            // 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
            // 至于getPath()函数，得到的只是你在new File()时设定的路径
            String projectPath = file.getAbsolutePath();
            // 生成 源文件的目录
            this.generateDir = projectPath + "/src/main/resources/generate";
        } else {
            this.generateDir = generateDir;
        }
        fileSuffix = properties.getProperty("default.config.suffix", ".java");
        packageName = properties.getProperty("default.config.package", "com.test.generate");
        entityName = properties.getProperty("default.config.entity.name", "user");
        //controller
        controllerDirName = properties.getProperty("default.config.controller.dir", DefaultName.CONTROLLER);
        controllerSuffix = properties.getProperty("default.config.controller.suffix", StringUtil.upFirst(DefaultName.CONTROLLER));

        // service
        String serviceInterfaceIsNeed = properties.getProperty("isNeed", "true");
        if ("true".equals(serviceInterfaceIsNeed)) {
            this.serviceInterface = true;
            serviceDirName = properties.getProperty("default.config.service.interface.dir", DefaultName.SERVICE_INTERFACE);
            serviceSuffix = properties.getProperty("default.config.service.interface.suffix", StringUtil.upFirst(DefaultName.SERVICE_INTERFACE));
        }
        serviceImplDirName = properties.getProperty("default.config.service.impl.dir", String.format("%s%s%s", DefaultName.SERVICE_INTERFACE, "/", DefaultName.SERVICE_IMPL));
        serviceImplSuffix = properties.getProperty("default.config.service.impl.suffix", String.format("%s%s", StringUtil.upFirst(DefaultName.SERVICE_INTERFACE), StringUtil.upFirst(DefaultName.SERVICE_IMPL)));

        // dao
        daoDirName = properties.getProperty("default.config.dao.dir", DefaultName.DAO);
        daoSuffix = properties.getProperty("default.config.dao.suffix", StringUtil.upFirst(DefaultName.DAO));
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"generateDir\": \"" + generateDir + "\",\n" +
                "    \"fileSuffix\": \"" + fileSuffix + "\",\n" +
                "    \"packageName\": \"" + packageName + "\",\n" +
                "    \"entityName\": \"" + entityName + "\",\n" +
                "    \"controllerDirName\": \"" + controllerDirName + "\",\n" +
                "    \"controllerSuffix\": \"" + controllerSuffix + "\",\n" +
                "    \"serviceDirName\": \"" + serviceDirName + "\",\n" +
                "    \"serviceSuffix\": \"" + serviceSuffix + "\",\n" +
                "    \"serviceImplDirName\": \"" + serviceImplDirName + "\",\n" +
                "    \"serviceImplSuffix\": \"" + serviceImplSuffix + "\",\n" +
                "    \"daoDirName\": \"" + daoDirName + "\",\n" +
                "    \"daoSuffix\": \"" + daoSuffix + "\",\n" +
                "    \"serviceInterface\": \"" + serviceInterface + "\",\n" +
                "    \"generateSql\": \"" + generateSql + "\"\n" +
                "}";
    }
}
