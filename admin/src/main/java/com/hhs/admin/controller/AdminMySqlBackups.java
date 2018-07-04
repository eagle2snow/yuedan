package com.hhs.admin.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台数据库备份
 *
 * @author Guet
 * return "0"成功   "9"失败
 */
@Controller
@RequestMapping("/admin/mysql/")
public class AdminMySqlBackups {

    private static final String PATH = "/admin/mysql/";

    @RequestMapping("/show")
    public String showView(ModelMap map)
    {
        map.put("path", PATH);
        return PATH + "backup";
    }

    @ResponseBody
    @RequestMapping("backup")
    public static String backup()
    {
        try {
            Runtime rt = Runtime.getRuntime();

            // 调用 调用mysql的安装目录的命令
            Process child = rt
                    //.exec("D:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -h localhost -uroot -p1234 mysql --default-character-set=utf8");
                    .exec("/usr/local/mysql/bin/mysqldump -h localhost -uroot -pSge%5ej5De6z zhuyu --default-character-set=utf8");
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            // 要用来做导入用的sql目标文件：
            //FileOutputStream fout = new FileOutputStream("D:\\MySqlBackups\\mysql.sql");
            FileOutputStream fout = new FileOutputStream("/usr/local/mysql/Backups/zhuyu.sql");
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();

            System.out.println("");
            return "0";

        } catch (Exception e) {
            e.printStackTrace();
            return "9";
        }

    }

    @ResponseBody
    @RequestMapping("restore")
    public static String restore(/*String databaseName*/)
    {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime
                    //.exec("D:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe -hlocalhost -uroot -p1234 zhuyu --default-character-set=utf8 ");
                    //  + /*databaseName*/"beifen");
                    .exec("/usr/local/mysql/bin/mysql -h localhost -uroot -pSge%5ej5De6z zhuyu --default-character-set=utf8");
            OutputStream outputStream = process.getOutputStream();
            //BufferedReader br = new BufferedReader(new InputStreamReader(
            //		new FileInputStream("D:\\MySqlBackups\\zhuyu.sql"), "utf-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("/usr/local/mysql/Backups/zhuyu.sql"), "utf-8"));
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            str = sb.toString();
            // System.out.println(str);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,
                    "utf-8");
            writer.write(str);
            writer.flush();
            outputStream.close();
            br.close();
            writer.close();
            return "0";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "9";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "9";
        } catch (IOException e) {
            e.printStackTrace();
            return "9";
        }
    }

}
