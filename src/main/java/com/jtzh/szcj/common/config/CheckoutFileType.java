package com.jtzh.szcj.common.config;

import org.apache.tomcat.util.http.fileupload.FileItem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CheckoutFileType {
    // 记录各个文件头信息及对应的文件类型
    public static Map<String, String> mFileTypes = new HashMap<String, String>();
    // 所有合法的文件后缀
    public static String res_fileType = ".jpg.gif.png.jpeg";

    static {
        // images
        mFileTypes.put("FFD8FFE0", ".jpg");
        mFileTypes.put("89504E47", ".png");
        mFileTypes.put("47494638", ".gif");
    }

    /**
     * 根据文件的输入流获取文件头信息
     *
     * @param is 文件路径
     * @return 文件头信息
     */
    public static String getFileType(InputStream is) {
        byte[] b = new byte[4];
        if (is != null) {
            try {
                is.read(b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mFileTypes.get(getFileHeader(b));
    }

    /**
     * 根据文件转换成的字节数组获取文件头信息
     *
     * @param b 文件路径
     * @return 文件头信息
     */
    public static String getFileHeader(byte[] b) {
        String value = bytesToHexString(b);
        return value;
    }

    /**
     * 将要读取文件头信息的文件的byte数组转换成string类型表示 下面这段代码就是用来对文件类型作验证的方法，
     * 将字节数组的前四位转换成16进制字符串，并且转换的时候，要先和0xFF做一次与运算。
     * 这是因为，整个文件流的字节数组中，有很多是负数，进行了与运算后，可以将前面的符号位都去掉，
     * 这样转换成的16进制字符串最多保留两位，如果是正数又小于10，那么转换后只有一位，
     * 需要在前面补0，这样做的目的是方便比较，取完前四位这个循环就可以终止了
     *
     * @param src要读取文件头信息的文件的byte数组
     * @return 文件头信息
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
        // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        System.out.println("获取文件头信息:" + builder.toString());
        return builder.toString();
    }

    /**
     * 判断上传的文件是否合法 （一）、第一：检查文件的扩展名， (二）、 第二：检查文件的MIME类型 。
     *
     * @param attachDoc
     * @return boolean
     */
    public static boolean getUpFilelegitimacyFlag(FileItem attachDoc, String allowType) {
        boolean upFlag = false;// 为真表示符合上传条件，为假表标不符合
        if (attachDoc != null) {
            String attachName = attachDoc.getName();
            System.out.println("#######上传的文件:" + attachName);
            if (!"".equals(attachName) && attachName != null) {
                /** 返回在此字符串中最右边出现的指定子字符串的索引 **/
                String sname = attachName
                        .substring(attachName.lastIndexOf("."));
                /** 统一转换为小写 **/
                sname = sname.toLowerCase();
                /** 第一步：检查文件扩展名，是否符合要求范围 **/
                if (allowType.indexOf(sname) != -1) {
                    upFlag = true;
                }
                /**
                 * 第二步：获取上传附件的文件头，判断属于哪种类型,并获取其扩展名 直接读取文件的前几个字节，来判断上传文件是否符合格式
                 * 防止上传附件变更扩展名绕过校验
                 ***/
                if (upFlag) {
                    byte[] b = new byte[4];
                    String req_fileType = null;
                    try {
                        req_fileType = getFileType(attachDoc.getInputStream());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("///////用户上传的文件类型///////////"
                            + req_fileType);
                    /** 第三步：检查文件扩展名，是否符合要求范围 **/
                    if (req_fileType != null && !"".equals(req_fileType)
                            && !"null".equals(req_fileType)) {
                        /** 第四步：校验上传的文件扩展名，是否在其规定范围内 **/
                        if (allowType.indexOf(req_fileType) != -1) {
                            upFlag = true;
                        } else {
                            upFlag = false;
                        }
                    } else {
                        /** 特殊情况校验,如果用户上传的扩展名为,文本文件,则允许上传-START **/
                        if (sname.indexOf(".txt") != -1) {
                            upFlag = true;
                        } else {
                            upFlag = false;
                        }
/** 特殊情况校验,如果用户上传的扩展名为,文本文件,则允许上传-END **/
                    }
                }
            }
        }
        return upFlag;
    }

    /**
     * 主函数，测试用
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
// final String fileType = getFileType("D:/BICP-HUAWEI.mht");
        FileInputStream is = null;
        String value = null;
        String filePath = "e:/aa/c.txt";
        try {
            is = new FileInputStream(filePath);
            byte[] b = new byte[4];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        System.out.println(value);
    }
}
