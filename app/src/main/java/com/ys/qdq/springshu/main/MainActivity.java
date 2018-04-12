package com.ys.qdq.springshu.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseActivity;
import com.ys.qdq.springshu.config.Constants;
import com.ys.qdq.springshu.entity.Record;
import com.ys.qdq.springshu.util.ProgressDialogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private int curPosition = 0;
    private List<Record> recordList = new ArrayList<>();
    private List<RecordFragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragment();
    }

    private void initFragment() {
        for (int i = 0; i < 1; i++) {
            RecordFragment recordFragment = new RecordFragment();
            fragmentList.add(recordFragment);
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.setCurrentItem(curPosition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_menu://添加记录
                MultiImageSelector.create(this).showCamera(true).count(1).single().start(this, Constants.REQUEST_IMAGE);
                return true;
            case R.id.delete_menu://删除记录
                deleteRecord();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                // 获取返回的图片列表
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                // 处理你自己的逻辑 ....
                uploadFile(path.get(0));
            }
        }
    }

    private void uploadFile(String url) {
        ProgressDialogUtil.showDialog(this);
        final BmobFile bmobFile = new BmobFile(new File(url));
        bmobFile.uploadblock(this, new UploadFileListener() {
            @Override
            public void onSuccess() {
                addRecord(bmobFile);
            }

            @Override
            public void onFailure(int i, String s) {
                ProgressDialogUtil.cancelDialog();
                Toast.makeText(MainActivity.this, "上传图片失败！" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRecord(BmobFile bmobFile) {
        Record record = new Record();
        record.setPhoto(bmobFile);
        record.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                ProgressDialogUtil.cancelDialog();
                Toast.makeText(MainActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                ProgressDialogUtil.cancelDialog();
                Toast.makeText(MainActivity.this, "添加失败！" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteRecord() {
        ProgressDialogUtil.showDialog(this);
        final Record record = recordList.get(curPosition);
        record.delete(this, new DeleteListener() {
            @Override
            public void onSuccess() {
                ProgressDialogUtil.cancelDialog();
                Toast.makeText(MainActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
                //刷新数据
                viewPager.removeViewAt(curPosition);
                recordList.remove(record);
                fragmentList.remove(fragmentList.get(curPosition));
            }

            @Override
            public void onFailure(int i, String s) {
                ProgressDialogUtil.cancelDialog();
                Toast.makeText(MainActivity.this, "删除失败！" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
