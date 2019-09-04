package org.wilsonapps.formmaker.viewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.listener.ReloadListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;
import org.wilsonapps.formmaker.model.FormWidgetPickerSingle;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerSingleViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormWidget mFormWidget;
    private FormWidgetPickerSingle mFormWidgetPickerSingle;
    private int mPosition;

    public FormWidgetPickerSingleViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.FormWidgetValue);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormWidget FormWidget, final Context context) {
        mFormWidget = FormWidget;
        mPosition = position;
        mFormWidgetPickerSingle = (FormWidgetPickerSingle) mFormWidget;

        mTextViewTitle.setText(FormWidget.getTitle());
        mEditTextValue.setText(FormWidget.getValue());
        mEditTextValue.setHint(FormWidget.getHint());
        mEditTextValue.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[mFormWidgetPickerSingle.getOptions().size()];
        for (int i = 0; i < mFormWidgetPickerSingle.getOptions().size(); i++) {
            options[i] = mFormWidgetPickerSingle.getOptions().get(i);
        }

        final AlertDialog dialog = new AlertDialog.Builder(context)
            .setTitle(mFormWidgetPickerSingle.getPickerTitle())
            .setItems(options, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    mEditTextValue.setText(options[which]);
                    mFormWidgetPickerSingle.setValue(options[which].toString());
                    mReloadListener.updateValue(position, options[which].toString());
                }
            })
            .create();

        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

}
