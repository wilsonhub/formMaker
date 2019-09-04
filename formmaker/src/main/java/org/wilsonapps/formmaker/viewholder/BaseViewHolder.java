package org.wilsonapps.formmaker.viewholder;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.wilsonapps.formmaker.listener.FormItemEditTextListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;


/**
 * Base ViewHolder for all other viewholders
 * Created by Wilson.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements BaseViewHolderInterface {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public FormItemEditTextListener getListener() {
        return null;
    }

    @Override
    public void bind(int position, BaseFormWidget FormWidget, Context context) {

    }


}
