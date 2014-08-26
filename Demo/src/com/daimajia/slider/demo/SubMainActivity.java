package com.daimajia.slider.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lidynast.customdialog.dialog.Effectstype;
import com.lidynast.customdialog.dialog.NiftyDialogBuilder;



public class SubMainActivity extends Activity{

    private Effectstype effect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity_main);

    }

    public void dialogShow( View v){
        NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);

        int transformerId = (int) (System.currentTimeMillis()%(Effectstype.values().length));
        for(Effectstype e: Effectstype.values()){
        	if(e.ordinal() == transformerId){
        		effect = e;
            }
        }
        

        dialogBuilder
                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFF")                                //def
                .withIcon(getResources().getDrawable(R.drawable.icon))
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .withDuration(700)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                .withButton2Text("Cancel")                                  //def gone
                .setCustomView(R.layout.custom_view,getApplicationContext())         //.setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }

    public void dialogShow(){
        NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);

        int transformerId = (int) (System.currentTimeMillis()%(Effectstype.values().length));
        for(Effectstype e: Effectstype.values()){
        	if(e.ordinal() == transformerId){
        		effect = e;
            }
        }
        

        dialogBuilder
                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFF")                                //def
                .withIcon(getResources().getDrawable(R.drawable.icon))
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .withDuration(700)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                .withButton2Text("Cancel")                                  //def gone
                .setCustomView(R.layout.custom_view,getApplicationContext())         //.setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }


    }
