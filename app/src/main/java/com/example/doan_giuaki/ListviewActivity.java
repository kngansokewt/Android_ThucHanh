package com.example.doan_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.doan_giuaki.databinding.ActivityListviewBinding;
import com.example.doan_giuaki.databinding.ActivityAppBinding;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    ActivityListviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.youtube,R.drawable.tiktok,R.drawable.instagram,R.drawable.twitter,R.drawable.facebook,R.drawable.among,R.drawable.duolingo,R.drawable.figma,R.drawable.google_drive,R.drawable.inshot};
        String[] name = {"Youtube","TikTok","Instagram","Twitter","FaceBook","Among Us","Duolingo","Figma","Google Drive","Inshot"};
        String[] lastMessage = {"Ứng dụng Youtube chính thức","Kết nối tài năng và sáng tạo","Ảnh & Video","Tin tức","Mạng xã hội"
                ,"Hành động","Học tiếng anh và hơn nữa","Đồ hoạ & Thiết kế","Hiệu suất","Ảnh & Video"};
        String[] lastmsgTime = {"Đã nhận","Đã nhận","Đã nhận","Nhận","Nhận","Nhận","Nhận","Đã nhận","Đã nhận","Nhận"};
        String[] phoneNo = {"7656610000","9999043232","7834354323","9876543211","5434432343","7834354323","9876543211","5434432343"};
        String[] country = {"United States","Russia","India","Israel","Germany","India","Israel","Germany"};

        ArrayList<App> appArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            App app = new App(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);
            appArrayList.add(app);

        }



        ListAdapter listAdapter = new ListAdapter(ListviewActivity.this, appArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListviewActivity.this,AppActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });
    }
}