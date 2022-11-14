package com.pauljean.bankkata.dto;

public class StatementDto {
    private long userId;
    private int index;

    public StatementDto(long userId, int index) {
        this.userId = userId;
        this.index = index;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
