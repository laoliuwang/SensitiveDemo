package com.cw.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
//@ConfigurationProperties(prefix = "ftp")
public class FtpUtils {
    @Value("${ftp.host}")
    public String host;

    @Value("${ftp.port}")
    public int port;

    @Value("${ftp.username}")
    public String username;

    @Value("${ftp.password}")
    public String password;

    private FtpUtils() {

    }

    /**
     * 上传文件
     *
     * @param path
     * @param inputStream
     * @param fileName
     * @return
     */
    public boolean upload(String path, InputStream inputStream, String fileName) {

        log.info(host + port + username + password);
        FTPClient ftpClient = new FTPClient();
        boolean flag = false;
        //测试连接
        if (connect(ftpClient)) {
            try {
                //检查路径是否存在
                if (ftpClient.changeWorkingDirectory(path)) {
                    //
                    if (storeFile(ftpClient, fileName, inputStream)) {
                        flag = true;
                        disconnect(ftpClient);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 获取目录下的所有文件
     *
     * @param directory
     * @return
     */
    public List<FTPFile> subFilesByDirectory(String directory) {
        List<FTPFile> subFiles = new ArrayList<>();
        FTPClient ftpClient = new FTPClient();

        if (connect(ftpClient)) {
            try {
                FTPFile[] files = ftpClient.mlistDir(directory);
                subFiles = Arrays.asList(files);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return subFiles;
    }

    /**
     * 通过路径和名称下载文件
     *
     * @param path
     * @param fileName
     * @return
     */
    public InputStream download(String path, String fileName) throws IOException {
        FTPClient ftpClient = new FTPClient();
        InputStream is = null;
        if (connect(ftpClient)) {
            try {
                if (ftpClient.changeWorkingDirectory(path)) {
                    try {
                        is = ftpClient.retrieveFileStream(fileName);
                    } catch (IOException e) {
                        throw e;
                    }
                }
            } catch (IOException e) {
                throw e;
            }

        }
        return is;
    }

    /**
     * 通过路径和名称删除文件
     *
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean delete(String path, String fileName) throws IOException {
        FTPClient ftpClient = new FTPClient();
        boolean flag = false;
        if (connect(ftpClient)) {
            try {
                if (ftpClient.changeWorkingDirectory(path)) {
                    try {
                        if (ftpClient.deleteFile(fileName)) {
                            flag = true;
                        }
                    } catch (IOException e) {
                        throw e;
                    }
                }
            } catch (IOException e) {
                throw e;
            }

        }
        return flag;
    }

    /**
     * 保存文件到FTP服务器
     *
     * @param ftpClient
     * @param fileName
     * @param inputStream
     * @return
     */
    private boolean storeFile(FTPClient ftpClient, String fileName, InputStream inputStream) {
        boolean flag = false;
        try {
            if (ftpClient.storeFile(fileName, inputStream)) {
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 连接FTP服务器
     *
     * @param ftpClient
     * @return
     */
    private boolean connect(FTPClient ftpClient) {
        boolean flag = false;
        try {
            ftpClient.connect(host, port);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding("UTF-8");
            if (ftpClient.login(username, password)) {
                log.info("连接成功");
                flag = true;
            } else {
                log.info("连接失败!");
                disconnect(ftpClient);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return flag;
    }

    /**
     * 断开FTP服务器连接
     *
     * @param ftpClient
     */
    private void disconnect(FTPClient ftpClient) {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
                log.error("已关闭连接");
            } catch (IOException e) {
                log.error("没有关闭连接");
                e.printStackTrace();
            }
        }
    }

}
