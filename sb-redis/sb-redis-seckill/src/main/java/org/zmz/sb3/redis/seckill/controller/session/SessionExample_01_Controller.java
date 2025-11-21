package org.zmz.sb3.redis.seckill.controller.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/session01")
@RestController
public class SessionExample_01_Controller {

    public static final Logger LOG = LoggerFactory.getLogger(SessionExample_01_Controller.class);

    @GetMapping("/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        // 取出 session 中的 browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            LOG.info("不存在 session，设置 browser: {}", browser);
            session.setAttribute("browser", browser);
        } else {
            LOG.info("存在 session，browser:{}", sessionBrowser);
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                LOG.info("{} : {}", cookie.getName(), cookie.getValue());
            }
        }
        return "index";
    }

}