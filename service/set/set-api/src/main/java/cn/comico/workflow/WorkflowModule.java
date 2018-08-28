package cn.comico.workflow;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkflowModule
 * @Description TODO 流程模块枚举
 * @date 2018/8/8 10:15
 **/
public enum WorkflowModule {

    INFO(7l, "基本资料"),

    SUPPLY(3l, "供应链"),

    STORE(2l, "仓库");

    private Long id;

    private String name;

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

    WorkflowModule(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
