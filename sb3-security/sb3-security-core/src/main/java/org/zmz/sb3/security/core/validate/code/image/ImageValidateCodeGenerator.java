package org.zmz.sb3.security.core.validate.code.image;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.zmz.sb3.security.core.properties.SecurityProperties;
import org.zmz.sb3.security.core.validate.code.ValidateCodeGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageValidateCodeGenerator implements ValidateCodeGenerator<ImageCode> {

    private SecurityProperties securityProperties;

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public ImageCode generateCode(ServletWebRequest servletWebRequest) {
        HttpServletRequest request = servletWebRequest.getRequest();
        int width = ServletRequestUtils.getIntParameter(request, "width", securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request, "height", securityProperties.getCode().getImage().getHeight());
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));

        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);

            g.drawLine(x, y, x + xl, y + yl);
        }

        StringBuilder sRand = new StringBuilder();

        for (int i = 0; i < securityProperties.getCode().getImage().getLength(); i++) {
            String r = String.valueOf(random.nextInt(10));
            sRand.append(r);
            g.setColor(
                    new Color(
                            20 + random.nextInt(110),
                            20 + random.nextInt(110),
                            20 + random.nextInt(110)
                    )
            );

            g.drawString(r, 13 * i + 6, 16);
        }

        g.dispose();
        return new ImageCode(image, sRand.toString(), securityProperties.getCode().getImage().getExpireIn());
    }

    /**
     * 生成随机背景条纹
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
