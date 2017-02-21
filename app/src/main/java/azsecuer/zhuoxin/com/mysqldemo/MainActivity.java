package azsecuer.zhuoxin.com.mysqldemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add,updata,findone,findall,deleteone,deleteall;
    private TextView textView;
    private MyExpress myExpress;
    private List<People> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myExpress =  new MyExpress(this);
        list=new ArrayList<>();
        initdata();
        add= (Button) findViewById(R.id.bt_add);
        updata= (Button) findViewById(R.id.bt_updata);
        findone= (Button) findViewById(R.id.bt_findone);
        findall= (Button) findViewById(R.id.bt_findall);
        deleteone= (Button) findViewById(R.id.deleteone);
        deleteall= (Button) findViewById(R.id.deleteall);
        textView= (TextView) findViewById(R.id.textview);
        add.setOnClickListener(this);
        findone.setOnClickListener(this);
        findall.setOnClickListener(this);
        deleteone.setOnClickListener(this);
        deleteall.setOnClickListener(this);
        updata.setOnClickListener(this);
    }

    private void initdata() {
        if(myExpress.findall().size()==0){
            myExpress.add(new People("yh","20","女"));
            myExpress.add(new People("yhh","21","男"));
            myExpress.add(new People("hyh","27","女"));
            myExpress.add(new People("yhh","24","男"));
            myExpress.add(new People("yyh","28","女"));
            myExpress.add(new People("yhy","19","男"));
        }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_add:
                myExpress.add(new People("lfy","20","男"));
                break;
            case R.id.bt_updata:
                myExpress.updata("yhy",new People("hhy","10","女"));
                break;
            case R.id.bt_findone:
                list=myExpress.findone("yh");
                textView.setText(list.toString());
                break;
            case R.id.bt_findall:
                list=myExpress.findall();
                textView.setText(list.toString());
                break;
            case R.id.deleteone:
                myExpress.deleteone("yyh");
                break;
            case R.id.deleteall:
                myExpress.deleteall();
                break;
        }
    }
}
