package azsecuer.zhuoxin.com.mysqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class MyExpress {
    private SQLiteDatabase sq;
    private Context context;
    private List<People> list=new ArrayList<>();

    public List<People> getList() {
        return list;
    }

    public void setList(List<People> list) {
        this.list = list;
    }

    public MyExpress(Context context) {
        this.context = context;
        MyDb myDb = new MyDb(context);
        sq = myDb.getReadableDatabase();
    }

    public void add(People people) {//增加
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", people.getName());
        contentValues.put("age", people.getAge());
        contentValues.put("sex", people.getSex());
        sq.insert("abc", null, contentValues);
    }

    public void deleteone(String name) {//删除一个
        sq.delete("abc", "name=?", new String[]{name});
    }

    public void deleteall() {//全部删除
        sq.delete("abc", null, null);
    }

    public void updata(String befor, People now) {//更新数据
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", now.getName());
        contentValues.put("age",now.getAge());
        contentValues.put("sex",now.getSex());
        sq.update("abc", contentValues, "name=?", new String[]{befor});
    }

    public List<People> findone(String name) {//查询一个
        list =   new ArrayList<>();
        Cursor cursor = sq.rawQuery("select * from abc where name=?", new String[]{name});
        while (cursor.moveToNext()) {
            String names = cursor.getString(cursor.getColumnIndex("name"));
            String age = cursor.getString(cursor.getColumnIndex("age"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            People people = new People(names, sex, age);
            list.add(people);
        }
        return list;
    }

    public List<People> findall() {
        list = new ArrayList<>();
        Cursor cursor = sq.rawQuery("select * from abc ", null);
        while (cursor.moveToNext()) {
            String names = cursor.getString(cursor.getColumnIndex("name"));
            String age = cursor.getString(cursor.getColumnIndex("age"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            People people = new People(names, sex, age);
            list.add(people);
        }
        return list;
    }
}


