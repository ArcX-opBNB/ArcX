package net.daylong.baselibrary.base;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import net.daylong.baselibrary.bean.IUserInfo;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.img.UserIconView;


public class MyViewHolder  extends BaseViewHolder {
    public MyViewHolder(@NonNull View view) {
        super(view);
    }


    public void setImageUrl(int id, String url) {
        ((MyImageView) getView(id)).setImageUrl(url);
    }
    public void setUserIcon(int id, IUserInfo info) {
        ((UserIconView ) getView(id)).setUserImage(info);
    }

    public void setImageReg(int id, int reg) {
        ((MyImageView) getView(id)).setImageReg(reg);
    }


}
