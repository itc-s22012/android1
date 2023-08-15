package jp.ac.it_college.std.s22012.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s22012.fragmentsample.databinding.FragmentMenuListBinding
internal const val REQUEST_SELECTED_MENU = "resultMenu"
internal const val RESULT_NAME = "menuName"
internal const val RESULT_PRIME = "menuPrice"
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MenuListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuListFragment : Fragment() {
    private var _binding:FragmentMenuListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.menuList.apply {
            adapter = MenuAdapter(teishokuList) {
                parentFragmentManager.setFragmentResult(REQUEST_SELECTED_MENU, bundleOf(
                    RESULT_NAME to it.name,
                    RESULT_PRIME to it.price
                )
                )
            }
            val manager = LinearLayoutManager(context)
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(context,manager.orientation))
        }
    }

}