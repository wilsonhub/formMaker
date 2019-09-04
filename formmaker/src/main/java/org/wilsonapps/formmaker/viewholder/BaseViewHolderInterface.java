package org.wilsonapps.formmaker.viewholder;

import android.content.Context;

import org.wilsonapps.formmaker.listener.FormItemEditTextListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;


/**
 * Base ViewHolder method instance
 * Created by Wilson.
 */

public interface BaseViewHolderInterface {
    FormItemEditTextListener getListener();
    void bind(int position, BaseFormWidget FormWidget, Context context);
}
