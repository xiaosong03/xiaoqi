package com.test.springboot.controller;

import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.MessageDigest;

@Controller
@ResponseBody
public class RegisterController {
    @Resource
    private UserService userService;

    @RequestMapping("register")
    public DataResult register(@RequestBody User user){

        String md=user.getPassword();
        System.out.println(md);
        System.out.println("=======================");
        String md1=encode(md);
        System.out.println(md1);
        System.out.println("=======================");
        user.setPassword(md1);
        int register = userService.register(user);
        if(register == 0){
            return new DataResult(false,"注册失败，用户已存在");//wrong
        }
        return new DataResult(true,"注册成功");
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
