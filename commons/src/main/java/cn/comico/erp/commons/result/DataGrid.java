package cn.comico.erp.commons.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 表格数据载体
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataGrid<T> implements Serializable {

    private long total;

    private List<T> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public DataGrid () {

    }

    public DataGrid(long total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }
}
