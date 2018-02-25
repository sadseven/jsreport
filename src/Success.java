package jsreport;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Success {
	public static InputStream doHttpPost() {
		
		String URL = "http://localhost:5488/api/report";
        JSONObject json = new JSONObject();
		
		JSONObject shortid = new JSONObject();
		shortid.put("shortid", "rkJTnK2ce");
		
		JSONObject data = new JSONObject();

		JSONObject seller = new JSONObject();
		seller.put("name", "Next Step Webs, Inc.");
		seller.put("road", "12345 Sunny Road");
		seller.put("country", "Sunnyville, TX 12345");
		
		JSONObject buyer = new JSONObject();
		buyer.put("name", "Acme Corp.");
		buyer.put("road", "16 Johnson Road");
		buyer.put("country", "Paris, France 8060");
		
		JSONArray items = new JSONArray();
		JSONObject item1 = new JSONObject();
		item1.put("name", "Website design");
		item1.put("price", "300");
		items.add(item1);
		
		data.put("number", "123");
		data.put("seller", seller);
		data.put("buyer", buyer);
		data.put("items", items);
		
		json.put("template", shortid);
		json.put("data", data);
		
        String xmlInfo = json.toString();
		
		
        System.out.println("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
        java.io.ByteArrayOutputStream out = null;
        try {
            URL url = new URL(URL);
            URLConnection urlCon = url.openConnection();
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            urlCon.setUseCaches(false);
            urlCon.setRequestProperty("content-Type", "application/json");
            urlCon.setRequestProperty("charset", "utf-8");
            urlCon.setRequestProperty("Content-length",
                    String.valueOf(xmlData.length));
            System.out.println(String.valueOf(xmlData.length));
            DataOutputStream printout = new DataOutputStream(
                    urlCon.getOutputStream());
            printout.write(xmlData);
            printout.flush();
            printout.close();
            instr = urlCon.getInputStream();
            
            /*ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
            byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
            int rc = 0; 
            while ((rc = instr.read(buff, 0, 100)) > 0) { 
            swapStream.write(buff, 0, rc); 
            }
            
            
            
            byte[] bis = swapStream.toByteArray();
            String ResponseString = new String(bis, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                System.out.println("返回空");
            }
            System.out.println("返回数据为:" + ResponseString);*/
            return instr;

        } catch (Exception e) {
            e.printStackTrace();
            return instr;
        } finally {
            try {
                out.close();
                instr.close();

            } catch (Exception ex) {
                return instr;
            }
        }
    }
    
}
