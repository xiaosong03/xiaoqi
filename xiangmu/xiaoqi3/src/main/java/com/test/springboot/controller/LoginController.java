package com.test.springboot.controller;

import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.utils.result.code.Code;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.MessageDigest;

@Controller
@ResponseBody
public class LoginController {
    @Resource
    private UserService loginService;

    @RequestMapping("login")
    public DataResult login(@RequestBody User user){
        //System.out.println("=======================");
        String md=user.getPassword();
        System.out.println(md);
        String md1=encode(md);
        System.out.println(md1);
        user.setPassword(md1);
        User login = loginService.login(user);

        if(null == login){
            return DataResult.errByErrCode(Code.LOGIN_ERROR);
        }
        //System.out.println(login.getUsername()+"  +  "+login.getPassword());
        return DataResult.successByData(login);
    }
    public String encode(String str) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            result = md.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }

    /**
     * 将二进制转换成十六进制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
