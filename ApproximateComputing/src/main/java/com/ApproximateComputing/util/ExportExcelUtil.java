package com.ApproximateComputing.util;


import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//使用jxl包
public class ExportExcelUtil {
	private final static Logger logger = Logger.getLogger(ExportExcelUtil.class);
	private final static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	/**
	 * 导出excel
	 * 
	 * @param fileName
	 * @param exportMap
	 * @param listContent
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public final static String exportExcel(String fileName, List<String>exportList,List<String>fieldNameList,
			List<? extends Object> listContent, HttpServletResponse response) {
		String result = "success";
		// 以下开始输出到EXCEL
		try {
			long currentTimeMills=System.currentTimeMillis();
			
			// 定义输出流，以便打开保存对话框______________________begin
			// HttpServletResponse response=ServletActionContext.getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String(fileName.getBytes("GB2312"), "ISO8859-1"));
			// 设定输出文件头，可以是application/vnd.ms-excel或者application/msexcel
			response.setContentType("application/vnd.ms-excel");// 定义输出类型
			// 定义输出流，以便打开保存对话框_______________________end

			/** **********创建工作簿************ */
			WritableWorkbook workbook = Workbook.createWorkbook(os);

			

			/** ************设置单元格字体************** */
			WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
			WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

			/** ************以下设置三种单元格样式，灵活备用************ */
			// 用于标题居中
			WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
			wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_center.setWrap(false); // 文字是否换行

			// 用于正文居左
			WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
			wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
			wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
			wcf_left.setWrap(false); // 文字是否换行

			//单个sheet最多只能添加65536个cell，所以超出的部分记录需要新建sheet来存储
			//需要多少个sheet来存储
			int sheetCount=listContent.size()/60000;
			//当前写入记录位置
			int current=0;
			int z=0;
			for(;z<sheetCount;z++){
				/** ***************以下是EXCEL开头大标题，暂时省略********************* */
				// sheet.mergeCells(0, 0, colWidth, 0);
				// sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
				/** ***************以下是EXCEL第一行列标题********************* */
				
				/** **********创建工作表************ */
				WritableSheet sheet = workbook.createSheet("Sheet"+String.valueOf(z+1), 0);

				/** **********设置纵横打印（默认为纵打）、打印纸***************** */
				jxl.SheetSettings sheetset = sheet.getSettings();
				sheetset.setProtected(false);
				for (int i = 0; i < exportList.size(); i++) {
					/** **********创建单元格************ */
					//第一个参数表示某一行的第几列，从0开始；第二个参数表示第几行，从0开始
					//第三个参数表示某一行某一列的值；第四个参数表示单元格样式
					sheet.addCell(new Label(i, 0, exportList.get(i).toString(), wcf_center));
				}
				
				/** ***************以下是EXCEL正文数据********************* */
				int c = 1;
				for(;current<60000*(z+1);current++){
					int j=0;
					//利用反射找到实体的每个成员的值
					Object obj=listContent.get(current);
					String fieldNameTemp=null;
					Object value=null;
					Method method=null;
					for(Object fieldName:fieldNameList){
						fieldNameTemp="get"+fieldName.toString().substring(0,1).toUpperCase()
										+fieldName.toString().substring(1);
						method=obj.getClass().getMethod(fieldNameTemp, null);
						value=method.invoke(obj, null);
						if(value==null){
							value="";
						}
						sheet.addCell(new Label(j,c,value.toString(),wcf_left));
						j++;
					}
					c++;
				}
			}
			
			if(current<listContent.size()){
				/** ***************以下是EXCEL开头大标题，暂时省略********************* */
				// sheet.mergeCells(0, 0, colWidth, 0);
				// sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
				/** ***************以下是EXCEL第一行列标题********************* */

				WritableSheet sheet = workbook.createSheet("Sheet"+String.valueOf(z+1), 0);

				/** **********设置纵横打印（默认为纵打）、打印纸***************** */
				jxl.SheetSettings sheetset = sheet.getSettings();
				sheetset.setProtected(false);
				for (int i = 0; i < exportList.size(); i++) {
					//第一个参数表示某一行的第几列，从0开始；第二个参数表示第几行，从0开始
					//第三个参数表示某一行某一列的值；第四个参数表示单元格样式
					sheet.addCell(new Label(i, 0, exportList.get(i).toString(), wcf_center));
				}
				
				/** ***************以下是EXCEL正文数据********************* */
				int c = 1;
				for(;current<listContent.size();current++){
					int j=0;
					//利用反射找到实体的每个成员的值
					Object obj=listContent.get(current);
					String fieldNameTemp=null;
					Object value=null;
					Method method=null;
					for(Object fieldName:fieldNameList){
						fieldNameTemp="get"+fieldName.toString().substring(0,1).toUpperCase()
										+fieldName.toString().substring(1);
						method=obj.getClass().getMethod(fieldNameTemp, null);
						value=method.invoke(obj, null);
						if(value==null){
							value="";
						}
						sheet.addCell(new Label(j,c,value.toString(),wcf_left));
						j++;
					}
					c++;
				}
			}

			/** **********将以上缓存中的内容写到EXCEL文件中******** */
			workbook.write();
			/** *********关闭文件************* */
			workbook.close();
			logger.info("导出excel成功");
			System.out.println("花费时间："+(System.currentTimeMillis()-currentTimeMills)+"ms");

		} catch (Exception e) {
			result = "error";
			logger.error("导出excel失败", e);
			throw new RuntimeException();
		}
		return result;
	}
}
