package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Product
 * @Description TODO
 * @date 2018/7/16 18:28
 **/
@Entity
@Table(name = "t_product")
public class Product implements Serializable {

    private static final long serialVersionUID = -1905774317012337730L;

    public static final int STATUS_CHECKING                             = 0;       //待审核
    public static final int STATUS_CHECK_NOT_PASS                       = 1;        //不通过
    public static final int STATUS_CHECK_PASS                           = 2;        //已通过

    public static final int PRICE_STATUS_NOT_INPUT                      = 0;         //未录入价格
    public static final int PRICE_STATUS_CHECKING                       = 1;        //待审核
    public static final int PRICE_STATUS_CHECK_NOT_PASS                 = 2;        //不通过
    public static final int PRICE_STATUS_CHECK_PASS                     = 3;        //已通过

    public static final int STATUS_ENABLE                               = 0;                //启用
    public static final int STATUS_DISABLE                              = 1;                //禁用


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 条码
     */
    @Column(name = "code")
    private String code;

    /**
     * 品牌
     */
    @Column(name = "brand")
    private String brand;

    /**
     * 图片
     */
    @Column(name = "img")
    private String img;

    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 颜色
     */
    @Column(name = "color")
    private String color;

    /**
     * 尺寸
     */
    @Column(name = "size")
    private String size;

    /**
     * 年份
     */
    @Column(name = "year")
    private int year;

    /**
     * 款号
     */
    @Column(name = "style")
    private String style;

    /**
     * 系列
     */
    @Column(name = "series")
    private String series;

    /**
     * 包型
     */
    @Column(name = "package_type")
    private String packageType;

    /**
     * 五金
     */
    @Column(name = "hardware")
    private String hardware;

    /**
     * 面料
     */
    @Column(name = "material")
    private String material;

    /**
     * 工艺特技
     */
    @Column(name = "skil")
    private String skil;

    /**
     * 功能
     */
    @Column(name = "function")
    private String function;

    /**
     * 季节
     */
    @Column(name = "season")
    private String season;

    /**
     * 上市时间
     */
    @Column(name = "sale_date")
    private Date saleDate;

    /**
     * 吊牌价1
     */
    @Column(name = "dp1")
    private int dp1;

    /**
     * 吊牌价2
     */
    @Column(name = "dp2")
    private int dp2;

    /**
     * 购货价
     */
    @Column(name = "purchasePrice")
    private String purchasePrice;

    /**
     * 开启折扣
     */
    @Column(name = "enable_discount")
    private int enableDiscount;

    /**
     * 创建人
     */
    @Column(name = "create_person")
    private String createPerson;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createDate;

    /**
     * 审核状态
     */
    @Column(name = "check_status", columnDefinition = "tinyint")
    private int checkStatus;

    /**
     * 价格审核人
     */
    @Column(name = "price_create_person")
    private String priceCreatePerson;

    /**
     * 价格审核状态
     */
    @Column(name = "price_check_status", columnDefinition = "tinyint")
    private int priceCheckStatus;

    @Column(name = "r1")
    private String r1;

    @Column(name = "r2")
    private String r2;

    @Column(name = "r3")
    private String r3;

    @Column(name = "r4")
    private String r4;

    @Column(name = "r5")
    private String r5;

    @Column(name = "r6")
    private String r6;

    @Column(name = "r7")
    private String r7;

    @Column(name = "r8")
    private String r8;

    @Column(name = "r9")
    private String r9;

    @Column(name = "r10")
    private String r10;

    @Column(name = "r11")
    private String r11;

    @Column(name = "r12")
    private String r12;

    @Column(name = "r13")
    private String r13;

    @Column(name = "r14")
    private String r14;

    @Column(name = "r15")
    private String r15;

    @Column(name = "r16")
    private String r16;

    @Column(name = "r17")
    private String r17;

    @Column(name = "r18")
    private String r18;

    @Column(name = "r19")
    private String r19;

    @Column(name = "r20")
    private String r20;

    @Column(name = "d1")
    private int d1;

    @Column(name = "d2")
    private int d2;

    @Column(name = "d3")
    private int d3;

    @Column(name = "d4")
    private int d4;

    @Column(name = "d5")
    private int d5;

    @Column(name = "d6")
    private int d6;

    @Column(name = "d7")
    private int d7;

    @Column(name = "d8")
    private int d8;

    @Column(name = "d9")
    private int d9;

    @Column(name = "d10")
    private int d10;

    @Column(name = "status", columnDefinition = "tinyint")
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSkil() {
        return skil;
    }

    public void setSkil(String skil) {
        this.skil = skil;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getDp1() {
        return dp1;
    }

    public void setDp1(int dp1) {
        this.dp1 = dp1;
    }

    public int getDp2() {
        return dp2;
    }

    public void setDp2(int dp2) {
        this.dp2 = dp2;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getEnableDiscount() {
        return enableDiscount;
    }

    public void setEnableDiscount(int enableDiscount) {
        this.enableDiscount = enableDiscount;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getPriceCreatePerson() {
        return priceCreatePerson;
    }

    public void setPriceCreatePerson(String priceCreatePerson) {
        this.priceCreatePerson = priceCreatePerson;
    }

    public int getPriceCheckStatus() {
        return priceCheckStatus;
    }

    public void setPriceCheckStatus(int priceCheckStatus) {
        this.priceCheckStatus = priceCheckStatus;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String getR5() {
        return r5;
    }

    public void setR5(String r5) {
        this.r5 = r5;
    }

    public String getR6() {
        return r6;
    }

    public void setR6(String r6) {
        this.r6 = r6;
    }

    public String getR7() {
        return r7;
    }

    public void setR7(String r7) {
        this.r7 = r7;
    }

    public String getR8() {
        return r8;
    }

    public void setR8(String r8) {
        this.r8 = r8;
    }

    public String getR9() {
        return r9;
    }

    public void setR9(String r9) {
        this.r9 = r9;
    }

    public String getR10() {
        return r10;
    }

    public void setR10(String r10) {
        this.r10 = r10;
    }

    public String getR11() {
        return r11;
    }

    public void setR11(String r11) {
        this.r11 = r11;
    }

    public String getR12() {
        return r12;
    }

    public void setR12(String r12) {
        this.r12 = r12;
    }

    public String getR13() {
        return r13;
    }

    public void setR13(String r13) {
        this.r13 = r13;
    }

    public String getR14() {
        return r14;
    }

    public void setR14(String r14) {
        this.r14 = r14;
    }

    public String getR15() {
        return r15;
    }

    public void setR15(String r15) {
        this.r15 = r15;
    }

    public String getR16() {
        return r16;
    }

    public void setR16(String r16) {
        this.r16 = r16;
    }

    public String getR17() {
        return r17;
    }

    public void setR17(String r17) {
        this.r17 = r17;
    }

    public String getR18() {
        return r18;
    }

    public void setR18(String r18) {
        this.r18 = r18;
    }

    public String getR19() {
        return r19;
    }

    public void setR19(String r19) {
        this.r19 = r19;
    }

    public String getR20() {
        return r20;
    }

    public void setR20(String r20) {
        this.r20 = r20;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }

    public int getD4() {
        return d4;
    }

    public void setD4(int d4) {
        this.d4 = d4;
    }

    public int getD5() {
        return d5;
    }

    public void setD5(int d5) {
        this.d5 = d5;
    }

    public int getD6() {
        return d6;
    }

    public void setD6(int d6) {
        this.d6 = d6;
    }

    public int getD7() {
        return d7;
    }

    public void setD7(int d7) {
        this.d7 = d7;
    }

    public int getD8() {
        return d8;
    }

    public void setD8(int d8) {
        this.d8 = d8;
    }

    public int getD9() {
        return d9;
    }

    public void setD9(int d9) {
        this.d9 = d9;
    }

    public int getD10() {
        return d10;
    }

    public void setD10(int d10) {
        this.d10 = d10;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
