package com.xlm.mybatisgenerator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MybatisGeneratorApplication {

    public static void main(String[] args) {
        // SpringApplication.run(MybatisGeneratorApplication.class, args);
        test();
    }
    public static void test(){
        List<String> warnings = new ArrayList<>();
        try {
            String configFilePath = System.getProperty("user.dir")
                    .concat("/mybatis-generator/src/main/resources/mybatisGenerator/generatorConfig.xml");
            System.out.println("加载配置文件===" + configFilePath);
            boolean overwrite = true;
            File configFile = new File(configFilePath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            //ProgressCallback progressCallback = new VerboseProgressCallback();
            myBatisGenerator.generate(null);
            //myBatisGenerator.generate(progressCallback);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
