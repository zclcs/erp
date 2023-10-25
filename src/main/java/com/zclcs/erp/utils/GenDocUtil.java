package com.zclcs.erp.utils;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author zclcs
 */
@UtilityClass
public class GenDocUtil {

    public File genDoc(Class<?> clazz, String templateName, Map<String, Object> dataMap) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setClassForTemplateLoading(clazz, "/templates");
        Template template = configuration.getTemplate(templateName);
        File file = FileUtil.file(FileUtil.getTmpDirPath(), System.currentTimeMillis() + ".doc");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8), 10240)) {
            template.process(dataMap, out);
        }
        return file;
    }

    public File genPdf(Class<?> clazz, String templateName, Map<String, Object> dataMap) throws TemplateException, IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setClassForTemplateLoading(clazz, "/templates");
        Template template = configuration.getTemplate(templateName);
        File file = FileUtil.file(FileUtil.getTmpDirPath(), System.currentTimeMillis() + ".pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try (Writer out = new StringWriter()) {
            template.process(dataMap, out);
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setCharset("UTF-8");
            FontProvider fontProvider = new FontProvider();
            fontProvider.addSystemFonts();
            converterProperties.setFontProvider(fontProvider);
            String s = out.toString();
            HtmlConverter.convertToPdf(s, fileOutputStream, converterProperties);
        }
        return file;
    }
}
