package com.exler.speed.convert.yaml;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.CollectionFactory;
import org.springframework.lang.Nullable;

import java.util.Properties;

/**
 * @Description: TODO
 * @Company: BIG-FINTECH
 * @ProjectName: iRich
 * @author: Exler(yz)
 * @GmtCreate: 2019/8/26 11:14
 */
public class YamlProperties extends YamlProcessor implements FactoryBean<Properties>, InitializingBean {
    private boolean singleton = true;
    @Nullable
    private Properties properties;

    public YamlProperties() {
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public void afterPropertiesSet() {
        if (this.isSingleton()) {
            this.properties = this.createProperties();
        }

    }

    @Nullable
    @Override
    public Properties getObject() {
        return this.properties != null ? this.properties : this.createProperties();
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }

    protected Properties createProperties() {
        Properties result = CollectionFactory.createStringAdaptingProperties();
        this.process((properties, map) -> {
            result.putAll(properties);
        });
        return result;
    }
}
