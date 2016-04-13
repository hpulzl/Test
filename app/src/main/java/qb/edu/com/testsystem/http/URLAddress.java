package qb.edu.com.testsystem.http;

import java.io.File;

/**
 * Created by admin on 2016/4/4.
 * 提供访问服务器的链接。
 */
public class URLAddress {
    private static final String TAG="URLAddress";

//       public static final String IP_ADDRESS="http://192.168.1.110:8888";
    public static final String IP_ADDRESS="http://10.18.250.120:8888";
    private static final String PROJECT_NAME="TestSystem";

    /**
     * 访问的servlet路径
     * @param servletName
     * @return
     */
    public static String getURLPath(String servletName){
        return IP_ADDRESS + File.separator+PROJECT_NAME+File.separator+servletName;
    }
    public static String getRealUrlImg(String urlImg){
        return URLAddress.getURLPath("upload"+ File.separator+urlImg);
    }
    public static String getViewPagerUrl(String movieId){
        return URLAddress.getURLPath("upload"+File.separator+"indexfilmIMG"+File.separator+movieId+".jpg");
    }
}
