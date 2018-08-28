package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Channel
 * @Description TODO
 * @date 2018/6/22 10:34
 **/
@Entity
@Table(name = "t_channel")
public class Channel implements Serializable {

    public static final Long COMPANY_ID     = 1l;       //公司ID

    public static final int TYPE_COMPANY    = -1;        //经销商
    public static final int TYPE_CHANNEL    = 0;        //经销商
    public static final int TYPE_SHOP       = 1;        //门店

    public static final int CATEGORY_NONE     = -1;      //公司本体
    public static final int CATEGORY_ZY     = 0;        //自营
    public static final int CATEGORY_THIRD  = 1;        //第三方

    public static final int STATUS_CHECKING = 0;        //待审核
    public static final int STATUS_NOT_PASS = 1;        //未通过
    public static final int STATUS_CHECKED = 2;         //已通过

    public static final int STATUS_ENABLE   = 0;        //启用
    public static final int STATUS_DISABLE   = 1;           //禁用


    public static final int LEVEL_COMPANY   = 0;
    public static final int LEVEL_FIRST     = 1;
    public static final int LEVEL_SECOND    = 2;
    public static final int LEVEL_THIRD     = 3;

    private static final long serialVersionUID = 1188177568451251463L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 类型(0-经销商、1-门店)
     */
    @Column(name = "type", columnDefinition = "tinyint")
    private Integer type;

    @Column(name = "fid")
    private Long fid;

    /**
     * 级别
     */
    @Column(name = "level", columnDefinition = "tinyint")
    private Integer level;

    /**
     * 经销类别（0-自营、1-第三方）
     */
    @Column(name = "category", columnDefinition = "tinyint")
    private Integer category;

    /**
     * 店铺编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 联系人
     */
    @Column(name = "linkman")
    private String linkman;

    /**
     * 电话1
     */
    @Column(name = "phone1")
    private String phone1;

    /**
     * 电话2
     */
    @Column(name = "phone2")
    private String phone2;

    /**
     * 传真
     */
    @Column(name = "fax")
    private String fax;

    /**
     * 区域
     */
    @Column(name = "area")
    private String area;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 前缀
     */
    @Column(name = "prefix")
    private String prefix;

    /**
     * 对账日
     */
    @Column(name = "check_day")
    private Integer checkDay;

    /**
     * 简介
     */
    @Column(name = "[desc]")
    private String desc;

    @Column(name = "status", columnDefinition = "tinyint")
    private Integer status;

    /**
     * 电子印章
     */
    @Column(name = "seal")
    private String seal;

    /**
     * 门店照片
     */
    @Column(name = "shop_img")
    private String shopImg;

    /**
     * 法人证件
     */
    @Column(name = "leagal_person_licenses")
    private String leagalPersonLicenses;

    /**
     * 公司证件
     */
    @Column(name = "company_licenses")
    private String companyLicenses;

    /**
     * 创建人
     */
    @Column(name = "create_person")
    private String createPerson;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 审核状态（0-待审核、1-未通过、2-已通过）
     */
    @Column(name = "check_status", columnDefinition = "tinyint")
    private Integer checkStatus;

    /**
     * 审核时间
     */
    @Column(name = "check_date")
    private Date checkDate;

    /**
     * 审核人
     */
    @Column(name = "check_person")
    private String checkPerson;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCheckDay() {
        return checkDay;
    }

    public void setCheckDay(Integer checkDay) {
        this.checkDay = checkDay;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSeal() {
        return seal;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getLeagalPersonLicenses() {
        return leagalPersonLicenses;
    }

    public void setLeagalPersonLicenses(String leagalPersonLicenses) {
        this.leagalPersonLicenses = leagalPersonLicenses;
    }

    public String getCompanyLicenses() {
        return companyLicenses;
    }

    public void setCompanyLicenses(String companyLicenses) {
        this.companyLicenses = companyLicenses;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }
}
