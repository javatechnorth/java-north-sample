package pk;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipDemo  {

    /**
     * 压缩文件
     * @param sourceFilePath 待压缩的文件路径
     * @param zipFilePath    压缩后存放路径
     * @return
     */
    public static void fileToZip(String sourceFilePath, String zipFilePath) {
        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists()) {
            System.out.println(sourceFilePath + " 不存在");
            return;
        }
        File zipFile = new File(zipFilePath);
        if (zipFile.exists()) {
            System.out.println(zipFilePath + " 已经存在");
            return;
        }

        try {
            byte[] buffer = new byte[1024];
            try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)))){

                for(File file: sourceFile.listFiles()) {
                    // 创建 ZIP 中的文件,并添加进压缩包
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zos.putNextEntry(zipEntry);
                    // 读取待压缩的文件并写进压缩包里
                    try (InputStream bis = new BufferedInputStream(new FileInputStream(file))){
                        int read = 0;
                        while ((read = bis.read(buffer)) != -1) {
                            zos.write(buffer, 0, read);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压
     * @param zipPath zip 文件夹路径
     * @param targetPath 解压路径
     */
    public static void unzip(String zipPath,String targetPath){

        File pathFile = new File(targetPath);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }

        try{
            //指定编码
            try(ZipFile zipFile = new ZipFile(zipPath, Charset.forName("gbk"))) {
                //遍历里面的文件及文件夹
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    String zipEntryName = entry.getName();

                    try (InputStream in = zipFile.getInputStream(entry)) {
                        String outpath = (targetPath + File.separator + zipEntryName);
                        //判断路径是否存在，不存在则创建文件路径
                        File file = new File(outpath.substring(0, outpath.lastIndexOf(File.separator)));
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        //判断文件全路径是否为文件夹
                        if (new File(outpath).isDirectory())
                            continue;

                        try (OutputStream out = new FileOutputStream(outpath)) {
                            byte[] buffer = new byte[1024];
                            int len;
                            while ((len = in.read(buffer)) > 0) {
                                out.write(buffer, 0, len);
                            }
                        }
                    }
                }
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }

}
