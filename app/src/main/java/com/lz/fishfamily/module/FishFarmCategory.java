package com.lz.fishfamily.module;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class FishFarmCategory {


    /**
     * FishCategory_ID : 7d1954c0-e488-4b25-a23d-d8917a9fe834
     * FishCategory_Name : 世界巅峰
     * FishCategory_Sort : 6
     * FishCategory_Type : 0
     */

    private String FishCategory_ID;
    private String FishCategory_Name;
    private int FishCategory_Sort;
    private int FishCategory_Type;
    private String FishCategory_Describe;

    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public FishFarmCategory setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public String getFishCategory_Describe() {
        return FishCategory_Describe;
    }

    public FishFarmCategory setFishCategory_Describe(String fishCategory_Describe) {
        FishCategory_Describe = fishCategory_Describe;
        return this;
    }

    public String getFishCategory_ID() {
        return FishCategory_ID;
    }

    public void setFishCategory_ID(String FishCategory_ID) {
        this.FishCategory_ID = FishCategory_ID;
    }

    public String getFishCategory_Name() {
        return FishCategory_Name;
    }

    public void setFishCategory_Name(String FishCategory_Name) {
        this.FishCategory_Name = FishCategory_Name;
    }

    public int getFishCategory_Sort() {
        return FishCategory_Sort;
    }

    public void setFishCategory_Sort(int FishCategory_Sort) {
        this.FishCategory_Sort = FishCategory_Sort;
    }

    public int getFishCategory_Type() {
        return FishCategory_Type;
    }

    public void setFishCategory_Type(int FishCategory_Type) {
        this.FishCategory_Type = FishCategory_Type;
    }
}
