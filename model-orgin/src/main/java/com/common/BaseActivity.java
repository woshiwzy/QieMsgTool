package com.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.task.BaseTaskJosn;
import com.cretve.model.R;
/**
 * 基础activity
 * 
 * @author:wangzhengyun 2012-8-31
 */
public class BaseActivity extends Activity implements OnProgressDialogCallback {

	public Dialog mProgressDialog = null;
	public Dialog mProgressDialog2 = null;
	private OnProgressDialogCallback mProgressDialogCallback;
	private ProgressBar mProgressBar = null;
	private ProgressBar mProgressBar2 = null;

	private AsyncTask mTaskRunning;
	private AsyncTask mTaskRunning2;

	// private ImageView imageView;
	// private Animation rotateAnimation;


	protected BaseTaskJosn baseTask;
	protected BaseTaskJosn baseTask2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		crateDialog();
		crateDialog2();
	}

	public void crateDialog() {
		mProgressDialog = new Dialog(this, R.style.dialog);
		View dialogView = View.inflate(this, R.layout.dialog_progress, null);
		mProgressBar = (ProgressBar) dialogView.findViewById(R.id.progressBarMore);
		mProgressDialog.setContentView(dialogView);
		mProgressDialog.setCancelable(true);

		mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				if (null != mTaskRunning && !mTaskRunning.isCancelled()) {
					mTaskRunning.cancel(true);
				}
			}
		});

		mProgressDialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface dialog) {

				if (null != mTaskRunning && !mTaskRunning.isCancelled()) {
					mTaskRunning.cancel(true);
				}

				if (null != mProgressDialogCallback) {
					mProgressDialogCallback.onProgressDialogcancel();
				}

			}
		});
	}


	public void crateDialog2() {
		mProgressDialog2 = new Dialog(this, R.style.dialog);
		View dialogView = View.inflate(this, R.layout.dialog_progress, null);
		mProgressBar2 = (ProgressBar) dialogView.findViewById(R.id.progressBarMore);
		mProgressDialog2.setContentView(dialogView);
		mProgressDialog2.setCancelable(true);

		mProgressDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				if (null != mTaskRunning2 && !mTaskRunning2.isCancelled()) {
					mTaskRunning2.cancel(true);
				}
			}
		});

		mProgressDialog2.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface dialog) {
				if (null != mTaskRunning2 && !mTaskRunning2.isCancelled()) {
					mTaskRunning2.cancel(true);
				}
				if (null != mProgressDialogCallback) {
					mProgressDialogCallback.onProgressDialogcancel();
				}

			}
		});
	}

	public void showProgressDialogWithTask(AsyncTask runingTask) {
		mTaskRunning = runingTask;
		showProgressDialog();
	}
	public void hideProgressDialogWithTask() {
		if (null != mTaskRunning && !mTaskRunning.isCancelled()) {
			mTaskRunning.cancel(true);
		}
		hideProgressDialog();
	}


	public void showProgressDialogWithTask2(AsyncTask runingTask) {
		mTaskRunning2 = runingTask;
		showProgressDialog2();
	}
	public void hideProgressDialogWithTask2() {
		if (null != mTaskRunning2 && !mTaskRunning2.isCancelled()) {
			mTaskRunning2.cancel(true);
		}
		hideProgressDialog2();
	}

	public Dialog getmProgressDialog() {

		return mProgressDialog;
	}


	public void setmProgressDialog(Dialog mProgressDialog) {

		this.mProgressDialog = mProgressDialog;
	}


	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// hideProgressDialog();
		super.onNewIntent(intent);
	}

	public void setDialogCancellAable(boolean isCancellAable) {
		mProgressDialog.setCancelable(isCancellAable);
	}

	/**
	 * 初始化视图
	 */
	public void initView() {

	}

	/**
	 * 丛可输入的组件中获取输入
	 * 
	 * @param id
	 * @return
	 */
	public String getInputFromId(int id) {
		EditText edit = findEditTextById(id);
		String input = edit.getText().toString();
		return input;
	}

	public String getInput(EditText input) {
		return input.getText().toString();
	}

	public TextView findTextViewById(int id) {
		return (TextView) findViewById(id);
	}

	public EditText findEditTextById(int id) {
		return (EditText) findViewById(id);
	}

	public Button findButtonById(int id) {
		return (Button) findViewById(id);
	}

	public ImageView findImageViewById(int id) {
		return (ImageView) findViewById(id);
	}

	public ImageButton findImageButtonById(int id) {
		return (ImageButton) findViewById(id);
	}

	public ListView findListViewById(int id) {
		return (ListView) findViewById(id);
	}

	public RelativeLayout findRelativeLayout(int id) {
		return (RelativeLayout) findViewById(id);
	}

	public LinearLayout findLinearLayout(int id) {
		return (LinearLayout) findViewById(id);
	}

	public AutoCompleteTextView findAutoCompleteTextById(int id) {
		return (AutoCompleteTextView) findViewById(id);
	}

	@Override
	public void onBackPressed() {
		backFinish();
		return;
	}

	// public void showProgressDialog(String title, String message,
	// boolean cancelable) {
	//
	// }

	public void showProgressDialog(boolean isCancellAble) {
		if (!isFinishing()) {
			if (isCancellAble) {
				mProgressDialog.setCancelable(true);
			} else {
				mProgressDialog.setCancelable(false);
			}
			mProgressDialog.show();
		}
	}

	public void showProgressDialog2(boolean isCancellAble) {
		if (!isFinishing()) {
			if (isCancellAble) {
				mProgressDialog2.setCancelable(true);
			} else {
				mProgressDialog2.setCancelable(false);
			}
			mProgressDialog2.show();
		}
	}
	public void showProgressDialog() {
		if (!isFinishing()) {
			showProgressDialog(true);
		}
	}

	public void showProgressDialog2() {
		if (!isFinishing()) {
			showProgressDialog2(true);
		}
	}

	public void hideProgressDialog() {
		mProgressDialog.hide();
	}
	public void hideProgressDialog2() {
		mProgressDialog2.hide();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mProgressDialog.dismiss();
		mProgressDialog2.dismiss();
	}

	public void backFinish() {
		finish();
	}

	public void backOkFinish() {
		setResult(Activity.RESULT_OK);
		finish();
	}


	@Override
	public void onProgressDialogcancel() {

	}

	public void setCancelAble(boolean isAble) {
		mProgressDialog.setCancelable(isAble);
	}

}

/**
 * 进度条回调
 * 
 * @author:wangzhengyun 2012-8-13
 */
interface OnProgressDialogCallback {
	public void onProgressDialogcancel();

}
