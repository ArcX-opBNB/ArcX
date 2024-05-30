package net.daylong.baselibrary.bean;


import net.daylong.baselibrary.utils.sys.AppUtil;

/**

 */
public class CanvasImageBean {
    private Integer width;
    private Integer height;
    private Integer imgRegId;
    private Integer rightMargin;

    public CanvasImageBean(Integer width, Integer height, Integer imgRegId, Integer rightMargin) {
        this.width = AppUtil.getSize(width);
        this.height = AppUtil.getSize(height);
        this.imgRegId = imgRegId;
        this.rightMargin = AppUtil.getSize(rightMargin);
    }

    public CanvasImageBean(float width, float height, int imgRegId) {
        this.width = AppUtil.getSize(width);
        this.height = AppUtil.getSize(height);
        this.imgRegId = imgRegId;
    }

    public CanvasImageBean(float width, float height) {
        this.width = AppUtil.getSize(width);
        this.height = AppUtil.getSize(height);
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public int getImgRegId() {
        return imgRegId;
    }

    public void setImgRegId(int imgRegId) {
        this.imgRegId = imgRegId;
    }

    public Integer getRightMargin() {
        return rightMargin ==null?AppUtil.getSize(2):rightMargin;
    }

    public void setRightMargin(Integer rightMargin) {
        this.rightMargin = rightMargin;
    }
}
