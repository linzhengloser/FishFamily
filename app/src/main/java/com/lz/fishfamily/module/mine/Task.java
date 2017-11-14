package com.lz.fishfamily.module.mine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/12
 *     desc   : 任务
 *     version: 1.0
 * </pre>
 */
public class Task implements Parcelable {


    /**
     * Name : 签到1次
     * TotalNumber : 1
     * Type : 0
     * YuDou : 5
     * Explain : 在我的首页中签到1次
     * Empirical : 5
     * State : 1
     * Number : 1
     */

    private String Name;
    private int TotalNumber;
    private int Type;
    private int YuDou;
    private String Explain;
    private int Empirical;
    private int State;
    private int Number;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTotalNumber() {
        return TotalNumber;
    }

    public void setTotalNumber(int TotalNumber) {
        this.TotalNumber = TotalNumber;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public int getYuDou() {
        return YuDou;
    }

    public void setYuDou(int YuDou) {
        this.YuDou = YuDou;
    }

    public String getExplain() {
        return Explain;
    }

    public void setExplain(String Explain) {
        this.Explain = Explain;
    }

    public int getEmpirical() {
        return Empirical;
    }

    public void setEmpirical(int Empirical) {
        this.Empirical = Empirical;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeInt(this.TotalNumber);
        dest.writeInt(this.Type);
        dest.writeInt(this.YuDou);
        dest.writeString(this.Explain);
        dest.writeInt(this.Empirical);
        dest.writeInt(this.State);
        dest.writeInt(this.Number);
    }

    public Task() {
    }

    protected Task(Parcel in) {
        this.Name = in.readString();
        this.TotalNumber = in.readInt();
        this.Type = in.readInt();
        this.YuDou = in.readInt();
        this.Explain = in.readString();
        this.Empirical = in.readInt();
        this.State = in.readInt();
        this.Number = in.readInt();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
