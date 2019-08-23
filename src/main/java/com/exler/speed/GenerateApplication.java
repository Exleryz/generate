package com.exler.speed;

import com.exler.speed.util.FileUtil;
import com.exler.speed.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class GenerateApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(GenerateApplication.class, args);
        GenerateApplication generateApplication = new GenerateApplication();
        generateApplication.test(args);
    }

    public void test(String[] args) throws IOException {
        System.out.println(this.getClass().getResource(""));
        String entityName = "User";
        if (StringUtils.isEmpty(entityName)) {
            log.error("生成实体类名称为空");
        }
        // 强行大写首字母
        entityName = StringUtil.upFirst(entityName);
        System.out.println(entityName);
        File file = new File("");
        // 对于getCanonicalPath()函数，"."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
        // 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
        // 至于getPath()函数，得到的只是你在new File()时设定的路径
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String projectPath = file.getAbsolutePath();

        // todo 可自行修改
        // 生成 源文件的目录
        String generatePath = projectPath + "/src/main/resources/generate";

        // todo 抽象
        File gen = new File(generatePath);
        if (!gen.exists()) {
            boolean flag = gen.mkdirs();
            System.out.println("项目路径生成" + flag);
        } else {
            log.info("项目路径已存在");
        }

        // 开始输出
        output(generatePath, entityName);
    }

    public static void output(String generatePath, String entityName) {
        FileUtil.generate(generatePath, "controller", entityName);
        FileUtil.generate(generatePath, "service", entityName);
        FileUtil.generate(generatePath, "service/impl", entityName);
        FileUtil.generate(generatePath, "mapper", entityName);
    }


}
