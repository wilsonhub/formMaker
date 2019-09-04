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
import org.wilsonapps.formmaker.model.FormWidgetPickerMulti;

import java.util.ArrayList;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerMultiViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormWidget mFormWidget;
    private FormWidgetPickerMulti mFormWidgetPickerMulti;
    private int mPosition;

    public FormWidgetPickerMultiViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.FormWidgetValue);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormWidget FormWidget, final Context context) {
        mFormWidget = FormWidget;
        mPosition = position;
        mFormWidgetPickerMulti = (FormWidgetPickerMulti) mFormWidget;

        mTextViewTitle.setText(FormWidget.getTitle());
        mEditTextValue.setText(FormWidget.getValue());
        mEditTextValue.setHint(FormWidget.getHint());
        mEditTextValue.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[mFormWidgetPickerMulti.getOptions().size()];
        final boolean[] optionsSelected = new boolean[mFormWidgetPickerMulti.getOptions().size()];
        final ArrayList<Integer> mSelectedItems = new ArrayList();

        for (int i = 0; i < mFormWidgetPickerMulti.getOptions().size(); i++) {
            options[i] = mFormWidgetPickerMulti.getOptions().get(i);
            optionsSelected[i] = false;

            if (mFormWidgetPickerMulti.getOptionsSelected().contains(options[i])) {
                optionsSelected[i] = true;
                mSelectedItems.add(i);
            }
        }

        // prepare the dialog
        final AlertDialog dialog  = new AlertDialog.Builder(context)
                .setTitle(mFormWidgetPickerMulti.getPickerTitle())
                .setMultiChoiceItems(options, optionsSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton(mFormWidgetPickerMulti.getPositiveText(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String s = "";
                        for (int i = 0; i < mSelectedItems.size(); i++) {
                            s += options[mSelectedItems.get(i)];

                            if (i < mSelectedItems.size() - 1) {
                                s += ", ";
                            }
                        }
                        mEditTextValue.setText(s);
                        mReloadListener.updateValue(position, s);
                    }
                })
                .setNegativeButton(mFormWidgetPickerMulti.getNegativeText(), null)
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
