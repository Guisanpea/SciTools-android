package com.example.archie.scitools;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ListActivity {
    Map<String, Class> toolsMap;
    ArrayList <String> toolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolsMap = initMap();
        toolList = new ArrayList<>();
        toolList.addAll(toolsMap.keySet());

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                toolList));
    }

    @Override
    protected void onListItemClick(ListView parent, View view, int position, long id) {
        String toolName = toolList.get(position);
        Class newActivity = toolsMap.get(toolName);
        startActivity(new Intent(this, newActivity));
    }

    private Map<String, Class> initMap() {
        HashMap<String, Class> tools = new HashMap<>();
        tools.put("LCD", LowestCommonDivisor.class);
        tools.put("BinaryTools", BinaryTools.class);
        return tools;
    }
}

