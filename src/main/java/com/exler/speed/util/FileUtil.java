package com.exler.speed.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @Description: TODO
 * @Company: BIG-FINTECH
 * @ProjectName: iRich
 * @author: Exler(yz)
 * @GmtCreate: 2019/8/23 11:47
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
     * @param dirPath    项目生成路径/mvcPath
     * @param suffix     后缀
     * @param entityName 实体类名称
     */
    public static void generateFile(String dirPath, String suffix, String entityName) {
        // 生成entity mvc文件
        String filePath = String.format("%s/%s%s.java", dirPath, entityName, StringUtil.upFirst(suffix));
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                boolean flag = file.createNewFile();
                log.info("{}{}.java 文件生成{}", entityName, StringUtil.upFirst(suffix), flag);
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

    /**
     * 生成对应MVC文件
     *
     * @param generatePath
     * @param mvcPath
     * @param entityName
     */
    public static void generate(String generatePath, String mvcPath, String entityName) {
        String[] split = mvcPath.split("/");
        String suffix = mvcPath;
        if (split.length > 1) {
            suffix = split[0] + StringUtil.upFirst(split[1]);
        }
        String dirPath = generateDir(generatePath, mvcPath);
        generateFile(dirPath, suffix, entityName);
    }

}
