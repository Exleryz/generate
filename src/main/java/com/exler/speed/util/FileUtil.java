package com.exler.speed.util;

import com.exler.speed.entity.DefaultConfig;
import com.exler.speed.template.Generate;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author Exler(yz)
 */

@Slf4j
public class FileUtil {


    public static String generateDir(String generatePath, String mvcPath) {
        // 生成 mvc 层 文件夹
        // 校验路径是否存在
        String dirPath = String.format("%s/%s", generatePath, mvcPath);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            boolean flag = dir.mkdirs();
            log.info("{}, 路径生成{}", dirPath, flag);
        }
        return dirPath;
    }


    /**
     * @param dirPath 项目生成路径/mvcPath
     * @param config  配置
     * @param suffix  后缀
     */
    public static void generateFile(String dirPath, DefaultConfig config, String suffix) {
        // 生成entity mvc文件
        String filePath = String.format("%s/%s%s%s", dirPath, config.getEntityNameU(), suffix, config.getFileSuffix());
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                boolean flag = file.createNewFile();
                log.info("{}{}.java 文件生成{}", config.getEntityNameU(), suffix, flag);
                generateCodeFile(config, filePath, suffix);
                log.info("代码生成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.info("文件存在");
            log.info("创建个新文件试试文件");
            try {
                file.delete();
                log.info("删除, 看看是否存在 {}", file.exists());
                boolean flag = file.createNewFile();
                log.info("文件存在创建新文件{}", flag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean generateCodeFile(DefaultConfig config, String filePath, String suffix) {
        Generate generate = new Generate();
        generate.generate(config, filePath, suffix);
        return true;
    }

    /**
     * 生成对应MVC文件
     *
     * @param config
     * @param mvcPath
     * @param entityName
     * @param suffix
     */
    public static void generate(DefaultConfig config, String mvcPath, String entityName, String suffix) {
        String dirPath = generateDir(config.getGenerateDir(), mvcPath);
//        generateFile(dirPath, mvcPath,entityName, suffix);
        generateFile(dirPath, config, suffix);
    }

}
