package com.geo.fileoperation;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText editName;
    private EditText editInfo;
    private Button btnSave;
    private Button btnClear;
    private Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        editName = (EditText)findViewById(R.id.ed_filename);
        editInfo = (EditText)findViewById(R.id.ed_fileinfo);
        btnClear = (Button) findViewById(R.id.bt_clear);
        btnSave = (Button) findViewById(R.id.bt_input);
        btnRead = (Button) findViewById(R.id.bt_getFileInfo);

        editInfo.setOnClickListener(this);
        editInfo.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        switch(view.getId()){
        case R.id.ed_fileinfo:{

            }
            break;
        case R.id.ed_filename:{

            }
            break;
        case R.id.bt_clear: {
                editInfo.setText("");
                editName.setText("");
            }
            break;
        case R.id.bt_input:{
                FileService service = new FileService(getApplicationContext());
                String filename = editName.getText().toString();
                String filedetail = editInfo.getText().toString();
                try
                {
                    service.save(filename, filedetail);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                }catch(Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败,"+"文件名：【"+filename+"]; 文件内容：【"+filedetail+"】", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        case R.id.bt_getFileInfo:
            String detail = "";
            FileService service = new FileService(getApplicationContext());
            try
            {
                String filename = editName.getText().toString();
                detail = service.show(filename);
            }
            catch(IOException e){e.printStackTrace();}

            Toast.makeText(getApplicationContext(), detail, Toast.LENGTH_SHORT).show();
            break;
        default:
            break;
        }

    }


}
