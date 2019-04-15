package com.xiaoma.utils;

import com.aliyun.openservices.ClientException;
import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.*;
import com.aliyun.oss.common.utils.BinaryUtil;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 * OSS文件上传工具类
 */
public class OssUtil {

    private final static OSSClient client=new OSSClient("LTAIcTTlOYbBP7dI", "10evaGVsOSPAwH4FW6lw5eRwhlqSQi");
    private final static String bucketName = "innjoe-header-icon";

    private OssUtil() {
    }

    /**Purpose:上传流
     */
    public static void uploadInputStream(InputStream ins, ObjectMetadata objectMetadata,
                                         String key) throws OSSException, ClientException, IOException {
        client.putObject(bucketName, fileFormat(key), ins, objectMetadata);
    }

    /**Purpose:上传文件
     * Version: 1.0
     */
    public static void uploadFile(File file, ObjectMetadata objectMetadata,
                                  String key) throws OSSException, ClientException, IOException {
        client.putObject(bucketName, fileFormat(key), FileUtils.openInputStream(file), objectMetadata);
    }

    /**Purpose:分段上传文件
     * Version: 1.0
     */
    public static void multipartFile(File file, int partSize,
                                     InitiateMultipartUploadRequest initiateMultipartUploadRequest,
                                     String key) throws IOException {

        InitiateMultipartUploadResult initiateMultipartUploadResult =
                client.initiateMultipartUpload(initiateMultipartUploadRequest);
        // 计算分块数目
        int partCount = (int) (file.length() / partSize);
        if (file.length() % partSize !=   0){
            partCount++;
        }

        // 新建一个List保存每个分块上传后的ETag和PartNumber
//        List<PartETag> partETags = new ArrayList<PartETag>();

        for(int i =   0; i < partCount; i++){
            // 获取文件流
            try (FileInputStream fis = new FileInputStream(file)) {

                // 跳到每个分块的开头
                long skipBytes = 1L * partSize * i;
                fis.skip(skipBytes);

                // 计算每个分块的大小
                long size = partSize < file.length() - skipBytes ?
                        partSize : file.length() - skipBytes;

                // 创建UploadPartRequest，上传分块
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(bucketName);
                uploadPartRequest.setKey(fileFormat(key));
                uploadPartRequest.setUploadId(initiateMultipartUploadResult.getUploadId());
                uploadPartRequest.setInputStream(fis);
                uploadPartRequest.setPartSize(size);
                uploadPartRequest.setPartNumber(i + 1);
                client.uploadPart(uploadPartRequest);
//            UploadPartResult uploadPartResult = client.uploadPart(uploadPartRequest);

//            // 将返回的PartETag保存到List中。
//            partETags.add(uploadPartResult.getPartETag());

                // 关闭文件
                fis.close();
            }
        }
    }

    /**Purpose:删除指定文件
     */
    public static void deleteFile(String key){
        client.deleteObject(bucketName, fileFormat(key));
    }

    /**Purpose:批量删除文件
     * Version: 1.0
     */
    public static void deleteMultipartFile(String prefix,boolean isDirestory){
//    格式啊目录地址
        if(isDirestory){
            prefix=directoryFormat(prefix);
        }
//    获取key
        List<String> keyLi=getKeys(prefix);
//    循环删除key
        for(String key:keyLi){
            client.deleteObject(bucketName, key);
        }
    }
    //拷贝目录
    public static void copyDirectory(String oldPath,String newPath){
        oldPath=directoryFormat(oldPath);
        newPath=directoryFormat(newPath);
        List<String> keyLi=getKeys(oldPath);
        for(String key:keyLi){
            client.copyObject(bucketName, key, bucketName, key.replace(oldPath, newPath));
            client.deleteObject(bucketName, key);
        }
    }


    /**Purpose:根据key开头获取keys
     * Version: 1.0
     */
    private static List<String> getKeys(String prefix){
        List<String> keyLi=new ArrayList<>();
        ListObjectsRequest objectsRequest=new ListObjectsRequest(bucketName);
        objectsRequest.setPrefix(prefix);
        objectsRequest.setMaxKeys(1000);
        ObjectListing listing=client.listObjects(objectsRequest);
        for(OSSObjectSummary objectSummary :listing.getObjectSummaries()){
            keyLi.add(objectSummary.getKey());
        }
        String marker=listing.getNextMarker();
        while(listing.getObjectSummaries().size()!=  0&&marker!=null){
            objectsRequest.setPrefix(prefix);
            objectsRequest.setMaxKeys(1000);
            objectsRequest.setMarker(marker);
            listing=client.listObjects(objectsRequest);
            for(OSSObjectSummary objectSummary :listing.getObjectSummaries()){
                keyLi.add(objectSummary.getKey());
            }
            marker=listing.getNextMarker();
        }
        return keyLi;
    }


    /**Purpose:验证key是否存在
     * @author

     * Create Time: 2014年10月11日 上午9:53:03

     * @param key
     * @return

     * Version: 1.0
     */
    public static boolean verifyKey(String key){
        try {
            client.getObject(bucketName, key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //file文件地址格式化
    public static String fileFormat(String key){
        key=key.replaceAll("^/+", "");
        key=key.replaceAll("/+$", "");
        return key;
    }
    //direstory目录地址格式化
    public static String directoryFormat(String key){
        key=key.replaceAll("^/+", "");
        key=key.replaceAll("/+$", "")+"/";
        return key;
    }


    /*=========================================================================================*/

    public static String getPostBody(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return new String(message,"utf-8");
            } catch (IOException e) {
            }
        }
        return "";
    }

    public static boolean verifyOSSCallbackRequest(HttpServletRequest request, String ossCallbackBody) throws NumberFormatException, IOException {
        boolean ret = false;
        String autorizationInput = request.getHeader("Authorization");
        String pubKeyInput = request.getHeader("x-oss-pub-key-url");
        byte[] authorization = BinaryUtil.fromBase64String(autorizationInput);
        byte[] pubKey = BinaryUtil.fromBase64String(pubKeyInput);
        String pubKeyAddr = new String(pubKey,"utf-8");
        if (!pubKeyAddr.startsWith("http://gosspublic.alicdn.com/") && !pubKeyAddr.startsWith("https://gosspublic.alicdn.com/"))
        {
            System.out.println("pub key addr must be oss addrss");
            return false;
        }
        String retString = executeGet(pubKeyAddr);
        retString = retString.replace("-----BEGIN PUBLIC KEY-----", "");
        retString = retString.replace("-----END PUBLIC KEY-----", "");
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        String decodeUri = java.net.URLDecoder.decode(uri, "UTF-8");
        String authStr = decodeUri;
        if (queryString != null && !queryString.equals("")) {
            authStr += "?" + queryString;
        }
        authStr += "\n" + ossCallbackBody;
        ret = doCheck(authStr, authorization, retString);
        return ret;
    }

    public static String executeGet(String url) {
        BufferedReader in = null;

        String content = null;
        try {
            // 定义HttpClient
            @SuppressWarnings("resource")
            DefaultHttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            content = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }

    public static boolean doCheck(String content, byte[] sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = BinaryUtil.fromBase64String(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            boolean bverify = signature.verify(sign);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
