package com.handsome.didi.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @author 许英俊 2017/6/19
 */
public class AlertUtils {

    public static ProgressDialog pd;
    private static Dialog dlg;

    /**
     * 弹出对话框
     *
     * @param context
     * @param message
     */
    public static void showAlert(Context context, String message) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("温馨提示")
                .setPositiveButton(android.R.string.ok, null)
                .setMessage(message)
                .setCancelable(true)
                .create();
        dlg.show();
    }

    /**
     * 弹出对话框，带有一个按钮
     *
     * @param context
     * @param message
     * @param positiveButtontxt
     * @param positiveListener
     */
    public static void showAlert(Context context, String message,
                                 CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("温馨提示")
                .setPositiveButton(positiveButtontxt, positiveListener)
                .setMessage(message)
                .setCancelable(true)
                .create();
        dlg.show();
    }

    /**
     * 弹出对话框，带有两个按钮
     *
     * @param context
     * @param message
     * @param positiveButtontxt
     * @param positiveListener
     * @param negativeButtontxt
     * @param negativeListener
     */
    public static void showAlert(Context context, String message,
                                 CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
                                 CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("温馨提示")
                .setPositiveButton(positiveButtontxt, positiveListener)
                .setNegativeButton(negativeButtontxt, negativeListener)
                .setMessage(message)
                .setCancelable(true)
                .create();
        dlg.show();
    }

    /**
     * 弹出多选对话框
     *
     * @param context
     * @param items
     * @param selected
     * @param multiChoiceClickListener
     */
    public static void showAlert(Context context, String[] items, boolean[] selected,
                                 DialogInterface.OnMultiChoiceClickListener multiChoiceClickListener) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("请选择")
                .setCancelable(true)
                .setMultiChoiceItems(items, selected, multiChoiceClickListener)
                .create();
        dlg.show();
    }

    /**
     * 弹出单选对话框
     *
     * @param context
     * @param items
     * @param clickListener
     */
    public static void showAlert(Context context, String[] items,
                                 DialogInterface.OnClickListener clickListener) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("请选择")
                .setCancelable(true)
                .setSingleChoiceItems(items, -1, clickListener)
                .create();
        dlg.show();
    }

    /**
     * 弹出进度条对话框
     *
     * @param context
     * @param progress
     */
    public static void showAlert(Context context, int progress) {
        if (pd == null) {
            pd = new ProgressDialog(context);
            pd.setTitle("上传中");
            pd.setCancelable(true);
            pd.setMessage("图片正在上传");
            pd.setProgress(progress);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
        } else {
            pd.setProgress(progress);
        }
    }


    /**
     * 弹出进度对话框
     *
     * @param context
     * @param title
     * @param message
     */
    public static void showAlert(Context context, String title, String message) {
        if (pd == null) {
            pd = new ProgressDialog(context);
            pd.setTitle(title);
            pd.setCancelable(true);
            pd.setMessage(message);
            pd.show();
        }
    }

    /**
     * 关闭弹窗
     */
    public static void close() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
            pd = null;
        }
    }

}
