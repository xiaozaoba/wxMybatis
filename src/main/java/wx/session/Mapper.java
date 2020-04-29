package wx.session;

/**
 * @author wangxun
 * @title: Mapper
 * @projectName mybatis-zdy
 * @version: 1.0.0
 * @description: sql 和 结果返回类型
 * @date 2020/4/29 10:14 上午
 */
public class Mapper {
    /**
     * sql
     */
    private String sql;
    /**
     * 结果返回类型
     */
    private String resultType;

    public Mapper(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public Mapper() {
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
