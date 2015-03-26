import java.security.MessageDigest;

public class aa {
	public static void main(String[] args) {
		// 3���ġ�signText��0guid����Ϊ��e885f918-e5a8-4e1d-b349-e978747c5d3cb4106aac-9bc3-4ce0-aae9-d8e81502d35d����Ӧ��sign��
		// ��serverSign��1C4C320AD47D2857DFD3D259ABE9CC7D

//		System.out.println(java.util.UUID.randomUUID().toString());
		// vhhhhhhh ddddddd  ggggg
		String appid = "90101";
		
		String method = "CheckLoginV2";
		
		String user = "15010001001";
		
		String pwd = "1";
		
		String guid = java.util.UUID.randomUUID().toString();
		
		String appOption = "1";
		
		String U2AppKey = "u2testAppKey#$vs";
		String signText = (method + appid + guid + user + pwd + U2AppKey).toLowerCase();
		String sign = MD5(signText); //ǩ��
		
		System.out.println(sign);

	}
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // ���MD5ժҪ�㷨�� MessageDigest ����
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // ʹ��ָ�����ֽڸ���ժҪ
            mdInst.update(btInput);
            // �������
            byte[] md = mdInst.digest();
            // ������ת����ʮ����Ƶ��ַ���ʽ
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
