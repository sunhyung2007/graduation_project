package com.example.myapplication;

/***************************************************************
 * 프로그램명 : ListViewAdapter
 * 작성자 : 2016039038 신동규
 * 작성일 : 2020.06.19 ~ 2020.06.26
 * 프로그램 설명 : 리스트뷰 출력에 대한 어뎁터 스크립트
 ****************************************************************/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 배열 선언
    private ArrayList<ListViewItem> listViewItemBoardList = new ArrayList<ListViewItem>() ;

    private boolean IsDelCB = false;

    // ListViewAdapter 생성자
    public ListViewAdapter() {

    }

    // 삭제 모드 설정 함수
    public void setDelMode (boolean type) {
        IsDelCB = type;
    }

    //리스트 항목에 대한 삭제 여부를 읽어오는 함수
    public boolean getDelCheck(int i, ListView listview) {
        CheckBox DelCB = (CheckBox) listview.getChildAt(i).findViewById(R.id.Board_DelCB) ;

        // 체크 여부 반환
        return DelCB.isChecked();
    }

    // Adapter에 사용되는 데이터의 개수를 리턴하는 함수
    @Override
    public int getCount() {
        return listViewItemBoardList.size() ;
    }

    // 리스트뷰를 그리는 어뎁터 함수
    // position : 리턴 할 자식 뷰의 위치
    // convertView : 메소드 호출 시 position에 위치하는 자식 뷰 ( if == null 자식뷰 생성 )
    // parent : 리턴할 부모 뷰, 어댑터 뷰
    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        // "board_listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (IsDelCB) {
                convertView = inflater.inflate(R.layout.board_listview_item_delete, parent, false);
            }
            else {
                convertView = inflater.inflate(R.layout.board_listview_item, parent, false);
            }
        }

        // 화면에 표시될 View로부터 위젯에 대한 참조 획득
        TextView titleTextView = (TextView) convertView.findViewById(R.id.Board_titleContext) ;
        TextView writerTextView = (TextView) convertView.findViewById(R.id.Board_writerContext) ;

        // listViewItemList에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemBoardList.get(position);

        // 아이템 내 각 위젯에 데이터를 반영함
        titleTextView.setText(listViewItem.getTitle());
        writerTextView.setText(listViewItem.getWriter());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴하는 함수
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴하는 함수
    @Override
    public ListViewItem getItem(int position) {
        return listViewItemBoardList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(String title, String writer, String desc) {
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setWriter(writer);
        item.setDesc(desc);

        listViewItemBoardList.add(item);
    }

    //오버로딩 : 항목 자체를 인자로
    public void addItem(ListViewItem Item) {
        listViewItemBoardList.add(Item);
    }

    //오버로딩 : Null로 초기화
    public void addItem() {
        ListViewItem item = new ListViewItem();

        item.setTitle("Null");
        item.setDesc("Null");
        item.setWriter("Null");

        listViewItemBoardList.add(item);
    }

    //항목을 삭제하는 함수
    public void delItem(int i) {
        listViewItemBoardList.remove(i);
    }
}