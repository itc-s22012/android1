package jp.ac.it_college.std.s22012.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.ac.it_college.std.s22012.fragmentsample.databinding.FragmentMenuThanksBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
internal const val ARG_NAME = "menuName"
internal const val ARG_PRICE = "menuPrice"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuThanksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuThanksFragment : Fragment() {
    private var _binding: FragmentMenuThanksBinding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentMenuThanksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuName = arguments?.getString(ARG_NAME) ?: ""
        val menuPrice = arguments?.getString(ARG_PRICE) ?: ""

        binding.tvMenuName.text = menuName
        binding.tvMenuPrice.text = "%.d".format(menuPrice)
        binding.tbThxBack.setOnClickListener(::onBackButtonClick)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
private fun onBackButtonClick(v: View){
    parentFragmentManager.popBackStack()
}

}