package com.fengsri.restaurant.vo;

/**
 * @author fengwen
 * @date 2019/4/8 22:06
 */
public class Pager {
    public static  int PAGER_COUNT=5;//每一页的个数为5
    private int current_pager;
    private int all_pager;
    private int start_count;
    private int end_count;

    public Pager() {
    }

    public int getCurrent_pager() {
        return current_pager;
    }

    public void setCurrent_pager(int current_pager) {
        this.current_pager = current_pager;
        this.start_count = (current_pager-1)* Pager.PAGER_COUNT;
        this.end_count = (current_pager)* Pager.PAGER_COUNT;
    }

    public int getAll_pager() {
        return all_pager;
    }

    public void setAll_pager(int all_pager) {
        this.all_pager = all_pager;
    }

    public int getStart_count() {
        return start_count;
    }

    public void setStart_count(int start_count) {
        this.start_count = start_count;
    }

    public int getEnd_count() {
        return end_count;
    }

    public void setEnd_count(int end_count) {
        this.end_count = end_count;
    }
}
