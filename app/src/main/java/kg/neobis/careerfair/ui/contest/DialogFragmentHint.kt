package kg.neobis.careerfair.ui.contest

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R

import kg.neobis.careerfair.utils.Constants

import kotlinx.android.synthetic.main.fragment_hint.view.*

class DialogFragmentHint : DialogFragment() {

    companion object {
        fun newInstance(position: Int): DialogFragmentHint {
            val fragment = DialogFragmentHint()
            val args = Bundle()
            args.putInt(Constants.BUNDLE_KEY_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_hint, container)

        val names = resources.getStringArray(R.array.hint_names)
        val descriptions = resources.getStringArray(R.array.hint_description)

        val position = arguments?.getInt(Constants.BUNDLE_KEY_POSITION)
        mView.tvTitle.text = position?.let { names[it] }
        mView.tvHint.text = position?.let { descriptions.get(it) }
        return mView
    }
}