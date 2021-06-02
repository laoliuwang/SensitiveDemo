package com.cw;

import java.math.BigDecimal;


public class ObjectVo implements Cloneable {

    private BigDecimal total = BigDecimal.ZERO;

    private String name;
    private BigDecimal availiable = BigDecimal.ZERO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAvailiable() {
        return availiable;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
