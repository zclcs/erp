package com.zclcs.erp.utils;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import com.zclcs.erp.handler.WaterMarkEventHandler;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.Resource;

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

    public File genPdf(Class<?> clazz, String templateName, String waterMark, Map<String, Object> dataMap, Resource resource) throws TemplateException, IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setClassForTemplateLoading(clazz, "/templates");
        Template template = configuration.getTemplate(templateName);
        File file = FileUtil.file(FileUtil.getTmpDirPath(), System.currentTimeMillis() + ".pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try (Writer out = new StringWriter()) {
            template.process(dataMap, out);
            String html = out.toString();
            PdfWriter pdfWriter = new PdfWriter(fileOutputStream);
            PdfFont pdfFont = PdfFontFactory.createTtcFont(resource.getContentAsByteArray(), 0, PdfEncodings.IDENTITY_H, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED, true);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            //设置为A4大小
            pdfDocument.setDefaultPageSize(PageSize.A4);
            //添加水印
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new WaterMarkEventHandler(waterMark, pdfFont));
            ConverterProperties properties = new ConverterProperties();
            FontProvider fontProvider = new FontProvider();
            fontProvider.addFont(pdfFont.getFontProgram(), PdfEncodings.IDENTITY_H);
            properties.setFontProvider(fontProvider);
            HtmlConverter.convertToPdf(html, pdfDocument, properties);
        }
        return file;
    }
}
