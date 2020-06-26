package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.MainActivity.db_DEC;

public class yearof2016 extends AppCompatActivity {



    Button btn_sub;
    Button btn_basic;
    Button btn_hard;
    Button btn_nes1;
    Button btn_nes2;
    Button btn_select1;
    Button btn_select2;
    Button btn_select3;
    Button btn_save;

    TextView tv_hard;
    TextView tv_result;
    TextView tv_basic;
    TextView tv_nes1;
    TextView tv_nes2;
    TextView tv_select1;
    TextView tv_select2;
    TextView tv_select3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearof2016);

        final ArrayList<String> newDesc= new ArrayList<>();
        //버튼 및 텍스트뷰, 스크롤뷰로 보게 함
        btn_sub=(Button)findViewById(R.id.btn_sub);
        tv_result = (TextView)findViewById(R.id.tv_result);
        tv_result.setMovementMethod(new ScrollingMovementMethod());

        btn_basic=(Button)findViewById(R.id.btn_basic);
        tv_basic = (TextView)findViewById(R.id.tv_basic);
        tv_basic.setMovementMethod(new ScrollingMovementMethod());

        btn_hard=(Button)findViewById(R.id.btn_hard);
        tv_hard = (TextView)findViewById(R.id.tv_hard);
        tv_hard.setMovementMethod(new ScrollingMovementMethod());

        btn_nes1=(Button)findViewById(R.id.btn_nes1);
        tv_nes1 = (TextView)findViewById(R.id.tv_nes1);
        tv_nes1.setMovementMethod(new ScrollingMovementMethod());

        btn_nes2=(Button)findViewById(R.id.btn_nes2);
        tv_nes2 = (TextView)findViewById(R.id.tv_nes2);
        tv_nes2.setMovementMethod(new ScrollingMovementMethod());

        btn_select1=(Button)findViewById(R.id.btn_select1);
        tv_select1 = (TextView)findViewById(R.id.tv_select1);
        tv_select1 .setMovementMethod(new ScrollingMovementMethod());

        btn_select2=(Button)findViewById(R.id.btn_select2);
        tv_select2 = (TextView)findViewById(R.id.tv_select2);
        tv_select2 .setMovementMethod(new ScrollingMovementMethod());

        btn_select3=(Button)findViewById(R.id.btn_select3);
        tv_select3 = (TextView)findViewById(R.id.tv_select3);
        tv_select3 .setMovementMethod(new ScrollingMovementMethod());

        btn_save=(Button)findViewById(R.id.btn_save);
        Intent intent=getIntent();
        final String userID =intent.getStringExtra("userID");//유저아이디 받아옴

        //각 과목 별 정렬 리스트
        final List<String> selected_subitemes = new ArrayList<String>();
        final List<String> selected_basicitemes = new ArrayList<String>();
        final List<String> selected_harditemes = new ArrayList<String>();
        final List<String> selected_nes1itemes = new ArrayList<String>();
        final List<String> selected_nes2itemes = new ArrayList<String>();
        final List<String> selected_select1itemes = new ArrayList<String>();
        final List<String> selected_select2itemes = new ArrayList<String>();
        final List<String> selected_select3itemes = new ArrayList<String>();

        //특성 교양 버튼
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] sub_items = new String[]{"토익 듣기와 읽기"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");

                //boolean 리스트를 만들고 전부 false로 초기화
                ad.setMultiChoiceItems(sub_items, new boolean[]{false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            Toast.makeText(yearof2016.this,sub_items[i],Toast.LENGTH_SHORT).show();;
                            selected_subitemes.add(sub_items[i]);
                        }
                        else selected_subitemes.remove(sub_items[i]);
                    }
                });

                //확인 버튼 누르면 해당 텍스트가 입력됨
               final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sub_itemms="";
                        if(selected_subitemes.size()!=0){
                            for(String selectedsubitem : selected_subitemes){
                                sub_itemms += (selected_subitemes+",");
                            }
                        }
                        tv_result.setText("특성교양:" + sub_itemms );
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //기초 교양 버튼
        btn_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] basic_items = new String[]{"국어와 작문","Action English","영어읽기와 토론","발표와 토론","수학1","수학2","기초프로그래밍","기초통계학및실습", "맛보기물리학및실험","응용컴퓨터프로그래밍"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(basic_items, new boolean[]{false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if(b){
                            Toast.makeText(yearof2016.this,basic_items[i],Toast.LENGTH_SHORT).show();;
                            selected_basicitemes.add(basic_items[i]);
                        }
                        else selected_basicitemes.remove(basic_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String basic_itemms="";
                        if(selected_basicitemes.size()!=0){

                            for(String selectedsubitem : selected_basicitemes){
                                basic_itemms = (selected_basicitemes+",");
                                tv_basic.setText("기초교양:" + basic_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //심화 교양 버튼
        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] hard_items = new String[]{"언어로의 초대","동양문화사","공업경영과 경제","공학윤리와 역사"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(hard_items, new boolean[]{false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if(b){
                            Toast.makeText(yearof2016.this,hard_items[i],Toast.LENGTH_SHORT).show();;
                            selected_harditemes.add(hard_items[i]);
                        }
                        else selected_harditemes.remove(hard_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String hard_itemms="";
                        if(selected_harditemes.size()!=0){

                            for(String selectedharditem : selected_harditemes){
                                hard_itemms = (selected_harditemes+",");
                                tv_hard.setText("심화교양:" + hard_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //전공 필수 버튼
        btn_nes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] nes1_items = new String[]{"컴퓨터시스템개론","논리회로 및 실험","자료구조","컴퓨터 구조","프로그래밍언어론","운영체제","객체지향 설계","알고리즘","소프트웨어공학","캡스톤 디자인1"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(nes1_items, new boolean[]{false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            selected_nes1itemes.add(nes1_items[i]);
                        }
                        else selected_nes1itemes.remove(nes1_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nes1_itemms="";
                        if(selected_nes1itemes.size()!=0){

                            for(String selectednesitem : selected_nes1itemes){
                                nes1_itemms = (selected_nes1itemes+",");
                                tv_nes1.setText("전공필수" + nes1_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //전공 필수 버튼
        btn_nes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] nes2_items = new String[]{"미래설계탐색1","미래설계탐색2","미래설계준비1","미래설계준비2","미래설계구현1","미래설계구현2","기초프로젝트","개발프로젝트","전문프로젝트","산학프로젝트"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(nes2_items, new boolean[]{false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            selected_nes2itemes.add(nes2_items[i]);
                        }
                        else selected_nes2itemes.remove(nes2_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nes2_itemms="";
                        if(selected_nes2itemes.size()!=0){

                            for(String selectednes2item : selected_nes2itemes){
                                nes2_itemms = (selected_nes2itemes+",");
                                tv_nes2.setText("" + nes2_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //전공 선택 버튼
        btn_select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] select1_items = new String[]{"창의공학설계","소프트웨어도구실험","객체지향프로그래밍","시스템프로그래밍","오토마타","인간컴퓨터상호작용","컴파일러","웹기반소프트웨어개발","데이터통신","컴퓨터네트워크"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(select1_items, new boolean[]{false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            selected_select1itemes.add(select1_items[i]);
                        }
                        else selected_select1itemes.remove(select1_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String select1_itemms="";
                        if(selected_select1itemes.size()!=0){

                            for(String selectedselect1item : selected_select1itemes){
                                select1_itemms = (selected_select1itemes+",");
                                tv_select1.setText("전공선택:" + select1_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //전공 선택 버튼
        btn_select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] select2_items = new String[]{"데이터베이스시스템","펌웨어프로그래밍","컴퓨터그래픽스","임베디드시스템","영상처리","인공지능","산학특강초청세미나1","데이터베이스설계","정보보호","정보검색"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(select2_items, new boolean[]{false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            selected_select2itemes.add(select2_items[i]);
                        }
                        else selected_select2itemes.remove(select2_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String select2_itemms="";
                        if(selected_select2itemes.size()!=0){

                            for(String selectedselect2item : selected_select2itemes){
                                select2_itemms = (selected_select2itemes+",");
                                tv_select2.setText("" + select2_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        //전공 선택 버튼
        btn_select3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] select3_items = new String[]{"산학특강초청세미나2","캡스톤디자인2"};
                AlertDialog.Builder ad = new AlertDialog.Builder(yearof2016.this);
                ad.setTitle("듣지 못한 과목을 선택하세요");
                ad.setMultiChoiceItems(select3_items, new boolean[]{false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            selected_select3itemes.add(select3_items[i]);
                        }
                        else selected_select3itemes.remove(select3_items[i]);
                    }
                });
                final EditText et = new EditText(yearof2016.this);
                ad.setView(et);
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String select3_itemms="";
                        if(selected_select3itemes.size()!=0){

                            for(String selectedselect3item : selected_select3itemes){
                                select3_itemms = (selected_select3itemes+",");
                                tv_select3.setText("" + select3_itemms );
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             db_DEC.userDatabaseDao().insert(new UserDatabase(userID,tv_result.getText().toString(),
                     tv_basic.getText().toString(),tv_hard.getText().toString(),tv_nes1.getText().toString(),
                     tv_nes2.getText().toString(),tv_select1.getText().toString(),tv_select2.getText().toString(),
                     tv_select3.getText().toString()));
                Intent mainintent=new Intent(yearof2016.this,Box.class);
                mainintent.putExtra("userID",userID);//아이디

                yearof2016.this.startActivity(mainintent);
            }

        });

    }
}