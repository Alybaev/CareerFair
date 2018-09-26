package kg.neobis.careerfair.ui.map

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.custom.DividerItemDecoration
import kg.neobis.careerfair.ui.employers.DetailActivity
import kg.neobis.careerfair.ui.employers.EmployersAdapter
import kg.neobis.careerfair.ui.organizers.OrganizersContract
import kg.neobis.careerfair.ui.organizers.OrganizersPresenter
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : BaseActivity(),OrganizersContract.View,EmployersAdapter.Listener {
    override fun onItemSelectedAt(item: Organizers) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }

    var presenter : OrganizersPresenter? = null

    private var listOfEmployers: ArrayList<Organizers>? = null
    private var listOfStageEmployers: ArrayList<Organizers>? = null
    private var mAdapter: EmployersAdapter? = null

    override fun onSuccess(result: ArrayList<Organizers>) {
        listOfEmployers = result
        getEmployersStageList(1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        init()
    }




    private fun init() {
        initPresenter()
        initAdapter()
        initSpinner()
    }

    private fun initPresenter() {
        presenter = OrganizersPresenter(this)
        presenter?.getInfo(Constants.PATH_FOR_EMPLOYERS)
    }


    private fun initAdapter() {
        mAdapter = EmployersAdapter(this, ArrayList<Organizers>())
        rvMap.adapter = mAdapter
        rvMap.addItemDecoration(DividerItemDecoration(this))

    }

    private fun initSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.stageList, R.layout.item_spinner)
        spinner_in_map.adapter = adapter
        setSpinnerListener()
    }

    private fun setSpinnerListener() {
        spinner_in_map.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, itemSelected: View, selectedItemPosition: Int, selectedId: Long) {

                imageView.setImageResource(when (selectedItemPosition) {
                    0 -> R.drawable.image_1_floor
                    1 -> R.drawable.image_2_floor
                    2 -> R.drawable.image_3_floor
                    3 -> R.drawable.image_4_floor
                    else -> R.drawable.food_zone
                })

                 getEmployersStageList(selectedItemPosition + 1)

            }
        }
    }

    private fun getEmployersStageList(position: Int) {
        listOfStageEmployers = ArrayList()

        if(listOfEmployers != null) {
            for (i in 0 until listOfEmployers!!.size) {

                if (listOfEmployers!![i].floor == position ) {
                    listOfStageEmployers!!.add(listOfEmployers!![i])
                }
            }
            mAdapter!!.setMData(listOfStageEmployers!!)
        }

    }
}