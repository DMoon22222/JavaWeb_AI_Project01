package com.scut;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;

public class CreateBucket {

    public static void main(String[] args) throws Exception {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置全局环境变量。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 填写Bucket名称（保持与创建时一致）
        String bucketName = "java-web-ai-project-001";
        // 填写Object完整路径。此处的名字决定了图片在云端的路径和文件名
        String objectName = "001.jpg";
        // 填写Bucket所在地域
        String region = "cn-beijing";
        // 本地要上传的图片路径
        String localFilePath = "C:\\Users\\15614\\Desktop\\ACG图集\\wallhaven-ogyw75.jpg";

        // 创建OSSClient实例并配置V4签名
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();

        try {
            // 新版推荐使用 PutObjectRequest 对象来封装上传请求，扩展性更强
            File uploadFile = new File(localFilePath);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, uploadFile);

            // 执行上传动作
            ossClient.putObject(putObjectRequest);
            System.out.println("图片上传成功！云端路径: " + objectName);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}