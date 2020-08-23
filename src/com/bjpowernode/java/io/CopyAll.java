package com.bjpowernode.java.io;

import java.io.*;

/*
拷贝目录
 */
public class CopyAll {
    public static void main(String[] args) {
        //拷贝源
        File srcFile = new File("F:\\testSSM");
        //拷贝目标
        File destFile = new File("D:\\");
        //调用方法拷贝
        copyDir(srcFile, destFile);
    }

    /**
     * 拷贝目录
     * @param srcFile 拷贝源
     * @param destFile 拷贝目标
     */
    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {
            //srcFile如果是一个文件的话，递归结束
            //是文件的时候需要拷贝
            //一边读一边写
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                //读这个文件
                //D:\course\02-JavaSE\document\JavaSE进阶讲义
                in = new FileInputStream(srcFile);
                //写到文件中
                //C:\course\02-JavaSE\document\JavaSE进阶讲义
                String path = (destFile.getAbsolutePath().endsWith("\\") ?
                        destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\") + srcFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(path);
                //一边读一边写

                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in == null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }

        //获取源下面的子目录（包括目录和文件）
        File[] files = srcFile.listFiles();
        for (File file: files) {
            //获取所有文件的（包括目录和文件）绝对路径
            System.out.println(file.getAbsolutePath());

            if (file.isDirectory()) {
                //新建对应的目录
                //D:\course\02-JavaSE\document\JavaSE进阶讲义 源目录
                //C:\course\02-JavaSE\document\JavaSE进阶讲义 目标目录
                String srcDir = file.getAbsolutePath();
                String destDir = (destFile.getAbsolutePath().endsWith("\\") ?
                        destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\") + srcDir.substring(3);
                File newFile = new File(destDir);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
            }

            copyDir(file, destFile);
        }

    }
}
