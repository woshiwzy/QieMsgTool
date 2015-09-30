package com.common.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

public class DialogUtils {

	/**
	 * 显示输入对话框
	 * @param message
	 * @param callBackListener
	 */
	public static void showInputDialog(final Activity activity, String title, String yesText, String noText, final String errTip,
			final DialogCallBackListener callBackListener) {

		final EditText editText = new EditText(activity);
		new AlertDialog.Builder(activity).setTitle(title).setIcon(android.R.drawable.ic_dialog_info).setView(editText)
				.setPositiveButton(yesText, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (null != callBackListener) {
							String alias = editText.getText().toString();
							if (!StringUtils.isEmpty(alias)) {
								dialog.dismiss();
								callBackListener.onCallBack(true, alias);
							} else {
								Tool.ToastShow(activity, errTip);
							}
						}
					}
				}).setNegativeButton(noText, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						if (null != callBackListener) {
							callBackListener.onCallBack(false, "");
						}
					}
				}).setOnCancelListener(new DialogInterface.OnCancelListener() {
					@Override
					public void onCancel(DialogInterface dialog) {
						dialog.dismiss();
					}
				}).show();
	}
}
