package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SilverPriceService {
	public String downloadContent(URI uri) throws Exception{				
	
		URLConnection conn = uri.toURL().openConnection();
		
		if(!(conn instanceof HttpURLConnection)){
			
			throw new IllegalArgumentException("The URI must be HTTP URI");
		}
		
		
		HttpURLConnection httpConn=(HttpURLConnection) conn;
		
		String contentType=httpConn.getHeaderField("Content-Type");
		String encoding=getEncoding(contentType);
		BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),encoding));
		String line;
		StringBuilder content=new StringBuilder(1000);
	    while ((line = reader.readLine()) != null) {
	    	content.append(line);
	    	content.append("\r\n");
	    }		
		
		return content.toString();
		
	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = "report@bettbio.com";
           String password = "bk123456!";
           
           System.out.print("really called here!");
           return new PasswordAuthentication(username, password);
        }
    }
	protected boolean sendEmail(String to, String subject, String content) throws URISyntaxException, Exception {

		Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "report@bettbio.com");
        mailProps.put("mail.smtp.host", "smtp.bettbio.com");
        mailProps.put("mail.smtp.port", 25);
        mailProps.put("mail.smtp.auth", "true");
        //mailProps.put("mail.smtp.socketFactory.port", port);
        //mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //mailProps.put("mail.smtp.socketFactory.fallback", "false");
        //mailProps.put("mail.smtp.starttls.enable", "true");
        SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(mailProps,  auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("report@bettbio.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("zeusec@qq.com"));
		//String content = value + "! product price has been changed ";
		msg.setSubject(subject);
		msg.setText(content);

		// Send the message
		Transport.send(msg);
		return true;

	}
	protected String getEncoding(String contentType)
	{		
		String encoding=getValueInExpr(contentType,"charset");
		if(encoding!=null){
			return encoding;
		}
		encoding=getValueInExpr(contentType,"encoding");
		if(encoding!=null){
			return encoding;
		}
		return "UTF-8";		
	}
	protected String getValueInExpr(String contentType, String prefix)
	{		
		Pattern pattern = Pattern.compile(prefix+"=\\S+(;)?");
		Matcher matcher = pattern.matcher(contentType);
		if(!matcher.find()){
			return null;
		}
		String temp=matcher.group();
		temp=temp.replace(prefix+"=", "");
		temp=temp.replace(";", "");
		return temp;
	}
	
	public double currentPrice() throws URISyntaxException, Exception{
		
		//String content=downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
				
		return currentPrice("白银");
	
		
	}
	
	public double currentGoldPrice() throws URISyntaxException, Exception{
		
		//String content=downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
				
		return currentGoldPrice("Au 100g");
	
		
	}
	
	public String allMetalPrice() throws URISyntaxException, Exception{
		
		//String content=downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
		
		
		String urlExpr="http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY";
		
		
		return downloadContent(new URI(urlExpr));
		
		
	}
	
	public double currentPrice(String metalName) throws URISyntaxException, Exception{
		
		//String content=downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
		
		
		String urlExpr="http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY";
		Document doc = Jsoup.connect(urlExpr).get();
		Elements elements = doc.select("td");
		int index=0;
		for(Element element: elements){
			//System.out.println(element.html());
			String text=element.html();
			if(metalName.equals(text)){
				String priceExpr=elements.get(index+1).html();
				return Double.parseDouble(priceExpr);
			}
			index++;
		}
		
		
		throw new IllegalArgumentException("不支持'"+metalName+"'的价格查询，仅支持白银、钯、铂、铑的人民币价格");
		
		
	}
	//Au 100g
	
	public double currentGoldPrice(String product) throws URISyntaxException, Exception{
		
		//String content=downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
		
		//curl 'http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=ShangHaiPrices' -H 'Accept-Encoding: gzip, deflate, sdch' -H 'Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.6,en;q=0.4,es-419;q=0.2,es;q=0.2' -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36' -H 'Accept: */*' -H 'Referer: http://www.kitco.cn/' -H 'Cookie: JSESSIONID=73E6B3D5E40033D4EB64CB67D781FFCF; counter=762923402084; _gat=1; __gads=ID=c2daff988c27286e:T=1462288489:S=ALNI_MaFYr3fJOM6NPvzlqiFIXoKcC-faw; _ga=GA1.2.219007872.1462288487' -H 'Connection: keep-alive' -H 'Cache-Control: max-age=0' --compressed
		String urlExpr="http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=ShangHaiPrices";
		Document doc = Jsoup.connect(urlExpr).get();
		Elements elements = doc.select("td");
		int index=0;
		for(Element element: elements){
			//System.out.println(element.html());
			String text=element.html().trim();
			System.out.println(text);
			if(text.contains(product)){
				String priceExpr=elements.get(index+1).html();
				
				return Double.parseDouble(priceExpr);
			}
			index++;
		}
		
		
		throw new IllegalArgumentException("不支持'"+product+"'的价格查询，仅支持白银、钯、铂、铑的人民币价格");
		
		
	}
	
	
	
	
}

/*
 * <div class="divbox07">
  <table width="100%" height="100%" border="0" cellspacing="0">
    <tr>
      <td height="20">&nbsp;</td>
      <td>&nbsp;</td>
      <td colspan="2" align="right" valign="middle"><font class="fcolor_gray">人民币/克&nbsp;</font></td>
    </tr>
	<tr class="fcolor_blue">
	<td>&nbsp;</td>
      <td align="center">金属</td>
      <td align="center">价格</td>
      <td align="center">变动</td>
	</tr>
    
	
				<tr>
			      <td> </td>
			      <td align="center">白银</td>
			      <td align="center">3.28</td>
			      <td align="center"><font class="fcolor_green">-0.73%</font></td>
			    </tr>
            
				<tr>
			      <td> </td>
			      <td align="center">铂</td>
			      <td align="center">205.12</td>
			      <td align="center"><font class="fcolor_green">-1.01%</font></td>
			    </tr>
            
				<tr>
			      <td> </td>
			      <td align="center">钯</td>
			      <td align="center">124.87</td>
			      <td align="center"><font class="fcolor_green">-0.66%</font></td>
			    </tr>
            
				<tr>
			      <td> </td>
			      <td align="center">铑</td>
			      <td align="center">151.13</td>
			      <td align="center"><font class="fcolor_red">+0.00%</font></td>
			    </tr>
            
      
    <tr>
      <td></td>
      <td colspan="3"><font class="fcolor_gray"> 
          	2016-3-23 13:19:50
           北京时间</font></td>
    </tr>
  </table>
</div>
*/
