package com.google.cloud.android.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    public String[] outmessage=new String[15];
    public int[] sal=new int[15];
    public int outindex=0;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] outmessage=new String[15];
        int[] sal=new int[15];
        int outindex=0;
        setContentView(R.layout.activity_output);
        display=(TextView)findViewById(R.id.finalout);
        display.setText("");
        int count;
        for(int i=0;i<MainActivity.msgindex;i++)
        {   count=0;
            for(int j=0;j<MainActivity.entindex;j++)
            {
                if(MainActivity.message[i].toUpperCase().indexOf(MainActivity.ent[j].toUpperCase())!=-1)
                {
                    outmessage[outindex]=(outindex+1)+"."+MainActivity.message[i]+"\n";
                    sal[outindex]+=MainActivity.entsal[j];
                    count=1;
                }
            }
            if(count==1)
                outindex++;
        }
        int temp=0;
        String temp1;
        for(int i=0;i<outindex;i++)
        {
            for(int j=0;j<outindex-i-1;j++)
            {
                if(sal[j]<sal[j+1])
                {
                    temp=sal[j];
                    sal[j]=sal[j+1];
                    sal[j+1]=temp;
                    temp1=outmessage[j];
                    outmessage[j]=outmessage[j+1];
                    outmessage[j+1]=temp1;
                }
            }
        }
        for(int i=0;i<outindex;i++)
        {
            display.append(outmessage[i]);
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
