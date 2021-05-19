package ru.petshop.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Log4j2
@Configuration
public class Config {
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/mybatis";
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String CLIENT_URL = "http://localhost:1841";

    static {
        Field[] fields = Config.class.getDeclaredFields();
        for(Field field : fields) {
            try {
                log.info("{} : {}",field.getName(),field.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
