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

        setSpinnerListener()
    }

    private fun setSpinnerListener() {
        spinner_in_map.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {

                val choose = resources.getStringArray(R.array.stageList)
                when(choose[selectedItemPosition]){
                    "1 Этаж"-> {imageMap1.setImageResource(R.drawable.image_2_floor)
                       }

                    "2 Этаж"-> {imageMap1.setImageResource(R.drawable.image_1_floor)
                     }

                    "3 Этаж"-> {imageMap1.setImageResource(R.drawable.image_3_floor)
                        }
                    "4 Этаж"-> {
                        imageMap1.setImageResource(R.drawable.image_4_floor)
                    }
                        else ->{
                            imageMap1.setImageResource(R.drawable.food_zone)
                        }



                }


            }


        }
    }

}
