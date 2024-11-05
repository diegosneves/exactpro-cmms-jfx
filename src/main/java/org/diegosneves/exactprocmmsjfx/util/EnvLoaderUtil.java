package org.diegosneves.exactprocmmsjfx.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EnvLoaderUtil {

    private static final String DOT_ENV_FILE = ".env";
    private static final String COMMENT_PREFIX = "#";
    private static final String ENV_SEPARATOR = "=";

    private static Map<String, String> newenv;

    private EnvLoaderUtil() {}

    private static void loadEnv() {
        newenv = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DOT_ENV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith(COMMENT_PREFIX)) {
                    continue;
                }
                String[] parts = line.split(ENV_SEPARATOR, 2);
                if (parts.length == 2) {
                    setEnv(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            log.error(String.format("Fail: %s.loadEnv() [%s]", EnvLoaderUtil.class.getSimpleName(), e.getMessage()), e);
        }
    }

    private static void setEnv(String key, String value) {
        try {
            newenv.put(key, value);
        } catch (Exception e) {
            log.error(String.format("Fail: %s.setEnv(%s, %s)", EnvLoaderUtil.class.getSimpleName(), key, value), e);
        }
    }

    public static String getEnv(String key) {
        loadEnv();
        try {
            return newenv.get(key);
        } catch (Exception e) {
            log.error(String.format("Fail: %s.getEnv(%s)", EnvLoaderUtil.class.getSimpleName(), key), e);
        }
        return System.getenv(key);
    }

}
