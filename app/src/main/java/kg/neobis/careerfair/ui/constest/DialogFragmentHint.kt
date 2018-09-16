package kg.neobis.careerfair.ui.constest

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R

import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.fragment_hint.*

import kotlinx.android.synthetic.main.fragment_hint.view.*

class DialogFragmentHint : DialogFragment() {

    companion object {
        fun newInstance(position: Int): DialogFragmentHint {
            val f = DialogFragmentHint()

            val args = Bundle()

            args.putInt(Constants.BUNDLE_KEY_POSITION, position)


            f.arguments = args
            return f
        }

    }




    private lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_hint, container)
        getDataFromBundle()
        init()


        return v
    }


    private var names: Array<out String>? = null

    private var descriptions: Array<out String>? = null

    private var position: Int? = null

    private fun getDataFromBundle() {
        names = v.resources.getStringArray(R.array.hint_names)
        descriptions = v.resources.getStringArray(R.array.hint_description)
        position = arguments!!.getInt(Constants.BUNDLE_KEY_POSITION)



    }
    private fun init(){
        v.title_hint.text = names!![position!!]
        v.text_description_hint.text = descriptions!![position!!]
    }


}