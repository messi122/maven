package cn.comico.erp.commons.common;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName POIUtil
 * @Description TODO
 * @Author LuckyQi
 * @Date 2018/8/15 10:17
 * @Version 1.0
 */
public class POIUtil {

    /**
     * 解析excel格式文件
     * resolveExcel:().
     * TODO().
     *
     * @author zhiwutu
     * @param file excel文件
     * @param num sheet工作簿名称
     * @return
     * @since JDK 1.8
     */
    public static List<Map<String, Object>> resolveExcel(File file, int num){
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            Workbook work = null;
            try {
                work = new XSSFWorkbook(file);
            } catch (Exception e) {
                InputStream in = new FileInputStream(file);
                work = new HSSFWorkbook(in);
                in.close();
            }
            Sheet sheet = work.getSheetAt(num);
            for(Row row : sheet) {
                int index = row.getRowNum();
                if(index == 0) {
                    continue;
                }

                Map<String, Object> rows = new HashMap<>();
                for(int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(null != cell) {
                        switch (cell.getCellTypeEnum()) {
                            //字符串
                            case STRING:
                                rows.put("cell"+i, cell.getStringCellValue());
                                break;
                            //数字、日期
                            case NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    rows.put("cell"+i, cn.comico.erp.commons.common.DateUtil.format(cell.getDateCellValue(), "yyyy-MM-dd"));
                                } else {
                                    rows.put("cell"+i, new DecimalFormat("0").format(cell.getNumericCellValue()));
                                }
                                break;
                            //boolean
                            case BOOLEAN:
                                rows.put("cell"+i, cell.getBooleanCellValue());
                                break;
                            //公式
                            case FORMULA:
                                rows.put("cell"+i, cell.getCellFormula());
                                break;
                            //空值
                            case BLANK:
                                rows.put("cell"+i, "");
                                break;
                            //故障
                            case ERROR:
                                rows.put("cell"+i, "故障");
                                break;
                            default:
                                rows.put("cell"+i, "未知类型");
                                break;
                        }
                    } else {
                        rows.put("cell" + i, "");
                    }
                }
                data.add(rows);
                work.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


    public static List<Map<String, Object>> resolveExcelForOrder(InputStream stream, int num){
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            Workbook work = null;
            //手动判断输入流
            String name = stream.getClass().getName();
            System.out.println(name);
            if(name.contains("ByteArrayInputStream")) {
                work = new XSSFWorkbook(stream);
            } else if(name.contains("FileInputStream")) {
                work = new HSSFWorkbook(stream);
            }

            Sheet sheet = work.getSheetAt(num);
            for(Row row : sheet) {
                int index = row.getRowNum();
                if(index == 0) {
                    continue;
                }

                Map<String, Object> rows = new HashMap<>();
                for(int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(null != cell) {
                        switch (cell.getCellTypeEnum()) {
                            //字符串
                            case STRING:
                                rows.put("cell"+i, cell.getStringCellValue());
                                break;
                            //数字、日期
                            case NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    rows.put("cell"+i, cn.comico.erp.commons.common.DateUtil.format(cell.getDateCellValue(), "yyyy-MM-dd"));
                                } else {
                                    rows.put("cell"+i, new DecimalFormat("0.00").format(cell.getNumericCellValue()));
                                }
                                break;
                            //boolean
                            case BOOLEAN:
                                rows.put("cell"+i, cell.getBooleanCellValue());
                                break;
                            //公式
                            case FORMULA:
                                rows.put("cell"+i, cell.getCellFormula());
                                break;
                            //空值
                            case BLANK:
                                rows.put("cell"+i, "");
                                break;
                            //故障
                            case ERROR:
                                rows.put("cell"+i, "故障");
                                break;
                            default:
                                rows.put("cell"+i, "未知类型");
                                break;
                        }
                    } else {
                        rows.put("cell" + i, "");
                    }
                }
                data.add(rows);
                work.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != stream) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }


    /**
     *
     * resolveExcel:().
     * TODO().
     *
     * @author zhiwutu
     * @param stream
     * @param num sheet工作簿名称
     * @return
     * @since JDK 1.8
     */
    public static List<Map<String, Object>> resolveExcel(InputStream stream, int num){
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            Workbook work = WorkbookFactory.create(stream);
			/*try {
				work = new HSSFWorkbook(stream);
			} catch (Exception e) {
				work = new XSSFWorkbook(stream);
			} */
            Sheet sheet = work.getSheetAt(num);
            for(Row row : sheet) {
                int index = row.getRowNum();
                if(index == 0) {
                    continue;
                }

                Map<String, Object> rows = new HashMap<>();
                for(int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(null != cell) {
                        switch (cell.getCellTypeEnum()) {
                            //字符串
                            case STRING:
                                rows.put("cell"+i, cell.getStringCellValue());
                                break;
                            //数字、日期
                            case NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    rows.put("cell"+i, cn.comico.erp.commons.common.DateUtil.format(cell.getDateCellValue(), "yyyy-MM-dd"));
                                } else {
                                    rows.put("cell"+i, new DecimalFormat("0.00").format(cell.getNumericCellValue()));
                                }
                                break;
                            //boolean
                            case BOOLEAN:
                                rows.put("cell"+i, cell.getBooleanCellValue());
                                break;
                            //公式
                            case FORMULA:
                                rows.put("cell"+i, cell.getCellFormula());
                                break;
                            //空值
                            case BLANK:
                                rows.put("cell"+i, "");
                                break;
                            //故障
                            case ERROR:
                                rows.put("cell"+i, "故障");
                                break;
                            default:
                                rows.put("cell"+i, "未知类型");
                                break;
                        }
                    } else {
                        rows.put("cell" + i, "");
                    }
                }
                data.add(rows);
                work.close();
            }

        } catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != stream) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static List<List<Object>> resoExcelForPlan(InputStream stream, int num){
        List<List<Object>> data = new ArrayList<>();
        try {
            Workbook work = null;
            //手动判断输入流
            String name = stream.getClass().getName();
            if(name.contains("ByteArrayInputStream")) {
                work = new XSSFWorkbook(stream);
            } else if(name.contains("FileInputStream")) {
                work = new HSSFWorkbook(stream);
            }
            Sheet sheet = work.getSheetAt(num);
            for(Row row : sheet) {
                List<Object> array = new ArrayList<>();
                for(int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(null != cell) {
                        switch (cell.getCellTypeEnum()) {
                            //字符串
                            case STRING:
                                array.add(cell.getStringCellValue());
                                break;
                            //数字、日期
                            case NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    array.add(cn.comico.erp.commons.common.DateUtil.format(cell.getDateCellValue(), "yyyy-MM-dd"));
                                } else {
                                    array.add(new DecimalFormat("0").format(cell.getNumericCellValue()));
                                }
                                break;
                            //boolean
                            case BOOLEAN:
                                array.add(cell.getBooleanCellValue());
                                break;
                            //公式
                            case FORMULA:
                                array.add(cell.getCellFormula());
                                break;
                            //空值
                            case BLANK:
                                array.add("0");
                                break;
                            //故障
                            case ERROR:
                                array.add("0");
                                break;
                            default:
                                array.add("0");
                                break;
                        }
                    } else {
                        array.add("0");
                    }
                }
                data.add(array);
                work.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


    public static List<List<Object>> resoExcel(InputStream stream, int num){
        List<List<Object>> data = new ArrayList<>();
        try {
            Workbook work = WorkbookFactory.create(stream);
			/*try {
				work = new XSSFWorkbook(stream);
			} catch (Exception e) {
				work = new HSSFWorkbook(stream);
			} finally {
				if(null != stream) {
					stream.close();
				}
			}*/
            Sheet sheet = work.getSheetAt(num);
            for(Row row : sheet) {
                List<Object> array = new ArrayList<>();
                for(int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(null != cell) {
                        switch (cell.getCellTypeEnum()) {
                            //字符串
                            case STRING:
                                array.add(cell.getStringCellValue());
                                break;
                            //数字、日期
                            case NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    array.add(cn.comico.erp.commons.common.DateUtil.format(cell.getDateCellValue(), "yyyy-MM-dd"));
                                } else {
                                    array.add(new DecimalFormat("0").format(cell.getNumericCellValue()));
                                }
                                break;
                            //boolean
                            case BOOLEAN:
                                array.add(cell.getBooleanCellValue());
                                break;
                            //公式
                            case FORMULA:
                                array.add(cell.getCellFormula());
                                break;
                            //空值
                            case BLANK:
                                array.add("0");
                                break;
                            //故障
                            case ERROR:
                                array.add("0");
                                break;
                            default:
                                array.add("0");
                                break;
                        }
                    } else {
                        array.add("0");
                    }
                }
                data.add(array);
                work.close();
            }

        } catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            if(null != stream) {
                try {
                    stream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        return data;
    }





    public static void exportExcel(HttpServletRequest request, HttpServletResponse response, List<List<Object>> content, String fileName, String sheetName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");// 定义输出类型
            response.setHeader("Cache-Control", "no-store");
            //获取浏览器类型
            String user_agent = request.getHeader("User-Agent").toLowerCase();
            //为不同的浏览器，对文件名进行不同的编码转换

            if(user_agent.indexOf("firefox") > 0){
                fileName =  new String(fileName.getBytes("UTF-8"), "iso8859-1");
            }else{
                fileName = URLEncoder.encode(fileName, "UTF-8");
            }
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");  // 设定输出文件头
            response.setCharacterEncoding("utf-8");

            //单元格样式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment( HorizontalAlignment.CENTER);
            HSSFFont font1 = workbook.createFont();
            HSSFFont font2 = workbook.createFont();
            font1.setFontName("宋体");
            font2.setFontName("宋体");
            //建立新的sheet对象（excel的表单）
            HSSFSheet sheet = workbook.createSheet(sheetName);
//            //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
//            HSSFRow row1=sheet.createRow(0);
//            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
//            HSSFCell cell = row1.createCell(0);
//            //设置单元格内容
//            cell.setCellValue("dfsdf");
//            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
//            sheet.addMergedRegion(new CellRangeAddress(0 , 0, 0, 6));
            if(null != content && content.size() > 0) {
                for(int i = 0; i < content.size(); i++) {
                    if(i == 0) {
                        font1.setFontHeightInPoints((short)14);
                        font1.setBold(true);
                        cellStyle.setFont(font1);
                    } else if(i == 1) {
                        cellStyle = workbook.createCellStyle();
                        cellStyle.setAlignment(HorizontalAlignment.CENTER);
                        font2.setFontHeightInPoints((short)12);
                        cellStyle.setFont(font2);
                    }
                    HSSFRow row = sheet.createRow(i);
                    for(int j = 0; j < content.get(i).size(); j++) {
//            			sheet.setColumnWidth(j, content.get(i).getString(j).getBytes().length * 2 * 256 > 0 ? content.get(i).getString(j).getBytes().length * 2 * 256 + 800 : 2000);
                        sheet.setColumnWidth(j, 256*20+184);
                        row.createCell(j).setCellStyle(cellStyle);
                        row.getCell(j).setCellValue(content.get(i).get(j).toString());
                    }
                }
            }

            //输出流
            workbook.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != workbook) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }




	public static void main(String[] args) {
		//创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //在sheet里创建第二行
        HSSFRow row2=sheet.createRow(1);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)20);
        cellStyle.setFont(font);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.getCell(0).setCellStyle(cellStyle);

        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");
        //在sheet里创建第三行
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);
        //.....省略部分代码

        File file = new File("D:/export3.xls");
        try {
        	FileOutputStream out = new FileOutputStream(file);
//			wb.write(new File("D:/export.xlsx"));
			wb.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	/*public static void main(String[] args) throws IOException, InvalidFormatException {
		String path1 = "C:\\Users\\win 10\\Desktop\\订货会表格1.xlsx";
		String path2 = "C:\\Users\\win 10\\Desktop\\高美高2018年春季订货会.xlsx";
		String path3 = "C:\\Users\\win 10\\Desktop\\1.xls";
		File file = new File(path1);

		FileInputStream stream = new FileInputStream(file);

		List<Map<String, Object>> excel = resolveExcel(stream, 0);
		System.out.println(excel);


	}*/

}
