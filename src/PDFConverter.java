package jsreport;

import java.awt.Dimension;  
import java.awt.Insets;  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;  

public class PDFConverter {  
  
      
//  public byte[] generatePDF(InputStreamReader isr, String pdfFilename, String baseurl){  
//      //FileOutputStream fos = null;  
//      byte[] res = null;  
//      ByteArrayOutputStream baos = null;   
//      try{  
//          //fos = new FileOutputStream(new File(pdfFilename));  
//          baos = new ByteArrayOutputStream();  
//          PD4ML pd4ml = new PD4ML();  
//          pd4ml.setPageInsets(new Insets(10, 10, 10, 10));  
//          pd4ml.setHtmlWidth(1000);  
//          pd4ml.enableImgSplit(false);  
//          //Dimension format = PD4ML.A4;  
//          //pd4ml.setPageSize(pd4ml.changePageOrientation(format)); // landscape page orientation  
//          pd4ml.useTTF("java:fonts", true );  
//          //pd4ml.enableDebugInfo();  
//            
//          // footer if needed  
//          //PD4PageMark footer = new PD4PageMark();   
//          //footer.setPageNumberTemplate("page $[page] of $[total]");     
//          //footer.setPageNumberAlignment(PD4PageMark.RIGHT_ALIGN);     
//          //footer.setInitialPageNumber(1);     
//          //footer.setPagesToSkip(1);     
//          //footer.setFontSize(10);     
//          //footer.setAreaHeight(18);        
//          //pd4ml.setPageFooter(footer);   
//            
//            
//          pd4ml.render(isr, baos, new URL(baseurl));  
//  
//          res = baos.toByteArray();  
//      }catch(Exception e){  
//          e.printStackTrace();  
//          //try{fos.close();fos=null;}catch(Exception ee){}  
//          //fos=null;  
//          try{baos.close();baos=null;}catch(Exception ee){}  
//          baos=null;  
//      }finally{  
//          //try{fos.close();fos=null;}catch(Exception ee){}  
//          try{baos.close();baos=null;}catch(Exception ee){}  
//      }  
//  
//      return res;  
//  }  
      
    public static void main(String[] args) {  
        PDFConverter pdf = new PDFConverter();  
        pdf.processFile("d://123/", "123.pdf");  
    }  
      
    /** 
     *  
     * @param folder 生成pdf后放在哪个目录 
     * @param filename pdf的名称 
     * @param baseurl 要生成pdf的url 
     * @param jspString 要把哪个生成pdf 
     * @return 
     */  
    public boolean processFile(String folder, String filename){  
        boolean res = false;  
        InputStreamReader isr = null;  
        try{  
            File f = new File(folder);  
            if (f.isDirectory()) {  
                f.mkdir();  
            }  
            String fullfilename = folder + filename;  
           
            Success success = new Success();
            InputStream doHttpPost = Success.doHttpPost();
            
            
            isr = new InputStreamReader(doHttpPost, "UTF-8"); 
            
            OutputStream os = new FileOutputStream(fullfilename);  
            int bytesRead = 0;  
            byte[] buffer = new byte[8192];  
            while ((bytesRead = doHttpPost.read(buffer, 0, 8192)) != -1) {  
               os.write(buffer, 0, bytesRead);  
            }  
            os.close();  
            doHttpPost.close();
  
            //PDFConverter converter = new PDFConverter();  
            //String localpath = getServletContext().getInitParameter("pdfDir") + admin.getUserid() + "/" + lessonid + ".pdf";  
            //String downloadUrl = getServletContext().getInitParameter("pdfUrl") + admin.getUserid() + "/" + lessonid + ".pdf";  
              
            //res = converter.generatePDF(isr, fullfilename);  
              
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{isr.close();isr=null;}catch(Exception e){}  
        }  
  
        return res;  
          
    }  
    private Object doHttpPost() {
		// TODO Auto-generated method stub
		return null;
	}

}  