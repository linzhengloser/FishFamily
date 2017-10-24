package com.lz.fishfamily.module.mine;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 草稿
 *     version: 1.0
 * </pre>
 */
public class Draft {

    private int icon;

    private String title;

    private String content;

    private String date;

    public Draft(int icon, String title, String content, String date) {
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getIcon() {
        return icon;
    }

    public Draft setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Draft setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Draft setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Draft setDate(String date) {
        this.date = date;
        return this;
    }
}
