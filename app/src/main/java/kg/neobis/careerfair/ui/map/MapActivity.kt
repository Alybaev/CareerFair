package kg.neobis.careerfair.ui.map

import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.activity_map.*
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import kg.neobis.careerfair.ui.BaseActivity


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

        val adapter = ArrayAdapter.createFromResource(this, R.array.stageList, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_in_map.adapter = adapter


        spinner_in_map.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP)
        setSpinnerListener()
    }

    private fun setSpinnerListener() {
        spinner_in_map.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {

                val choose = resources.getStringArray(R.array.stageList)
                when(choose[selectedItemPosition]){
                    "1 Этаж"-> {imageMap1.setImageResource(R.drawable.logo2)
                        imageMap2.setImageResource(R.drawable.logo1)}

                    "2 Этаж"-> {imageMap2.setImageResource(R.drawable.logo2)
                        imageMap1.setImageResource(R.drawable.logo1)}

                    "3 Этаж"-> {imageMap2.setImageResource(R.drawable.logo2)
                        imageMap1.setImageResource(R.drawable.logo2)}


                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
