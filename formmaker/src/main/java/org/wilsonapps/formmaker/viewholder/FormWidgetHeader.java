package org.wilsonapps.formmaker.viewholder;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.model.BaseFormWidget;

/**
 * ViewHolder for Header
 * Created by Wilson.
 */

public class FormWidgetHeader extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;

    public FormWidgetHeader(View v) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
    }

    @Override
    public void bind(int position, BaseFormWidget FormWidget, final Context context) {
        mTextViewTitle.setText(FormWidget.getTitle());
    }

}
