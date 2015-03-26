import java.security.MessageDigest;

public class aa {
	public static void main(String[] args) {
		// 3中心【signText】0guid不能为空e885f918-e5a8-4e1d-b349-e978747c5d3cb4106aac-9bc3-4ce0-aae9-d8e81502d35d【本应用sign】
		// 【serverSign】1C4C320AD47D2857DFD3D259ABE9CC7D

//		System.out.println(java.util.UUID.randomUUID().toString());
		
		String appid = "90101";
		
		String method = "CheckLoginV2";
		
		String user = "15010001001";
		
		String pwd = "1";
		
		String guid = java.util.UUID.randomUUID().toString();
		
		String appOption = "1";
		
		String U2AppKey = "u2testAppKey#$vs";
		String signText = (method + appid + guid + user + pwd + U2AppKey).toLowerCase();
		String sign = MD5(signText); //签名
		
		System.out.println(sign);

	}
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
