package example.androidstudio0311;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Drawable[] images = new Drawable[4];
    int index = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //加载图片
        images[0] = getDrawable(R.drawable.im_01);
        images[1] = getDrawable(R.drawable.im_02);
        images[2] = getDrawable(R.drawable.im_03);
        images[3] = getDrawable(R.drawable.im_04);

        //设置监听器
        Button buttonLast = (Button)findViewById(R.id.id_playLast);
        buttonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playLast();
            }
        });

        Button buttonNext = (Button)findViewById(R.id.id_playNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNext();
            }
        });

        updateIndex();
    }

    private void playLast(){
        index -= 1;
        if(index < 0)
            index = 3;
        ImageView imageView = (ImageView)findViewById(R.id.id_imageBox);
        imageView.setImageDrawable(images[index]);
        updateIndex();
    }

    private void playNext(){
        index += 1;
        if(index >= 4)
            index = 0;
        ImageView imageView = (ImageView)findViewById(R.id.id_imageBox);
        imageView.setImageDrawable(images[index]);
        updateIndex();
    }

    private void updateIndex(){
        TextView text = (TextView)findViewById(R.id.id_index);
        String nowIndex = String.valueOf(index+1) + "/" + images.length;
        text.setText(nowIndex);
    }
}
