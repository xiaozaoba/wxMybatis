package wx.entity;

/**
 * @author wangxun
 * @title: Address
 * @projectName mybatis-demo2020424
 * @version: 1.0.0
 * @description: TODO
 * @date 2020/4/27 11:55 上午
 */

public class Address {
    private Integer id;
    private String name;
    private String full;
    private String mobilephone;

    public Address() {
    }

    public Address(Integer id, String name, String full, String mobilephone) {
        this.id = id;
        this.name = name;
        this.full = full;
        this.mobilephone = mobilephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", full='" + full + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                '}';
    }
}
