package batai.com.bottomview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.button);

    }

    public void onClick(View view){

         showDialog();

    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }

    private Dialog dialog;
    private View view;


    public void showDialog(){

        dialog=new Dialog(this, R.style.ActionSheetDialogStyle);

       view= LayoutInflater.from(this).inflate(R.layout.layout,null);

        //初始化控件
        TextView btn_web = (TextView) view.findViewById(R.id.main_pop_web);
        TextView btn_tel = (TextView) view.findViewById(R.id.main_pop_tel);
        TextView btn_address = (TextView) view.findViewById(R.id.main_pop_address);
        TextView btn_close = (TextView) view.findViewById(R.id.main_pop_cancel);


        //点击取消按钮对话框消失
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //对话框消失
                dialog.cancel();
            }
        });

        //将布局设置给Dialog
        dialog.setContentView(view);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // 设置底部宽度
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框

    }


}
