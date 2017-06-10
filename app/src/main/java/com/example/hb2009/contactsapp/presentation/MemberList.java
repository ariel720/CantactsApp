package com.example.hb2009.contactsapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hb2009.contactsapp.MainActivity;
import com.example.hb2009.contactsapp.R;
import com.example.hb2009.contactsapp.domain.Member;
import com.example.hb2009.contactsapp.service.MemberService;
import com.example.hb2009.contactsapp.service.MemberServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);

        final Context context = MemberList.this;
        MemberService service = new MemberServiceImpl(context);
        final ArrayList<Member> list =(ArrayList<Member>)service.getMembers();

       Log.d("신희",list.get(3).toString());

        ListView listView = (ListView) findViewById(R.id.lv_memberlist);

        listView.setAdapter(new MemberAdapter(context,list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });


        findViewById(R.id.btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemberList.this, MemberRegister.class));
            }
        });

        findViewById(R.id.btn_mypage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemberList.this, MemberDetail.class));
            }
        });

        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemberList.this, MainActivity.class));
                finish();
            }
        });

    }


    private class MemberAdapter extends BaseAdapter {

        ArrayList<Member> list ;
        LayoutInflater inflater;

        public MemberAdapter(Context context, ArrayList<Member> list) {
            this.list = list;
            this.inflater = LayoutInflater.from(context);
        }

        private int[] photos = {
                R.drawable.cupcake,
                R.drawable.gingerbread,
                R.drawable.honeycomb,
                R.drawable.icecream,
                R.drawable.jellybean,
                R.drawable.kitkat,
                R.drawable.lollipop,
                R.drawable.donut,
                R.drawable.eclair,
                R.drawable.froyo
        };

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup g) {
            ViewHolder vh;
            if(v==null){
                v=inflater.inflate(R.layout.member_item,null);
                vh = new ViewHolder();
                vh.profileimg = (ImageView) v.findViewById(R.id.iv_userphoto);
                vh.name = (TextView) v.findViewById(R.id.tv_username);
                vh.phone = (TextView) v.findViewById(R.id.tv_userphone);
            }else {
                vh = (ViewHolder) v.getTag();
            }

            vh.profileimg.setImageResource(photos[i]);
            vh.name.setText(list.get(i).getName());
            vh.phone.setText(list.get(i).getPhone());

            return v;
        }
    }

    static class ViewHolder{
        ImageView profileimg;
        TextView name;
        TextView phone;
    }
}
