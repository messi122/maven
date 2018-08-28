package cn.comico.set;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_permission")
public class Permission implements GrantedAuthority {

    public static final int TYPE_MENU = 0;
    public static final int TYPE_PERMISSION = 1;

    public static final int LEVEL_PUBLIC    = -1;
    public static final int LEVEL_COMPANY   = 0;
    public static final int LEVEL_FIRST     = 1;
    public static final int LEVEL_SECOND    = 2;
    public static final int LEVEL_THIRD     = 3;
    public static final int LEVEL_SHOP      = 4;

    public static final int MENU_LEVEL_FIRST        = 1;
    public static final int MENU_LEVEL_SECOND       = 2;
    public static final int MENU_LEVEL_THIRD        = 3;

    @Id
    private Long id;

    @Column(name = "fid")
    private Long fid;

    @Column(name = "name")
    private String name;

    @Column(name = "[key]")
    private String key;

    @Column(name = "icon")
    private String icon;

    @Column(name = "url")
    private String url;

    @Column(name = "type", columnDefinition = "tinyint")
    private int type;

    @Column(name = "level", columnDefinition = "tinyint")
    private int level;

    @Column(name = "menu_level", columnDefinition = "tinyint")
    private int menuLevel;

    @Column(name = "[redirect]")
    private String redirect;

    @Column(name = "component")
    private String component;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return TYPE_MENU == type ? null : key;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getTypeMenu() {
        return TYPE_MENU;
    }

    public static int getTypePermission() {
        return TYPE_PERMISSION;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public static int getLevelPublic() {
        return LEVEL_PUBLIC;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

}
