package com.zclcs.erp.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zclcs
 */
@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    public static final String NORM_TIME_PATTERN = "HH:mm:ss";

    @Override
    public void addFormatters(@Nullable FormatterRegistry registry) {
        if (registry != null) {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setDateFormatter(DateTimeFormatter.ofPattern(NORM_DATE_PATTERN));
            registrar.setTimeFormatter(DateTimeFormatter.ofPattern(NORM_TIME_PATTERN));
            registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN));
            registrar.registerFormatters(registry);
        }
    }

    @ControllerAdvice
    public static class ControllerStringParamTrimConfig {

        /**
         * url和form表单中的参数trim
         */
        @InitBinder
        public void initBinder(WebDataBinder binder) {
            // 构造方法中 boolean 参数含义为如果是空白字符串,是否转换为null
            // 即如果为true,那么 " " 会被转换为 null,否者为 ""
            StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(false);
            binder.registerCustomEditor(String.class, stringTrimmerEditor);
        }
    }

    /**
     * 统一配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(NORM_DATE_PATTERN)));
        timeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(NORM_TIME_PATTERN)));
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN)));
        SimpleModule longModule = new SimpleModule();
        longModule.addSerializer(Long.class, ToStringSerializer.instance);
        longModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        return builder -> {
            builder.simpleDateFormat(NORM_DATETIME_PATTERN);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(NORM_DATE_PATTERN)),
                    new LocalTimeSerializer(DateTimeFormatter.ofPattern(NORM_TIME_PATTERN)),
                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN)));
            builder.deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                @Override
                public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
                        throws IOException {
                    return jsonParser.getValueAsString().strip();
                }
            });
            builder.modules(timeModule, longModule);
        };
    }
}
