package lab.oks.smtm;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import lab.oks.smtm.model.ImageCustomAdapter;

public class MenuViewActivity extends AppCompatActivity {

    ViewPager pager;
    Button currencyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);
        getSupportActionBar().setTitle("맛집이름");
        pager = (ViewPager)findViewById(R.id.pager);

        ImageCustomAdapter adapter= new ImageCustomAdapter(getLayoutInflater());
        pager.setAdapter(adapter);

        //RadioGroup azione = (RadioGroup) findViewById(R.id.radiogroup_menu);
        currencyBtn = (Button) findViewById(R.id.view_currencyBtn);
        currencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"English", "中文"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuViewActivity.this);
                builder.setTitle("언어를 선택하세요")
                        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int index){
                                Toast.makeText(getApplicationContext(), items[index], Toast.LENGTH_SHORT).show();
                                currencyBtn.setText(items[index]);
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }




}
