/*
* 2020.06.21
* 작성자: 안한길
* 보관함 에서 리스트를 확인 ,삭제, 추가 를 할수있도록 함
* */

package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import static com.example.myapplication.MainActivity.db_DEC;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Box extends AppCompatActivity {

    int i;
    Button[] list;
    Button[] list_delete;
    boolean delete_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box_activity_box);
        delete_check=false;
       /*
       Intent intent=getIntent();
        String userID =intent.getStringExtra("userID");유저아이디 받아옴*/
        //final String userID="idg";
        list_delete=new Button[3];
        list_delete[0] = findViewById(R.id.list1_delete);
        list_delete[1] = findViewById(R.id.list2_delete);
        list_delete[2] = findViewById(R.id.list3_delete);
        list=new Button[3];
        list[0] = findViewById(R.id.list1);
        list[1] = findViewById(R.id.list2);
        list[2] = findViewById(R.id.list3);

       Intent intent=getIntent();
        String userID =intent.getStringExtra("userID");//유저아이디 받아옴
        if(db_DEC==null)
            db_DEC = Room.databaseBuilder(this, AppDataBase.class, "ListDatabase-db").allowMainThreadQueries().build();
        final List<UserDatabase> list_DEC= db_DEC.userDatabaseDao().find_DEC(userID);
        View view = null;
        for(int i=0;i<3;i++)
        {
            if(i<list_DEC.size()) {
                list[i].setText("리스트 ");

                list_delete[i].setVisibility(view.VISIBLE);
                db_DEC.userDatabaseDao().update_num(i+1,list_DEC.get(i).getI());
            }
        }



        final AlertDialog.Builder bulider=new AlertDialog.Builder(Box.this);
        final AlertDialog.Builder bulider2=new AlertDialog.Builder(Box.this);
        final AlertDialog.Builder bulider3=new AlertDialog.Builder(Box.this);
        bulider.setMessage("삭제 하시겠습니까?.").setNegativeButton("아니오",null);
        bulider.setPositiveButton("예",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                delete_check=true;
                bulider2.create().show();
            }
        } );
        bulider2.setMessage("삭제하려면 다시 눌러주세요.");
        bulider3.setMessage("삭제 되었습니다.");
        for( i=0;i<list.length;i++) {
            list[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId()==R.id.list1){
                        if(list_delete[0].getVisibility()==view.VISIBLE) {
                            //리스트로 이동
                            Intent viewintent = new Intent(Box.this, listview.class);
                            viewintent.putExtra("userID", userID);//아이디
                            viewintent.putExtra("pk_i", list_DEC.get(0).getI());
                            Box.this.startActivity(viewintent);
                        }
                        else{
                    //리스트 추가로 넘어감
                         Intent mainintent=new Intent(Box.this,MainActivity.class);
                         mainintent.putExtra("userID",userID);//아이디
                         Box.this.startActivity(mainintent);
                        }
                    }
                    else if(view.getId()==R.id.list2){
                        if(list_delete[1].getVisibility()==view.VISIBLE) {
                            Intent viewintent = new Intent(Box.this, listview.class);
                            viewintent.putExtra("userID", userID);//아이디
                            viewintent.putExtra("pk_i", list_DEC.get(1).getI());
                            Box.this.startActivity(viewintent);
                        }
                        else {
                                //리스트 추가로 넘어감
                            Intent mainintent=new Intent(Box.this,MainActivity.class);
                            mainintent.putExtra("userID",userID);//아이디
                            Box.this.startActivity(mainintent);

                            }
                    }
                    else{
                        if(list_delete[2].getVisibility()==view.VISIBLE){
                            //리스트로 이동
                            Intent viewintent = new Intent(Box.this, listview.class);
                            viewintent.putExtra("userID", userID);//아이디
                            viewintent.putExtra("pk_i", list_DEC.get(0).getI());
                            Box.this.startActivity(viewintent);
                        }
                         else {
                                //리스트 추가로 넘어감
                            Intent mainintent=new Intent(Box.this,MainActivity.class);
                            mainintent.putExtra("userID",userID);//아이디
                            Box.this.startActivity(mainintent);

                            }
                    }
                }
            });

            list_delete[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(delete_check==false)
                        bulider.create().show();
                    if(view.getId()==R.id.list1_delete){


                        if(delete_check==true){
                            list_delete[0].setVisibility(view.INVISIBLE);
                            //리스트 삭제
                            db_DEC.userDatabaseDao().delete_dec(userID,1);
                            list[0].setText("리스트 추가");
                            bulider3.create().show();
                            delete_check=false;

                        }


                    }
                   else if(view.getId()==R.id.list2_delete){

                        if(delete_check==true){
                            list_delete[1].setVisibility(view.INVISIBLE);
                             //리스트 삭제
                            db_DEC.userDatabaseDao().delete_dec(userID,2);
                              list[1].setText("리스트 추가");
                            bulider3.create().show();
                            delete_check=false;

                        }
                    }
                    else {


                        if(delete_check==true){
                            list_delete[2].setVisibility(view.INVISIBLE);
                            //리스트 삭제
                            db_DEC.userDatabaseDao().delete_dec(userID,3);
                             list[2].setText("리스트 추가");
                            bulider3.create().show();
                            delete_check=false;

                        }
                    }

                }
            });
        }
    }
}
