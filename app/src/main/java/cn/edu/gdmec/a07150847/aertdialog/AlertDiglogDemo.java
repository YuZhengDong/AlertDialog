package cn.edu.gdmec.a07150847.aertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class AlertDiglogDemo extends AppCompatActivity {
    private AlertDialog dialog;
    private TextView tView;
    private AlertDialog.Builder builder;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_diglog_demo);
        tView = (TextView) this.findViewById(R.id.textView1);
        Button button1 =(Button)this.findViewById(R.id.button1);
        Button button2= (Button)this.findViewById(R.id.button2);
        Button button3=(Button)this.findViewById(R.id.button3);
        Button button4= (Button)this.findViewById(R.id.button4);
        Button button5=(Button)this.findViewById(R.id.button5);
        Button button6=(Button)this.findViewById(R.id.button6);
        Button button7= (Button)this.findViewById(R.id.button7);
        View.OnClickListener  listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;

                    case R.id.button2:
                        dialog2();
                        break;

                    case R.id.button3:
                        dialog3();
                        break;

                    case  R.id.button4:
                        dialog4();
                        break;

                    case R.id.button5:
                        dialog5();
                        break;

                    case  R.id.button6:
                        dialog6();
                        break;


                    case R.id.button7:
                        dialog7();
                        break;



                }
            }

        };


        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }

    private void dialog1() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lisr= new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                  dialog.dismiss();
                    AlertDiglogDemo.this.finish();

                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();


                }
            }
        };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", lisr);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", lisr);
            dialog.show();


    };





    private void dialog2() {
            dialog = new AlertDialog.Builder(this).create();
            dialog.setTitle("调查");
            dialog.setMessage("你平时忙吗？");
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            DialogInterface.OnClickListener fis = new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str="";
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            str="平时很忙";
                            break;
                        case DialogInterface.BUTTON_NEUTRAL:
                            str="平时一般";
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            str="平时轻松";
                            break;
                    }
                        tView.setText(str);
                }
            };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",fis);
            dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",fis);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"轻松",fis);
            dialog.show();


    };

    private void dialog3() {

        dialog= new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEid =  new EditText(this);
        dialog.setView(tEid);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    tView.setText("输入的是:"+tEid.getText().toString());
            }
        };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
            dialog.show();

    };

    private void dialog4() {

        final String it[]=new String[]{"北京","上海","广州"};
        final boolean bSl[]= new boolean[it.length];
        DialogInterface.OnMultiChoiceClickListener mLs = new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                     bSl[which]=isChecked;

            }
        };

        builder= new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(it,null,mLs);
        dialog.setTitle("复选框");

        DialogInterface.OnClickListener lisr = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    String str = "你选择了";
                    for (int i=0;i<bSl.length;i++){
                    if(bSl[i]){
                        str = str+"\n"+it[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lisr);
        dialog.show();
    };




    private void dialog5() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSel[] = new boolean[item.length];
        DialogInterface.OnClickListener SL = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    bSel[which]=true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,SL);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener LIS = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str ="你选择了:";
                for(int i=0;i<bSel.length;i++){
                    if(bSel[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",LIS);
        dialog.show();

    };

    private void dialog6() {


        final String item[]=new String[]{"北京","上海","广州"};
        final boolean Str[] = new  boolean[item.length];
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了"+item[which];
                tView.setText(str);
            }
        };


        builder = new AlertDialog.Builder(this);
        builder.setItems(item,lis);
        dialog=builder.create();
        DialogInterface.OnClickListener liss =new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",liss);
        dialog.show();
    };

    private void dialog7() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText tD = (EditText)layout.findViewById(R.id.editText1);
        dialog= new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是:"+tD.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();



    };
}
