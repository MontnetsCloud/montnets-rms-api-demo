package com.montnets.bean.response.balance;

import com.montnets.bean.Balance;
import com.montnets.bean.response.BaseResponse;

import java.util.List;

/**
 * @author montnets
 */
public class BalanceResponse extends BaseResponse {

    /**
     * 余额详情数组
     */
    private List<Balance> balance;

    public List<Balance> getBalance() {
        return balance;
    }

    public void setBalance(List<Balance> balance) {
        this.balance = balance;
    }
}
