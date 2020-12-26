package uz.unzosoft.expandableviewdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.child_item.view.*
import kotlinx.android.synthetic.main.group_item.view.*
import uz.unzosoft.expandableviewdemo.R

class MyExpandableAdapter(var listTitle: List<String>, var map: HashMap<String, List<String>>) :
    BaseExpandableListAdapter() {


    override fun getGroupCount(): Int {
        return listTitle.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[listTitle[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): String {
        return listTitle[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val list = map[listTitle[groupPosition]]
        return list!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        childPosition: Boolean,
        p2: View?,
        p3: ViewGroup?
    ): View {
        val groupItemView: View
        if (p2 == null) {
            groupItemView = LayoutInflater.from(p3?.context).inflate(R.layout.group_item, p3, false)
        } else {
            groupItemView = p2
        }
        groupItemView.tvGroup.text = listTitle[groupPosition]
        return groupItemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        p2: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var childItemView: View
        if (convertView == null) {
            childItemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.child_item, parent, false)
        } else {
            childItemView = convertView
        }
        val list = map[listTitle[groupPosition]]
        val childPosition = list!![childPosition]
        childItemView.tvChild.text = childPosition
        return childItemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}