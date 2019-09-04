package org.wilsonapps.formmaker.viewholder;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.listener.FormItemEditTextListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;


/**
 * Created by Wilson.
 */

public class FormWidgetTextPasswordViewHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    public AppCompatEditText mEditTextValue;
    public FormItemEditTextListener mFormCustomEditTextListener;

    public FormWidgetTextPasswordViewHolder(View v, FormItemEditTextListener listener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.FormWidgetValue);
        mFormCustomEditTextListener = listener;
        mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        mEditTextValue.setRawInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD| InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

    @Override
    public FormItemEditTextListener getListener() {
        return mFormCustomEditTextListener;
    }

    @Override
    public void bind(int position, BaseFormWidget FormWidget, final Context context) {
        mTextViewTitle.setText(FormWidget.getTitle());
        mEditTextValue.setText(FormWidget.getValue());
        mEditTextValue.setHint(FormWidget.getHint());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextValue.requestFocus();
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.showSoftInput(mEditTextValue, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }

}
