package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PackageType
 * @Description TODO
 * @date 2018/7/13 15:22
 **/
@Entity
@Table(name = "t_package_type")
public class PackageType implements Serializable {

    private static final long serialVersionUID = -1495198005919844970L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "package_type")
    private String packageType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}
