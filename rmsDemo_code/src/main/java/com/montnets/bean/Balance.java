package com.montnets.bean;

/**
 * 余额详情
 * @author montnets
 */
public class Balance {

    /**
     * 计费类型
     */
    private Integer chgtp;

    /**
     * 条数
     */
    private String amount;

    /**
     * 金额
     */
    private String money;

    public Integer getChgtp() {
        return chgtp;
    }

    public void setChgtp(Integer chgtp) {
        this.chgtp = chgtp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
