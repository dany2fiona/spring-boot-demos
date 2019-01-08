package com.dany.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception{
        mailService.sendSimpleMail("yangdan90@126.com","test simple mail","hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception{
        String context = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("yangdan90@126.com","test Html mail",context);
    }

    @Test
    public void sendAttachmentsMail() throws Exception{
        String filePath = "f:\\log\\log";
        mailService.sendAttachmentsMail("yangdan90@126.com","主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() throws Exception{//<img src="cid:" + rscId ></body> contentid:rscid
        String rscId = "dany001";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "G:\\robot.jpg";

        mailService.sendInlineResourceMail("yangdan90@126.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail(){
        Context context = new Context();
        context.setVariable("id","001");
        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("yangdan90@126.com","主题：这是模板邮件",emailContent);
    }

}
