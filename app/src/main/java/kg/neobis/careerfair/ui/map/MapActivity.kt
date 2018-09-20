package kg.neobis.careerfair.ui.map

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        init()
    }

    private fun init() {
        initSpinner()
    }

    private fun initSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.stageList, R.layout.item_spinner)
        spinner_in_map.adapter = adapter
        setSpinnerListener()
    }

    private fun setSpinnerListener() {
        spinner_in_map.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>, itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                imageView.setImageResource(when (selectedItemPosition) {
                    0 -> R.drawable.image_2_floor
                    1 -> R.drawable.image_1_floor
                    2 -> R.drawable.image_3_floor
                    3 -> R.drawable.image_4_floor
                    else -> R.drawable.food_zone
                })
            }
        }
    }
}