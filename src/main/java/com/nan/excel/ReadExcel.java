package com.nan.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadExcel {
    public static void main(String[] args) {
        Map<String, List<Cell[]>> map = new HashMap<String, List<Cell[]>>();
        try {
            Workbook book = Workbook.getWorkbook(new File("e://押品管理优化//押品管理优化//9月当前在库.xls"));
            // 获得第一个工作表对象
            Sheet sheet = book.getSheet(0);
            int columns = sheet.getColumns();
            int rows = sheet.getRows();
            for (int i = 1; i < rows; i++) {
                Cell cellfen = sheet.getCell(1, i);
                Cell[] cell1 = sheet.getRow(i);
                String result = cellfen.getContents();
                if (map.get(result) != null) {
                    List<Cell[]> lists = (List<Cell[]>) map.get(result);
                    lists.add(cell1);
                    map.put(result, lists);
                } else {
                    List<Cell[]> lists = new ArrayList<Cell[]>();
                    lists.add(cell1);
                    map.put(result, lists);
                }
            }

            for (Map.Entry<String, List<Cell[]>> entry : map.entrySet()) {
                String fengongsi = entry.getKey();
                List<Cell[]> lists = entry.getValue();


                String[] title = {"序号", "所属网点", "主贷人姓名", "车牌号码", "合同编号", "放款时间", "评估价格", "贷款金额", "未还本金", "逾期天数", "抵质押类型", "抵押登记办理情况", "备用钥匙数量", "是否有行驶证原件", "车库状态", "车辆情况", "逾期天数(状态变更时)", "停车地点", "办理时间", "经办人", "备注", "填表人", "填表时间", "还款状态"};

                File file = new File("E://押品管理优化//tmpfile//" + fengongsi+".xls");
                file.createNewFile();
                WritableWorkbook wwb;
                OutputStream os = new FileOutputStream(file.getPath());
                wwb = Workbook.createWorkbook(os);
                WritableSheet sonsheet = wwb.createSheet("押品入库台帐表", 0);
                Label label = null;
                for (int i = 0; i < title.length; i++) {
                    // 在Label对象的子对象中指明单元格的位置和内容
                    label = new Label(i, 0, title[i]);
                    // 将定义好的单元格添加到工作表中
                    sonsheet.addCell(label);
                }
                int num = 0;

                for (int j = 0; j < lists.size(); j++) {
                    num++;
                    for (int i = 0; i < 24; i++) {
                        Cell[] cells = lists.get(j);
                        sonsheet.addCell(new Label(i, num, cells[i].getContents()));
                    }
                }
                // 写入数据
                wwb.write();
                // 关闭文件
                wwb.close();
                os.flush();
                os.close();
            }
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
