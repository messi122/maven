package cn.comico.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetWorkflowModuleDTO
 * @Description TODO
 * @date 2018/7/4 15:40
 **/
public class SetWorkflowModuleDTO implements Serializable {

    private Long id;

    private String name;

    private String icon;

    private List<SetWorkflowDTO> setWorkflowDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SetWorkflowDTO> getSetWorkflowDTOList() {
        return setWorkflowDTOList;
    }

    public void setSetWorkflowDTOList(List<SetWorkflowDTO> setWorkflowDTOList) {
        this.setWorkflowDTOList = setWorkflowDTOList;
    }
}
